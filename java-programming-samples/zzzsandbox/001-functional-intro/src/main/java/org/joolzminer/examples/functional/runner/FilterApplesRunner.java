package org.joolzminer.examples.functional.runner;

import java.util.ArrayList;
import java.util.List;

import org.joolzminer.examples.domain.Apple;
import org.joolzminer.examples.functions.ApplePredicate;
import org.joolzminer.examples.functions.AppleRedAndHeavyPredicate;

public class FilterApplesRunner {
	
	public static List<Apple> filterApples(List<Apple> apples, ApplePredicate p) {
		List<Apple> resultList = new ArrayList<>();
		for (Apple apple : apples) {
			if (p.test(apple)) {
				resultList.add(apple);
			}
		}
		return resultList;
	}	
	
	public static void main(String[] args) {
		System.out.println("================================");
		System.out.println(filterApples(Apple.getSomeApples(), new AppleRedAndHeavyPredicate()));
		
		System.out.println("================================");
		System.out.println(filterApples(Apple.getSomeApples(), new ApplePredicate() {
			
			@Override
			public boolean test(Apple apple) {
				return "red".equalsIgnoreCase(apple.getColor());
			}
		}));
		
		// Using Lambdas
		// - green apples
		// - apples that weigh more than 100g
		// - red and heavy apples
		// - red apples
		
		System.out.println("================================");
		System.out.println(filterApples(Apple.getSomeApples(), (Apple a) -> "green".equalsIgnoreCase(a.getColor())));
		
		System.out.println("================================");
		System.out.println(filterApples(Apple.getSomeApples(), a -> a.getWeight() > 100));
		
		System.out.println("================================");
		System.out.println(filterApples(Apple.getSomeApples(), a -> "red".equalsIgnoreCase(a.getColor()) && a.getWeight() > 100));
		
		System.out.println("================================");
		System.out.println(filterApples(Apple.getSomeApples(), a -> "red".equalsIgnoreCase(a.getColor())));
		
		
		
	}
}
