package mainGame;

import javafx.scene.image.Image;

public class Candy extends Sprite {
	
	public final static int CANDY_WIDTH = 50;
	private final Image Candy_IMG = new Image("castlestageimages/candy.gif",Candy.CANDY_WIDTH,Candy.CANDY_WIDTH,false,false);

	public Candy(int x, int y) {
		super(x,y);
		this.loadImage(Candy_IMG);
	}
	
}
