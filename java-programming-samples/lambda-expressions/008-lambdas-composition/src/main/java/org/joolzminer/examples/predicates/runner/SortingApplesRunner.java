package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.joolzminer.examples.predicates.domain.Apple;

// Sorting a list of Apples with different strategies

public class SortingApplesRunner {


	public static void main(String[] args) {
		// Using anonymous classes
		List<Apple> apples = resetInventory();
		System.out.println("before: " + apples);
		apples.sort(new Comparator<Apple>() {

			@Override
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		System.out.println("after : " + apples);
		
		// Using lambdas
		apples = resetInventory();
		System.out.println("before: " + apples);
		apples.sort((apple1, apple2) -> apple1.getWeight().compareTo(apple2.getWeight()));
		System.out.println("after : " + apples);
		
		// Using lambdas and the Comparator static method comparing()
		// which takes a Function extracting a Comparable key and produces
		// a Comparator object
		apples = resetInventory();
		System.out.println("before: " + apples);
		Comparator<Apple> appleComparator = Comparator.comparing((apple) -> apple.getWeight());
		apples.sort(appleComparator);
		System.out.println("after : " + apples);
		
		// Same but shorter
		apples = resetInventory();
		System.out.println("before: " + apples);
		apples.sort(Comparator.comparing((apple) -> apple.getWeight()));
		System.out.println("after : " + apples);		
		
		// Using method references
		apples = resetInventory();
		System.out.println("before: " + apples);
		apples.sort(Comparator.comparing(Apple::getWeight));
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
}
