package org.joolzminer.examples.functional.runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.joolzminer.examples.functions.BufferedReaderProcessor;

public class ExecuteAroundRunner {
	
	public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/logback.xml"))) {
			return bufferedReaderProcessor.process(bufferedReader);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// print the first line
		System.out.println(processFile(br -> br.readLine()));
		
		// print the first and second lines
		System.out.println(processFile(br -> br.readLine() + br.readLine()));
		
		// return the whole file in a string
		System.out.println(processFile(br -> {
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
