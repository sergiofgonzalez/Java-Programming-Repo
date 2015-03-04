package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.joolzminer.examples.predicates.domain.Apple;
import org.joolzminer.examples.predicates.domain.Fruit;
import org.joolzminer.examples.predicates.domain.Orange;

public class ConstructorMethodReferencesRunner {

	public static List<Apple> map(List<Integer> weights, Function<Integer, Apple> function) {
		List<Apple> result = new ArrayList<>();
		for (Integer weight : weights) {
			result.add(function.apply(weight));
		}
		return result;
	}
	
	@SuppressWarnings("serial")
	private static Map<String, Function<Integer,Fruit>> ctorMap = new HashMap<String, Function<Integer, Fruit>>() {{
		put("apple", Apple::new);
		put("orange", Orange::new);
	}};
	
	public static Fruit giveMeFruit(String fruitName, Integer weight) {
		return ctorMap.get(fruitName).apply(weight); 
	}
	
	public static void main(String[] args) {
		
	// No-Args Constructor	
		// Using lambdas
		Supplier<Apple> appleSupplierLambda = () -> new Apple();		
		System.out.println(appleSupplierLambda.get());
		
		// Using Method References
		Supplier<Apple> appleSupplierMethodRef = Apple::new;		
		System.out.println(appleSupplierMethodRef.get());		
		
	// Constructor that accepts single arg
		// Using lambdas
		Function<Integer, Apple> appleFunctionLambda = (weight) -> new Apple(weight);		
		System.out.println(appleFunctionLambda.apply(100));
		
		// Using Method References
		Function<Integer, Apple> appleFunctionMethodRef = Apple::new;		
		System.out.println(appleFunctionMethodRef.apply(200));	
		
	// Constructor that accepts two args
		// Using lambdas
		BiFunction<Integer, String, Apple> appleBiFunctionLambda = (weight, color) -> new Apple(weight, color);
		System.out.println(appleBiFunctionLambda.apply(80, "yellow"));
		
		// Using method references
		BiFunction<Integer, String, Apple> appleBiFunctionMethodRef = Apple::new;
		System.out.println(appleBiFunctionMethodRef.apply(90, "red"));
		
	// Use the map function defined above to obtain a list of Apples when passing a list of weights
		// Using lambdas
		List<Apple> lambdaApples = map(Arrays.asList(75, 90, 65, 100), (weight) -> new Apple(weight));
		System.out.println(lambdaApples);
		
		// Using method references
		List<Apple> methodRefApples = map(Arrays.asList(75, 90, 65, 100), Apple::new);
		System.out.println(methodRefApples);

	// Interesting application of MethodReferences
		System.out.println(giveMeFruit("orange", 150));
		System.out.println(giveMeFruit("apple", 90));
		
	}

}
