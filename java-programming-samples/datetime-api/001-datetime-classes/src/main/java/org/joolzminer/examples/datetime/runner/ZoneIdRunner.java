package org.joolzminer.examples.datetime.runner;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class ZoneIdRunner {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Get the time zone from a region ID
		ZoneId ukZone = ZoneId.of("Europe/London");
		
		// Convert old TimeZone to a zoneId
		ZoneId defaultZone = TimeZone.getDefault().toZoneId();
		
		// Applying a time zone to a point in time
		LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
		ZonedDateTime zdt1 = date.atStartOfDay(ukZone);
		System.out.println(zdt1);
				
		LocalDateTime dateTime = LocalDateTime.of(2014,  Month.MARCH, 18, 13, 45);
		ZonedDateTime zdt2 = dateTime.atZone(ukZone);
		System.out.println(zdt2);
		
		Instant instant = Instant.now();
		ZonedDateTime zdt3 = instant.atZone(ukZone);
		System.out.println(zdt3);
		
		Instant instant1 = Instant.now();
		ZonedDateTime zdt4 = instant.atZone(defaultZone);
		System.out.println(zdt4);
				
		printSeparator();
		
		// Convert a LocalDateTime to an instant
		LocalDateTime localDateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
//		Instant instantFromDateTime = localDateTime.toInstant(ukZone); // <- this does not compile
//		System.out.println(instantFromDateTime);
	
		ZonedDateTime zdt = localDateTime.atZone(ukZone);
		ZoneOffset offset = zdt.getOffset();
		Instant instantFromDateTime = localDateTime.toInstant(offset);
		System.out.println(instantFromDateTime);
				
		printSeparator();
		
		// Convert an Instant to a given LocalDateTime
		Instant instant2 = Instant.now();
		LocalDateTime timeFromInstant = LocalDateTime.ofInstant(instant2, ukZone);
		System.out.println(timeFromInstant);
		printSeparator();
		
		// Using ZoneOffset
		ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
		Instant instantFromDateTime1 = localDateTime.toInstant(newYorkOffset);
		System.out.println(instantFromDateTime1);
		printSeparator();
		
		// You can also create an OffsetDateTime which represents a datetime with an offset
		// from UTC/Greenwich
		OffsetDateTime dateTimeInNewYork = OffsetDateTime.of(dateTime, newYorkOffset);
		System.out.println(dateTimeInNewYork);
		printSeparator();
	}
	
	public static void printSeparator() {
		System.out.println("======================================================");
	}	
}
