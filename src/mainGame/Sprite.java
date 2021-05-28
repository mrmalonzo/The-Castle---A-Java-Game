package mainGame;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
	protected Image img;
	protected int x, y, dx, dy;
	protected boolean visible;
	protected double width;
	protected double height;
	
	public Sprite(int xPos, int yPos){
		this.x = xPos;
		this.y = yPos;
		this.visible = true;
	}
	
	//method to set the object's image
	protected void loadImage(Image img){
		try{
			this.img = img;
	        this.setSize();
		} catch(Exception e){}
	}
	
	//method to set the image to the image view node
	void render(GraphicsContext gc){
		gc.drawImage(this.img, this.x, this.y);
        
    }
	
	//method to set the object's width and height properties
	private void setSize(){
		this.width = this.img.getWidth();
	    this.height = this.img.getHeight();
	}
	//method that will check for collision of two sprites
	public boolean collidesWith(Sprite rect2)	{
		Rectangle2D rectangle1 = this.getBounds();
		Rectangle2D rectangle2 = rect2.getBounds();

		return rectangle1.intersects(rectangle2);
	}
	//method that will return the bounds of an image
	private Rectangle2D getBounds(){
		return new Rectangle2D(this.x, this.y, this.width, this.height);
	}
	
	public boolean collidesWith2(Sprite rect2)	{ //for collision of the land
		Rectangle2D rectangle1 = this.getBounds();
		Rectangle2D rectangle2 = rect2.getBounds2();

		return rectangle1.intersects(rectangle2);
	}
	
	private Rectangle2D getBounds2(){ //for collision of the land
		return new Rectangle2D(this.x-25, this.y+20, this.width+50, this.height+20);
	}
	
//	public boolean collidesWithLand(Sprite rect2){
//		Rectangle2D rectangle1 = this.getBounds();
//		Rectangle2D rectangle2 = rect2.getBoundsLand();
//
//		return rectangle1.intersects(rectangle2);
//	}
//	//method that will return the bounds of an image
//	private Rectangle2D getBoundsLand(){
//		return new Rectangle2D(this.x+20, this.y-10, this.width-40, this.height-40);
//	}
	
	public boolean collidesWith3(Sprite rect2)	{ //for collision of the player and pushable onject
		Rectangle2D rectangle1 = this.getBounds();
		Rectangle2D rectangle2 = rect2.getBounds3();

		return rectangle1.intersects(rectangle2);
	}
	
	private Rectangle2D getBounds3(){ //for collision of the player and the pushable object
		return new Rectangle2D(this.x-10, this.y+20, this.width+30, this.height);
	}
	//method to return the image
	Image getImage(){
		return this.img;
	}
	
	public int getBottom() {
		return (this.x+Land.LAND_HEIGHT+10);
	}
	//getters
	public int getX() {
    	return this.x;
	}

	public int getY() {
    	return this.y;
	}
	
	public int getDX(){
		return this.dx;
	}
	public int getDY(){
		return this.dy;
	}
	
	public boolean getVisible(){
		return visible;	
	}
	public boolean isVisible(){
		if(visible) return true;
		return false;
	}
	
	//setters
	public void setDX(int dx){
		if(dx+this.x>0 && dx+this.x<1300-10 ) { //conditions so that the player wont go out of bounds
			this.dx = dx;  
		}
		
	}
	
	public void setDY(int dy){
			this.dy = dy;
		
	}
	
	public void setY(int y) {
		this.y-=y;
	}
	
	public void setY2(int y) {
		this.y=y;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setWidth(double val){
		this.width = val;
	}

	public void setHeight(double val){
		this.height = val;
	}
		
	public void setVisible(boolean value){
		this.visible = value;
	}
	
	

}
