package org.joolzminer.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitializationTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(InitializationTest.class);
	
	static int num;
	
	int x = 3;
	int y;
	
	// Instance initialization code
	{
		y = x * 2;
		LOGGER.info("in instance initialization block: x={}, y={}", x, y);
	}
	
	// Static initialization code
	static {
		num = 5;
		LOGGER.info("in static initialization block: num={}", num);
	}
	
	public InitializationTest() {
		LOGGER.info("in constructor");
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		InitializationTest obj1 = new InitializationTest();
		System.out.println("*** second initialization");
		InitializationTest obj2 = new InitializationTest();
	}
}
