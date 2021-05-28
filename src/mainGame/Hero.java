package mainGame;

import javafx.scene.image.Image;

public class Hero extends Sprite{

	private boolean alive;
	public final static int HERO_HEIGHT = 75;
	public final static int HERO_WIDTH = 50;
	public static boolean isfalling=false;
	public static int health=3;
	private Key heldKey;

	public final static Image HERO_IMAGE_STANDRIGHT = new Image("castlestageimages/samuraistandright.png",Hero.HERO_WIDTH,Hero.HERO_HEIGHT,false,false);
	public final static Image HERO_IMAGE_STANDLEFT = new Image("castlestageimages/samuraistandleft.png",Hero.HERO_WIDTH,Hero.HERO_HEIGHT,false,false);
	public final static Image HERO_IMAGE_WALKRIGHT = new Image("castlestageimages/samuraiwalkright.png",Hero.HERO_WIDTH,Hero.HERO_HEIGHT,false,false);
	public final static Image HERO_IMAGE_WALKLEFT = new Image("castlestageimages/samuraiwalkleft.png",Hero.HERO_WIDTH,Hero.HERO_HEIGHT,false,false); 
	
	public Hero(int health, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.alive = true;
		this.loadImage(Hero.HERO_IMAGE_STANDRIGHT);
	}
	
	
	public boolean isAlive(){
		if(this.alive) return true;
		return false;
	} 
	
	public int getHealth() {
		return this.health;
	}
	
	public Key getKey() {
		return this.heldKey;
	}
	
	public void holdKey(Key key) {
		if(this.heldKey == null) this.heldKey = key;
	}
	
	public void useKey() {
		if(this.heldKey != null) this.heldKey = null;
	}
	
	public void setHealth(int health) {
		this.health=health;
	}

	public void die(){
		this.alive = false;
	}

	public void move() {
		if(this.x+this.dx>0 && this.x+this.dx<1300-20) { //so that the player wont go out of bounds
			this.x += this.dx;
		}
		if(GameTimer.checker2==1 || GameTimer.checker3==1) { //to prevent going through the lands
			this.x=GameTimer.oldx;
		}
//		
		this.y+=this.dy;
		
		
		if(Hero.isfalling==false && GameTimer.jump!=true) { //gravity physics. If the player is supposed to fall and the player does not press the jump button
			this.y+=15;
		}
	}
}
