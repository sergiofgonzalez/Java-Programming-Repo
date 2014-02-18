package org.joolzminer.examples.tuple;

public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {

	protected C c;
	
	public ThreeTuple(A a, B b, C c) {
		super(a, b);
		this.c = c;
	}

	public C getC() {
		return c;
	}

	@Override
	public String toString() {
		return "(" + a + ", " + b + ", " + c + ")";
	}	
}
