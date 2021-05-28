package mainGame;

import javafx.scene.image.Image;

public class PushableObject extends Sprite{ //land object, also extends sprite

//	private boolean alive;
	public final static int LAND_WIDTH = 1300;
	public final static int LAND_HEIGHT = 50;
	public boolean isfalling;

	public final static Image Object_IMAGE = new Image("castlestageimages/pot.gif",75,100,false,false);
	
	public PushableObject( int x, int y) {
		// TODO Auto-generated constructor stub
		super(x,y);
//		this.alive = true;
		this.loadImage(PushableObject.Object_IMAGE);
		this.isfalling=true;
	}
	
	public void move() {
//		System.out.println(this.isfalling);
		if(this.isfalling==true) {
			this.y+=10;
		}
		if(this.dx+this.x>0 && this.dx+this.x<1300-75) { //to prevent the obj getting out of the stage
			this.x+=this.dx;
		}
		
	}
	
	public void setFalling(boolean fall) {
		this.isfalling=fall;
		
	}

}
	
	

