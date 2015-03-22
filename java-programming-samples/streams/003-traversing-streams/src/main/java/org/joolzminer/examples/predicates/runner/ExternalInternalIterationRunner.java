package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




import static java.util.stream.Collectors.*;

import org.joolzminer.examples.domain.Dish;

public class ExternalInternalIterationRunner {	
	
	public static void main(String[] args) {
		List<Dish> menu = getDishesInMenu();

		// External Iteration
		// Get the names of all the dishes in the menu
		List<String> dishNames = new ArrayList<>();
		Iterator<Dish> iterator = menu.iterator();
		while (iterator.hasNext()) {
			Dish dish = iterator.next();
			dishNames.add(dish.getName());
		}
		System.out.println(dishNames);

		// Internal Iteration
		// Get the names of all the dishes in the menu
		List<String> names = menu.stream()
								.map(Dish::getName)
								.collect(toList());
		System.out.println(names);
		
		
		// Internal Iteration with traces
		// Get the top 3 caloric dishes in the menu
		List<String> topThreeCaloricDishes = menu.stream()
								.filter(dish -> {
									System.out.println("Filtering " + dish.getName());
									return dish.getCalories() > 300;
								})
								.map(dish -> {
									System.out.println("Mapping " + dish.getName());
									return dish.getName();
								})
								.limit(3)
								.collect(toList());
		System.out.println(topThreeCaloricDishes);
		
		
		// Terminal operation is void
		// Print all the dishes in the menu
		menu.stream().forEach(System.out::println);
	
		// Terminal operation is int
		// Count all the dishes in the menu with more than 300 cal
		menu.stream()
			.filter(dish -> dish.getCalories() > 300)
			.count();
			
		
		// Get the list of the names of the vegeratian Dishes

		// External iteration
		List<String> vegetarianDishNames = new ArrayList<>();
		for (Dish dish : menu) {
			if (dish.isVegetarian()) {
				vegetarianDishNames.add(dish.getName());
			}
		}
		System.out.println(vegetarianDishNames);
		
		
		// Internal Iteration
		System.out.println(
				menu.stream()
					.filter(Dish::isVegetarian)
					.map(Dish::getName)
					.collect(toList())
				);
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
