package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;

public class ToListUsingReduceRunner {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		List<Integer> evenNumbers = numbers.stream()
									.filter(n -> n % 2 == 0)
									.collect(toList());
		System.out.println(evenNumbers);		
		
		// Implementation of toList() using reduce
		// This has multiple problems though:
		//		+ it needs a combinator function
		//		+ it is mutating the container to accumulate
		//		  the result, which will lead to problems in
		//		  parallel scenarios.
		System.out.println(
				numbers.stream()
					.filter(n -> n % 2 != 0)
					.reduce( new ArrayList<Integer>(),
								(List<Integer> l, Integer e) -> {
																	l.add(e);
																	return l; 
																},
								(List<Integer> l1, List<Integer> l2) -> {
																			l1.addAll(l2);
																			return l1; 
																		}
							)
				);
	}
}
