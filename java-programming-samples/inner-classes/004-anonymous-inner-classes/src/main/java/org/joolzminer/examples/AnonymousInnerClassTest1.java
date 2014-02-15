package org.joolzminer.examples;

interface Printable {
	void print(String message);
}

public class AnonymousInnerClassTest1 {

	public static void main(String[] args) {
		Printable printer = new Printable() {
			
			@Override
			public void print(String message) {
				System.out.println(message);				
			}
		};
		
		printer.print("Beach music");
	}
}
