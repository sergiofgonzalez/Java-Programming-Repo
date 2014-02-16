package org.joolzminer.examples;

import java.util.ArrayList;
import java.util.List;

public class ListWithoutGenerics {
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		List stringList = new ArrayList();
		stringList.add("hello");
		stringList.add("world");
		
		String item = (String) stringList.get(1);
		
		stringList.add(new ListWithoutGenerics());
	}
}
