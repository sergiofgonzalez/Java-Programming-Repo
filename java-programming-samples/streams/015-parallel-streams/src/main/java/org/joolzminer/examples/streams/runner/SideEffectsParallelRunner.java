package org.joolzminer.examples.streams.runner;

import java.util.stream.LongStream;

class Accumulator {
	private long total = 0;
	
	public void add(long value) {
		total += value;
	}

	public long getTotal() {
		return total;
	}		
}

public class SideEffectsParallelRunner {
		
	public static long sideEffectsSum(long n) {
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(1, n)
					.forEach(accumulator::add);
		return accumulator.getTotal();
	}
	
	public static long sideEffectsParallelSum(long n) {
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(1, n)
					.parallel()
					.forEach(accumulator::add);
		return accumulator.getTotal();
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Result (sequential) =" + sideEffectsSum(10_000_000));
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Result (parallel) =" + sideEffectsParallelSum(10_000_000));			
		}
	}
}
