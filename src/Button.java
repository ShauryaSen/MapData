import processing.core.*;

public class Button {
	
	// Field variables
	private float x;
	private float y;
	private final float WIDTH = 260;
	private final float HEIGHT = 80;
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
	
	
	public void draw() {
		// Button settings
		window.fill(36, 214, 179);
		
		window.shape(this.button);
		
		// Text settings
		window.fill(255, 255, 255);
		window.noStroke();	
		
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
		
	
	
	public float getWIDTH() {
		return WIDTH;
	}
	
	public float getHEIGHT() {
		return HEIGHT;
	}
	
	
	
	
}
