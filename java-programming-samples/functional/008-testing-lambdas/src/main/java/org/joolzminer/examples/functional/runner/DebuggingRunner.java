package org.joolzminer.examples.functional.runner;

import java.util.Arrays;
import java.util.List;

import org.joolzminer.examples.functional.domain.Point;

public class DebuggingRunner {
	
	// This method is designed to fail so that you can have a look
	// at the stack trace
	public static void main(String[] args) {
		List<Point> points = Arrays.asList(new Point(12, 2), null);
		
		try {
			points.stream()
				.map(p -> p.getX())
				.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
			printSeparator();
		}
		
		
		try {
			points.stream()
				.map(Point::getX)
				.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
			printSeparator();
		}
		
		
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		
		try {
			numbers.stream()
					.map(DebuggingRunner::divideByZero)
					.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
			printSeparator();
		}
	}
	
	
	public static int divideByZero(int n) {
		return n / 0;
	}
	
	
	public static void printSeparator() {
		System.out.println("\n=======================================================");
	}
}
