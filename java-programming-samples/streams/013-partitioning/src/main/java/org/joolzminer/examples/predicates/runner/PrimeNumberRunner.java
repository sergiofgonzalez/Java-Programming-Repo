package org.joolzminer.examples.predicates.runner;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class PrimeNumberRunner {

	public static boolean isPrime(int candidate) {
		return IntStream.range(2, candidate)
				.noneMatch(i -> candidate % i == 0);
	}
	
	public static  Map<Boolean, List<Integer>> partitionPrimes(int n) {
		return IntStream.rangeClosed(2, n)
						.boxed()
						.collect(partitioningBy(i -> isPrime(i)));
	}
	
	public static Map<Boolean, Long> countPrimesUpTo(int n) {
		return IntStream.rangeClosed(2, n)
				.boxed()
				.collect(partitioningBy(i -> isPrime(i), counting()));
	}
	
	public static void main(String[] args) {
		prettyPrint(partitionPrimes(100));
		
		System.out.println(countPrimesUpTo(1000));
	}
	
	public static <K,V> void prettyPrint(Map<K, List<V>> map) {
		for (Entry<K, List<V>> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			for (V v : entry.getValue()) {
				System.out.println("\t" + v);
			}
		}
	}
}
