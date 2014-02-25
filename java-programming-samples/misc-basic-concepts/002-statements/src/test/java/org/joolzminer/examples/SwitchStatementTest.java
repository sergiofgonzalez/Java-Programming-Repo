package org.joolzminer.examples;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwitchStatementTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(SwitchStatementTest.class);
	
	@Test
	public void testSwitchOnString() {
		String option = "two";
		switch (option) {
			case "one":
				LOGGER.info("one");
				break;

			case "two":
				LOGGER.info("two");
				break;
				
			case "three":
				LOGGER.info("three");
			
			default :
				LOGGER.info("option is not one, two or three");
				break;
		}		
	}	
}
