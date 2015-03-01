package org.joolzminer.examples.generics;

import java.util.ArrayList;
import java.util.List;

import org.joolzminer.examples.predicates.Formatter;
import org.joolzminer.examples.predicates.Predicate;

public class GenericFunctionsHolder {
	
	public static <T> List<T> filter(List<T> items, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T item : items) {
			if (p.test(item)) {
				result.add(item);
			}
		}
		return result;
	}	
	
	public static <T> void prettyPrint(List<T> items, Formatter<T> f) {
		for (T item : items) {
			String output = f.accept(item);
			System.out.println(output);
		}
	}
}
