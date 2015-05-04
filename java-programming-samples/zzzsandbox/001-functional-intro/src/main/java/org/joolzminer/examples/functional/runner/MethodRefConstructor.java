package org.joolzminer.examples.functional.runner;

import java.util.Arrays;
import java.util.List;

import org.joolzminer.examples.domain.Apple;

import static org.joolzminer.examples.domain.Apple.*;

public class MethodRefConstructor {
	public static void main(String[] args) {
		List<Apple> apples = Arrays.asList(appleFactory.apply("Green", 100), appleFactory.apply("Red", 80));
		System.out.println(apples);
	}
}
