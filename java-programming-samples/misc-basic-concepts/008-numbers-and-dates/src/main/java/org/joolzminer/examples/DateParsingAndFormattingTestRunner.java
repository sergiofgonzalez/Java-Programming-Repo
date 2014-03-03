package org.joolzminer.examples;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParsingAndFormattingTestRunner {
	public static void main(String[] args) {
		DateFormat shortDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		DateFormat mediumDateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		DateFormat longDateFormat = DateFormat.getDateInstance(DateFormat.LONG);
		DateFormat fullDateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		
		System.out.println("*** displaying dates using DateFormat styles:");
		Date now = new Date();
		System.out.println(shortDateFormat.format(now));
		System.out.println(mediumDateFormat.format(now));
		System.out.println(longDateFormat.format(now));
		System.out.println(fullDateFormat.format(now));
		
		System.out.println("*** parsing and displaying a correct date:");
		try {
			Date date = shortDateFormat.parse("3/3/2014");
			System.out.println(fullDateFormat.format(date));
		} catch (ParseException e) {
			System.err.println("Could not parse '3/3/2014'");
		}
		
		System.out.println("*** parsing incorrect date (leniency=true):");
		System.out.println("isLenient: " + shortDateFormat.isLenient());
		try {
			Date date = shortDateFormat.parse("1/32/2014");
			System.out.println(fullDateFormat.format(date));
		} catch (ParseException e) {
			System.err.println("Could not parse '1/32/2014'");
		}
		
		shortDateFormat.setLenient(false);
		System.out.println("*** parsing incorrect date (leniency=false):");
		System.out.println("isLenient: " + shortDateFormat.isLenient());
		try {
			Date date = shortDateFormat.parse("1/32/2014");
			System.out.println(fullDateFormat.format(date));
		} catch (ParseException e) {
			System.err.println("Could not parse '1/32/2014'");
		}
		
		
		System.out.println("*** Using SimpleDateFormat:");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(simpleDateFormat.format(now));
		try {
			Date date = simpleDateFormat.parse("2015-02-05");
			System.out.println(fullDateFormat.format(date));
		} catch (ParseException e) {
			System.err.println("could not parse date using SimpleDateFormat");
		}
	}
}
