package org.joolzminer.examples.tasks;

import java.util.concurrent.RecursiveTask;

@SuppressWarnings("serial")
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

	private final long[] numbers;
	private final int start;
	private final int end;
	
	private static final long PARALLELIZATION_THRESHOLD = 10_000;
	
	public ForkJoinSumCalculator(long[] numbers, int start, int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}
	
	public ForkJoinSumCalculator(long[] numbers) {
		this(numbers, 0, numbers.length);
	}
	
	
	/*
	 * if (task is small enough or no longer divisible) {
	 * 		compute task sequentially
	 * } else {
	 * 		split task in two subtasks
	 * 		call this method recursively to perform further splitting of the two subtasks
	 * 		wait for the completion of all subtasks
	 * 		combine the results of each subtask
	 * }
	 */
	
	@Override
	protected Long compute() {
		int length = end - start;
		if (length < PARALLELIZATION_THRESHOLD) {
			return computeSequentially();
		} else {
			ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
			leftTask.fork();

			ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
			Long rightResult = rightTask.compute();
			
			Long leftResult = leftTask.join();
			
			return rightResult + leftResult;
		}
	}

	private long computeSequentially() {
		long result = 0;
		for (int i = start; i < end; i++) {
			result += numbers[i];
		}
		return result;
	}
}
