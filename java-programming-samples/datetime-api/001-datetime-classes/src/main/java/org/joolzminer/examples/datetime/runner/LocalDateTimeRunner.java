package org.joolzminer.examples.datetime.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeRunner {
	public static void main(String[] args) {
		
		// LocalDate creation
		LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
		System.out.println("dt1=" + dt1);
		printSeparator();
		
		LocalDate date = LocalDate.of(1974, 2, 5);
		LocalTime time = LocalTime.of(11, 59);
		LocalDateTime dt2 = LocalDateTime.of(date, time);
		System.out.println("dt2=" + dt2);
		printSeparator();
		
		LocalDateTime dt3 = date.atTime(13, 45, 20);
		System.out.println("dt3=" + dt3);
		printSeparator();
		
		LocalDateTime dt4 = date.atTime(time);
		System.out.println("dt4=" + dt4);
		printSeparator();
		
		LocalDateTime dt5 = time.atDate(date);
		System.out.println("dt5=" + dt5);
		printSeparator();
		
		// Convert to LocalDate or LocalTime
		LocalDate date1 = dt1.toLocalDate();
		LocalTime time1 = dt2.toLocalTime();
		System.out.println("date1=" + date1);
		System.out.println("time1=" + time1);
	
	}
	
	public static void printSeparator() {
		System.out.println("======================================================");
	}
}
