import processing.core.*;

public class Button {
	
	// Field variables
	private float x;
	private float y;
	private final float WIDTH = 260;
	private final float HEIGHT = 100;
	private String text;
	private PShape button;
	private PApplet window;
	

	public Button(PApplet window, int x, int y, String text) {
		this.window = window;
		this.x = x;
		this.y = y;
		this.text = text;
		
		this.button = window.createShape(PConstants.RECT, x, y, WIDTH, HEIGHT);
		
		// myButton = createShape(RECT, this.x, this.y, this.WIDTH, this.HEIGHT);
		
	}
	
	
	public void draw () {

		window.shape(this.button);
	}
	
	
	
	
	
	public float getWIDTH() {
		return WIDTH;
	}
	
	public float getHEIGHT() {
		return HEIGHT;
	}
	
	
	
	
}
