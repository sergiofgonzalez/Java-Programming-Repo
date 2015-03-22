package org.joolzminer.examples.predicates.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.joolzminer.examples.domain.Dish;

public class FindingRunner {	
	
	public static void main(String[] args) {
		List<Dish> menu = Dish.getSomeDishesInMenu();
		
		// Find me any vegetarian dish
		Optional<Dish> anyVegetarianDish = menu.stream()
									.filter(Dish::isVegetarian)
									.findAny();

		if (anyVegetarianDish.isPresent()) {
			System.out.println("I recommend " + anyVegetarianDish.get().getName());
		}
		
		// More succint
		menu.stream()
			.filter(Dish::isVegetarian)
			.map(Dish::getName)
			.findAny()
			.ifPresent(System.out::println);
		
		// Any vegetarian dish with +1Kcal? (there is none)
		System.out.println(menu.stream()
			.filter(Dish::isVegetarian)
			.filter(dish -> dish.getCalories() > 1000)
			.findAny()
			.orElse(new Dish("On Demand Veggie Pizza", true, 1001, Dish.Type.OTHER)));
		
		// Find the first square divisible by 3
		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
															.map(n -> n * n)
															.filter(n -> n % 3 == 0)
															.findFirst();

		firstSquareDivisibleByThree.ifPresent(System.out::println);
	}

}
