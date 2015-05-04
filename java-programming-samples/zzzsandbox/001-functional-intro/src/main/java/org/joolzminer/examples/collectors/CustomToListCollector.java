package org.joolzminer.examples.collectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.*;

public class CustomToListCollector<T> implements Collector<T, List<T>, List<T>> {

	/*
	 * The supplier method of a Collector<T,A,R> has to return a Supplier () -> A than when
	 * invoked creates the accumulator.
	 * 
	 * A is the type of the accumulator, where the partial result will be accumulated
	 * during the collection process.
	 * 
	 * In our case, the A is of type List<T>
	 */
	@Override
	public Supplier<List<T>> supplier() {
		return ArrayList::new;
	}

	// The accumulator method of a Collector<T,A,R> has to return a BiConsumer<A,T> (A, T) -> () that
	// will be invoked to perform the reduction operation.
	//
	// When traversing the nth element of the stream, this function is applied with two arguments:
	//	- the result of the reduction after having collected the first n-1 elements of the stream
	//	- the nth element itself
	//
	//	The function returns void because the accumulator is modified in place.
	//
	//	
	@Override
	public BiConsumer<List<T>, T> accumulator() {
		// return (list, elem) -> list.add(elem);
		// or more concisely
		return List::add;
	}

	// The finisher method of a Collector<T,A,R> has to return a Function<A,R> A -> R that will be
	// invoked at the end of the accumulation process after having completely traversed the stream.
	// The function must transform the Accumulator object into the final result of the collect operation.
	@Override
	public Function<List<T>, List<T>> finisher() {
		return Function.identity();
	}
	
	// The combiner method of a Collector<T,A,R> has to return a BinaryOperator<A> (A,A)-> A that defines 
	// how the accumulators resulting from the reduction different subparts of the stream are combined when
	// the subparts are processed in parallel.
	@Override
	public BinaryOperator<List<T>> combiner() {
		return (list1, list2) -> { 
			list1.addAll(list2);
			return list1;
		};
	}


	// The characteristics method returns an immutable set of Characteristic defining the
	// behavior of the collector.
	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, CONCURRENT));
	}
}
