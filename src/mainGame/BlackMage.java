package mainGame;

import javafx.scene.image.Image;

public class BlackMage extends Enemy {
	public final static Image BLACK_MAGE_IMAGE_RIGHT = new Image("castlestageimages/blackmage.png",Enemy.ENEMY_WIDTH,Enemy.ENEMY_HEIGHT,false,false);
	public final static Image BLACK_MAGE_IMAGE_LEFT = new Image("castlestageimages/blackmageleft.png",Enemy.ENEMY_WIDTH,Enemy.ENEMY_HEIGHT,false,false);
	public BlackMage(int x, int y, int start, int end) {
		// TODO Auto-generated constructor stub
		super(x,y,start,end);
		this.setAlive(true);
		this.loadImage(BLACK_MAGE_IMAGE_RIGHT);
		
		this.speed=3;
		
		this.start_area=start;
		this.end_area=end;
	}
	
	
	public void move() {
		
		if(this.getX() <= this.start_area ) { //if the enemy will hit its start area
			this.x += this.dx;
			this.turn = 0; //update the turn meaning that the enemy will need to got to the right
			this.loadImage(BLACK_MAGE_IMAGE_RIGHT);
		}else if(this.getX() + this.getDX() == this.end_area || this.turn == 1) { //if the enemy will hit its end area or needs to go to the left
			this.x -= this.dx;
			this.turn = 1; //update the turn meaning that the enemy needs to go to the left
			this.loadImage(BLACK_MAGE_IMAGE_LEFT);
		}else {
			this.x += this.dx;
		}
    	this.y += this.dy;
		
	}
}
