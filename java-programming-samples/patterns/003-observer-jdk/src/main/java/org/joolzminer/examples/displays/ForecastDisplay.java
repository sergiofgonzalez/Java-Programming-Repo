package org.joolzminer.examples.displays;

import java.util.Observable;
import java.util.Observer;

import org.joolzminer.examples.WeatherData;

public class ForecastDisplay implements DisplayElement, Observer {

	private float currentPressure = 29.92F;
	private float lastPressure;

	
	public ForecastDisplay(WeatherData weatherData) {
		weatherData.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)o;
			lastPressure = currentPressure;
			currentPressure = weatherData.getPressure();
			display();
		}
	}

	@Override
	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("Stable weather");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather!");
		}
	}
}
