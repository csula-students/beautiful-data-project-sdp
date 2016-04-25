package org.gradle;

import java.util.List;

public class Weather{

	private String name;
	private List<WeatherInfo> weatherInfos;

	public List<WeatherInfo> getWeatherInfos() {
		return weatherInfos;
	}

	public void setWeathers(List<WeatherInfo> weathers) {
		this.weatherInfos = weathers;
	}

	public Weather (String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCity(String name) {
		this.name = name;
	}
}