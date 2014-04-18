package org.joolzminer.examples.displays;

import org.joolzminer.examples.WeatherData;
import org.joolzminer.examples.observer.Observer;

public class StatisticsDisplay implements DisplayElement, Observer {

	private float maxTemp = 0.0F;
	private float minTemp = 200.0F;
	private float tempSum = 0.0F;
	private int numReadings;
	private WeatherData weatherData;

	public StatisticsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		tempSum += temperature;
		numReadings++;

		if (temperature > maxTemp) {
			maxTemp = temperature;
		}

		if (temperature < minTemp) {
			minTemp = temperature;
		}

		display();
	}

	@Override
	public void display() {
		System.out.println("Avg/Max/Min temperature={" + (tempSum / numReadings) 
				+ "/" + maxTemp + "/" + minTemp + "}");
	}
}
