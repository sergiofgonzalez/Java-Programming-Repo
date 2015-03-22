package org.joolzminer.examples.predicates.runner;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class FilteringUniqueElemsRunner {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		
		// Filter unique even numbers
		List<Integer> uniqueEvenNumbers = numbers.stream()
											.filter(i -> i % 2 == 0)
											.distinct()
											.collect(toList());
		
		System.out.println(uniqueEvenNumbers);
	}
}
