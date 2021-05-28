package mainGame;

import javafx.scene.image.Image;

public class Door extends Sprite {

	public final static int DOOR_WIDTH = 78;
	private final Image door = new Image("castlestageimages/door.png",Door.DOOR_WIDTH,Door.DOOR_WIDTH*2,false,false);
	
	public Door(int x, int y) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.loadImage(door);
	}

}
