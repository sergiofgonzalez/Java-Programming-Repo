package org.joolzminer.examples.displays;

import org.joolzminer.examples.WeatherData;
import org.joolzminer.examples.observer.Observer;

public class FeelsLikeDisplay implements Observer, DisplayElement {

	private float heatIndex;
	private WeatherData weatherData;
	
	public FeelsLikeDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		heatIndex = toCelsius(computeHeatIndex(toFarenheit(temperature), humidity));
		display();
	}
	
	private float computeHeatIndex(float t, float rh) {		
		return (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) 
				+ (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) 
				+ (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
				(0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 * 
				(rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) + 
				(0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
				0.000000000843296 * (t * t * rh * rh * rh)) -
				(0.0000000000481975 * (t * t * t * rh * rh * rh)));
	}
	
	private float toFarenheit(float celsiusTemp) {
		return (celsiusTemp * (9.0F/5.0F)) + 32;		
	}
	
	private float toCelsius(float farenheitTemp) {
		return (farenheitTemp - 32) * (5.0F/9.0F);
	}

	@Override
	public void display() {
		System.out.println("Feels like " + heatIndex + " degrees Celsius");
	}
}
