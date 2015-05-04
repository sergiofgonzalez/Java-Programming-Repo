package org.joolzminer.examples.functional.domain;

public abstract class Product {
	private final String productName;

	protected Product(String productName) {
		this.productName = productName;
	}
	
	@Override
	public String toString() {
		return "A " + productName;
	}	
}
