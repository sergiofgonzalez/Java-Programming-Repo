package org.joolzminer.examples.predicates.runner;

import java.util.stream.IntStream;

public class RangesRunner {
	public static void main(String[] args) {
		
		// Get the even numbers from 1 to 100
		IntStream evenNumbers = IntStream.rangeClosed(1, 100)
											.filter(n -> n % 2 == 0);
		System.out.println(evenNumbers.count());
	}
}
