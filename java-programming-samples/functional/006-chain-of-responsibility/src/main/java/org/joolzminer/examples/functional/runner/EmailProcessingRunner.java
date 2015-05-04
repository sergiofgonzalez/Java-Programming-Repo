package org.joolzminer.examples.functional.runner;

import java.util.function.Function;
import java.util.function.UnaryOperator;

import org.joolzminer.examples.functional.ProcessingObject;
import org.joolzminer.examples.functional.impl.HeaderTextProcessing;
import org.joolzminer.examples.functional.impl.SpellCheckerProcessing;
import org.joolzminer.examples.functional.impl.TrailingTextProcessing;

public class EmailProcessingRunner {
	public static void main(String[] args) {
		
		// old school
		ProcessingObject<String> p1 = new HeaderTextProcessing();
		ProcessingObject<String> p2 = new SpellCheckerProcessing();
		ProcessingObject<String> p3 = new TrailingTextProcessing();
		
		p1.setSuccessor(p2);
		p2.setSuccessor(p3);
		
		String result = p1.handle("To use or not to use lambdas. That is the dilemna.");
		
		System.out.println(result);
		printSeparator();
		
		
		// using lambdas
		UnaryOperator<String> headerProcessing = (text) -> "From Raoul, Mario and Alan:\n\n" + text;
		UnaryOperator<String> spellCheckingProcessing = (text) -> text.replaceAll("dilemna", "dilemma");
		UnaryOperator<String> trailerProcessing = (text) -> text + "\n\nKind regards,\nRaoul, Mario and Alan";
		
		Function<String,String> processingPipeline = headerProcessing
														.andThen(spellCheckingProcessing)
														.andThen(trailerProcessing);
		
		String result2 = processingPipeline.apply("To use or not to use lambdas. That is the dilemma");
		System.out.println(result2);
		
	}
	
	public static void printSeparator() {
		System.out.println("======================================================");
	}
}	
