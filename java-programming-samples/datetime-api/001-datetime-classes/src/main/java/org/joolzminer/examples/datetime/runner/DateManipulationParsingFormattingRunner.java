package org.joolzminer.examples.datetime.runner;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import org.joolzminer.examples.datetime.adjusters.NextWorkingDay;

import static java.time.temporal.TemporalAdjusters.*;

public class DateManipulationParsingFormattingRunner {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Date manipulation
		LocalDate date1 = LocalDate.of(2015, 5, 1);
		LocalDate date2 = date1.withYear(1974);
		LocalDate date3 = date2.withDayOfMonth(5);
		LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);
		
		// add/subtract a given amount of time declaratively
		LocalDate date5 = date4.plusWeeks(1);
		LocalDate date6 = date5.minusYears(3);
		LocalDate date7 = date6.plus(6, ChronoUnit.MONTHS);
		
		// Quiz 12.1: Manipulating a LocalDate	
		LocalDate date = LocalDate.of(2014, 3, 18);
		date = date.with(ChronoField.MONTH_OF_YEAR, 9);	// 2014-09-18
		date = date.plusYears(2).minusDays(10);			// 2016-09-08
		date = date.withYear(2011);						// 2011-09-08
		
		// Using TemporalAdjuster for advanced modifications
		LocalDate date8 = date7.with(nextOrSame(DayOfWeek.SUNDAY));
		LocalDate date9 = date8.with(lastDayOfMonth());
		
		// Using our custom TemporalAdjuster implementation
		LocalDate firstOfMay = LocalDate.of(2015, 5, 1);
		LocalDate nextWorkingDay = firstOfMay.with(new NextWorkingDay());
		System.out.println(nextWorkingDay);
		printSeparator();
		
		// Inline definition with a lambda
		LocalDate nextWorkingDayAlt = firstOfMay.with(temporal -> {
			DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
			int daysToAdd = 1;
			if (dayOfWeek == DayOfWeek.FRIDAY) {
				daysToAdd = 3;
			} else if (dayOfWeek == DayOfWeek.SATURDAY) {
				daysToAdd = 2;
			}
			
			return temporal.plus(daysToAdd, ChronoUnit.DAYS);
		});
		
		// as a static factory using ofDateAdjuster (the recommended way)
		TemporalAdjuster nextWorkingDayAdjuster = TemporalAdjusters.ofDateAdjuster(temporal -> {
			DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
			int daysToAdd = 1;
			if (dayOfWeek == DayOfWeek.FRIDAY) {
				daysToAdd = 3;
			} else if (dayOfWeek == DayOfWeek.SATURDAY) {
				daysToAdd = 2;
			}
			
			return temporal.plus(daysToAdd, ChronoUnit.DAYS);
		});
		
		LocalDate nextWorkingDayAlt2 = firstOfMay.with(nextWorkingDayAdjuster);
		
		// Formatting dates
		LocalDate someDate = LocalDate.of(2015, 5, 1);
		String s1 = someDate.format(DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(s1);
		
		String s2 = someDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println(s2);
		printSeparator();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String s3 = someDate.format(formatter);
		System.out.println(s3);
		
		String s4 = "02/05/1974";
		LocalDate date10 = LocalDate.parse(s4, formatter);
		System.out.println(date10.format(DateTimeFormatter.ISO_LOCAL_DATE));
		printSeparator();
		
		// Building a Localized date formatter
		DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM  yyyy", Locale.ITALIAN);
		String s5 = someDate.format(italianFormatter);
		System.out.println(s5);
		printSeparator();
		
		// Using DateTimeFormatterBuilder
		DateTimeFormatter spanishFormatter = new DateTimeFormatterBuilder()
			.appendText(ChronoField.DAY_OF_MONTH)
			.appendLiteral(" de ")
			.appendText(ChronoField.MONTH_OF_YEAR)
			.appendLiteral(" de ")
			.appendText(ChronoField.YEAR)
			.parseCaseInsensitive()
			.toFormatter(Locale.forLanguageTag("es"));
		
		String s6 = someDate.format(spanishFormatter);
		System.out.println(s6);
		
		LocalDate date11 = LocalDate.parse("17 de mayo de 2015", spanishFormatter);
		System.out.println(date11.format(DateTimeFormatter.ISO_LOCAL_DATE));
		
		
	}
	
	public static void printSeparator() {
		System.out.println("======================================================");
	}
}	
