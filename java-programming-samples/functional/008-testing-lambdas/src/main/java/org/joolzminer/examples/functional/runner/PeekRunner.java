package org.joolzminer.examples.functional.runner;

import java.util.Arrays;
import java.util.List;

public class PeekRunner {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
		numbers.stream()
			.peek(x -> System.out.println("\n==============\nafter stream(): " + x))
			.map(x -> x + 17)
			.peek(x -> System.out.println("after map()   : " + x))
			.filter(x -> x % 2 == 0)
			.peek(x -> System.out.println("after filter(): " + x))
			.limit(3)
			.peek(x -> System.out.println("after limit() : " + x))
			.forEach(System.out::println);
	}
}
