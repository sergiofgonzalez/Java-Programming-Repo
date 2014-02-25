package org.joolzminer.examples;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



class Point {
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
}

public class ByValueAndByRefRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ByValueAndByRefRunner.class);
	
	public static void incrementByRef(Integer num) {
		++num;
	}
	
	public static void incrementByValue(int num) {
		++num;
	}

	public static void increment(final Point p) {
		p.setX(p.getX() + 1);
		p.setY(p.getY() + 1);
	}
	
	public static void increment2(Point p) {
		Point oldPoint = p;
		p = new Point();
		p.setX(oldPoint.getX() + 1);
		p.setY(oldPoint.getY() + 1);				
	}
	
	public static void modify(List<String> list) {
		list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
	}
	
	public static void main(String[] args) {
		int num = 5;
		System.out.println("*** using int");
		incrementByValue(num);
		System.out.println("incrementByRef=" + num);
		
		incrementByRef(num);
		System.out.println("incrementByVal=" + num);
		
		System.out.println("*** using Integer");
		Integer num2 = 5;
		incrementByValue(num2);
		System.out.println("incrementByRef=" + num2);
		
		incrementByRef(num2);
		System.out.println("incrementByVal=" + num2);

		System.out.println("*** increment with refs");
		Point point = new Point();
		point.setX(1);
		point.setY(2);
		increment(point);
		
		System.out.println(point);
		
		System.out.println("*** increment2 with refs");
		Point point2 = new Point();
		point2.setX(1);
		point2.setY(2);
		increment2(point2);
		
		System.out.println(point2);
		
		
		System.out.println("*** Using lists: ");
		List<String> list = new ArrayList<>();
		list.add("uno");
		list.add("dos");
		list.add("tres");
		
		LOGGER.info("list={}", list);
		
	}
}
