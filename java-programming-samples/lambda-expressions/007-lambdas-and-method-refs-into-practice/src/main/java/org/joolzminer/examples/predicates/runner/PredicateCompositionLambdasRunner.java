package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;

import static java.util.Comparator.*;

import java.util.List;
import java.util.function.Predicate;

import org.joolzminer.examples.predicates.domain.Apple;



public class PredicateCompositionLambdasRunner {


	public static void main(String[] args) {
		
		// ByWeight: Forward
		List<Apple> apples = resetInventory();
		System.out.println("before: " + apples);
		apples.sort(comparing(Apple::getWeight));
		System.out.println("after : " + apples);		
		
		// ByWeight: Reverse
		apples = resetInventory();
		System.out.println("before: " + apples);
		apples.sort(comparing(Apple::getWeight).reversed());
		System.out.println("after : " + apples);
		
		// ByWeight, then by color
		apples = resetInventory();
		apples.add(new Apple(80, "black"));
		System.out.println("before: " + apples);
		apples.sort(comparing(Apple::getWeight)
						.reversed()
						.thenComparing(Apple::getColor));
		System.out.println("after : " + apples);
				
		// Negate an existing Predicate
		apples = resetInventory();
		System.out.println("before: " + apples);
		Predicate<Apple> redApple = (apple) -> "red".equals(apple.getColor());
		Predicate<Apple> notRedApple = redApple.negate();
		apples = filter(apples, notRedApple);
		System.out.println("after : " + apples);
		
		// And composition of Predicates
		apples = resetInventory();
		apples.add(new Apple(90, "green"));
		System.out.println("before: " + apples);
		
		Predicate<Apple> greenApple = (apple) -> "green".equals(apple.getColor());
		Predicate<Apple> heavyApple = (apple) -> apple.getWeight() >= 100;
		Predicate<Apple> greenAndHeavyApple = greenApple.and(heavyApple);
		
		apples = filter(apples, greenAndHeavyApple);
		System.out.println("after : " + apples);	
		
		// Or composition of Predicates
		apples = resetInventory();

		System.out.println("before: " + apples);		
		Predicate<Apple> yellowApple = (apple) -> "yellow".equals(apple.getColor());
		Predicate<Apple> yellowOrLightApple = yellowApple.or(apple -> apple.getWeight() < 80);
		
		apples = filter(apples, yellowOrLightApple);
		System.out.println("after : " + apples);			
	}
	
	@SuppressWarnings("serial")
	private static List<Apple> resetInventory() {
		return new ArrayList<Apple>() {{ 
			add(new Apple(80, "yellow"));
			add(new Apple(65, "red"));
			add(new Apple(100, "green"));			
		}};
	}
	
	private static List<Apple> filter(List<Apple> apples, Predicate<Apple> predicate) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : apples) {
			if (predicate.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}
