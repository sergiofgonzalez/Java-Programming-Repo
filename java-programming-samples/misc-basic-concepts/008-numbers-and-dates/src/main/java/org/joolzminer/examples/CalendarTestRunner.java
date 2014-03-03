package org.joolzminer.examples;


import java.util.Calendar;
import java.util.Date;

public class CalendarTestRunner {

	public static void main(String[] args) {
		// Instantiating a calendar
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		
		// Getting a Date instance representing the same date as the Calendar
		Date date = calendar.getTime();
		System.out.println(date);
		
		// Getting the components from a Calendar instance
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int calDate = calendar.get(Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millis = calendar.get(Calendar.MILLISECOND);
		
		System.out.println("year=" + year + ", " 
						+ "month=" + month + ", "
						+ "day=" + day + ", "
						+ "date=" + calDate + ", "
						+ "hour=" + hour + ", "
						+ "minute=" + minute + ", "
						+ "second=" + second + ", "
						+ "milliseconds=" + millis);
		
		// Constructing a Calendar instance from a Date object
		Date now = new Date();
		Calendar nowCalendar = Calendar.getInstance();
		nowCalendar.setTime(now);		
		System.out.println(nowCalendar);
		
		// Adjust the calendar to change components:
		calendar.set(Calendar.YEAR, 2015);
		System.out.println(calendar);
	}
}
