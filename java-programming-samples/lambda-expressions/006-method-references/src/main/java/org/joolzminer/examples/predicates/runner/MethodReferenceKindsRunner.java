package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

// Three kinds of method references
// 1. References to static methods, such as Integer.ParseInt()
// 2. References to instance method of an arbitrary type, such as String.length()
// 3. References to instance method of a particular existing object, such as myTransaction.getValue()


public class MethodReferenceKindsRunner {

	public static <T> void forEach(List<T> items, Consumer<T> consumer) {
		for (T item : items) {
			consumer.accept(item);
		}
	}

	
	@SuppressWarnings("serial")
	private static List<String> numberStrings = new ArrayList<String>() {{
		add("1");
		add("22");
		add("333");
	}};
	

	public static void main(String[] args) throws Exception {
		// Case 1: convert each of the strings to number		
		// 1.a Lambdas
		forEach(numberStrings, (s) -> Integer.parseInt(s));
		
		// 1.b Method reference
		forEach(numberStrings,  Integer::parseInt);
		
		// Case 2: compute the length
		// 2.a Lambdas
		forEach(numberStrings, (s) -> s.length());
		
		// 2.b Method reference
		forEach(numberStrings, String::length);
		
		// Case 3: Reference a method of an existing object
		StringTransformer stringTransformer = new StringTransformer("some string");
		//3.a Lambdas
		forEach(numberStrings, (s) -> stringTransformer.getTransformed(s));
		
		//3.b Method Reference
		forEach(numberStrings, stringTransformer::getTransformed);
	}
}