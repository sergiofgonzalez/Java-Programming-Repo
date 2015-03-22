package org.joolzminer.examples.predicates.runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreamsRunner {

	public static void main(String[] args) throws IOException {
		// Build a stream from a sequence of values
		Stream<String> stream = Stream.of("Java", "8", "Lambdas", "In", "Action");
		stream.map(String::length)
				.forEach(System.out::println);
		
		// Build a stream from an Array
		int[] numbers = { 1, 2, 3, 4, 5 };
		int sum = Arrays.stream(numbers)
						.sum();
		System.out.println(sum);
		
		// Build a stream from a file
		// Find all the unique words in a file
		try(Stream<String> lines = Files.lines(Paths.get("src/main/resources/data.txt"))) {
			lines.flatMap(line -> Arrays.stream(line.split(" ")))
				.distinct()
				.sorted()
				.forEach(System.out::println);
		} catch (IOException e) {
			System.err.println("Error occurred while operating the file: " + e);
		}
		
		// Build a stream from a function
		
		// Function that return even numbers from zero
		Stream<Integer> evenNumbers = Stream.iterate(0, n -> n + 2);
		evenNumbers.limit(10)
					.forEach(System.out::println);
		
		// Quiz 5.4: Create a stream that returns the Fibonacci numbers
		// fib(0) = 0
		// fib(1) = 1
		// fib(2) = fib(1) + fib(0) = 1
		// fib(3) = fib(2) + fib(1) = 1 + 1 = 2
		// fib(4) = fib(3) + fib(2) = 2 + 1 = 3
		IntStream fibonacciStream = Stream.iterate(new int[] {1, 0}, pair -> new int[] {pair[1] + pair[0], pair[0]})
											.mapToInt(pair -> pair[0]);
		fibonacciStream.limit(10)
						.forEach(System.out::println);
		
		
		// Stream with infinite number of random numbers
		Stream.generate(Math::random)
				.limit(10)
				.forEach(System.out::println);
		
		// The Fibonacci series with generate
		// This uses a stateful stream and is not safe to use in parallel code
		
		// ones and twos return an infinite stream of ones and twos
		IntStream ones = IntStream.generate(() -> 1);
		IntStream twos = IntStream.generate(new IntSupplier() {
			
			@Override
			public int getAsInt() {
				return 2;
			}
		});
		
		IntSupplier fibSupplier = new IntSupplier() {
			
			private int previous = 0;
			private int current = 1;
			
			@Override
			public int getAsInt() {
				int oldPrevious = this.previous;
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				return oldPrevious;
			}
		};
		
		IntStream.generate(fibSupplier)
				.limit(10)
				.forEach(System.out::println);		
	}
}
