package org.joolzminer.examples.functional.runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamBuildingRunner {
	@SuppressWarnings({ "serial", "unused", "resource" })
	public static void main(String[] args) throws IOException {
		// Building a stream from a discreet set of values
		Stream<String> wordStream1 = Stream.of("Java8", "Lambdas", "in", "Action");
		
		// Building a stream from a List
		List<String> words2 = new ArrayList<String>() {{
			add("Java8");
			add("Lambdas");
			add("in");
			add("Action");
		}};
		Stream<String> wordStream2 = words2.stream();
		
		// Building a stream from an Array
		String[] words3 = { "Java8", "Lambdas", "in", "Action" };
		Stream<String> wordStream3 = Arrays.stream(words3);
		
		// Building a stream from file contents
		Stream<String> fileLinesStream = Files.lines(Paths.get("src/main/resources/logback.xml"));
		
		// iterate() : Building a stream from a Function : even number generator
		
		// unbounded, stateful stream
		IntStream evenNumbersStream = IntStream.iterate(0, n -> n + 2);
		evenNumbersStream.limit(10).forEach(System.out::println);
		separator();
		
		// iterate() : Fibonacci generator
		// unbounded, stateful stream
		System.out.println(Stream
								.iterate(new int[] {1, 0}, pair -> new int[] {pair[1] + pair[0], pair[0]})
								.mapToInt(pair -> pair[0])
								.limit(25)
								.boxed()
								.collect(toList()));
		separator();
		// generate() : Building a stream from a Function : give me 10 random numbers
		//unbounded, stateless stream
		System.out.println(Stream.generate(Math::random)
									.limit(3)
									.collect(toList()));
		separator();

		// unbounded, stateful
		IntSupplier fibonacciSupplier = new IntSupplier() {
			
			private int previous = 0;
			private int current = 1;
			
			@Override
			public int getAsInt() {
				int oldPrevious = this.previous;
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				return nextValue;
			}
		};
				
		System.out.println(IntStream.generate(fibonacciSupplier)
									.limit(10)
									.boxed()
									.collect(toList()));
		
	}
	
	public static void separator() {
		System.out.println("==============================================================");
	}
}
