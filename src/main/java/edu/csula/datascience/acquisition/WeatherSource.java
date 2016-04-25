package org.gradle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherSource implements Source<Weather> {

	private List<String> list;
	private Iterator<String> iterator;

	public WeatherSource() {
		list = WeatherCityList.getCityListcode();
		iterator = list.iterator();
	}

	public Weather getRegion(String city) throws JsonParseException, JsonMappingException, IOException {
		String jsonString = callURL("http://api.openweathermap.org/data/2.5/forecast/daily?q="+city+"&mode=json&units=metric&cnt=15&appid=f3aac65fea4ca566cc304beccf9cccf3");
		ObjectMapper mapper = new ObjectMapper();
		RootObject obj = (RootObject) mapper.readValue(jsonString, RootObject.class);
		Weather w = new Weather(obj.getCity().name);
		List<WeatherInfo> weatherInfos = new ArrayList<WeatherInfo>();
		for (ListJson lst : obj.list) {
			WeatherInfo info = new WeatherInfo();
			info.setMaxTemp(lst.temp.max);
			info.setMinTemp(lst.temp.min);
			info.setDayTemp(lst.temp.day);
			info.setEveTemp(lst.temp.eve);
			info.setMornTemp(lst.temp.morn);
			info.setNightTemp(lst.temp.night);
			info.setDegree(lst.deg);
			info.setHumidity(lst.humidity);
			info.setPressure(lst.pressure);
			info.setWindspeed(lst.speed);
			info.setCloudsper(lst.clouds);
			info.setSnowper(lst.snow);
			info.setRainper(lst.rain);
			weatherInfos.add(info);
		}
		w.setWeathers(weatherInfos);
		return w;
	}

	private Collection<Weather> query(String country) throws JsonParseException, JsonMappingException, IOException {
		List<Weather> list = new ArrayList<Weather>();
		list.add(getRegion(country));
		return list;
	}

	public static String callURL(String myURL) {
		InputStreamReader input = null;
		StringBuilder sb = new StringBuilder();
		try {
			URL urlnew = new URL(myURL);
			URLConnection connectionurl = urlnew.openConnection();
			if (connectionurl != null && connectionurl.getInputStream() != null) {
				input = new InputStreamReader(connectionurl.getInputStream(),
						Charset.defaultCharset());
				BufferedReader BR = new BufferedReader(input);
				if (BR != null) {
					int cp;				
					while ((cp = BR.read()) != -1) {
						sb.append((char) cp);
					}
					BR.close();
				}
			}

			input.close();
		} catch (Exception e) {
			throw new RuntimeException(myURL, e);
		}
		return sb.toString();
	}
	public boolean hasNext() {
		return this.iterator.hasNext();
	}

	public Collection<Weather> next() {
		String citiy = iterator.next();

		try {
			return query(citiy);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
