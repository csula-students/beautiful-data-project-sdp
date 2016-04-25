package org.gradle;



public class WeatherInfo {

	public double getDayTemp() {
		return dayTemp;
	}
	public void setDayTemp(double dayTemp) {
		this.dayTemp = dayTemp;
	}
	public double getNightTemp() {
		return nightTemp;
	}
	public void setNightTemp(double nightTemp) {
		this.nightTemp = nightTemp;
	}
	public double getEveTemp() {
		return eveTemp;
	}
	public void setEveTemp(double eveTemp) {
		this.eveTemp = eveTemp;
	}
	public double getMornTemp() {
		return mornTemp;
	}
	public void setMornTemp(double mornTemp) {
		this.mornTemp = mornTemp;
	}
	private double minTemp;
	private double maxTemp;
	public double pressure; 
    public int humidity; 
    public double windspeed; 
    public int degree; 
    public int cloudsper; 
    public double rainper;
    public double snowper;
    public double dayTemp; 
    public double nightTemp; 
    public double eveTemp; 
    public double mornTemp;
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
	public double getWindspeed() {
		return windspeed;
	}
	public void setWindspeed(double windspeed) {
		this.windspeed = windspeed;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public int getCloudsper() {
		return cloudsper;
	}
	public void setCloudsper(int cloudsper) {
		this.cloudsper = cloudsper;
	}
	public double getRainper() {
		return rainper;
	}
	public void setRainper(double rainper) {
		this.rainper = rainper;
	}
	public double getSnowper() {
		return snowper;
	}
	public void setSnowper(double snowper) {
		this.snowper = snowper;
	}
	public double getMinTemp() {
		return minTemp;
	}
	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}
	public double getMaxTemp() {
		return maxTemp;
	}
	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}


}
