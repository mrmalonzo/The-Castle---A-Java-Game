package mainGame;

import javafx.scene.image.Image;


public class Elevator extends Sprite{

	private boolean alive;
	private final static int ELEVATOR_WIDTH = 200;
	private final static int ELEVATOR_HEIGHT =100;
	public static boolean isfalling=false;
	
	public static boolean up=false;
	
	private int start_area; //the area where the enemy will walk
	private int end_area;
	
	private int speed; //randomized speed
	
	private int turn=0;

	public final static Image ELEVATOR_IMAGE = new Image("castlestageimages/landmed.png",Elevator.ELEVATOR_WIDTH,Elevator.ELEVATOR_HEIGHT,false,false);
	
	public Elevator(int x, int y, int start, int end) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.alive = true;
		this.loadImage(ELEVATOR_IMAGE);
		
		this.speed=2;
		
		this.start_area=start;
		this.end_area=end;
	}
	
	
	public boolean isAlive(){
		if(this.alive) return true;
		return false;
	} 

	public void die(){
		this.alive = false;
	}

	public int getSpeed() {
		return this.speed;
	}
	public void move() {
		
		if(this.getY() <= this.start_area ) { //if the eleveator will hit its start area
			up=false;
			this.y += this.dy;
			this.turn = 0; //update the turn meaning that the elevator will need to go up
			
		}else if(this.getY() + this.getDY() == this.end_area || this.turn == 1) { //if the elevator will hit its end area or needs to go to the down
			up=true;
			this.y	-= this.dy;
			this.turn = 1; //update the turn meaning that the elevator needs to go down

		}else {
			up=false;
			this.y += this.dy;
		}
//    	this.y += this.dy;
		
	}
}
