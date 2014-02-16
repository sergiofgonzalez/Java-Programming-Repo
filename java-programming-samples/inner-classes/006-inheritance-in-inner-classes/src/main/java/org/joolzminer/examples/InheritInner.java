package org.joolzminer.examples;

class Outer {
	class Inner {		
	}
}

public class InheritInner extends Outer.Inner {
	public InheritInner(Outer outer) {
		outer.super();
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Outer outer = new Outer();
		InheritInner inheritInner = new InheritInner(outer);
	}
}
