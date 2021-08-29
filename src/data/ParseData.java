package data;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class ParseData {
	
	public static List<Marker> populationDensityParser(PApplet window) {
	// return awesome colored markers so in the main script i can just be like map.addMarkers(...
		List<Feature> countries = GeoJSONReader.loadData(window, "data/countries.geo.json");
		List<Marker> countryMarkers = MapUtils.createSimpleMarkers(countries);
		
		// start off on 255, 255, 255 markers (white) and then decrease the blue and green to make it more red when popuation increases
		for (Marker marker : countryMarkers) {
			marker.setColor(window.color(255, 100, 100));
		}
		
		return countryMarkers;
	}

	
	
}
