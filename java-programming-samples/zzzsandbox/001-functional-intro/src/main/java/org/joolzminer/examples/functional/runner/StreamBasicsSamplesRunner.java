package org.joolzminer.examples.functional.runner;

import java.util.List;
import java.util.stream.Stream;

import org.joolzminer.examples.domain.Dish;

import static java.util.Comparator.*; 
import static java.util.stream.Collectors.*;


public class StreamBasicsSamplesRunner {
	
	
	public static void main(String[] args) {
		
		List<Dish> menu = Dish.someDishesInMenu.get(); 
		
		// list of dish names in the menu ordered by their caloric value
		List<String> dishNamesSortedByCalories = menu.stream()
													.sorted(comparing(Dish::getCalories))
													.map(Dish::getName)
													.collect(toList());
		System.out.println(dishNamesSortedByCalories);
		System.out.println("=================================================");
		
		// list of dish names with caloric value < 400 ordered by their caloric value
		List<String> lightDishNamesSortedByCalories = menu.stream()
				.filter(d -> d.getCalories() < 400)
				.sorted(comparing(Dish::getCalories))
				.map(Dish::getName)
				.collect(toList());
		
		System.out.println(lightDishNamesSortedByCalories);
		System.out.println("=================================================");
		
		
		// streams use internal iteration but can be traversed just like collections
		Dish.someDishesInMenu.get()
							.stream()
							.forEach(System.out::println);
		System.out.println("=================================================");	
		
		// streams cannot be traversed twice
		List<Dish> dishes = Dish.someDishesInMenu.get();
		Stream<Dish> dishStream = dishes.stream();
		
		dishStream.forEach(d -> System.out.println("The " + d.getName() + " dish has " + d.getCalories() + " calories."));
		try {
			dishStream.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
}

