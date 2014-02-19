package org.joolzminer.examples;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.junit.Test;

public class BreakStatementTest {

	@Test
	public void testBreakWhile() {
		int i = 0;
		while (true) {
			i++;
			if (i > 5) {
				break;
			}
		}
		assertThat(i, is(6));
	}
	
	@Test
	public void testBreakDoWhile() {
		int i = 0;
		do {
			i++;
			if (i > 5) {
				break;
			}
		} while (true);
		assertThat(i, is(6));
	}
	
	@Test
	public void testBreakFor() {
		for (int i = 0; ;i++) {
			if (i > 5) {
				break;
			}
		}
	}
	
	@Test
	public void testBreakFor2() {
		int numIterations = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; ; j++) {
				numIterations++;
				if (j > 5) {
					break;
				}
			}
		}
		assertThat(numIterations, is(70));
	}
	
	@Test
	public void testBreakSwitch() {
		Random random = new Random();
		int value = random.nextInt(3);
		int assignedValue = -1;
		switch (value) {
			case 0:
				assignedValue = 0;
				System.out.println("*** value = 0");
				break;

			case 1:
				assignedValue = 1;
				System.out.println("*** value = 1");
				break;
			
			case 2:
				assignedValue = 2;
				System.out.println("*** value = 2");
				break;
				
			default:
				assignedValue = -1;
				System.out.println("*** value = default");
				break;
		}
		
		assertThat(assignedValue, is(equalTo(value)));		
	}
	
}
