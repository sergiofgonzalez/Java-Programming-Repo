package org.joolzminer.examples.datetime.runner;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class LocalDateRunner {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(1974, 2, 5);
		int year = date.getYear();
		Month month = date.getMonth();
		int day = date.getDayOfMonth();
		
		DayOfWeek dayofWeek = date.getDayOfWeek();
		int len = date.lengthOfMonth();
		
		boolean isLeapYear = date.isLeapYear();
		
		System.out.println("date=" + date);
		System.out.println("year=" + year);
		System.out.println("month=" + month);
		System.out.println("day=" + day);
		System.out.println("day of week=" + dayofWeek);
		System.out.println("len of month=" + len);
		System.out.println("is leap year? =" + isLeapYear);		
		printSeparator();
		
		// Obtain current date from system clock
		LocalDate today = LocalDate.now();
		System.out.println(today);
		printSeparator();
		
		// Using temporal fields
		int todaysYear = today.get(ChronoField.YEAR);
		int todaysMonth = today.get(ChronoField.MONTH_OF_YEAR); // starts from 1
		int todaysDay = today.get(ChronoField.DAY_OF_MONTH);    // starts from 1
		
		System.out.println("todaysYear=" + todaysYear);
		System.out.println("todaysMonth=" + todaysMonth);
		System.out.println("todaysDay=" + todaysDay);
		printSeparator();
		
		// Parsing
		LocalDate someDate = LocalDate.parse("2008-05-17");
		System.out.println("someDate=" + someDate);
		printSeparator();
	}
	
	public static void printSeparator() {
		System.out.println("======================================================");
	}
}
