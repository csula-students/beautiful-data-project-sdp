package edu.csula.datascience.examples;

import com.google.common.collect.Lists;
import io.searchbox.action.BulkableAction;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.sql.Date;
import java.util.Collection;
import edu.csula.datascience.examples.Sealevel;

public class JestWeatherSeaLevel {
	  public static void main(String[] args) throws URISyntaxException, IOException {
	        String indexName = "sealevel-data";
	        String typeName = "sea-level";
	        String awsAddress = "https://search-sdp-mybigdata16-uzqy5ee6mnlrhf7uwnrac6hbmy.us-west-2.es.amazonaws.com/";
	        JestClientFactory factory = new JestClientFactory();
	        factory.setHttpClientConfig(new HttpClientConfig
	            .Builder(awsAddress)
	            .multiThreaded(true)
	            .build());
	        JestClient client = factory.getObject();

	        // as usual process to connect to data source, we will need to set up
	        // node and client// to read CSV file from the resource folder
	        File csv = new File(
	            ClassLoader.getSystemResource("sea-level.csv")
	                .toURI()
	        );

	        try {
	            // after reading the csv file, we will use CSVParser to parse through
	            // the csv files
	            CSVParser parser = CSVParser.parse(
	                csv,
	                Charset.defaultCharset(),
	                CSVFormat.EXCEL.withHeader()
	            );
	            Collection<Sealevel> Sealevel = Lists.newArrayList();

	            int count = 0;

	            // for each record, we will insert data into Elastic Search
//	            parser.forEach(record -> {
	            for (CSVRecord record: parser) {
	                // cleaning up dirty data which doesn't have time or temperature
	                if (
	                    !record.get("Year").isEmpty() &&
	                    !record.get("CSIRO_Adjusted_sea_level").isEmpty() 
	                    
	                ) {
	                    Sealevel sealvl = new Sealevel(
	                    		record.get("Year"),
	                    		Double.valueOf(record.get("CSIRO_Adjusted_sea_level")),
	                    		Double.valueOf(record.get("CSIRO_Lower_error_bound")),
		                        Double.valueOf(record.get("CSIRO_Upper_error_bound")),
		                        Double.valueOf(record.get("NOAA_Adjusted_sea_level"))
	                    );

	                    if (count < 20) {
	                    	Sealevel.add(sealvl);
	                        count ++;
	                    } else {
	                        try {
	                            Collection<BulkableAction> actions = Lists.newArrayList();
	                            Sealevel.stream()
	                                .forEach(tmp -> {
	                                    actions.add(new Index.Builder(tmp).build());
	                                });
	                            Bulk.Builder bulk = new Bulk.Builder()
	                                .defaultIndex(indexName)
	                                .defaultType(typeName)
	                                .addAction(actions);
	                            client.execute(bulk.build());
	                            count = 0;
	                            Sealevel = Lists.newArrayList();
	                            System.out.println("Inserted documents to cloud");
	                        } catch (IOException e) {
	                            e.printStackTrace();
	                        }
	                    }
	                }
	            }

	            Collection<BulkableAction> actions = Lists.newArrayList();
	            Sealevel.stream()
	                .forEach(tmp -> {
	                    actions.add(new Index.Builder(tmp).build());
	                });
	            Bulk.Builder bulk = new Bulk.Builder()
	                .defaultIndex(indexName)
	                .defaultType(typeName)
	                .addAction(actions);
	            client.execute(bulk.build());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        System.out.println("We are done! Yay!");
	    }

	   

}
