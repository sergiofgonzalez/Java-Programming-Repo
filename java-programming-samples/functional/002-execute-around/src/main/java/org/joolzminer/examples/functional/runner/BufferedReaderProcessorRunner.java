package org.joolzminer.examples.functional.runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.joolzminer.examples.functional.BufferedReaderProcessor;

public class BufferedReaderProcessorRunner {
	
	public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/logback.xml"))) {
			return bufferedReaderProcessor.process(bufferedReader);
		}
	}
	
	public static void main(String[] args) throws IOException {
		String firstLineOfFile = processFile((br) -> br.readLine());
		String firstTwoLinesOfFile = processFile((br) -> br.readLine() + br.readLine());
		
		System.out.println(firstLineOfFile);
		printSeparator();
		
		System.out.println(firstTwoLinesOfFile);
		printSeparator();
	}
	
	public static void printSeparator() {
		System.out.println("======================================================");
	}
}
