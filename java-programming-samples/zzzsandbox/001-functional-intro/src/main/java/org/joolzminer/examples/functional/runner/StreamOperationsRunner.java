package org.joolzminer.examples.functional.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.joolzminer.examples.domain.Dish;

import static java.util.stream.Collectors.*;

public class StreamOperationsRunner {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Dish> menu = Dish.someDishesInMenu.get(); 
		
		// filter(): Filter veggie dish names
		System.out.println(menu.stream()
								.filter(Dish::isVegetarian)
								.map(Dish::getName)
								.collect(toList()));
		printSeparator();
		
		// distinct(): Remove duplicate numbers in a stream
		List<Integer> numbers = Arrays.asList(1, 5, 3, 7, 3, 2, 7, 8, 1, 2, 3, 6, 0, 8, 6);
		
		System.out.println(numbers.stream()
									.distinct()
									.collect(toList()));
		printSeparator();
		
		// limit(): get the first three dishes with more than 500 cal
		System.out.println(menu.stream()
								.filter(d -> d.getCalories() > 500)								
								.collect(toList()));
		printSeparator();
		
		// skip(): Select the dishes with more than 500 cal skipping the first two ones
		menu.stream()
				.filter(d -> d.getCalories() > 500)
				.skip(2)
				.forEach(d -> System.out.println(d.getName()));
		printSeparator();
		
		// map(): map a list of words to its length
		List<String> words = Arrays.asList("Java8", "Lambdas", "in", "Action");
		words.stream()
				.map(String::length)
				.forEach(System.out::println);
		printSeparator();
		
		// flatMap(): return a list of all the unique characters in a list of words
		System.out.println(words.stream()
								.map(String::toLowerCase)
								.map(word -> word.split(""))
								.flatMap(Arrays::stream)
								.distinct()
								.collect(toList()));
		printSeparator();
		
		// this is the deconstruction
		// write tempX = stream.op() and let Eclipse tell you the resulting type
		// with the Content Assist
		// Example:
		//		temp1 = words.stream().map(String::toLowerCase);
		//
		//   After Content Assist - define local variable
		//		Stream<String> temp1 = words.stream().map(String::toLowerCase);
		
		Stream<String> temp1 = words.stream()
						.map(String::toLowerCase);
		
		Stream<String[]> temp2 = words.stream()
						.map(String::toLowerCase)
						.map(word -> word.split(""));
		
		Stream<Stream<String>> temp3 = words.stream()
										.map(String::toLowerCase)
										.map(word -> word.split(""))
										.map(Arrays::stream); // <- close but no good
		
		Stream<String> temp4 = words.stream()
				.map(String::toLowerCase)
				.map(w -> w.split(""))
				.flatMap(Arrays::stream); // <- yes!!
		
		temp4.forEach(System.out::println);
		printSeparator();
		
		// Nested Traversing of Streams: generate all possible combinations  (pairs) of two arrays
		List<String> set1 = Arrays.asList("a", "b", "c");
		List<String> set2 = Arrays.asList("x", "y");
		List<String> pairs = set1.stream()
								.flatMap((String i) -> set2.stream()
														.map((String j) -> new String(i + j)))
								.collect(toList());
		System.out.println(pairs);
		printSeparator();
		
		
		// Deconstruction:
		Stream<String> tempA = set1.stream()
			.map(i -> new String(i + "z"));
		
		Stream<Stream<String>> tempB = set1.stream()
				.map(i -> set2.stream()
								.map(j -> new String(i + j)));	// <- close but no good
		
		Stream<String> tempC = set1.stream()
				.flatMap(i -> set2.stream()
								.map(j -> new String(i + j)));	// <- close but no good
		
		
		// anyMatch() : find if there is a veggie dish with more than 500 cal
		System.out.println(menu.stream()
			.filter(d -> d.getCalories() > 500)
			.anyMatch(Dish::isVegetarian));
		printSeparator();
		
		// allMatch() : find if all the dishes are below 1000 cal
		System.out.println(menu.stream()
								.allMatch(d -> d.getCalories() < 1000));
		printSeparator();
		
		// noneMatch(): find if all the dishes are below 100 cal
		System.out.println(menu.stream()
								.noneMatch(d -> d.getCalories() >= 1000));	
		printSeparator();
		
		// findAny(): find any vegetarian dish in the menu
		Optional<Dish> anyVeggieDish = menu.stream()
											.filter(Dish::isVegetarian)
											.findAny();
		anyVeggieDish.ifPresent(System.out::println);
		
		if (anyVeggieDish.isPresent()) {
			System.out.println("Veggie dish found: " + anyVeggieDish.get());
		}
		
		System.out.println(anyVeggieDish.orElse(new Dish("air", true, 0, Dish.Type.OTHER)));
		
		printSeparator();
		
		
		// findFirst(): find the first number on the stream whose square is divisible by three
		
		Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream()
				.map(n -> n * n)
				.filter(n -> n % 3 == 0)
				.findFirst()
				.ifPresent(System.out::println);
		printSeparator();
		
		
		// reduce() : find the sum of all the numbers
		System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
			.stream()
			.reduce(0, (accumulator, item) -> accumulator + item));
			
		// using method refs
		System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
			.stream()
			.reduce(0, Integer::sum));
		printSeparator();
		
		// reduce() : find the min and max number
		numbers.stream()
				.reduce(Integer::min)
				.ifPresent(System.out::println);
		
		numbers.stream()
				.reduce(Integer::max)
				.ifPresent(System.out::println);
		
		// without method refs
		numbers.stream()
				.reduce((acc, item) -> Integer.min(acc, item))
				.ifPresent(System.out::println);
		
		numbers.stream()
				.reduce((acc, item) -> Integer.max(acc, item))
				.ifPresent(System.out::println);
		printSeparator();
		
		// count() : count the number of dishes with more than 500 cal
		System.out.println(menu.stream()
								.filter(d -> d.getCalories() > 500)
								.count());
		printSeparator();
		
		
		// Numeric Streams: count the calories in the menu, obtain the min, max, and average
		System.out.println(menu.stream()
								.mapToInt(d -> d.getCalories())
								.sum());
		
		System.out.println(menu.stream()
								.mapToInt(d -> d.getCalories())
								.min()
								.getAsInt());
		
		System.out.println(menu.stream()
				.mapToInt(d -> d.getCalories())
				.max()
				.getAsInt());
		
		System.out.println(menu.stream()
				.mapToInt(d -> d.getCalories())
				.average()
				.getAsDouble());
		printSeparator();
		
		// reduce() : obtain the max and min cal dish
		menu.stream()
			.reduce((acc, dish) -> acc.getCalories() > dish.getCalories() ? acc : dish)
			.ifPresent(System.out::println);
		
		menu.stream()
			.reduce((acc, dish) -> acc.getCalories() < dish.getCalories() ? acc : dish)
			.ifPresent(System.out::println);
		printSeparator();
		
		// range() and rangeClosed() : generate a stream of int (not Integer) 
		System.out.println(IntStream.range(0, 10)		// unboxed
					.boxed()		// box to be able to collect values in a List<Integer>
					.collect(toList()));
		
		System.out.println(IntStream.rangeClosed(0, 10)
				.boxed()
				.collect(toList()));
		printSeparator();
	}
	
	public static void printSeparator() {
		System.out.println("=================================================================");
	}
}
