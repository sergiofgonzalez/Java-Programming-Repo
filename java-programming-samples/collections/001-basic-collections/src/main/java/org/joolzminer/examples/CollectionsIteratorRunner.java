package org.joolzminer.examples;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CollectionsIteratorRunner {

	public static void main(String[] args) {
		System.out.println("*** Iterating over a collection with an Iterator:");
		List<String> characters = Arrays.asList("Jerry", "Kramer", "George", "Elaine", "Newman");
		
		Iterator<String> iterator = characters.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println(element);
		}
	}
}
