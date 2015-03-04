package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerLambdaRunner {
	
	public static <T> void forEach(List<T> items, Consumer<T> consumer) {
		for (T item : items) {
			consumer.accept(item);
		}
	}
	
	@SuppressWarnings("serial")
	private static List<Integer> numbers = new ArrayList<Integer>() {{
		for (int i = 0; i < 10; i++) {
			add(i);
		}
	}};
	
	
	public static void main(String[] args) {
		// Print the numbers
		forEach(numbers, (Integer num) -> System.out.println(num));
		
		// Multiply each element by 2
		forEach(numbers, (Integer num) -> System.out.println(num * 2));
	}
}
