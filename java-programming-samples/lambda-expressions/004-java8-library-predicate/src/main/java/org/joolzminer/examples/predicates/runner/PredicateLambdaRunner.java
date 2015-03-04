package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class PredicateLambdaRunner {

	public static <T> List<T> filter(List<T> items, Predicate<T> predicate) {
		List<T> result = new ArrayList<>();
		for (T item : items) {
			if (predicate.test(item)) {
				result.add(item);
			}
		}
		return result;
	}

	
	@SuppressWarnings("serial")
	private static List<Integer> numbers = new ArrayList<Integer>() {{
		for (int i = 0; i < 10; i++) {
			add(i);
		}
	}};
	
	@SuppressWarnings("serial")
	private static List<String> strings = new ArrayList<String>() {{
		add("uno");
		add("");
		add("tres");
		add("");
		add("catorce");
	}};

	
	
	public static void main(String[] args) throws Exception {
		// Filter even numbers
		System.out.println(filter(numbers, (Integer num) -> num % 2 == 0));
		
		// Filter non-empty strings
		System.out.println(filter(strings, (String s) -> !s.isEmpty()));	
		
		// Note that you don't have to include the type of the argument
		// as the compiler can infer that information from the functional
		// interface
		System.out.println(filter(strings, (s) -> s.length() > 3));
	}
}