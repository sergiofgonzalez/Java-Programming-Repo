package org.joolzminer.examples;

import java.util.HashMap;
import java.util.Map;

public class SpringDetectorRunner2 {
	public static void detectSpring() {
		
		Map<Groundhog2, Prediction> predictionMap = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			predictionMap.put(new Groundhog2(i), new Prediction());
		}
		
		System.out.println("predictionMap=" + predictionMap);
		
		Groundhog2 gh3 = new Groundhog2(3);
		System.out.println("*** looking up prediction for " + gh3);
		if (predictionMap.containsKey(gh3)) {
			System.out.println(predictionMap.get(gh3));
		} else {
			System.out.println("key not found: " + gh3);
		}
	}
	
	public static void main(String[] args) {
		detectSpring();
	}
}
