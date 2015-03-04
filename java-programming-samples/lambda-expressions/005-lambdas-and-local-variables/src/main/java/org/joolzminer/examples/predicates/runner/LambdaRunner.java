package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class LambdaRunner {

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

	private static String STATIC_MESSAGE = "This is an static message";
	
	private static String instanceMessage = "This is an instance message";
			
	public static void main(String[] args) throws Exception {
		// you can reference a private static var defined out of the scope of the lambda
		forEach(numbers, (num) -> System.out.println(STATIC_MESSAGE + ": " + num));
		
		// you can reference a private static var defined out of the scope of the lambda
		forEach(numbers, (num) -> System.out.println(instanceMessage + ": " + num));
		
		// you can reference a non final, local variable
		String message = "This a non-mutable local message";
		forEach(numbers, (num) -> System.out.println(message + ": " + num));	
		
		// You cannot reference a mutable, local variable
		String changingMessage = "This is a changing message";
//		forEach(numbers, (num) -> System.out.println(changingMessage + ": " + num)); // Must be final or effectively final
		changingMessage = "another";
	}
}