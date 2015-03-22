package org.joolzminer.examples.predicates.runner;

import java.util.List;

import org.joolzminer.examples.domain.Dish;

public class QuizRunner {
	
	public static void main(String[] args) {
		List<Dish> menu = Dish.getSomeDishesInMenu();
		
		// Count the number of dishes in the menu
		int dishCount = menu.stream()
							.map(dish -> 1)
							.reduce(0, (a, b) -> a + 1);
		
		System.out.println(dishCount);
		
		// This can also be performed using the count() terminal operation
		System.out.println(menu.stream().count());
	}
}
