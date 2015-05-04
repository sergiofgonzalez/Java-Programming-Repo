package org.joolzminer.examples.datetime.runner;

import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.JapaneseDate;

public class NonStandardCalendarRunner {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
		JapaneseDate japaneseDate = JapaneseDate.from(date);
		System.out.println(japaneseDate);
	}
	
	public static void printSeparator() {
		System.out.println("======================================================");
	}
}
