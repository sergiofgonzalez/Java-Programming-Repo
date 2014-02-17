package org.joolzminer.examples;

import java.util.ArrayList;
import java.util.List;

public class AllowedTypeTest {
	public static void doIt(List<Object> objects) {		
	}
	
	public static void doIt2(List<?> objects) {		
	}
	
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		
		// Error: type not allowed for the argument
//		doIt(strings);
		
		doIt2(strings);
		
		List<Integer> numbers = new ArrayList<>();
		doIt2(numbers);		
	}
}

