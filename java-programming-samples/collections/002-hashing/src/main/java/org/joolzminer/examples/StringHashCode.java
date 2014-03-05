package org.joolzminer.examples;

public class StringHashCode {
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "hello hello";
		
		System.out.println("s1.hashCode()=" + s1.hashCode());
		
		String[] strings = s2.split(" ");
		System.out.println("strings[0].hashCode()=" + strings[0].hashCode());
		System.out.println("strings[1].hashCode()=" + strings[1].hashCode());
		
	}
}
