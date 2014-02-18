package org.joolzminer.examples;

public class ClassNamePrinter {
	public static <T> void displayClassName(T t) {
		System.out.println(t.getClass().getName());
	}
	
	public static void main(String[] args) {
		ClassNamePrinter.displayClassName(new Integer(1));
		ClassNamePrinter.displayClassName(new String());
		ClassNamePrinter.displayClassName(ClassNamePrinter.class);
	}
}
