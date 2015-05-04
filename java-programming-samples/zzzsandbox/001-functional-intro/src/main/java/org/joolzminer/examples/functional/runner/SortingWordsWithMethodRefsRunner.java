package org.joolzminer.examples.functional.runner;

import java.util.Arrays;
import java.util.List;

public class SortingWordsWithMethodRefsRunner {

	private static List<String> words = Arrays.asList("Charlie", "Yankee", "Echo", "Bravo", "Alpha", "Tango");
	
	public static void main(String[] args) {
		System.out.println(words);
		words.sort(String::compareToIgnoreCase);
		System.out.println(words);
	}
}
