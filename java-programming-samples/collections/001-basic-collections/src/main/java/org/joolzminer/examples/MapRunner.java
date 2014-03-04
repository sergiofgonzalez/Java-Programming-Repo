package org.joolzminer.examples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapRunner {
	public static void main(String[] args) {
		Map<String,Integer> numbers = new HashMap<>();
		numbers.put("one", 1);
		numbers.put("two", 2);
		numbers.put("three", 3);
		
		Set<String> keys = numbers.keySet();
		System.out.println("keys=" + keys);
		
		Collection<Integer> values = numbers.values();
		System.out.println("values=" + values);
		
		for (Entry<String, Integer> number : numbers.entrySet()) {
			System.out.println(number.getKey() + "=" + number.getValue());
		}
	}
}
