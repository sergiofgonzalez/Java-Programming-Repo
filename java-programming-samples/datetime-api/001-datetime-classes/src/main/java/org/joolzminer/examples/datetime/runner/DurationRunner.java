package org.joolzminer.examples.datetime.runner;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationRunner {
	public static void main(String[] args) {
		LocalTime t1 = LocalTime.of(8, 0);
		LocalTime t2 = LocalTime.now();
		Duration d1 = Duration.between(t1, t2);
		System.out.println("d1=" + d1);
		printSeparator();
		
		LocalDateTime dt1 = LocalDateTime.of(1974, 2, 5, 13, 0);
		LocalDateTime dt2 = LocalDateTime.now();
		Duration d2 = Duration.between(dt1, dt2);
		System.out.println("d2=" + d2);
		printSeparator();
		
		Instant i1 = Instant.now();
		Instant i2 = Instant.now();
		Duration d3 = Duration.between(i1, i2);
		System.out.println("d3=" + d3);
		printSeparator();
		
		// Creating a Duration without defining it as a difference of time points
		Duration threeMinutes = Duration.ofMinutes(3);
		Duration anotherThreeMinutes = Duration.of(3, ChronoUnit.MINUTES);
		System.out.println("threeMinutes=" + threeMinutes);
		System.out.println("anotherThreeMinutes=" + anotherThreeMinutes);
		printSeparator();
		
	}
	
	public static void printSeparator() {
		System.out.println("======================================================");
	}
}
