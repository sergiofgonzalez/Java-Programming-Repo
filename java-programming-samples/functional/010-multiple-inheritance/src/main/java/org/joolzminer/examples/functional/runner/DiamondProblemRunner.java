package org.joolzminer.examples.functional.runner;

// iteration 1
interface Ax {
	default void hello() {
		System.out.println("Ax::hello");
	}
}

interface Bx extends Ax {}

interface Cx extends Ax {}

class Dx implements Bx, Cx {}


// iteration 2
interface Ay {
	default void hello() {
		System.out.println("Ay::hello");
	}
}

interface By extends Ay {}

interface Cy extends Ay {
	default void hello() {
		System.out.println("Cy::hello");
	}
}

class Dy implements By, Cy {}


public class DiamondProblemRunner {
	public static void main(String[] args) {
		// iteration 1
		new Dx().hello();	// only Ax::hello is defined
		
		new Dy().hello();	// Cy::hello wins, because it is the most specific sub-interface
	}
}
