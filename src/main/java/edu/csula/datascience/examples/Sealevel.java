package edu.csula.datascience.examples;


public class Sealevel {
	final String Year;
    final double CSIRO_Adjusted_sea_level;
    final double CSIRO_Lower_error_bound;
    final double CSIRO_Upper_error_bound;
    final double NOAA_Adjusted_sea_level;

    public Sealevel(String Year, Double CSIRO_Adjusted_sea_level, Double CSIRO_Lower_error_bound,Double CSIRO_Upper_error_bound,Double NOAA_Adjusted_sea_level) {
        this.Year = Year;
        this.CSIRO_Adjusted_sea_level = CSIRO_Adjusted_sea_level;
        this.CSIRO_Lower_error_bound = CSIRO_Lower_error_bound;
        this.CSIRO_Upper_error_bound = CSIRO_Upper_error_bound;
        this.NOAA_Adjusted_sea_level = NOAA_Adjusted_sea_level;
        
}

}
