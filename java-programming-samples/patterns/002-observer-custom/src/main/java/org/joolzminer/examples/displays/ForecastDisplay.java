package org.joolzminer.examples.displays;

import org.joolzminer.examples.WeatherData;
import org.joolzminer.examples.observer.Observer;

public class ForecastDisplay implements DisplayElement, Observer {
	private float currentPressure = 29.92F;
	private float lastPressure;
	private WeatherData weatherData;
	
	public ForecastDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		lastPressure = currentPressure;
		currentPressure = pressure;
		display();
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
