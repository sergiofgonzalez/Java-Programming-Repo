package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.List;
import org.joolzminer.examples.domain.Apple;
import org.joolzminer.examples.generics.GenericFunctionsHolder;

public class PredicatesRunner {
	
	@SuppressWarnings("serial")
	private static List<Apple> apples = new ArrayList<Apple>() {{ 
		add(new Apple("red", 150));
		add(new Apple("green", 80));
		add(new Apple("yellow", 125));		
	}};
	

	@SuppressWarnings("serial")
	private static List<Integer> numbers = new ArrayList<Integer>() {{ 
		for (int i = 1; i <= 10; i++) {
			add(i);
		}
	}};
	
	@SuppressWarnings("serial")
	private static List<String> names = new ArrayList<String>() {{
		add("Inma");
		add("Sergio");
		add("Adri");
	}};
	
	
	public static void main(String[] args) {
		// Filter Green Apples
		System.out.println(
				GenericFunctionsHolder.filter(apples, (Apple apple) -> "green".equals(apple.getColor())));
		
		// Filter Apples that weighs more than 100g
		System.out.println(
				GenericFunctionsHolder.filter(apples, (Apple apple) -> apple.getWeight() > 100)); 
		
		// Filter Apples that are red and weigh more than 100g
		System.out.println(
				GenericFunctionsHolder.filter(apples, 
						(Apple apple) -> "red".equals(apple.getColor()) && apple.getWeight() > 100));
		
		
		GenericFunctionsHolder.prettyPrint(apples,
				(Apple apple) -> "A " + apple.getColor() + " apple that weighs " + apple.getWeight() + " grams.");
		
		// Now with Integer
		System.out.println(
				GenericFunctionsHolder.filter(numbers, (Integer num) -> num % 2 == 0));
		
		// Now with Strings
		System.out.println(
				GenericFunctionsHolder.filter(names, (String name) -> name.length() > 4));		
	}
}
