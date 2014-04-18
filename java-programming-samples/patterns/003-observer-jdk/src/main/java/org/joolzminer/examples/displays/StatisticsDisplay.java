package org.joolzminer.examples.displays;

import java.util.Observable;
import java.util.Observer;

import org.joolzminer.examples.WeatherData;

public class StatisticsDisplay implements DisplayElement, Observer {

	private float maxTemp = 0.0F;
	private float minTemp = 200.0F;
	private float tempSum = 0.0F;
	private int numReadings;


	public StatisticsDisplay(WeatherData weatherData) {
		weatherData.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			float temperature = ((WeatherData)o).getTemperature();
			
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
	}

	@Override
	public void display() {
		System.out.println("Avg/Max/Min temperature={" + (tempSum / numReadings) 
				+ "/" + maxTemp + "/" + minTemp + "}");
	}
}
