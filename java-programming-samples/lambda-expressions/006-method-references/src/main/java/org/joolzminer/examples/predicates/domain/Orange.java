package org.joolzminer.examples.predicates.domain;

public class Orange extends Fruit {
	private Integer weight;
	
	public Orange(Integer weight) {
		this.weight = weight;
	}
	
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Orange [weight=" + weight + "]";
	}	
}
