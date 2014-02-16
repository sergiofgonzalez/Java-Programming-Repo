package org.joolzminer.examples;

import java.util.ArrayList;
import java.util.List;

public class ListWithoutGenerics {
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		
		// List before generics
		List stringList = new ArrayList();
		stringList.add("hello");
		stringList.add("world");
		
		String item = (String) stringList.get(1);
		
		stringList.add(new ListWithoutGenerics());
		System.out.println(stringList);
		
		// Generic List
		List<String> genericStringList = new ArrayList<>();
		genericStringList.add("hello");
		genericStringList.add("world");
		
		// Error: not applicable for those arguments
		//genericStringList.add(new ListWithoutGenerics());
		
		System.out.println(genericStringList);
	}
}
