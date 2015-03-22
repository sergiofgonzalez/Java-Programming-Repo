package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




import java.util.stream.Stream;

import org.joolzminer.examples.domain.Dish;

public class StreamsRunner {	
	
	public static void main(String[] args) {
		List<Dish> menu = getDishesInMenu();
		Stream<Dish> dishStream = menu.stream();
		dishStream.forEach(System.out::println);
//		dishStream.forEach(System.out::println); // IllegalStateException: stream has been already consumed
		
		List<String> words = Arrays.asList("More than words is all you need".split(" "));
		Stream<String> wordsStream = words.stream();
		wordsStream.forEach(System.out::println);		
	}
	
	@SuppressWarnings("serial")
	private static List<Dish> getDishesInMenu() {
		return new ArrayList<Dish>() {{ 
			add(new Dish("pork", false, 800, Dish.Type.MEAT));
			add(new Dish("beef", false, 700, Dish.Type.MEAT));
			add(new Dish("chicken", false, 400, Dish.Type.MEAT));
			add(new Dish("french fries", true, 530, Dish.Type.OTHER));
			add(new Dish("rice", true, 350, Dish.Type.OTHER));
			add(new Dish("season fruit", true, 120, Dish.Type.OTHER));
			add(new Dish("pizza", false, 550, Dish.Type.OTHER));
			add(new Dish("prawns", false, 300, Dish.Type.FISH));
			add(new Dish("salmon", false, 450, Dish.Type.FISH));
		}};
	}
}
