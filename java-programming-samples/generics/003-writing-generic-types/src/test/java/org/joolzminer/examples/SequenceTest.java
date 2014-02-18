package org.joolzminer.examples;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SequenceTest {

	@Test
	public void testStringSequence() {
		Sequence<String> stringSequence = new Sequence<>();
		stringSequence.add("one");
		stringSequence.add("two");
		stringSequence.add("three");

		assertThat(stringSequence.toString(), is(equalTo("one two three")));
	}
	
	@Test
	public void testIntegerSequence() {
		Sequence<Integer> intSequence = new Sequence<>();
		intSequence.add(1);
		intSequence.add(2);
		intSequence.add(3);

		assertThat(intSequence.toString(), is(equalTo("1 2 3")));
	}

	@Test
	public void testNumberSequence() {
		Sequence<Number> numSequence = new Sequence<Number>();
		numSequence.add(1);
		numSequence.add(2L);
		numSequence.add(3.0F);
		numSequence.add(4.0);

		Selector<Number> sequenceSelector = numSequence.getSelector(); 

		assertThat(sequenceSelector.current(), is(equalTo((Number)1)));
		sequenceSelector.next();
		assertThat(sequenceSelector.current(), is(equalTo((Number)2L)));
		sequenceSelector.next();
		assertThat(sequenceSelector.current(), is(equalTo((Number)3.0F)));
		sequenceSelector.next();
		assertThat(sequenceSelector.current(), is(equalTo((Number)4.0)));
		sequenceSelector.next();
		assertThat(sequenceSelector.isEnd(), is(true));
	}
	
	@Test
	public void testNumberSequenceCurrent() {
		Sequence<Number> numSequence = new Sequence<Number>();
		numSequence.add(1);
		numSequence.add(2L);
		numSequence.add(3.0F);
		numSequence.add(4.0);
		

		assertThat(numSequence.toString(), is(equalTo("1 2 3.0 4.0")));
	}

	@Test
	public void testTraverse() {
		Sequence<Integer> intSequence = new Sequence<>();
		intSequence.add(1);
		intSequence.add(2);
		intSequence.add(3);
		intSequence.add(4);
		intSequence.add(5);
		
		System.out.println("*** traversing the sequence and displaying contents:");
		displayTraverseSequence(intSequence.getSelector());
	}

	private void displayTraverseSequence(Selector<Integer> selector) {
		if (!selector.isEnd()) {
			System.out.print(selector.current() + " ");
			selector.next();
			displayTraverseSequence(selector);
		}
	}	
}
