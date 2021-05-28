package mainGame;

import javafx.scene.image.Image;

public class PhantomFlower extends Sprite {
	
	public final static int PHANTOMFLOWER_WIDTH = 78;
	public final static int PHANTOMFLOWER_HEIGHT = 75;
	public final static Image PHANTOMFLOWER_OPEN = new Image("castlestageimages/phantomfloweropen.png",PhantomFlower.PHANTOMFLOWER_WIDTH,PhantomFlower.PHANTOMFLOWER_HEIGHT*2,false,false);
	public final static Image PHANTOMFLOWER_CLOSED = new Image("castlestageimages/phantomflowerclosed.png",PhantomFlower.PHANTOMFLOWER_WIDTH,PhantomFlower.PHANTOMFLOWER_HEIGHT*2,false,false);
	private boolean open = false;

	public PhantomFlower(int x, int y) {
		super(x,y);
		this.loadImage(PHANTOMFLOWER_OPEN);
	}
	
	public boolean isOpen() {
		return this.open;
	}
	
	public void setOpen(boolean status) {
		this.open = status;
	}
}
