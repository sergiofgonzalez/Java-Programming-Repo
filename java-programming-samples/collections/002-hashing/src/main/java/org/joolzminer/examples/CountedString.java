package org.joolzminer.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountedString {
	private static List<String> createdStrings = new ArrayList<>();
	private String s;
	private int id = 0;
	
	public CountedString(String str) {
		s = str;
		createdStrings.add(s);
		for (String string : createdStrings) {
			if (string.equals(s)) {
				id++;
			}
		}
	}

	@Override
	public int hashCode() {
		int result = 17;
		
		// string field
		int c1 = s.hashCode();
		result = 37 * result + c1;
		
		// int field
		int c2 = id;		
		result = 37 * result + c2;
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof CountedString &&
				s.equals(((CountedString)obj).s) &&
				id == ((CountedString)obj).id;
	}

	@Override
	public String toString() {
		return "String: " + s + "(id=" + id + ", hashCode()=" + hashCode() + ")";
	}
	
	public static void main(String[] args) {
		CountedString[] countedStrings = new CountedString[5];
		for (int i = 0; i < countedStrings.length; i++) {
			countedStrings[i] = new CountedString("hi");
		}
		
		System.out.println(Arrays.asList(countedStrings));
	}
}
