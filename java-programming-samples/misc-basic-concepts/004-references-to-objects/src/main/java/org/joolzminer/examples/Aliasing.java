package org.joolzminer.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Tank {
	private int level;
	
	public Tank(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Tank [level=" + level + "]";
	}	
}

public class Aliasing {
	private static final Logger LOGGER = LoggerFactory.getLogger(Aliasing.class);
	
	public static void main(String[] args) {
		Tank t1 = new Tank(9);
		Tank t2 = new Tank(47);
		LOGGER.info("Original: t1={}, t2={}", t1, t2);
		
		t1 = t2;
		LOGGER.info("After assignment: t1={}, t2={}", t1, t2);
		
		// Now, one instance is lost: this is called aliasing
		t1.setLevel(10);
		LOGGER.info("After updating t1: t1={}, t2={}", t1, t2);

		t2.setLevel(25);
		LOGGER.info("After updating t2: t1={}, t2={}", t1, t2);
	}
}
