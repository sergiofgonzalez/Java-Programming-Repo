package org.joolzminer.examples;

class Outer1 {
	private static int value = 9;
	
	static class Nested1 {
		int value = 10;
		
		int calculate() {
			return value;
		}
		
		int getOuterValue() {
			return Outer1.value;
		}		
	}
}

public class StaticNestedTestRunner2 {
	public static void main(String[] args) {
		Outer1.Nested1 nested = new Outer1.Nested1();
		System.out.println(nested.calculate()); // returns 9 because of the shadowing
		System.out.println(nested.getOuterValue()); // returns 9 because of the shadowing
	}
}