package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.List;




import org.joolzminer.examples.domain.Dish;

public class StreamsRunner {	
	
	public static void main(String[] args) {
		List<Dish> menu = getDishesInMenu();
		
		// Return a list with the names of the dishes that are low in calories,
		// sorted by number of calories
		// Java 8 version
		
		List<String> lowCaloricDishesNameList =
				menu.stream()
					.filter(dish -> dish.getCalories() < 400)
					.sorted(comparing(Dish::getCalories))
					.map(Dish::getName)
					.collect(toList());
		
		System.out.println("The low caloric dishes in the menu are: " + lowCaloricDishesNameList);	
		
		
		// Return a list with the names of the 3 most caloric dishes
		// of the menu
		// Java 8 version
		List<String> topThreeMostCaloricDishesNameList =
				menu.stream()
					.sorted(comparing(Dish::getCalories).reversed())
					.limit(3)
					.map(Dish::getName)
					.collect(toList());
		System.out.println("The top 3 caloric dishes in the menu are: " + topThreeMostCaloricDishesNameList);					
		
		
		
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
