package mainGame;

import javafx.scene.image.Image;

public class Princess extends Sprite {
	public final static int PRINCESS_HEIGHT = 75;
	public final static int PRINCESS_WIDTH = 50;
	public final static Image PRINCESS_IMAGE = new Image("castlestageimages/princess.png",Princess.PRINCESS_WIDTH, Princess.PRINCESS_HEIGHT,false,false);

	public Princess(int x, int y) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.loadImage(PRINCESS_IMAGE);
	}

}
