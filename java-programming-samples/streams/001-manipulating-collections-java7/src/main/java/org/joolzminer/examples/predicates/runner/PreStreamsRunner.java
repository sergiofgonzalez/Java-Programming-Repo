package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.joolzminer.examples.domain.Dish;

public class PreStreamsRunner {	
	
	public static void main(String[] args) {
		List<Dish> menu = getDishesInMenu();
		
		// Return a list with the names of the dishes that are low in calories,
		// sorted by number of calories
		// Java 7 version
		
		List<Dish> lowCaloricDishes = new ArrayList<>();
		for (Dish dish : menu) {
			if (dish.getCalories() < 400) {
				lowCaloricDishes.add(dish);
			}
		}
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {

			@Override
			public int compare(Dish d1, Dish d2) {
				return d1.getCalories().compareTo(d2.getCalories());
			}
		});
		
		List<String> lowCaloricDishesNameList = new ArrayList<>();
		for (Dish dish : lowCaloricDishes) {
			lowCaloricDishesNameList.add(dish.getName());
		}
		
		System.out.println("The low caloric dishes in the menu are: " + lowCaloricDishesNameList);	
		
		
		// Return a list with the names of the 3 most caloric dishes
		// of the menu
		// Java 7 version
		List<Dish> highCaloricDishes = new ArrayList<>();
		for (Dish dish : menu) {
			highCaloricDishes.add(dish);
		}
		highCaloricDishes.sort(new Comparator<Dish>() {

			@Override
			public int compare(Dish d1, Dish d2) {
				return d2.getCalories().compareTo(d1.getCalories());
			}
		});
		
		List<String> topThreeHighCaloricDishesNameList = new ArrayList<>(3);
		for (int i = 0; i < 3; i++) {
			topThreeHighCaloricDishesNameList.add(highCaloricDishes.get(i).getName());
		}
		System.out.println("The top 3 caloric dishes in the menu are: " + topThreeHighCaloricDishesNameList);	
		
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
