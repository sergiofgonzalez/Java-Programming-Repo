package org.joolzminer.examples.predicates.collectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static org.joolzminer.examples.functions.PrimeFuncs.*;
import static java.util.stream.Collector.Characteristics.*;

public class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

	@SuppressWarnings("serial")
	@Override
	public Supplier<Map<Boolean, List<Integer>>> supplier() {
		// this will be used to put the prime and non-primer numbers
		
		return () -> new HashMap<Boolean, List<Integer>>() {{ 
			put(true, new ArrayList<Integer>());
			put(false, new ArrayList<Integer>());
		}};
	}

	@Override
	public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
		return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
			acc.get(isPrime(acc.get(true), candidate))
				.add(candidate);
		};
	}

	@Override
	public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
		// This will never be invoked, so i could as well do
		// throw new UnsupportedOperationException();
		
		return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
			map1.get(true).addAll(map2.get(true));
			map2.get(false).addAll(map2.get(false));
			return map1;
		};
	}

	@Override
	public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
		// no transformation needed after collector has completed
		return Function.identity();
	}

	@Override
	public Set<Characteristics> characteristics() {
		// It's neither CONCURRENT, nor UNORDERED
		return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
	}

}
