package org.joolzminer.examples.predicates.domain;

public class Letter {
	public static String addHeader(String text) {
		return "Hi all,\n\n" + text;
	}
	
	public static String addFooter(String text) {
		return text + "\n\nKind regards,\nS.";
	}
	
	public static String checkSpelling(String text) {
		return text
				.replaceAll("heigth", "height");
	}
}
