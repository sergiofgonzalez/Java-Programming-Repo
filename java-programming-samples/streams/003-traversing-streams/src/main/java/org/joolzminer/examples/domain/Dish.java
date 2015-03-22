package org.joolzminer.examples.domain;

public class Dish {
	private final String name;
	private final Boolean vegetarian;
	private final Integer calories;
	private final Type type;
	
	public Dish(String name, Boolean vegetarian, Integer calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public Boolean isVegetarian() {
		return vegetarian;
	}

	public Integer getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", vegetarian=" + vegetarian
				+ ", calories=" + calories + ", type=" + type + "]";
	}
	
	public enum Type { MEAT, FISH, OTHER }
}

