package org.joolzminer.examples.predicates.runner;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;

public class FlatteningStreamsRunner {	
	
	public static void main(String[] args) {
		
		// List all of the unique characters for a list of words
		List<String> words = Arrays.asList("Hello", "World");
		
		// 1st attempt

//		List<String> uniqueChars = words.stream()
//									.map(String::toLowerCase)
//									.map(word -> word.split("")) 		// returns an Array of Strings
//									.distinct()
//									.collect(toList());

		// 2nd attempt using Arrays.stream() which converts an array into a stream
//		List<String> uniqueChars = words.stream()
//										.map(String::toLowerCase)
//										.map(word -> word.split(""))
//										.map(Arrays::stream)			// returns two streams 
//										.distinct()
//										.collect(toList());
		
		// 3rd and final attempt
		List<String> uniqueChars = words.stream()
										.map(String::toLowerCase)
										.map(word -> word.split("")) 	// Several Arrays of one character
										.flatMap(Arrays::stream)		// each stream turned into a character
										.distinct()
										.collect(toList());

		System.out.println(uniqueChars);
		
		
		// Quiz 5.2.1
		// Given a list of numbers, return a list of the square of each number
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		List<Integer> squaredNumbers = numbers.stream()
												.map(n -> n * n)
												.collect(toList());
		System.out.println(squaredNumbers);
		
		// Quiz 5.2.1
		// Given two lists of numbers, return all pairs of numbers
		// E.g.
		//	list1={1,2,3}   list2={3,4}
		//  should return {{1,3}, {1,4}, {2,3}... , {3, 4}}
		
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);		
				
		List<int[]> pairs = numbers1.stream()
									.flatMap(
											(Integer i) -> numbers2.stream()
																.map((Integer j) -> new int[] {i, j}) // this returns a Stream<int[]>
											)
									.collect(toList());
		
		pairs.forEach(pair -> System.out.println("{" + pair[0] + ", " + pair[1] + "}"));
		
		// Quiz 5.2.2
		// Extend the previous example 
		// to return only pairs whose sum is only divisible by 3
		System.out.println("###");
		List<int[]> divByThreePairs = numbers1.stream()
				.flatMap((Integer i) -> numbers2.stream()
											.map((Integer j) -> new int[] {i, j})
					)
				.filter((int[] pair) -> (pair[0] + pair[1]) % 3 == 0)
				.collect(toList());
		divByThreePairs.forEach((int[] pair) -> System.out.println("{" + pair[0] + ", " + pair[1] + "}"));
	}	
}
