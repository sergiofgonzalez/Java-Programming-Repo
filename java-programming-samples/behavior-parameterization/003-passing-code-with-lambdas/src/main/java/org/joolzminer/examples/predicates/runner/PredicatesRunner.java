package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.List;

import org.joolzminer.examples.domain.Apple;
import org.joolzminer.examples.predicates.AppleFormatter;
import org.joolzminer.examples.predicates.ApplePredicate;

public class PredicatesRunner {
	
	@SuppressWarnings("serial")
	private static List<Apple> apples = new ArrayList<Apple>() {{ 
		add(new Apple("red", 150));
		add(new Apple("green", 80));
		add(new Apple("yellow", 125));		
	}};
	
	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	
	public static void prettyPrintAppleInventory(List<Apple> inventory, AppleFormatter formatter) {
		for (Apple apple : inventory) {
			String output = formatter.accept(apple);
			System.out.println(output);
		}
	}
	
	public static void main(String[] args) {
		// Filter Green Apples
		System.out.println(PredicatesRunner.filterApples(apples, (Apple apple) -> "red".equals(apple.getColor())));
		
		// Filter Apples that weighs more than 100g
		System.out.println(PredicatesRunner.filterApples(apples, (Apple apple) -> apple.getWeight() > 100)); 
		
		// Filter Apples that are red and weigh more than 100g
		System.out.println(PredicatesRunner.filterApples(apples, 
				(Apple apple) -> "red".equals(apple.getColor()) && apple.getWeight() > 100));
		
		PredicatesRunner.prettyPrintAppleInventory(apples,
				(Apple apple) -> "A " + apple.getColor() + " apple that weighs " + apple.getWeight() + " grams.");
	}
}
