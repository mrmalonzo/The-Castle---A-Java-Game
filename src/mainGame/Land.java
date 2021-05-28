package mainGame;

import javafx.scene.image.Image;

public class Land extends Sprite{ //land object, also extends sprite

//	private boolean alive;
	public final static int LAND_WIDTH = 1300;
	public final static int LAND_HEIGHT = 50;
	
	public final static int LAND_WIDTH2 = 200;
	public final static int LAND_HEIGHT2 =200;
	
	public final static int LAND_WIDTH3 = 400;
	public final static int LAND_HEIGHT3 =200;
	
	public final static Image LAND_IMAGE = new Image("castlestageimages/land.png",Land.LAND_WIDTH/2,Land.LAND_HEIGHT,false,false); //long land but inside castle
	public final static Image LAND_IMAGE2 = new Image("castlestageimages/landlong.png",Land.LAND_WIDTH2,Land.LAND_HEIGHT2,false,false); //short land
	public final static Image LAND_IMAGE3 = new Image("castlestageimages/landlong.png",Land.LAND_WIDTH3,Land.LAND_HEIGHT3,false,false); //med land
	public final static Image LAND_IMAGE4 = new Image("castlestageimages/landlong.png",Land.LAND_WIDTH/2,Land.LAND_HEIGHT,false,false); //long land
	public Land( int x, int y, int type) {
		// TODO Auto-generated constructor stub
		super(x,y);
//		this.alive = true;
		if(type==1) { //if user wants long inside castle land
			this.loadImage(Land.LAND_IMAGE);
		}else if(type==2) { //if user wants short land
			this.loadImage(Land.LAND_IMAGE2);
		}else if(type==3) { //if user wants med land
			this.loadImage(Land.LAND_IMAGE3);
		}else if(type==4) { //if user wants logn
			this.loadImage(Land.LAND_IMAGE4);
		}
		
	}

}
	
	

