package org.joolzminer.examples.functional.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joolzminer.examples.domain.Apple;
import org.joolzminer.examples.domain.Dish;
import org.joolzminer.examples.functions.Consumer;
import org.joolzminer.examples.functions.Predicate;

public class GenericCustomFilterRunner {

	public static <T> List<T> filter(List<T> items, Predicate<T> p) {
		List<T> resultList = new ArrayList<>();
		for (T item : items) {
			if (p.test(item)) {
				resultList.add(item);
			}			
		}
	
		return resultList;
	}
	
	public static <T> void print(List<T> items, Consumer<T> c) {
		for (T item : items) {
			c.accept(item);
		}
	}
	
	private static Consumer<Apple> applePrettyPrinter = a -> System.out.println("The apple is " + a.getColor() + " and weighs " + a.getWeight() + " grams.");
		
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Filter red and heavy apples
		List<Apple> apples = Apple.getSomeApples();
		List<Apple> redAndHeavyApples = filter(apples, a -> "red".equalsIgnoreCase(a.getColor()) && a.getWeight() > 100);
		print(redAndHeavyApples, a -> System.out.println("The apple is " + a.getColor() + " and weighs " + a.getWeight() + " grams."));
		
		// Filter even numbers
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> evenNumbers = filter(numbers, n -> n % 2 == 0);
		print(evenNumbers, System.out::println);
		
		// Using lambdas to reduce verbosity with existing code
		apples.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
		print(apples, applePrettyPrinter);
		
		List<Dish> menu = Dish.someDishesInMenu.get();
	}
}
