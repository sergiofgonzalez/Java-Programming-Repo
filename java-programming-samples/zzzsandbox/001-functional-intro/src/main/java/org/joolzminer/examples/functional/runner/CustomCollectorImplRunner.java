package org.joolzminer.examples.functional.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.joolzminer.examples.collectors.CustomToListCollector;
import org.joolzminer.examples.domain.Dish;

public class CustomCollectorImplRunner {
	public static void main(String[] args) {
		List<Dish> menu = Dish.someDishesInMenu.get();
		
		// Use a custom collector impl to get the list of veggie dishes
		List<Dish> veggieDishes = menu.stream()
			.filter(Dish::isVegetarian)
			.collect(new CustomToListCollector<Dish>());
		
		System.out.println(veggieDishes);
		printSeparator();
		
		// Inline implementation of the custom collector
		Predicate<Dish> veggieDishPredicate = Dish::isVegetarian;
		
		List<Dish> veggieAltDishes = menu.stream()
										.filter(veggieDishPredicate.negate())
										.collect(ArrayList::new, List::add, List::addAll);
		System.out.println(veggieAltDishes);
		printSeparator();		
	}
	
	public static void printSeparator() {
		System.out.println("==============================================================================");
	}
	
}
