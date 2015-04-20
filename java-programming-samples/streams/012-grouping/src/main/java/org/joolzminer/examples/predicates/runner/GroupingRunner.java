package org.joolzminer.examples.predicates.runner;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.joolzminer.examples.domain.Dish;

import static java.util.stream.Collectors.*;

public class GroupingRunner {
	public static void main(String[] args) {
		List<Dish> menu = Dish.getSomeDishesInMenu();
		
		// Classify in a map the dishes in the menu according to their type
		Map<Dish.Type, List<Dish>> dishesByTypeMap = menu.stream()
														.collect(groupingBy(Dish::getType));
		
		prettyPrintMap(dishesByTypeMap);
		
		// Classify dishes according to:
		//	- diet   : all dishes with 400 cal or fewer
		//  - normal : dishes between 400 and 700 cal
		//  - fat    : dishes with more than 700 cal
		
		Map<CaloricLevel, List<Dish>> dishesByDietTypeMap = menu.stream()
				.collect(groupingBy(dish -> {
					if (dish.getCalories() <= 400) {
						return CaloricLevel.DIET;
					} else if (dish.getCalories() <= 700) {
						return CaloricLevel.NORMAL;
					} else {
						return CaloricLevel.FAT;
					}
				}));
		
		prettyPrintMap(dishesByDietTypeMap);
	}
	
	public enum CaloricLevel { DIET, NORMAL, FAT }
	
	public static <K,V> void prettyPrintMap(Map<K,List<V>> groupMap) {
		for (Entry<K, List<V>> mapEntry : groupMap.entrySet()) {
			System.out.println(mapEntry.getKey());
			for (V value : mapEntry.getValue()) {
				System.out.println("\t" + value);
			}
		}
	}
}
