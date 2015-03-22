package org.joolzminer.examples.predicates.runner;

import java.util.List;

import org.joolzminer.examples.domain.Dish;

public class MatchingRunner {	
	
	public static void main(String[] args) {
		List<Dish> menu = Dish.getSomeDishesInMenu();
		
		// Find whether the menu has any vegetarian option
		boolean anyVegetarianDish = menu.stream()
			.anyMatch(Dish::isVegetarian);
		
		if (anyVegetarianDish) {
			System.out.println("The menu is vegetarian-friendly!");
		}
		
		// Find whether all the elements of the menu are below 1KCal
		boolean isHealthy = menu.stream()
								.allMatch(dish -> dish.getCalories() < 1000);
		if (isHealthy) {
			System.out.println("The menu is somewhat healthy!");
		}
		
		boolean isHealthy2 = menu.stream()
									.noneMatch(dish -> dish.getCalories() >= 1000);
		if (isHealthy2) {
			System.out.println("The menu is somewhat healthy2!");
		}
	}

}
