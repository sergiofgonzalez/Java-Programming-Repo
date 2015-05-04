package org.joolzminer.examples.functional.runner;

import java.util.function.Function;

public class FunctionPassingSyntaxRunner {
	public static void main(String[] args) {
		// Case 1: creating an inline function 
		functionRunner(3L, new Function<Long, Long>() {

			@Override
			public Long apply(Long t) {
				long result = 0;
				for (long i = 1; i <= t; i++) {
					result += i;
				}
				return result;
			}			
		});
		
		// Case 2: define a Function variable and use it as an argument
		Function<Long, Long> sumNumbersFunction = maxN -> {
			long result = 0;
			for (long i = 1; i <= maxN; i++) {
				result += i;
			}
			return result;
		};
		
		functionRunner(3L, sumNumbersFunction);
		
		
		// Case 3: Use method references
		functionRunner(3L, FunctionPassingSyntaxRunner::sumNumbers);	
		
		// Case 4: define inline lambda
		functionRunner(3L, n -> {
			long result = 0;
			for (long i = 1; i <= n; i++) {
				result += i;
			}
			return result;
		});
		
	}
	
	public static long sumNumbers(long n) {
		long result = 0;
		for (long i = 1; i <= n; i++) {
			result += i;
		}
		return result;
	}
	
	
	public static <T, R> void functionRunner(T functionParam, Function<T, R> f) {
		System.out.println("result=" + f.apply(functionParam));
	}
}
