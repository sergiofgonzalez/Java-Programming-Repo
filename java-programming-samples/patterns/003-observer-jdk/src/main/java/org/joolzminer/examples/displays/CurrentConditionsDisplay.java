package org.joolzminer.examples.displays;

import java.util.Observable;
import java.util.Observer;

import org.joolzminer.examples.WeatherData;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	
	public CurrentConditionsDisplay(WeatherData weatherData) {
		weatherData.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature + " degrees Celsius, "
				+ humidity + " % humidity");
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)o;
			temperature = weatherData.getTemperature();
			humidity = weatherData.getHumidity();
			display();
		}
	}	
}
