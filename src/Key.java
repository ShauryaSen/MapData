import de.fhpotsdam.unfolding.marker.Marker;
import processing.core.*;


public class Key {
	// The number of marker names should match the number of markers ofc
	private PApplet window;
	private String[] markerNames;
	private Marker[] markers;
	private float X = 20;
	private float Y = 550;
	private float WIDTH = 260;
	private float HEIGHT = 370;

	public Key(PApplet window, String[] markerNames, Marker[] markers) {
		this.window = window;
		this.markerNames = markerNames;
		this.markers = markers;
	}
	
	public void draw() {
		// Draw the key's rectangle
		window.stroke(0);
		window.fill(255,255,255);
		window.rect(X, Y, WIDTH, HEIGHT);
	}
	
	
}
