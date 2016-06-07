package edu.csula.datascience.examples;


public class Temperature {
	final String date_str;
    final double min_temp;
    final double max_temp;
    final String type;
    final String station_name;
    final double latitude;
    final double longitude;

    public Temperature(String date_str, double max_temp, Double min_temp, String type, String station_name, Double longitude, Double latitude) {
        this.date_str = date_str;
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.type = type;
        this.station_name = station_name;
        this.latitude = latitude;
        this.longitude = longitude;
}
}
