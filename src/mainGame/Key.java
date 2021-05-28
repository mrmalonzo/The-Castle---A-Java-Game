package mainGame;

import javafx.scene.image.Image;

public class Key extends Sprite {
	
	public final static int KEY_WIDTH = 25;
	private final Image key = new Image("castlestageimages/key.png",Key.KEY_WIDTH,Key.KEY_WIDTH+10,false,false);

	public Key(int x, int y) {
		super(x,y);
		this.loadImage(key);
	}
	
}
