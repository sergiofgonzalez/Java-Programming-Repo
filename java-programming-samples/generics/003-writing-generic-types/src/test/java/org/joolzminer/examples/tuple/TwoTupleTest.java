package org.joolzminer.examples.tuple;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TwoTupleTest {

	@Test
	public void testCreateTwoTuple() {
		TwoTuple<String, Integer> twoTuple = new TwoTuple<>("age", 40);
		
		assertThat(twoTuple.getA(), is(equalTo("age")));
		assertThat(twoTuple.getB(), is(equalTo(40)));		
	}
	
	@Test
	public void testTwoTupleToString() {
		TwoTuple<String, Integer> twoTuple = new TwoTuple<>("age", 40);
		
		assertThat(twoTuple.toString(), is(equalTo("(age, 40)")));
	}
}
