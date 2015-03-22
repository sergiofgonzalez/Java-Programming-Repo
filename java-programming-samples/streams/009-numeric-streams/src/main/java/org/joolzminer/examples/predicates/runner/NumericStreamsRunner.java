package org.joolzminer.examples.predicates.runner;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.joolzminer.examples.domain.Dish;

public class NumericStreamsRunner {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Dish> menu = Dish.getSomeDishesInMenu();
		
		// Count all the calories in the menu
		// without using Stream specialized version
		menu.stream()
			.map(Dish::getCalories)
			.reduce(Integer::sum)
			.ifPresent(System.out::println);
		
		// Using the IntStream specialization
		int sumCalories = menu.stream()
							.mapToInt(Dish::getCalories)
							.sum();
		System.out.println(sumCalories);
		
		OptionalInt minCalories = menu.stream()
				.mapToInt(Dish::getCalories)
				.min();
		System.out.println(minCalories.getAsInt());
		
		menu.stream()
				.mapToInt(Dish::getCalories)
				.max()
				.ifPresent(System.out::println);
				
		menu.stream()
				.mapToInt(Dish::getCalories)
				.average()
				.ifPresent(System.out::println);
		
		// Converting an specialized IntStream back to Stream<Integer> 
		IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
		Stream<Integer> stream = intStream.boxed();
	}
}
