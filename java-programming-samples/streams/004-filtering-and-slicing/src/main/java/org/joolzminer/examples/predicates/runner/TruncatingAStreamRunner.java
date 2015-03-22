package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.*;

import org.joolzminer.examples.domain.Dish;

public class TruncatingAStreamRunner {	
	
	public static void main(String[] args) {
		List<Dish> menu = getDishesInMenu();
		
		// Select the first three dishes that have more than 500 calories
		List<Dish> firstThreeHighCaloricDishes = menu.stream()
														.filter(dish -> dish.getCalories() > 500)
														.limit(3)
														.collect(toList());
		System.out.println(firstThreeHighCaloricDishes);
		
		// Filter the first two meat Dishes
		List<Dish> firstTwoMeatDishes =	menu.stream()
											.filter(d -> Dish.Type.MEAT == d.getType())
											.limit(2)
											.collect(toList());
		System.out.println(firstTwoMeatDishes);
	}
	
	@SuppressWarnings("serial")
	private static List<Dish> getDishesInMenu() {
		return new ArrayList<Dish>() {{ 
			add(new Dish("pork", false, 800, Dish.Type.MEAT));
			add(new Dish("beef", false, 700, Dish.Type.MEAT));
			add(new Dish("chicken", false, 400, Dish.Type.MEAT));
			add(new Dish("french fries", true, 530, Dish.Type.OTHER));
			add(new Dish("rice", true, 350, Dish.Type.OTHER));
			add(new Dish("season fruit", true, 120, Dish.Type.OTHER));
			add(new Dish("pizza", false, 550, Dish.Type.OTHER));
			add(new Dish("prawns", false, 300, Dish.Type.FISH));
			add(new Dish("salmon", false, 450, Dish.Type.FISH));
		}};
	}
}
