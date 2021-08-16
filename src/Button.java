import processing.core.*;

public class Button {
	
	// Field variables
	private float x;
	private float y;
	private final float WIDTH = 260;
	private final float HEIGHT = 50;
	private String text;
	private PShape myButton;

	public Button(int x, int y, String text) {
		this.x = x;
		this.y = y;
		this.text = text;
		// myButton = createShape(RECT, this.x, this.y, this.WIDTH, this.HEIGHT);
		
	}
	
	
	public void draw () {
		
	}
	
	
	
	
	
	public float getWIDTH() {
		return WIDTH;
	}
	
	public float getHEIGHT() {
		return HEIGHT;
	}
	
	
	
	
}
