package org.joolzminer.examples.streams.runner;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class HelloParallelStreamRunner {
	public static long sequentialSum(long n) {
		return Stream.iterate(1L, i -> i + 1)
					.limit(n)
					.reduce(0L, Long::sum);
	}
	
	public static long parallelSum(long n) {
		return Stream.iterate(1L, i -> i + 1)
					.limit(n)
					.parallel()
					.reduce(0L, Long::sum);
	}
	
	public static long iterativeSum(long n) {
		long result = 0L;
		for (int i = 1; i <= n; i++) {
			result += i;
		}
		return result;
	}
	
	public static long fastSequentialSum(long n) {
		return LongStream.rangeClosed(1, n)
						.reduce(0L, Long::sum);
	}
	
	public static long fastParallelSum(long n) {
		return LongStream.rangeClosed(1,  n)
						.parallel()
						.reduce(0L, Long::sum);
	}
	
	public static void main(String[] args) {
		System.out.println("Stream Sequential:");
		runPerfTestHarness(10_000_000, 10, HelloParallelStreamRunner::sequentialSum);
		
		System.out.println("Iterative Sequential:");
		runPerfTestHarness(10_000_000, 10, HelloParallelStreamRunner::iterativeSum);
		
		System.out.println("Stream Parallel:");
		runPerfTestHarness(10_000_000, 10, HelloParallelStreamRunner::parallelSum);
		
		System.out.println("=======================================================");
		System.out.println("Fast Stream Sequential:");
		runPerfTestHarness(10_000_000, 10, HelloParallelStreamRunner::fastSequentialSum);
		
		System.out.println("Fast Stream Parallel:");
		runPerfTestHarness(10_000_000, 10, HelloParallelStreamRunner::fastParallelSum);
	}
	
	public static void runPerfTestHarness(long n, long numTimes, Function<Long, Long> f) {
		System.out.println("\tAbout to execute test " + numTimes + " times to sum numbers up to " + n);
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < numTimes; i++) {
			long start = System.nanoTime();
			@SuppressWarnings("unused")
			long result = f.apply(n);
			long duration = (System.nanoTime() - start) / 1_000_000;
			if (duration < fastest) {
				fastest = duration;
			}
			System.out.print(".");
		}
		
		System.out.println(" > Fastest time execution: " + fastest + " msecs.");
	}
}
