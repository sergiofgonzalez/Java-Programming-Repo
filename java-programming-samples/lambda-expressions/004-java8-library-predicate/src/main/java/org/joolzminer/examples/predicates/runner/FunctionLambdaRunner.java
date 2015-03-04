package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionLambdaRunner {
	
	public static <T, R> List<R> map(List<T> items, Function<T, R> function) {
		List<R> result = new ArrayList<>();
		for (T item : items) {
			result.add(function.apply(item));
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
	private static List<String> stringNumbers = new ArrayList<String>() {{
		add("uno");
		add("dos");
		add("tres");
		add("cuatro");
		add("cinco");
	}};
	
	
	public static void main(String[] args) {
		// Get a list with all elements doubled
		System.out.println(map(numbers, (Integer num) -> num * 2));
		
		// Get a list with length of all elements
		System.out.println(map(stringNumbers, (String numStr) -> numStr.length()));
	}
}
