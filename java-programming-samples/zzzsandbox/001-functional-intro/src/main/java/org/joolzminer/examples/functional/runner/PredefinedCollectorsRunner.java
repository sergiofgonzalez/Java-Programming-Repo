package org.joolzminer.examples.functional.runner;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.joolzminer.examples.domain.Dish;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class PredefinedCollectorsRunner {
	public static void main(String[] args) {
		List<Dish> menu = Dish.someDishesInMenu.get();
		
		// groupingBy() : Group the dishes by category
		Map<Dish.Type, List<Dish>> dishesByTypeMap =
				menu.stream()
					.collect(groupingBy(Dish::getType));
		
		prettyPrintListMap(dishesByTypeMap, dish -> System.out.println(dish.getName() + " (" + dish.getCalories() + " cal) " + (dish.isVegetarian() ? "veggie!!!" : "")));
		printSeparator();
		
		// count() : count the dishes in the menu
		System.out.println(menu.stream().count() + " dishes in the menu");
		printSeparator();
		
		// maxBy() : find the most caloric dish
		menu.stream()
			.collect(maxBy(comparingInt(Dish::getCalories)))
			.ifPresent(System.out::println);
		printSeparator();
		
		// minBy() : find the less caloric dish
		menu.stream()
			.collect(minBy(comparingInt(Dish::getCalories)))
			.ifPresent(System.out::println);		
		printSeparator();
		
		// summingInt() : obtain the sum of all the veggie dishes
		System.out.println(
				menu.stream()
					.filter(Dish::isVegetarian)
					.collect(summingInt(Dish::getCalories)));
			
		printSeparator();

		// averagingInt() : obtain the average cal of the non veggie dishes
		Predicate<Dish> veggieDish = Dish::isVegetarian;
		
		System.out.println(menu.stream()
								.filter(veggieDish.negate())
								.collect(averagingInt(Dish::getCalories)));
		
		printSeparator();
		
		// summarizingInt() : getting some basic statistics on the dishes
		System.out.println(menu.stream()
								.filter(veggieDish.negate())
								.collect(summarizingInt(Dish::getCalories)));
		printSeparator();
		
		// joining() : get all the names of the veggie dishes in a single string
		System.out.println(menu.stream()
								.filter(veggieDish)
								.map(Dish::getName)
								.collect(joining()));

		// this can be improved a wee lil' bit
		System.out.println(menu.stream()
								.filter(veggieDish)
								.map(Dish::getName)
								.collect(joining(", ")));
		printSeparator();
		
		// reducing() : obtain the sum of all the veggieDish calories
		System.out.println(menu.stream()
								.filter(veggieDish)
								.collect(reducing(0, Dish::getCalories, Integer::sum)));
		printSeparator();
		
		
		// groupingBy() : get all the dishes grouped by its caloric level
		// DIET 	<= 400
		// NORMAL 	> 400 and <= 700
		// FAT		> 700
		Map<CaloricLevel, List<Dish>> dishesByDietTypeMap =
				menu.stream()
					.collect(groupingBy(d -> {
						if (d.getCalories() <= 400) {
							return CaloricLevel.DIET;
						} else if (d.getCalories() <= 700) {
							return CaloricLevel.NORMAL;
						} else {
							return CaloricLevel.FAT;
						}
					}));
		prettyPrintListMap(dishesByDietTypeMap, d -> System.out.println(d.getName() + " (" + d.getCalories() + " cal)"));
		printSeparator();
		
		// groupingBy() multilevel : Group dishes by Type, then by its Caloric Level
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeAndCaloricLevelMap =
				menu.stream()
					.collect(groupingBy(Dish::getType, groupingBy((Dish d) -> {
						if (d.getCalories() <= 400) {
							return CaloricLevel.DIET;
						} else if (d.getCalories() <= 700) {
							return CaloricLevel.NORMAL;
						} else {
							return CaloricLevel.FAT;
						}
					})));
		prettyPrintTwoLevelMap(dishesByTypeAndCaloricLevelMap, dish -> System.out.println(dish.getName() + " (" + dish.getCalories() + " cal) "));
		printSeparator();
		
		// groupingBy() multilevel : Group dishes by type and then count them
		Map<Dish.Type, Long> dishesByTypeCountMap =
				menu.stream()
					.collect(groupingBy(Dish::getType, counting()));
		prettyPrintMap(dishesByTypeCountMap, System.out::println);
		printSeparator();
		
		// groupingBy() multilevel : find the highest caloric dish classified by type
		Map<Dish.Type, Optional<Dish>> highestCaloricDishByTypeMap =
				menu.stream()
					.collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
		prettyPrintMap(highestCaloricDishByTypeMap, o -> o.ifPresent(d -> System.out.println(d.getName() + " (" + d.getCalories() + " cal) ")));
		printSeparator();
		
		// collectingAndThen() : find the highest caloric dish classified by type getting rid of the Optional
		Map<Dish.Type, Dish> highestCaloricDishByTypeAltMap =
				menu.stream()
					.collect(groupingBy(Dish::getType, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
		prettyPrintMap(highestCaloricDishByTypeAltMap, d -> System.out.println(d.getName() + " (" + d.getCalories() + " cal) "));
		printSeparator();		
		
		// mapping() : find out which caloric levels are available in the menu for each type of Dish
		Map<Dish.Type, Set<CaloricLevel>> availCaloricLevelsByTypeMap =
				menu.stream()
					.collect(groupingBy(Dish::getType, mapping(d -> {
						if (d.getCalories() <= 400) {
							return CaloricLevel.DIET;
						} else if (d.getCalories() <= 700) {
							return CaloricLevel.NORMAL;
						} else {
							return CaloricLevel.FAT;
						}
					}, toSet())));
		
		prettyPrintMap(availCaloricLevelsByTypeMap, System.out::println);
		printSeparator();
		
		// mapping() : force for an specific type of collection
		Map<Dish.Type, Set<CaloricLevel>> availCaloricLevelsHashSetByTypeMap =
				menu.stream()
					.collect(groupingBy(Dish::getType, mapping(d -> {
						if (d.getCalories() <= 400) {
							return CaloricLevel.DIET;
						} else if (d.getCalories() <= 700) {
							return CaloricLevel.NORMAL;
						} else {
							return CaloricLevel.FAT;
						}
					}, toCollection(HashSet::new))));
		prettyPrintMap(availCaloricLevelsHashSetByTypeMap, System.out::println);
		printSeparator();
	
		// partitioningBy() : partition the dishes in veggie/non-veggie
		Map<Boolean,List<Dish>> veggiePartitionMap =
				menu.stream()
					.collect(partitioningBy(Dish::isVegetarian));
		prettyPrintListMap(veggiePartitionMap, d -> System.out.println(d.getName() + " (" + d.getCalories() + " cal) "));
		printSeparator();
		
		// partitioningBy() : partition the dishes in veggie/non-veggie, then group by type
		Map<Boolean, Map<Dish.Type, List<Dish>>> veggiePartitionGroupByTypeMap =
				menu.stream()
					.collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
		prettyPrintTwoLevelMap(veggiePartitionGroupByTypeMap, d -> System.out.println(d.getName() + " (" + d.getCalories() + " cal) "));
		printSeparator();
		
		// partitioningBy() : find the most caloric dish among the veggie/non-veggie dishes
		Map<Boolean, Dish> mosCaloricDishAmongVeggiePartitionMap =
				menu.stream()
					.collect(partitioningBy(Dish::isVegetarian, 
								collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
		prettyPrintMap(mosCaloricDishAmongVeggiePartitionMap, d -> System.out.println(d.getName() + " (" + d.getCalories() + " cal) "));
		printSeparator();
	}
	
	enum CaloricLevel { DIET, NORMAL, FAT };
	
	public static <K,V> void prettyPrintMap(Map<K,V> map, Consumer<V> itemPrinter) {
		for (Entry<K,V> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":");
			System.out.print("\t");
			itemPrinter.accept(entry.getValue());
		}
	}
	
	public static <K,V> void prettyPrintListMap(Map<K,List<V>> map, Consumer<V> itemPrinter) {
		for (Entry<K,List<V>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":");
			for (V item : entry.getValue()) {
				System.out.print("\t");
				itemPrinter.accept(item);
			}
		}
	}
	
	public static <K1, K2, V> void prettyPrintTwoLevelMap(Map<K1, Map<K2, List<V>>> map, Consumer<V> itemPrinter) {
		for (Entry<K1, Map<K2, List<V>>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":");
			for (Entry<K2, List<V>> innerEntry : entry.getValue().entrySet()) {
				System.out.println("\t" + innerEntry.getKey() + ":");
				for (V item : innerEntry.getValue()) {
					System.out.print("\t\t");
					itemPrinter.accept(item);
				}
			}
		}
	}
	
	
	public static void printSeparator() {
		System.out.println("==============================================================================");
	}
		
}
