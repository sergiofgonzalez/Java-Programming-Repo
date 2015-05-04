package org.joolzminer.examples.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterHelper {
	
	public static <T> List<T> filter(List<T> items, Predicate<T> predicate) {
		List<T> result = new ArrayList<>();
		for (T item : items) {
			if (predicate.test(item)) {
				result.add(item);
			}
		}
		return result;
	}
	
}
