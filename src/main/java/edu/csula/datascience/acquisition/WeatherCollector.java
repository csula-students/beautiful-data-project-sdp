package org.gradle;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bson.Document;
import org.gradle.Collector;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class WeatherCollector implements Collector<Weather, Weather>{
	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;

	public WeatherCollector() {
		// establish database connection to MongoDB
		mongoClient = new MongoClient();

		// select `bd-example` as testing database
		database = mongoClient.getDatabase("db-weather");

		// select collection by name `tweets`
		collection = database.getCollection("weathercollect");

	}

	public Collection<Weather> mungee(Collection<Weather> src) {
		return src;
	}

	public void save(Collection<Weather> data) {
		List<Document> documents = data.stream()
				.map(item ->
				{
					Document forecast = new Document().append("name", item.getName());
					Stream<Document> docs = item.getWeatherInfos().stream().map(i -> {
						Document sub = new Document();

						sub
						.append("maxTemp", i.getMaxTemp())
						.append("minTemp",i.getMinTemp())
						.append("Humidity",i.getHumidity())
						.append("Pressure",i.getPressure())
						.append("DayTemp",i.getDayTemp())
						.append("EveTemp",i.getEveTemp())
						.append("MorningTemp",i.getMornTemp())
						.append("NightTemp",i.getNightTemp())
						.append("Degree",i.getDegree())
						.append("Rain",i.getRainper())
						.append("Sonw",i.getSnowper())
						.append("Speed",i.getWindspeed())
						.append("Clouds",i.getCloudsper());
					System.out.println(sub);
						return sub;
					});
					forecast.append("weathers", docs.collect(Collectors.toList()));
					return forecast;
				})
				.collect(Collectors.toList());
		collection.insertMany(documents);
	}
}
