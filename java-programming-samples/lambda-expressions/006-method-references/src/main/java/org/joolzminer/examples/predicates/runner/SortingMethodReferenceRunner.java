package org.joolzminer.examples.predicates.runner;

import java.util.Arrays;
import java.util.List;

public class SortingMethodReferenceRunner {

	private static List<String> words = 
		Arrays.asList("Sergio prepara la cena para Adrian mientras Inma trabaja en el salon".split(" "));

	
	public static void main(String[] args) {
		System.out.println(words);
		
		// Using lambdas
//		words.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		
		// Using method reference
		words.sort(String::compareToIgnoreCase);
		
		
		System.out.println(words);
	}
}
