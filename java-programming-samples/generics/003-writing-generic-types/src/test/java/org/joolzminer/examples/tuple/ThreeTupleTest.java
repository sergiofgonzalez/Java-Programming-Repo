package org.joolzminer.examples.tuple;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ThreeTupleTest {

	@Test
	public void testCreateThreeTuple() {
		ThreeTuple<String, Integer, Character> threeTuple = new ThreeTuple<>("age", 40, 'c');
		
		assertThat(threeTuple.getA(), is(equalTo("age")));
		assertThat(threeTuple.getB(), is(equalTo(40)));
		assertThat(threeTuple.getC(), is(equalTo('c')));
		
	}
	
	@Test
	public void testThreeTupleToString() {
		ThreeTuple<String, Integer, Character> threeTuple = new ThreeTuple<>("age", 40, 'c');
		
		assertThat(threeTuple.toString(), is(equalTo("(age, 40, c)")));
	}
}
