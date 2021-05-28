package mainGame;

import javafx.scene.image.Image;

public class FireSpirit extends Enemy {
	public final static Image FIRE_IMAGE = new Image("castlestageimages/fire.gif",Enemy.ENEMY_WIDTH,Enemy.ENEMY_HEIGHT,false,false);
	int ybounds;
	int yboundsend;
	int yrandom;
	public FireSpirit(int x, int y, int start, int end, int ybounds, int yboundsend) {
		// TODO Auto-generated constructor stub
		super(x,y,start,end);
		this.setAlive(true);
		this.loadImage(FIRE_IMAGE);
		
		
		this.start_area=start;
		this.end_area=end;
		this.ybounds = ybounds;
		this.yboundsend = yboundsend;
	}
	
	public void move() {
			
			if(this.getX() <= this.start_area ) { //if the enemy will hit its start area
				this.x += this.dx;
				this.turn = 0; //update the turn meaning that the enemy will need to got to the right
			}else if(this.getX() + this.getDX() == this.end_area || this.turn == 1) { //if the enemy will hit its end area or needs to go to the left
				this.x -= this.dx;
				this.turn = 1; //update the turn meaning that the enemy needs to go to the left
			}else {
				this.x += this.dx;
			}
			
			this.setDY(this.speed);
			if(this.getY() >= this.ybounds ) { //if the enemy will hit its start area
				this.y -= this.dy;
				this.yrandom = 0;
			}else if(this.getY() + this.getDY() == this.yboundsend || this.yrandom == 1) { //if the enemy will hit its end area or needs to go to the left
				this.y += this.dy;
				this.yrandom = 1;
			}else {
				this.y -= this.dy;
			}
			this.loadImage(FIRE_IMAGE);
	}
}
