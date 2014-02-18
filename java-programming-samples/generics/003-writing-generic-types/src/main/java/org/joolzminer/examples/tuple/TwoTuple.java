package org.joolzminer.examples.tuple;

public class TwoTuple<A, B> {
	protected A a;
	protected B b;
	
	public TwoTuple(A a, B b) {
		this.a = a;
		this.b = b;
	}

	public A getA() {
		return a;
	}

	public B getB() {
		return b;
	}

	@Override
	public String toString() {
		return "(" + a + ", " + b + ")";
	}		
}
