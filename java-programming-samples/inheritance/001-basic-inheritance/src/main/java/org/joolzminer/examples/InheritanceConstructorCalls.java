package org.joolzminer.examples;

class Base {
		
	public Base() {
		System.out.println("Inside Base()");
	}
	
	public Base(String s) {
		System.out.println("Inside Base(String): " + s);
	}
}

class Derived extends Base {
	
	public Derived(String s) {
		System.out.println("Inside Derived(String): " + s);
	}
}

class Derived2 extends Base {
	
	public Derived2(String s) {
		super();
		System.out.println("Inside Derived2(String): " + s);
	}
}

class Derived3 extends Base {
	public Derived3(String s) {
		super(s);
		System.out.println("Inside Derived3(String): " + s);
	}
}

public class InheritanceConstructorCalls {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// No-arg constructor of Base will be silently introduced by compiler
		Derived derived = new Derived("hello, world!!");
		
		// No-arg constructor explicitly called
		Derived2 derived2 = new Derived2("hello, world!!");
		
		// String constructor explicitly called: no call to no-arg constructor
		Derived3 derived3 = new Derived3("hello, world!!");
	}
}
