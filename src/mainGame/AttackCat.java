package mainGame;

import javafx.scene.image.Image;

public class AttackCat extends Enemy {
	
	public final static Image ATTACK_CAT_IMAGE_RIGHT = new Image("castlestageimages/attackcatright.png",Enemy.ENEMY_HEIGHT,Enemy.ENEMY_HEIGHT,false,false);
	public final static Image ATTACK_CAT_IMAGE_LEFT = new Image("castlestageimages/attackcatleft.png",Enemy.ENEMY_HEIGHT,Enemy.ENEMY_HEIGHT,false,false);

	public AttackCat(int x, int y, int start, int end) {
		super(x,y,start,end);
		this.setAlive(true);
		this.loadImage(ATTACK_CAT_IMAGE_RIGHT);
		
		this.speed=4;
		
		this.start_area=start;
		this.end_area=end;
	}
	
	public void move() {
		
		if(this.getX() <= this.start_area ) { //if the enemy will hit its start area
			this.x += this.dx;
			this.turn = 0; //update the turn meaning that the enemy will need to got to the right
			this.loadImage(ATTACK_CAT_IMAGE_RIGHT);
		}else if(this.getX() + this.getDX() == this.end_area || this.turn == 1) { //if the enemy will hit its end area or needs to go to the left
			this.x -= this.dx;
			this.turn = 1; //update the turn meaning that the enemy needs to go to the left
			this.loadImage(ATTACK_CAT_IMAGE_LEFT);
		}else {
			this.x += this.dx;
		}
    	this.y += this.dy;
	}
}
