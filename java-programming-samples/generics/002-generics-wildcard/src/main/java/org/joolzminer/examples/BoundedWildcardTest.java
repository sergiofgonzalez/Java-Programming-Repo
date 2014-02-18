package org.joolzminer.examples;

import java.util.ArrayList;
import java.util.List;

public class BoundedWildcardTest {
	public static double getAverage(List<? extends Number> numericValues) {
		double total = 0.0;
		for (Number numericValue : numericValues) {
			total += numericValue.doubleValue();
		}
		
		return total/numericValues.size();
	}
	
	public static void main(String[] args) {
		List<Integer> integerList = new ArrayList<>();
		integerList.add(3);
		integerList.add(30);
		integerList.add(300);
		System.out.println("*** getAverage(integerList)=" + getAverage(integerList));
		
		List<Float> floatList = new ArrayList<>();
		floatList.add(3.0F);
		floatList.add(33.0F);
		System.out.println("*** getAverage(floatList)=" + getAverage(floatList));
	}
}
