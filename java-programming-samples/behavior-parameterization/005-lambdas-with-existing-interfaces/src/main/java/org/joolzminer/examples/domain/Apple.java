package org.joolzminer.examples.domain;

public class Apple {
	private String color;
	private Integer weight;
	
	protected Apple() {		
	}
	
	public Apple(String color, int weight) {
		this.color = color;
		this.weight = weight;
	}
	
	public String getColor() {
		return color;
	}

	public Integer getWeight() {
		return weight;
	}
	
	
	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}	
}
