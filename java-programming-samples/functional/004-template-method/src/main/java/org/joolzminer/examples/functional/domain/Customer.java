package org.joolzminer.examples.functional.domain;

public class Customer {

	private final int id;
	private final String name;
	
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
}
