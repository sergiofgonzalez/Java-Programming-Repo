package org.joolzminer.examples.predicates.runner;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;

import org.joolzminer.examples.predicates.collectors.PrimeNumbersCollector;

public class SpecializedPrimeNumberGeneratorRunner {
	
	public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
		return IntStream.rangeClosed(2, n)
						.boxed()
						.collect(new PrimeNumbersCollector());
	}
	
	public static void main(String[] args) {
		prettyPrint(partitionPrimes(100));
		
		System.out.println("About to calculate prime numbers until 1M for ten times");
		// Do some perf test harness
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			partitionPrimes(1_000_000);
			long duration = (System.nanoTime() - start) / 1_000_000;
			if (duration < fastest) {
				fastest = duration;
			}
		}
		System.out.println("Fastest execution done in " + fastest + " msecs");
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
