package org.joolzminer.examples.predicates.runner;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

import org.joolzminer.examples.domain.Dish;

import static java.util.stream.Collectors.*;

public class SummarizingAndReducingRunner {
	
	public static void main(String[] args) {
		List<Dish> menu = Dish.getSomeDishesInMenu();
		
		// Reducing: Count the dishes in the menu
		long howManyDishes = menu.stream()
								.count();
		
		System.out.println(howManyDishes);
		
		// Alt approach: using collectors
		long howManyDishesAlt = menu.stream()
									.collect(counting());
		System.out.println(howManyDishesAlt);
		
		
		// Reducing: finding the most/less caloric dish
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		Optional<Dish> mostCaloricDish = menu.stream()
											.collect(maxBy(dishCaloriesComparator));
		mostCaloricDish.ifPresent(System.out::println);
		
		Optional<Dish> lessCaloricDish = menu.stream()
											   .collect(minBy(dishCaloriesComparator));
		lessCaloricDish.ifPresent(System.out::println);
		
		// using streams
		menu.stream()
			.max(Comparator.comparing(Dish::getCalories))
			.ifPresent(System.out::println);

		menu.stream()
			.min(Comparator.comparing(Dish::getCalories))
			.ifPresent(System.out::println);
			
		
		// Summarization: count all the calories of the menu
		int totalCalories = menu.stream()
								.collect(summingInt(Dish::getCalories));
		System.out.println(totalCalories);	
		
		// using IntStreams and sum
		System.out.println(
				menu.stream()
					.mapToInt(Dish::getCalories)					
					.sum());

		// using reduce
		System.out.println(
				menu.stream()
					.map(Dish::getCalories)
					.reduce(0, (accumulator, dishCalories) -> accumulator + dishCalories)
				);
		
		// Summarization: obtain the average calories of the menu
		double avgCalories = menu.stream()
								.collect(averagingInt(Dish::getCalories));
		System.out.println(avgCalories);
		
		// using IntStreams and average
		menu.stream()
			.mapToInt(Dish::getCalories)					
			.average()
			.ifPresent(System.out::println);
		
		// Summarization: obtain the summary statistics
		IntSummaryStatistics menuStatistics = menu.stream()
													.collect(summarizingInt(Dish::getCalories));
		System.out.println(menuStatistics);
		
		// Reduction: joining strings
		String menuStr = menu.stream()
							.map(Dish::getName)
							.collect(joining());
		System.out.println(menuStr);
	
		// An alt approach using reduce: but not that efficient as it creates a new string
		// in each iteration
		menu.stream()
			.map(Dish::getName)
			.reduce((accumulatedStr, elementStr) -> accumulatedStr + elementStr)
			.ifPresent(System.out::println);

		
		// You can also join the strings inserting a delimiter between elements
		System.out.println(
				menu.stream()
					.map(Dish::getName)
					.collect(joining(", "))
				);
		
		// The same using streams: but not that efficient as it creates a new string
		// in each iteration
		menu.stream()
			.map(Dish::getName)
			.reduce((accumulatedStr, elementStr) -> accumulatedStr + ", " + elementStr)
			.ifPresent(System.out::println);
	
		
		// Reduction: using the Collectors.reducing()
		// to perform a sum
		System.out.println(
			menu.stream()
				.collect(reducing(0, Dish::getCalories, Integer::sum)));
		
		// to perform a count
		System.out.println(
			menu.stream()
				.collect(reducing(0, d -> 1, Integer::sum))
				);
		
		// using a lambda as the third arg to exemplify args
		System.out.println(
				menu.stream()
					.collect(reducing(0, d -> 1, (acc, elem) -> acc + elem))
					);
		
		// using a custom collector
		System.out.println(
				menu.stream()
					.collect(customCounting())
				);
		
	}
	
	public static <T> Collector<T, ?, Long> customCounting() {
		return reducing(0L, e -> 1L, Long::sum);
	}
}
