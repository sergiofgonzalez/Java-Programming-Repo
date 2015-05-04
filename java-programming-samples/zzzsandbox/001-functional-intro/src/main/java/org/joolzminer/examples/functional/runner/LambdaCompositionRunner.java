package org.joolzminer.examples.functional.runner;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import org.joolzminer.examples.domain.Apple;





import static java.util.Comparator.*;


public class LambdaCompositionRunner {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Apple> apples = Apple.getSomeApples();
		
		// sort desc by weight
		apples.sort(comparing(Apple::getWeight).reversed());
		System.out.println(apples);
		System.out.println("==========================================");
		
		// sort desc by weight, then by color
		apples = Apple.getSomeApples();
		apples.sort(comparing(Apple::getWeight)
						.reversed()
						.thenComparing(Apple::getColor));		
		System.out.println(apples);
		System.out.println("==========================================");
		
		// filter out red apples
		Predicate<Apple> redApplePredicate = a -> "red".equalsIgnoreCase(a.getColor());
		Predicate<Apple> notRedApplePredicate = redApplePredicate.negate();
		
		// Filter green and heavy apples
		Predicate<Apple> greenApplePredicate = a -> "green".equalsIgnoreCase(a.getColor());
		Predicate<Apple> heavyApplePredicate = a -> a.getWeight() > 100;
		Predicate<Apple> greenAndHeavyApplePredicate = greenApplePredicate
															.and(heavyApplePredicate);
		
		// Filter yellow or light apples
		Predicate<Apple> yellowApplePredicate = a -> "yellow".equalsIgnoreCase(a.getColor());
		Predicate<Apple> lightApplePredicate = a -> a.getWeight() <= 100;
		Predicate<Apple> yellowOrLightApplePredicate = yellowApplePredicate
															.or(lightApplePredicate);
		
		
		// Composition of Functions
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x / 2;
		
		Function<Integer, Integer> h1 = f.andThen(g); // g(f(x))
		Function<Integer, Integer> h2 = f.compose(g); // f(g(x))
		
		System.out.println("h1(10)=" + h1.apply(10)); // should be 5
		System.out.println("h2(10)=" + h2.apply(10)); // should be 6
	}
}
