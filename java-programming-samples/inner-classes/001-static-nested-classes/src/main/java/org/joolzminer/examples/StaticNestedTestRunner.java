package org.joolzminer.examples;

class Outer {
	private static int value = 9;
	
	static class Nested {
		int calculate() {
			return value;
		}
	}
}

public class StaticNestedTestRunner {
	public static void main(String[] args) {
		Outer.Nested nested = new Outer.Nested();
		System.out.println(nested.calculate());
	}
}