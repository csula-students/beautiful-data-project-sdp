package org.gradle;

import java.util.List;

public class ListJson {
	    public int dt; 
	    public Temp temp; 
	    public double pressure; 
	    public int humidity; 
	    public List<WeatherJson> weather; 
	    public double speed; 
	    public int deg; 
	    public int clouds; 
	    public double rain;
	    public double snow;
	    
		public double getSnow() {
			return snow;
		}
		public void setSnow(double snow) {
			this.snow = snow;
		}
		public int getDt() {
			return dt;
		}
		public void setDt(int dt) {
			this.dt = dt;
		}
		public Temp getTemp() {
			return temp;
		}
		public void setTemp(Temp temp) {
			this.temp = temp;
		}
		public double getPressure() {
			return pressure;
		}
		public void setPressure(double pressure) {
			this.pressure = pressure;
		}
		public int getHumidity() {
			return humidity;
		}
		public void setHumidity(int humidity) {
			this.humidity = humidity;
		}
		public List<WeatherJson> getWeather() {
			return weather;
		}
		public void setWeather(List<WeatherJson> weather) {
			this.weather = weather;
		}
		public double getSpeed() {
			return speed;
		}
		public void setSpeed(double speed) {
			this.speed = speed;
		}
		public int getDeg() {
			return deg;
		}
		public void setDeg(int deg) {
			this.deg = deg;
		}
		public int getClouds() {
			return clouds;
		}
		public void setClouds(int clouds) {
			this.clouds = clouds;
		}
		public double getRain() {
			return rain;
		}
		public void setRain(double rain) {
			this.rain = rain;
		} 
	}

