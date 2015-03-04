package org.joolzminer.examples.predicates.runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.joolzminer.examples.predicates.functional.BufferedReaderProcessor;


public class ExecuteAroundLambdasRunner {

	public static String processFile() throws Exception {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/logback.xml"))) {
			return bufferedReader.readLine();
		}
	}
	
	public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws Exception {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/logback.xml"))) {
			return bufferedReaderProcessor.process(bufferedReader);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		// No parameterized behavior: sucks!
		System.out.println(processFile());
		
		// Parameterized behavior for processFile using anonymous inner classes
		System.out.println(processFile(new BufferedReaderProcessor() {
			
			@Override
			public String process(BufferedReader bufferedReader) throws IOException {
				return bufferedReader.readLine();
			}		
		}));
		
		// Parameterized behavior for processFile using lambdas
		System.out.println(processFile((BufferedReader br) -> br.readLine()));
		
		// Another behavior using inline lambdas
		System.out.println(processFile((BufferedReader br) -> br.readLine() + br.readLine()));
		
		// Yet another behavior using inline lambdas
		System.out.println(processFile((BufferedReader br) -> {
			String result = "";
			String line = br.readLine();
			while (line != null) {
				result += line;
				line = br.readLine();
			}
			return result;
		}));		
	}
}