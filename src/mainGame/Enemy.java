package mainGame;

import javafx.scene.image.Image;


public class Enemy extends Sprite{

	protected boolean alive;
	protected final static int ENEMY_HEIGHT = 75;
	protected final static int ENEMY_WIDTH = 50;
	public static boolean isfalling=false;
	
	protected int start_area; //the area where the enemy will walk
	protected int end_area;
	
	protected int speed; //randomized speed
	
	protected int turn=0;

	public final static Image ENEMY_IMAGE = new Image("castlestageimages/ninjastand.png",Enemy.ENEMY_WIDTH,Enemy.ENEMY_HEIGHT,false,false);
	public final static Image ENEMY_IMAGE_LEFT = new Image("castlestageimages/ninjaleft.png",Enemy.ENEMY_WIDTH,Enemy.ENEMY_HEIGHT,false,false);
	public final static Image ENEMY_IMAGE_RIGHT = new Image("castlestageimages/ninjaright.png",Enemy.ENEMY_WIDTH,Enemy.ENEMY_HEIGHT,false,false);
	
	public Enemy(int x, int y, int start, int end) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.setAlive(true);
		this.loadImage(ENEMY_IMAGE);
		
		this.speed=3;
		
		this.start_area=start;
		this.end_area=end;
	}
	
	
	public boolean isAlive(){
		if(this.alive) return true;
		return false;
	} 

	public void die(){
		this.setAlive(false);
	}

	public int getSpeed() {
		return this.speed;
	}
	public void move() {
		
		if(this.getX() <= this.start_area ) { //if the enemy will hit its start area
			this.x += this.dx;
			this.turn = 0; //update the turn meaning that the enemy will need to got to the right
			this.loadImage(ENEMY_IMAGE_RIGHT);
		}else if(this.getX() + this.getDX() == this.end_area || this.turn == 1) { //if the enemy will hit its end area or needs to go to the left
			this.x -= this.dx;
			this.turn = 1; //update the turn meaning that the enemy needs to go to the left
			this.loadImage(ENEMY_IMAGE_LEFT);
		}else {
			this.x += this.dx;
		}
    	this.y += this.dy;
		
	}


	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
