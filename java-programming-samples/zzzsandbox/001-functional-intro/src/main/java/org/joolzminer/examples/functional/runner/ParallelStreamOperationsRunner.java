package org.joolzminer.examples.functional.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.joolzminer.examples.tasks.ForkJoinSumCalculator;

import static java.util.stream.Collectors.*;

public class ParallelStreamOperationsRunner {
	public static void main(String[] args) {
		// Calculate the sum of the first n natural numbers **

		// Sequential mode
		
		testRunner(100, 100_000_000, n -> {
			long result = 0;
			for (long i = 1; i <= n; i++) {
				result += i;
			}
			return result;
		});	
		
		// Functional mode: not good for parallelization
		testRunner(100, 100_000_000L, ParallelStreamOperationsRunner::functionalSum);

		// Parallel mode: first approach
		testRunner(100, 100_000_000L, ParallelStreamOperationsRunner::parallelSum);
		
		// Using fork/join framework
		testRunner(100, 100_000_000L, ParallelStreamOperationsRunner::forkJoinSum);
	}
		
	public static long functionalSum(long n) {
		return Stream.iterate(1L, i -> i + 1)
						.limit(n)
						.reduce(0L, Long::sum);
	}
	
	public static long parallelSum(long n) {
		return LongStream.rangeClosed(1, n)
						.parallel()
						.reduce(0L, Long::sum);
	}
	
	public static long forkJoinSum(long n) {
		long[] numbers = LongStream.rangeClosed(1, n).toArray();
		ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
		long result = new ForkJoinPool().invoke(task);
		return result;
	}
	
	public static <T, R> void testRunner(int numRuns, T functionParam, Function<T, R> function) {
		List<Long> runElapsedTimes = new ArrayList<Long>();
		for (int i = 0; i < numRuns; i++) {
			long start = System.nanoTime();
			function.apply(functionParam);
			long elapsed = (System.nanoTime() - start) / 1_000_000;
			runElapsedTimes.add(elapsed);
			System.out.print(".");
		}
		
		LongSummaryStatistics testStats = runElapsedTimes
											.stream()
											.collect(summarizingLong(Long::longValue));
		
		System.out.println("\n-- Statistics ------------------------");
		System.out.println("Number of runs  : " + testStats.getCount());
		System.out.println("Min elapsed time: " + testStats.getMin() + " msec");
		System.out.println("Max elapsed time: " + testStats.getMax() + " msec");
		System.out.println("Avg elapsed time: " + testStats.getAverage() + " msec");
		System.out.println("--------------------------------------\n");		 		
	}
}
