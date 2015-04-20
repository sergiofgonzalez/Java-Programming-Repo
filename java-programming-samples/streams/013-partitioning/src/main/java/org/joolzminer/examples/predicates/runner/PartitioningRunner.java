package org.joolzminer.examples.predicates.runner;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.joolzminer.examples.domain.Dish;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class PartitioningRunner {
	public static void main(String[] args) {
		List<Dish> menu = Dish.getSomeDishesInMenu();
		
		// Partition the dishes in Vegetarian/Non-Veggie Dishes
		Map<Boolean,List<Dish>> partitionedMenu =
				menu.stream()
					.collect(partitioningBy(Dish::isVegetarian));
		
		prettyPrintPartitionedMap(partitionedMenu);
		
		partitionedMenu.get(true)
						.stream()
						.forEach(System.out::println);
		
		// Alternatively, you can use filter and collect
		System.out.println(menu.stream()
								.filter(Dish::isVegetarian)
								.collect(toList()));
		
		// Partition the dishes in Veggie/Non-veggie dishes
		// and then grouped by type
		Map<Boolean,Map<Dish.Type, List<Dish>>> veggieDishesByType =
				menu.stream()
					.collect(partitioningBy(Dish::isVegetarian, 
							                groupingBy(Dish::getType)));
		
		prettyPrintMultiLevelMap(veggieDishesByType);
		
		
		// Find the most caloric dish among both veggie/non-veggie dishes
		Map<Boolean, Dish> mostCaloricDishAmongVeggieNonVeggie =
				menu.stream()
					.collect(partitioningBy(Dish::isVegetarian, 
											collectingAndThen(maxBy(comparingInt(Dish::getCalories)),
													Optional::get)));
		System.out.println(mostCaloricDishAmongVeggieNonVeggie);
		
		// MultiLevel partitioning
		// Partition between Veggie/Non Veggie and
		// between dishes with more than 500 cal and less
		Map<Boolean, Map<Boolean, List<Dish>>> dishesByVeggieAndCal =
				menu.stream()
					.collect(partitioningBy(Dish::isVegetarian, 
								partitioningBy((Dish dish) -> {
									return dish.getCalories() > 500;
								})));
		
		prettyPrintMultiLevelMap(dishesByVeggieAndCal);
	}
	
	public static <K,V> void prettyPrintPartitionedMap(Map<K,List<V>> partitionedMap) {
		for (Entry<K,List<V>> entry : partitionedMap.entrySet()) {
			System.out.println(entry.getKey());
			for (V v : entry.getValue()) {
				System.out.println("\t" + v);
			}
		}
	}
	
	public static <K1, K2, V> void prettyPrintMultiLevelMap(Map<K1, Map<K2, List<V>>> multiLevelMap) {
		for (Entry<K1, Map<K2,List<V>>> mapEntry  : multiLevelMap.entrySet()) {
			System.out.println(mapEntry.getKey());
			for (Entry<K2, List<V>> entry : mapEntry.getValue().entrySet()) {
				System.out.println("\t" + entry.getKey());
				for (V v : entry.getValue()) {
					System.out.println("\t\t" + v);
				}
			}
		}
	}
}
