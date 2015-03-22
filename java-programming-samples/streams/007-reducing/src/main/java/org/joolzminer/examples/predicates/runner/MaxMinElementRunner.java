package org.joolzminer.examples.predicates.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MaxMinElementRunner {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(8, 3, 5, 1, 9, 2, 4);

		Optional<Integer> min = numbers.stream()
							.reduce((a, b) -> Integer.min(a, b));
		
		min.ifPresent(System.out::println);
			
		Optional<Integer> max = numbers.stream()
							.reduce((a, b) -> Integer.max(a, b));
		
		max.ifPresent(System.out::println);
		
		
		// It's more concise to use Integer::min and Integer::max
		numbers.stream()
				.reduce(Integer::min)
				.ifPresent(System.out::println);
		
		numbers.stream()
				.reduce(Integer::max)
				.ifPresent(System.out::println);
	}
}
