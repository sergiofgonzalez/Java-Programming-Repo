package org.joolzminer.examples.predicates.runner;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.joolzminer.examples.domain.Dish;
import org.joolzminer.examples.predicates.runner.GroupingRunner.CaloricLevel;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class MultiLevelGroupingRunner {
	public static void main(String[] args) {
		List<Dish> menu = Dish.getSomeDishesInMenu();
		
		// Collect a Map that groups dishes by type, and then by its caloric level
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = 
				menu.stream()
					.collect(
						groupingBy(Dish::getType, groupingBy((Dish dish) -> {
							if (dish.getCalories() <= 400) {
								return CaloricLevel.DIET;
							} else if (dish.getCalories() <= 700) {
								return CaloricLevel.NORMAL;
							} else {
								return CaloricLevel.FAT;
							}
						})));
		
		prettyPrintMultiLevelMap(dishesByTypeCaloricLevel);
		
		// Collect a Map that classifies the dishes by type and count them
		Map<Dish.Type, Long> dishByTypeCountMap =
				menu.stream()
					.collect(groupingBy(Dish::getType, counting()));
		
		System.out.println(dishByTypeCountMap);
		
		// Find the highest-calorie dish classified by the type of Dish
		Map<Dish.Type, Optional<Dish>> highestCaloricDishByTypeMap = 
				menu.stream()
					.collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
		
		prettyPrintMap(highestCaloricDishByTypeMap);
		
		// Find the highest-calorie dish classified by the type of Dish
		// and get rid of the Optional as it is not useful here
		Map<Dish.Type, Dish> highestCaloricDishByTypeMapAlt = 
				menu.stream()
					.collect(groupingBy(Dish::getType,
								collectingAndThen(maxBy(comparingInt(Dish::getCalories)), 
										Optional::get)));
		prettyPrintMapAlt(highestCaloricDishByTypeMapAlt);
		
		// Obtain a map with the sum of the calories classified 
		// by the types of Dishes
		Map<Dish.Type, Integer> dishCaloriesByType =
				menu.stream()
					.collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
		System.out.println(dishCaloriesByType);
		
		// Find out which CaloricLevels are available in the menu
		// for each type of Dish
		Map<Dish.Type, Set<CaloricLevel>> availCaloricLevelsByType =
				menu.stream()
					.collect(groupingBy(Dish::getType, mapping((Dish dish) -> {
						if (dish.getCalories() <= 400) {
							return CaloricLevel.DIET;
						} else if (dish.getCalories() <= 700) {
							return CaloricLevel.NORMAL;
						} else {
							return CaloricLevel.FAT;
						}
					}, toSet())));
		
		System.out.println(availCaloricLevelsByType);
		
		// Same again but forcing for a specific type of Set
		Map<Dish.Type, Set<CaloricLevel>> availCaloricLevelsByTypeAlt =
				menu.stream()
					.collect(groupingBy(Dish::getType, mapping((Dish dish) -> {
						if (dish.getCalories() <= 400) {
							return CaloricLevel.DIET;
						} else if (dish.getCalories() <= 700) {
							return CaloricLevel.NORMAL;
						} else {
							return CaloricLevel.FAT;
						}
					}, toCollection(HashSet::new))));
		
		System.out.println(availCaloricLevelsByTypeAlt);
	}

	
	public static <K1,K2,V> void prettyPrintMultiLevelMap(Map<K1, Map<K2, List<V>>> multiLevelMap) {
		for (Entry<K1, Map<K2,List<V>>> mapEntry : multiLevelMap.entrySet()) {
			System.out.println(mapEntry.getKey());
			for (Entry<K2, List<V>> entry : mapEntry.getValue().entrySet()) {
				System.out.println("\t" + entry.getKey());
				for (V value : entry.getValue()) {
					System.out.println("\t\t" + value);
				}
			}
		}
	}
	
	public static <K,V> void prettyPrintMap(Map<K,Optional<V>> map) {
		for (Entry<K,Optional<V>> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			entry.getValue().ifPresent(v -> System.out.println("\t" + v));
		}
	}
	
	public static <K,V> void prettyPrintMapAlt(Map<K,V> map) {
		for (Entry<K,V> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
