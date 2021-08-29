import java.util.List;

import data.ParseData;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.*;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.*;

public class Map extends PApplet {
	
	
	// eclipse gets mad when i don't have this line
	private static final long serialVersionUID = 1L;

	// Creating a map
	private UnfoldingMap map;
	
	/** just a list of cool map providers **/
	AbstractMapProvider providerNatGeo = new EsriProvider.NatGeoWorldMap();
	AbstractMapProvider providerGray = new EsriProvider.WorldGrayCanvas();
	AbstractMapProvider providerMicrosoftHybrid = new Microsoft.HybridProvider();
	AbstractMapProvider providerEsriStreet = new EsriProvider.WorldStreetMap();
	// AbstractMapProvider mapProvider = new EsriProvider.OceanBasemap();
	// AbstractMapProvider mapProvider = new EsriProvider.WorldTopoMap();
	// AbstractMapProvider mapProvider = new GeoMapApp.TopologicalGeoMapProvider();
	// AbstractMapProvider mapProvider = new Microsoft.AerialProvider();
	

	// make array of buttons:
	private Button buttons[] = new Button[5];
	private Key testKey;
	private String[] test = new String[3];
	private Marker[] test2 = new Marker[3];
	private int padding = 20;
	
	
	public void setup() {
		// set up like the default map
		
		// Setting up the window
		size(1300 + padding, 900 + padding * 2, P2D);
		this.background(0, 134, 165);
	
		// creates a map using one of the map providers above
		map = new UnfoldingMap(this, 300, padding, 1000, 900, providerNatGeo);
		// makes the map movable
		MapUtils.createDefaultEventDispatcher(this, map);
		map.zoomToLevel(2);
		
		// Add buttons to the array
		buttons[0] = new Button(this, padding, 50, "Population Density");
		buttons[1] = new Button(this, padding, 150, "fortnite cards");
		buttons[2] = new Button(this, padding, 250, "nice");
		buttons[3] = new Button(this, padding, 350, "oh ok");
		buttons[4] = new Button(this, padding, 450, "henglo");
		
		// Make the key
		testKey = new Key(this, test, test2);
		
		
		map.addMarkers(ParseData.populationDensityParser(this));
		
		
		
	}

	
	 
	public void draw() {
		// Draw the map
		map.draw();
		testKey.draw();
		
		for (Button button : buttons) {
			button.draw(false);
			
			// check if our mouse is hovering over a button (darken the button)
			if (button.isHovering()) {
				
				button.draw(true);
				// check if mouse down
				if (mousePressed && (mouseButton == LEFT)) {
					button.click();
					mousePressed = false;
				}
				
			}
			
			
		}

	}

	
	/* sum todo notes */
	// Make it so you can't zoom all the way out or too close either on some maps
	// min zoom max zoom
	// zoom right
	// color the buttons
	
	
	
	
	
	
	
	public static void main(String[] args) {
		PApplet.main("Map");
	}
	
}
