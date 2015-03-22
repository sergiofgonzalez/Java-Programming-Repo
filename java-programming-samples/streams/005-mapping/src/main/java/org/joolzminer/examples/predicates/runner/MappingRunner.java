package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

import org.joolzminer.examples.domain.Dish;

public class MappingRunner {	
	
	public static void main(String[] args) {
		List<Dish> menu = getDishesInMenu();
		
		// Map the Dishes to the Dish name
		List<String> dishNames = menu.stream()
										.map(Dish::getName)
										.collect(toList());
		System.out.println(dishNames);
		
		
		// Map a list of strings to a list of integer
		// representing the length of each word
		List<String> words = Arrays.asList("Java8", "Lambdas", "in", "Action");
		List<Integer> wordLengths = words.stream()
										.map(String::length)
										.collect(toList());
		System.out.println(wordLengths);
		
		// Map the Dishes to the length of each Dish name
		List<Integer> dishNameLengths = menu.stream()
											.map(Dish::getName)
											.map(String::length)
											.collect(toList());
		System.out.println(dishNameLengths);		
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
