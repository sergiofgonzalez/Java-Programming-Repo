package org.joolzminer.examples.functional.runner;

interface A {
	default void hello() {
		System.out.println("A::hello");
	}
}

interface B extends A {
	default void hello() {
		System.out.println("B::hello");
	}
}

class D implements A {}


class C extends D implements B, A {}

class D1 implements A {
	public void hello() {
		System.out.println("D1::hello");
	}
}

class C1 extends D1 implements B, A {}

// -- disambiguation
interface A2 {
	default void hello() {
		System.out.println("A1::hello");
	}
}

interface B2 {
	default void hello() {
		System.out.println("A2::hello");
	}
}


// class C2 implements A2, B2 {} // <- does not compile: duplicate default methods

class C2 implements A2, B2 {
	public void hello() {
		A2.super.hello(); // explicitly selecting one or the other
	}
}

public class MultipleInheritanceRunner implements B, A {
	public static void main(String[] args) {
		new MultipleInheritanceRunner().hello(); // B::hello wins because it is the most specific sub-interface
		
		new C().hello(); 	// B::hello wins, because it is the most specific sub-interface
							// 	as C is a class, but it does not override the hello() method.
		
		new C1().hello(); 	// D1::hello wins, because it extends from D1, a class that
							// 	overrides the hello() method.
	}
}
