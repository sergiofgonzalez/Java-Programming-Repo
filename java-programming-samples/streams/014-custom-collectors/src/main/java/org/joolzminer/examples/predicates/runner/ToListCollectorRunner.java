package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.List;

import org.joolzminer.examples.domain.Dish;
import org.joolzminer.examples.predicates.collectors.ToListCollector;

public class ToListCollectorRunner {
	public static void main(String[] args) {
		List<Dish> menu = Dish.getSomeDishesInMenu();
		
		List<Dish> dishes = menu.stream().collect(new ToListCollector<Dish>());
		System.out.println(dishes);
		
		// Using the overloaded collect() method
		List<Dish> veggieDishes = menu.stream().filter(Dish::isVegetarian)
									.collect(ArrayList::new, List::add, List::addAll);
		System.out.println(veggieDishes);
	}
}
