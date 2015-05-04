package org.joolzminer.examples.datetime.runner;

import java.time.LocalTime;

public class LocalTimeRunner {

	public static void main(String[] args) {
		LocalTime time = LocalTime.of(16, 47, 35);
		int hour = time.getHour();
		int minute = time.getMinute();
		int second = time.getSecond();
		
		System.out.println("time=" + time);
		System.out.println("hour=" + hour);
		System.out.println("minute=" + minute);
		System.out.println("second=" + second);
		printSeparator();
		
		// Obtain current time
		LocalTime now = LocalTime.now();
		System.out.println("now=" + now);
		printSeparator();
		
		// Parse string into LocalTime
		LocalTime someTime = LocalTime.parse("16:51:24");
		System.out.println("someTime=" + someTime);
		printSeparator();
	}
	
	public static void printSeparator() {
		System.out.println("======================================================");
	}
}
