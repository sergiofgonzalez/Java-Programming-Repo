package org.joolzminer.examples.runners;

import org.joolzminer.examples.WeatherData;
import org.joolzminer.examples.displays.CurrentConditionsDisplay;
import org.joolzminer.examples.displays.FeelsLikeDisplay;
import org.joolzminer.examples.displays.ForecastDisplay;
import org.joolzminer.examples.displays.StatisticsDisplay;

public class WeatherStationRunner {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		FeelsLikeDisplay feelsLikeDisplay = new FeelsLikeDisplay(weatherData);
		
		System.out.println("*** weather update");
		weatherData.setMeasurements(25, 65, 30.4F);

		System.out.println("\n*** weather update");
		weatherData.setMeasurements(20, 70, 29.2F);
		
		System.out.println("\n*** weather update");
		weatherData.setMeasurements(30, 90, 29.2F);
	}
}
