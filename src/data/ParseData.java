package data;

import java.util.HashMap;
import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class ParseData {

	// return awesome colored markers so in the main script i can just be like map.addMarkers(...
	public static List<Marker> populationDensityParser(PApplet window) {
		List<Feature> countries = GeoJSONReader.loadData(window, "data/countries.geo.json");
		List<Marker> countryMarkers = MapUtils.createSimpleMarkers(countries);	
		
		/*
		 *  put CSV data into dictionary with it's id as key and the population 
		 *  density has value
		 */
		
		// load the rows in the csv file into an array
		String[] rows = window.loadStrings("data/countries-population-density.csv");
		HashMap<String, String> countryData = new HashMap<String, String>();
		
		for (String row : rows) {
			// the data in each row is split by these: ";" 
			String[] columns = row.split(";");
			
			// apparently some of it doesn't even have three columns
			if (columns.length == 3) {
				// columns[1] is the country id and columns[2] is the pop. density
				countryData.put(columns[1], columns[2]);
			}		
		}
		
//		for (String value : countryData.values()) {
//			System.out.println(value);
//		}
		
//		 alot of the densities are low but some reach up to 6k 
//		 start off on 255, 255, 255 markers (white) and then decrease the blue and green to make it more red when popuation increases
		for (Marker marker : countryMarkers) {
//			marker.setColor(window.color(255, 200, 200, 200));
			
			// get the key value pair from hash map that matches up with the marker's id
			
			String markerDensity = countryData.get(marker.getId());
			
			if (markerDensity == null) {
				marker.setColor(150);
			} else {
				float redness = PApplet.map(Float.parseFloat(markerDensity), 0, 800, 180, 0);
				marker.setColor(window.color(255, redness, redness, 220));
			}	
		}
		
		return countryMarkers;
	}

	
	
}
