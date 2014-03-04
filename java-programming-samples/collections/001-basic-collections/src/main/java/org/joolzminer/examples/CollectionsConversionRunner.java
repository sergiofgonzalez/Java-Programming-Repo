package org.joolzminer.examples;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsConversionRunner {

	public static void main(String[] args) {
		Set<String> names = new HashSet<>();
		names.add("sergio");
		names.add("inma");
		names.add("adrian");
		
		List<String> namesList = new ArrayList<>(names);
		namesList.add("sergio");
		
		System.out.println(namesList);
	}
}
