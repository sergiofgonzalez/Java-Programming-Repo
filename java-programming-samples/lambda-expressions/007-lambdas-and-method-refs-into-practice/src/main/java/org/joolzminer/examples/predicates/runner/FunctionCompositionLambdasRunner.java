package org.joolzminer.examples.predicates.runner;

import java.util.function.Function;

import org.joolzminer.examples.predicates.domain.Letter;

public class FunctionCompositionLambdasRunner {
	
	
	public static void main(String[] args) {
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x / 2;
		
		Function<Integer, Integer> h1 = f.andThen(g);	// this is g(f(x))
		System.out.println(h1.apply(10)); // Should be 5
		
		Function<Integer, Integer> h2 = f.compose(g);	// this is f(g(x))
		System.out.println(h2.apply(10)); // Should be 6
		
		// This is also useful for Strings
		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> processingPipeline = addHeader
														.andThen(Letter::checkSpelling)
														.andThen(Letter::addFooter);
		
		System.out.println(processingPipeline.apply("The heigth of the mountain is unknown."));
	}
}
