package org.joolzminer.examples.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Apple {
	private final String color;
	private final Integer weight;
	
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
	
	public static List<Apple> getSomeApples() {
		return Arrays.asList(
				new Apple[] {new Apple("Green", 100), new Apple("Red", 120), new Apple("Red", 80), new Apple("Yellow", 140),
								appleFactory.apply("Green", 80), appleFactory.apply("Yellow", 95)}
				);
	}
	
	public static BiFunction<String, Integer, Apple> appleFactory = Apple::new;
}
