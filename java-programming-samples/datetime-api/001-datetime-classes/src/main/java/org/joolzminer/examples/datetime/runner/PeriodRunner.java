package org.joolzminer.examples.datetime.runner;

import java.time.LocalDate;
import java.time.Period;

public class PeriodRunner {
	public static void main(String[] args) {
		Period p1 = Period.between(LocalDate.of(2014, 3, 8), LocalDate.of(2014, 3, 18));
		System.out.println("p1=" + p1);
		printSeparator();
		
		// Creating a Period without defining it as a difference
		Period tenDays = Period.ofDays(10);
		Period threeWeeks = Period.ofWeeks(3);
		Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
		
		System.out.println("tenDays=" + tenDays);
		System.out.println("threeWeeks=" + threeWeeks);
		System.out.println("twoYearsSixMonthsOneDay=" + twoYearsSixMonthsOneDay);
		printSeparator();
		
	}
	
	public static void printSeparator() {
		System.out.println("======================================================");
	}
}
