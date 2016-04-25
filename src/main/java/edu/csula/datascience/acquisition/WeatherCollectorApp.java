package org.gradle;

import java.util.Collection;

public class WeatherCollectorApp{
	public static void main(String[] args)
	{
		while(true) {
			WeatherSource source = new WeatherSource();
			WeatherCollector collector = new WeatherCollector();

			while(source.hasNext())
			{
				Collection<Weather> popped = source.next();
				Collection<Weather> clean = collector.mungee(popped);
				collector.save(clean);
			}
		}
	}
}