package org.joolzminer.examples.domain;

public class Apple {
	private String color;
	private Integer weight;
	private String name;
	
	protected Apple() {		
	}
	
	public Apple(String name, String color, int weight) {
		this.name = name;
		this.color = color;
		this.weight = weight;
	}
	
	public String getColor() {
		return color;
	}

	public Integer getWeight() {
		return weight;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + ", name="
				+ name + "]";
	}	
}
