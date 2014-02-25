package org.joolzminer.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class AlphabetLetter {
	private char c;

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "AlphabetLetter [c=" + c + "]";
	}
}

public class PassObject {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PassObject.class);
	
	public static void convertToZ(AlphabetLetter alphabetLetter) {
		alphabetLetter.setC('z');
	}
	
	public static void main(String[] args) {
		AlphabetLetter alphabetLetter = new AlphabetLetter();
		alphabetLetter.setC('x');
		LOGGER.info("before: {}", alphabetLetter);
		
		convertToZ(alphabetLetter);
		LOGGER.info("after: {}", alphabetLetter);
	}
}
