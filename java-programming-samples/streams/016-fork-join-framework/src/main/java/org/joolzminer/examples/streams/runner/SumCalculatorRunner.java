package org.joolzminer.examples.streams.runner;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.joolzminer.examples.forkjoin.ForkJoinSumCalculator;

public class SumCalculatorRunner {
	public static void main(String[] args) {

		calculateSum(10_001L);
		
		calculateSum(10L);
		calculateSum(100L);
		calculateSum(1_000L);
		calculateSum(10_000L);
		
		// Parallelization enabled		
		calculateSum(100_000L);
//		calculateSum(getRangeClosed(1, 10_000_000));
//		calculateSum(getRangeClosed(1, 100_000_000));
//		calculateSum(getRangeClosed(1, 1_000_000_000));		
	}
		
		
	public static void calculateSum(long n) {
		long[] numbers = LongStream.rangeClosed(1, n).toArray();
		long start = System.nanoTime();
		ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
		long result = new ForkJoinPool().invoke(task);
		long end = System.nanoTime();
		long lapseMsecs = (end - start) / 10_000_000;
		System.out.println("Sum=" + result + " (" + lapseMsecs + " msec)");		
	}
}
