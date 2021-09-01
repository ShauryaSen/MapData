import data.ParseData;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.MarkerManager;
import processing.core.*;

public class Button {
	
	// Field variables
	private float x;
	private float y;
	private final float WIDTH = 260;
	private final float HEIGHT = 80;
	private String text;
	private PApplet window;
	
	

	public Button(PApplet window, int x, int y, String text) {
		this.window = window;
		this.x = x;
		this.y = y;
		this.text = text;
		
		// this.button = window.createShape(PConstants.RECT, x, y, WIDTH, HEIGHT);
				
	}
	
	
	public void draw(boolean hovering) {
		// draw the button

		// window.shape(this.button);
		// if the mouse is hovering over the button make the button a bit darker
		if (hovering) {
			window.fill(179, 179, 179);
		} else {
			window.fill(255,255,255);
		}
		// draw the rectangle
		window.rect(this.x, this.y, WIDTH, HEIGHT);
		
		// Text settings
		window.fill(0,0,0);
		
		window.textAlign(PConstants.LEFT, PConstants.CENTER);
		window.textSize(20);
		window.text(this.text, this.x, this.y + this.HEIGHT/2);
	}
	
	
	public boolean isHovering() {
		if (window.mouseX >= this.x && window.mouseX <= this.x + this.WIDTH && window.mouseY >= this.y && window.mouseY <= this.y + this.HEIGHT) {
			
			return true;
		} else {
			return false;
		}	
	}
	
	public void click(Key key, UnfoldingMap map) {
		System.out.println("henglo");
		
		// change the map and key
		switchScene(key, map);
	}
		
	
	private void switchScene(Key key, UnfoldingMap map) {
		// change the key's attribute "id"
		System.out.println(this.text);
		key.setId(this.text);
		
		// change the map's thing
		System.out.println(map.getMarkerManagerList());
		// first clear out the old marker manager and make new one
		map.removeMarkerManager(0);
		map.addMarkerManager(new MarkerManager<Marker>());

		switch(this.text) {
			case "Population Density":				
				map.addMarkers(ParseData.populationDensityParser(window));
			break;
		}
		
	}
	
	
	public float getWIDTH() {
		return WIDTH;
	}
	
	public float getHEIGHT() {
		return HEIGHT;
	}
	
	
	
	
}
