package org.joolzminer.examples;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class OperatorPrecedenceTest {

	@Test
	public void testPrecedence1() {
		int x = 5;
		int y = 5;
		
		boolean z = x * 5 == y + 20;
		
		// order of precedence: * + ==
		assertThat(z, is(((x*5)) == (y+20)));		
	}
	
}
