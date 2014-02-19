package org.joolzminer.examples;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class ContinueStatementTest {

	@Test
	public void testContinueWhile() {
		Integer i = 1;
		StringBuffer stringBuffer = new StringBuffer();
		while (i < 5) {
			i++;
			if (i == 3) {
				continue;
			} else {
				stringBuffer.append(i.toString());
				stringBuffer.append(" ");
			}
		}
		assertThat(stringBuffer.toString(), is(equalTo("2 4 5 ")));
	}
	
	@Test
	public void testContinueDoWhile() {
		Integer i = 1;
		StringBuffer stringBuffer = new StringBuffer();
		do {
			i++;
			if (i == 3) {
				continue;
			} else {
				stringBuffer.append(i.toString());
				stringBuffer.append(" ");
			}
		} while ( i < 5);
		assertThat(stringBuffer.toString(), is(equalTo("2 4 5 ")));
	}
	
	@Test
	public void testContinueFor() {
		StringBuffer stringBuffer = new StringBuffer();
		for (Integer i = 1; i < 5; i++) {
			if (i == 3) {
				continue;
			} else {
				stringBuffer.append(i.toString());
				stringBuffer.append(" ");
			}
		}
		assertThat(stringBuffer.toString(), is(equalTo("1 2 4 ")));	
	}
	
	@Test
	public void testContinueForLabel() {
		StringBuffer stringBuffer = new StringBuffer();
		start:
		for (Integer i = 0; i < 2; i++) {			
			for (Integer j = 0; j < 5; j++) {
				if (j == 3) {
					continue start;
				} else {
					stringBuffer.append(i.toString());
					stringBuffer.append(":");
					stringBuffer.append(j.toString());
					stringBuffer.append(" ");
				}
			}
		}
		assertThat(stringBuffer.toString(), is(equalTo("0:0 0:1 0:2 1:0 1:1 1:2 ")));	
	}
}
