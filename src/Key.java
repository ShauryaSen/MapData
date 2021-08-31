import processing.core.*;

public class Key {
	// The number of marker names should match the number of markers ofc
	private PApplet window;
	private float X = 20;
	private float Y = 550;
	private float WIDTH = 260;
	private float HEIGHT = 370;
	// variable for which key a map is using with default value of population density
	private String id = "henglo";

	public Key(PApplet window) {
		this.window = window;

	}
	
	public void draw() {
		// clear the key / draw the key's rectangle
		window.fill(255,255,255);
		clear();
		
		window.noStroke();
		drawKeyContents();
		
		
	}
	
	public void drawKeyContents() {
		if (id.equals("Population Density")) {
			// top text
			window.textSize(25);
			window.fill(0);
			window.textAlign(PApplet.LEFT,PApplet.TOP);
			window.text("Population Density", X + 15, Y + 3);
			
			// text for symbols 
			window.textSize(23);
			window.text("High Density", X + 75, Y + 75);
			window.text("Low Density", X + 75, Y + 155);
			window.text("No Data", X + 75, Y + 235);

			
			// the symbols
			window.fill(240, 87, 86);
			window.rect(X + 30, Y + 75, 30, 30);
			window.fill(244,181,173);
			window.rect(X + 30, Y + 155, 30, 30);
			window.fill(150);
			window.rect(X + 30, Y + 235, 30, 30);	
		}
		
		if (id.equals("henglo")) {
			
		}
		
	}
	
	public void clear() {
		window.rect(X, Y, WIDTH, HEIGHT);
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
