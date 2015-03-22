package org.joolzminer.examples.predicates.runner;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriples {

	public static void main(String[] args) {
		// Pythagorean triples
		// Pythagoras discovered that there are certain triples of numbers
		// that satisfy the formula:
		//	a * a + b * b = c * c
		// For example: (3, 4, 5) is a Pythagorean triple
		// 
		// Such triples describe the three side lengths of a right-angled triangle
		
		Stream<int[]> pythagoreanTriples =
			IntStream.rangeClosed(1, 100)
					.boxed()
					.flatMap(a -> IntStream.rangeClosed(a, 100)
									.filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)  // sqrt has no fractional part
									.boxed()
									.map(b -> new int[] {a, b, (int) Math.sqrt(a * a + b * b)}));
		
		pythagoreanTriples.limit(5)
						.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
		
		// Alternative way to calculate that
		// Generate all possible triples in the form
		//	(a, b, a*a + b*b) 
		// and then filter out the ones that do not satisfy the formula
		//  a*a + b*b = c*c
		
		
		// Step 1: Generate doubles (a, 1)
		Stream<int[]> doublesStep1 = IntStream.rangeClosed(1, 100)
										.boxed()	// This is needed because the map method of IntStream assumes int -> int
										.map(a -> new int[] {a, 1});
				
		doublesStep1.forEach(item -> System.out.println(item[0] + ", " + item[1]));

		
		// Step 2: Generate doubles (a, b)
		Stream<int[]> doublesStep2 = IntStream.rangeClosed(1, 100)
												.boxed()
												.flatMap((Integer a) -> IntStream.rangeClosed(1, 100)
																	.boxed()
																	.map( b -> new int[] {a, b}));

		doublesStep2.forEach(item -> System.out.println(item[0] + ", " + item[1]));
		
		// Apply .boxed() to an IntStream is equivalent to use .mapToObj()
		Stream<int[]> doublesStep2Alt = IntStream.rangeClosed(1, 100)
				.boxed()
				.flatMap(a -> IntStream.rangeClosed(1, 100)
									.mapToObj( b -> new int[] {a, b}));

		doublesStep2Alt.forEach(item -> System.out.println(item[0] + ", " + item[1]));
		
		
		// Step 3: Generate the triples, no filtering yet
		Stream<double[]> triplesStep3 = IntStream.rangeClosed(1, 100)
											.boxed()
											.flatMap(a -> IntStream.rangeClosed(1, 100)
														 	       .mapToObj(b -> new double[] {a, b, Math.sqrt(a * a + b * b)}));
		
		triplesStep3.forEach(item -> System.out.println(item[0] + ", " + item[1] + ", " + item[2]));
		
		// How to check if sqrt returns an integer result
		System.out.println(Math.sqrt(25) % 1 == 0);
		System.out.println(Math.sqrt(26) % 1 == 0);
		
		// Now we have all the pieces, let's put them all together		
		Stream<int[]> pythagoreanTriplesAlt = IntStream.rangeClosed(1, 100)
														.boxed()
														.flatMap(a -> IntStream.rangeClosed(1, 100)
														.mapToObj(b -> new double[] {a, b, Math.sqrt(a * a + b * b)})
														.filter(triple -> triple[2] % 1 == 0))
														.map(triple -> new int[] {(int)triple[0], (int)triple[1], (int)triple[2]});

		pythagoreanTriplesAlt.forEach(triple -> System.out.println(triple[0] + ", " + triple[1] + ", " + triple[2]));
	}
}
