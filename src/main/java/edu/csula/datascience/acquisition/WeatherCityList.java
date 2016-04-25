package org.gradle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeatherCityList {
	 static List<String> cities;
	 static {
		 Scanner scanner;
		 cities = new ArrayList<String>();
		try {
			scanner = new Scanner(new File("uscity.csv"));
		    while(scanner.hasNext()){
		    	String city = scanner.nextLine().trim().split(",")[1].replaceAll(" ", "%20");
		    	cities.add(city);
		    }
		    scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

 public static List<String> getCityListcode() {
     return cities;
 }

}
