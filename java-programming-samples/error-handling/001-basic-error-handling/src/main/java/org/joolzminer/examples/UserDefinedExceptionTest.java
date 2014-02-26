package org.joolzminer.examples;

class AlreadyCapitalizedException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Input has already been capitalized";
	}
	
}

class Capitalizer {
	public String capitalize(String s) throws AlreadyCapitalizedException {
		if (s == null) {
			throw new NullPointerException("input string is null");
		}
		Character firstCharacter = s.charAt(0);
		if (Character.isUpperCase(firstCharacter)) {
			throw new AlreadyCapitalizedException();
		}
		String theRest = s.substring(1);
		return firstCharacter.toString().toUpperCase() + theRest;
	}
}


public class UserDefinedExceptionTest {
	
	public static void main(String[] args) {
		Capitalizer capitalizer = new Capitalizer();
		try {
			String capitalized = capitalizer.capitalize("sergio");
			System.out.println("Hello, " + capitalized);
		} catch (AlreadyCapitalizedException e) {
			// No problem, already capitalized
		}		
	}
}
