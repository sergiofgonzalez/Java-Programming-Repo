package org.joolzminer.examples.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

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
	
	public static Supplier<List<Dish>> someDishesInMenu = () -> 
		Arrays.asList( new Dish("pork", false, 800, Dish.Type.MEAT),
						new Dish("beef", false, 700, Dish.Type.MEAT),
						new Dish("chicken", false, 400, Dish.Type.MEAT),
						new Dish("french fries", true, 530, Dish.Type.OTHER),
						new Dish("rice", true, 350, Dish.Type.OTHER),
						new Dish("season fruit", true, 120, Dish.Type.OTHER),
						new Dish("pizza", false, 550, Dish.Type.OTHER),
						new Dish("prawns", false, 300, Dish.Type.FISH),
						new Dish("salmon", false, 450, Dish.Type.FISH));
	
}