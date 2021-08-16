import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.core.Coordinate;
import de.fhpotsdam.unfolding.providers.*;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.*;

public class Map extends PApplet {
	
	
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
	
	
	// Buttons
	private Button button1;
	
	private int padding = 20;
	
	public void setup() {
		// Setting up the window
		size(1300 + padding, 900 + padding * 2, P2D);
		this.background(0, 134, 165);
	
		// creates a map using one of the map providers above
		map = new UnfoldingMap(this, 300, padding, 1000, 900, providerEsriStreet);
		// makes the map movable
		MapUtils.createDefaultEventDispatcher(this, map);
		
		
		// make buttons
		fill(123, 200, 254);
		noStroke();
		button1 = new Button(this, padding, 50, "MAC DONALDS");
	}
	
	 
	public void draw() {
		map.draw();
		
		button1.draw();

	}
	
	
	/* sum todo notes */
	// Make it so you can't zoom all the way out or too close either on some maps
	// zoom right
	
	
	
	
	
	
	
	public static void main(String[] args) {
		PApplet.main("Map");
	}
	
}
