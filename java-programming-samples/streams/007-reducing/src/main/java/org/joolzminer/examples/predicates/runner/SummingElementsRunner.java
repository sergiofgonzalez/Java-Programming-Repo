package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummingElementsRunner {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		// Old Style
		int sum = 0;
		for (Integer num : numbers) {
			sum += num;
		}
		System.out.println(sum);
		
		// Using reduce
		System.out.println(
				numbers.stream()
					.reduce(0, 						// Initial value
							(a, b) -> a + b)		// BinaryOperator (T, T) -> T
													//  where a is the accumulator, b the element
				);
		
		// Using the new Integer.sum() method
		System.out.println(
				numbers.stream()
						.reduce(0, Integer::sum)
				);
		
		// Using reduce for product instead of sum
		System.out.println(
				numbers.stream()
					.reduce(1, (a, b) -> a * b)
				);
		
		// Using the version with no initial value
		System.out.println(
				numbers.stream()
					.reduce(Integer::sum)
				);
		
		System.out.println(
				numbers.stream()
					.reduce((a, b) -> a * b)
				);

		List<Integer> emptyListOfNumbers = new ArrayList<Integer>();
		System.out.println(
				emptyListOfNumbers.stream()
					.reduce(Integer::sum)
				);
	}
}
