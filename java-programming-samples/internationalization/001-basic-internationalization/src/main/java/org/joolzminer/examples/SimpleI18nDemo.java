package org.joolzminer.examples;

import java.util.Locale;
import java.util.ResourceBundle;

public class SimpleI18nDemo {
	
	
	public static void main(String[] args) {
		System.out.println("*** Greeting on en_US: ");
		ResourceBundle resourceBundle = ResourceBundle.getBundle("MyResources", Locale.US);
		String localizedGreetings = resourceBundle.getString("greetings");
		String localizedFarewell = resourceBundle.getString("farewell");
		
		System.out.println("greeting='" + localizedGreetings + "'");
		System.out.println("farewell='" + localizedFarewell + "'");
		
		System.out.println("*** Greeting on de_DE: ");
		ResourceBundle resourceBundle1 = ResourceBundle.getBundle("MyResources", Locale.GERMANY);
		localizedGreetings = resourceBundle1.getString("greetings");
		localizedFarewell = resourceBundle1.getString("farewell");
		
		System.out.println("greeting='" + localizedGreetings + "'");
		System.out.println("farewell='" + localizedFarewell + "'");
		
		System.out.println("*** Greeting on de_DE: ");
		ResourceBundle resourceBundle2 = ResourceBundle.getBundle("MyResources", new Locale("zh", "CN"));
		localizedGreetings = resourceBundle2.getString("greetings");
		localizedFarewell = resourceBundle2.getString("farewell");
		
		System.out.println("greeting='" + localizedGreetings + "'");
		System.out.println("farewell='" + localizedFarewell + "'");		
	}
}
