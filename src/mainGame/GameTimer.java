package mainGame;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;


public class GameTimer extends AnimationTimer{

	private GraphicsContext gc;
	private Scene gameScene;
	private Scene menuScene;
	private Hero myHero;
	private Princess peach;
	
	public static int checker=0; //checker for the gravity and falling physics
	
	private ArrayList<Land> Lands;
	
	private ArrayList<Enemy> Enemies;
	
	private ArrayList<PushableObject> Pushobj;
	
	private ArrayList<Key> Keys;
	
	private ArrayList<Door> Doors;
	
	private ArrayList<Elevator> Elevators;
	
	private ArrayList<Candy> Candies;
	
	private ArrayList<PhantomFlower> Flowers;
	
	public static boolean jump=false; //marker for the jump action
	
	private static int gravity=0; //used for the momentum of the jump
	
	public static int checker2=0;  //checker for the collision of the player to the land to prevent the player from going in the land
	
	public static int oldx; //marker for the old x coordinate of the player to be used if there is a collision
	
	public static int objpushed; //marker for the object pushed
	
	public static int objtofall; //marker for the object that is about to fall
	
	private int level; //what level of the game it is
	
	public static int elevatorpush; // marker for the elevator lifting the player;
	
	public static boolean facingleft=false; //used as marker to know if the hero is pushing
	
	public static int checker3=0; //used for the collision of the player and elevator
	
	public static boolean faceright = true; //true if player is facing right, false if facing left
	
	public static Image heart = new Image("castlestageimages/heart.gif", 75,75, false,false);
	
	private Stage oldstage;
	
	public static int SCORE=0;
	
	private static int animationdelay=1; //for the animationw laking delay of the hero 
	
	private static long startshift;
	
	GameTimer(GraphicsContext gc, Scene gameScene, Scene menuScene, Stage stage, int level){
		this.gc = gc;
		this.gameScene = gameScene;
		this.menuScene = menuScene;
		this.startshift = System.nanoTime();
		//instantiate arraylists for kwys, doors, lands, enemies, elevators, pushable objects and candies
		this.Keys = new ArrayList<Key>();
		this.Doors = new ArrayList<Door>();
		this.Lands=new ArrayList<Land>(); //array of lands
		this.Enemies=new ArrayList<Enemy>();
		this.Elevators=new ArrayList<Elevator>();
		this.Pushobj=new ArrayList<PushableObject>(); //araylist for the pushable objects
		this.Candies= new ArrayList<Candy>();
		this.Flowers = new ArrayList<PhantomFlower>();
		//objects are constructed depending on number of levels cleared
		if(level==1) {
			this.myHero = new Hero(3, 100, 100);
			this.Keys.add(new Key(0,80));
			this.Doors.add(new Door(1225, 200));
			
			this.Lands.add(new Land(100,600,3));
			this.Lands.add(new Land(1150, 350,3));
			this.Lands.add(new Land(1225,0,2));
			this.Lands.add(new Land(-100,120,2));
			this.Lands.add(new Land(300, 90, 2));
			this.Pushobj.add(new PushableObject(400, 300));
			
			this.Flowers.add(new PhantomFlower(200,460));
			
			this.Enemies.add(new FireSpirit(500, 280, 500, 1100,200,100));
			this.Elevators.add(new Elevator (700, 100, 100, 500));	
			
			GameStage.player3.setAutoPlay(true);
			GameStage.player3.setCycleCount(MediaPlayer.INDEFINITE);
			GameStage.player3.play();

		}else if(level==2) {
			this.myHero = new Hero(3, 100, 100);
			this.Keys.add(new Key(300,60));
			this.Doors.add(new Door(1225, 200));
			
			this.Candies.add(new Candy(700, 490));
			
			this.Lands.add(new Land(100,600,4));
			this.Lands.add(new Land(850,500,2));
			this.Lands.add(new Land(1150, 350,2));
			this.Lands.add(new Land(1225,0,2));
			this.Lands.add(new Land(300, 100, 3));
			
			this.Enemies.add(new FireSpirit(800, 280, 800, 1100,400,100));
			this.Elevators.add(new Elevator(-50,0,100,400));
			
			this.Pushobj.add(new PushableObject(500, 500));
			
			this.Flowers.add(new PhantomFlower(300,460));
			this.Flowers.add(new PhantomFlower(600,-40));

		}else if(level==3) {
			GameStage.player3.stop();
			GameStage.player4.setAutoPlay(true);
			GameStage.player4.setCycleCount(MediaPlayer.INDEFINITE);
			GameStage.player4.play();

			this.myHero = new Hero(3,100,650);
			
			this.Keys.add(new Key(20,80));

			this.Doors.add(new Door(1225,250));
			//call method to handle mouse click event
			
			this.Lands.add(new Land(0, 750,1)); //main land
			this.Lands.add(new Land(0+Land.LAND_WIDTH/2, 750,1)); //main land
			this.Lands.add(new Land(-150, 500,1 ));
			this.Lands.add(new Land(650, 400 ,1));
			this.Lands.add(new Land(-50, 130 ,1));
			this.Lands.add(new Land(810,200,1));
//			this.Lands.add(new Land(1260, 600, 1));
	
			this.Candies.add(new Candy(30, 425));
			this.Candies.add(new Candy(800, 690));
			this.Candies.add(new Candy(1260, 550));
			this.Candies.add(new Candy(1225, 150));
			
			this.Enemies.add(new BlackMage(500, 675, 500, 1250)); //if enemy is BlackMage: (end-start) must be divisble by 3.
			this.Enemies.add(new Enemy(700, 325, 700, 1090)); 	
			this.Enemies.add(new BlackMage(0, 425, 0, 450)); 		//450-0 is div by speed (3)
			this.Enemies.add(new BlackMage(950,120,950,1250));
			
			this.Pushobj.add(new PushableObject(150, 0)); // add the pushable objects
			
		}else if(level == 4) {
			this.myHero = new Hero(3,100,650);
			
			this.Keys.add(new Key(1245,20));
			
			this.Candies.add(new Candy(30, 425));
			this.Candies.add(new Candy(800, 690));
			this.Candies.add(new Candy(20,80));
			this.Candies.add(new Candy(0,650));
			
			this.Doors.add(new Door(1225,250));
			
			this.Lands.add(new Land(0, 750,1)); //main land
			this.Lands.add(new Land(0+Land.LAND_WIDTH/2, 750,1)); //main land
			this.Lands.add(new Land(-150, 500,1 ));
			this.Lands.add(new Land(650, 400 ,1));
			this.Lands.add(new Land(-40, 130 ,1));
			this.Lands.add(new Land(1225,60,1));
			this.Lands.add(new Land(950,200,1));
		
			this.Enemies.add(new BlackMage(500, 675, 500, 1250)); //main land
			this.Enemies.add(new BlackMage(700, 325, 610, 1210)); //main land
			this.Enemies.add(new Enemy(0, 425, 0, 450)); //main land
			this.Enemies.add(new AttackCat(960,120,920,1200));
			
			this.Pushobj.add(new PushableObject(150, 0)); // add the pushable objects
		}else if(level == 5) {
			this.myHero = new Hero(3,100,650);
			
			this.peach = new Princess(1225,5); //load princess instead of a door because this is the last level
			
			this.Candies.add(new Candy(30, 425));
			this.Candies.add(new Candy(800, 690));
			this.Candies.add(new Candy(1225, 250));
			this.Candies.add(new Candy(1100,60));
			this.Candies.add(new Candy(1225,600));
			
			this.Lands.add(new Land(0, 750,1));
			this.Lands.add(new Land(0+Land.LAND_WIDTH/2, 750,1));
			this.Lands.add(new Land(-150, 500,1 ));
			this.Lands.add(new Land(625, 400 ,1));
			this.Lands.add(new Land(-40, 130 ,1));
			this.Lands.add(new Land(1150,75,1));
		
			this.Enemies.add(new Enemy(500, 675, 500, 1250));
			this.Enemies.add(new AttackCat(50, 815, 50, 950));
			this.Enemies.add(new Enemy(700, 325, 700, 1210));
			this.Enemies.add(new Enemy(0, 425, 0, 450));
			
			this.Pushobj.add(new PushableObject(80, 0)); // add the pushable objects
		}
		
		this.moveElevator();
		this.moveEnemies();
		this.handleKeyPressEvent();
		
		this.level=level;
		this.oldstage=stage; //my oldstage
	}

	@Override
	public void handle(long currentNanoTime) {
		this.gc.clearRect(0, 0, 1300,768);
		
		this.gc.setStroke(Color.WHITE); //show the score
		String currentscore = Integer.toString(GameTimer.SCORE);
		this.gc.setFont(new Font("Times New Roman", 70));
		this.gc.strokeText(currentscore, 1050, 75);
		
		//call the methods to move the player
		if(this.myHero.isAlive()==false) { //if player is dead go to gameoverstage
//			GameWinStage gamewin = new GameWinStage(this.oldstage, this.menuScene); //GAMEWIN SCENE
//			gamewin.setStage(this.oldstage);
			GameOverStage gameover=new GameOverStage(this.oldstage, this.menuScene); //GAMELOSE SCENE
			gameover.setStage(this.oldstage);
			//oldstage.setScene(gameover.getScene());
			this.stop();
		}
		if(Hero.health==0) { //if player has no health left, die
			this.myHero.die();
		}
		
		if(Hero.health>0) {
			this.gc.drawImage(heart, 200, 20);
		}
		if(Hero.health>1) {
			this.gc.drawImage(heart, 300, 20);
		}
		if(Hero.health>2) {
			this.gc.drawImage(heart, 400, 20);
		}
		
		//render the player
		this.myHero.render(this.gc);
		
		if(level < 5) { //render keys and doors only on levels 1-4 
			this.Keys.get(0).render(this.gc);
			this.Doors.get(0).render(this.gc);
		}
		else{ //render princess on level 5
			this.peach.render(this.gc);
		}
		
		if(level < 3) for(int i=0; i<this.Flowers.size();i++) this.Flowers.get(i).render(this.gc);
		
		for(int i=0; i<this.Lands.size() ; i++) { //render the lands
			this.Lands.get(i).render(this.gc);
		}
		for(int i=0; i<this.Enemies.size() ; i++) { //render the Enemies
			this.Enemies.get(i).render(this.gc);
		}
		for(int i=0; i<this.Pushobj.size() ; i++) { //render the Pushable objects
			this.Pushobj.get(i).render(this.gc);
		}
		for(int i=0; i<this.Elevators.size() ; i++) { //render the elevator objects
			this.Elevators.get(i).render(this.gc);
		}
		for(int i=0; i<this.Candies.size() ; i++) { //render the candy objects
			this.Candies.get(i).render(this.gc);
		}
		checker=0;
		for(int i=0; i<this.Lands.size() ; i++) { //for gravity
			if(this.myHero.collidesWith(this.Lands.get(i))) {
				checker=1;

			}
		}
		for(int i=0; i<this.Pushobj.size() ; i++) { //for gravity
			if(this.myHero.collidesWith(this.Pushobj.get(i))) {
				checker=1;

			}
		}
		for(int i=0; i<this.Elevators.size() ; i++) { //for gravity
			if(this.myHero.collidesWith(this.Elevators.get(i))) {
				checker=1;
				moveHeroElevator();
				elevatorpush=i;
			}
		}
		
		boolean pushobjgravity=true;
		for(int j=0; j<this.Pushobj.size() ; j++) {
			for(int i=0; i<this.Lands.size() ; i++) { //for gravity of the pushable objects
				if(this.Pushobj.get(j).collidesWith(this.Lands.get(i))) {
					this.Pushobj.get(j).isfalling=false;
					pushobjgravity=false;

				}
			}
			if(pushobjgravity==true) { //if the object doesn't collide to any land, then it needs to fall
				this.Pushobj.get(objtofall).isfalling=true;
				objtofall=j;
			}
		}
		for(int i=0; i<this.Pushobj.size() ; i++) { //if a pushable object collides with an enemy, remove enemy
			for(int j=0; j < this.Enemies.size(); j++) {
				if(this.Pushobj.get(i).collidesWith(this.Enemies.get(j))) {
					this.Enemies.remove(j);
				}
			}
		}
		for(int i=0; i<this.Pushobj.size() ; i++) { //for the collision of pushable obj (except the main ground) and hero
			if(this.myHero.collidesWith3(this.Pushobj.get(i))) {
				objpushed=i; //to let the program know the object that was pushed
				this.movePushableObj();	
//				System.out.println(objpushed);
			}				
		}

		 checker2=0;
		for(int i=0; i<this.Lands.size() ; i++) { //for the collision of land (except the main ground) and hero
			if(this.myHero.collidesWith2(this.Lands.get(i))) {
				checker2=1;
			}else {
				oldx=this.myHero.getX(); //get the old x coordinate of the hero while it doesnt collide with the land
			}
		}
		 checker3=0;
		for(int i=0; i<this.Elevators.size() ; i++) { //for the collision of elevtor and hero
			if(this.myHero.collidesWith2(this.Elevators.get(i))) {
				checker3=1;
			}else {
				oldx=this.myHero.getX(); //get the old x coordinate of the hero while it doesnt collide with the land
			}
		}
		for(int i=0; i<this.Enemies.size() ; i++) { //render the Enemies
				if(this.myHero.collidesWith(this.Enemies.get(i))){
					Hero.health-=1; //if it collides with the enemy, reduce the life of the player
					if(this.level == 1 || this.level == 2) {
						this.myHero.setX(150); //make the player go to its first position
						this.myHero.setY2(100);
					}
					else{
						this.myHero.setX(100); //make the player go to its first position
						this.myHero.setY2(650);
					}
				}
		}
		
		for(int i=0; i<this.Candies.size(); i++) {
			if(this.myHero.collidesWith(this.Candies.get(i))) {//if the player got the candy
				GameTimer.SCORE+=5;  //add 5 to the score
				this.Candies.remove(i); //remove the candy
			}
		}
		if(this.myHero.getY() > 768) { //if the hero falls
			Hero.health-=1; //if it collides with the enemy, reduce the life of the player
			if(this.level == 1 || this.level == 2) {
				this.myHero.setX(150); //make the player go to its first position
				this.myHero.setY2(100);
			}
			else{
				this.myHero.setX(100); //make the player go to its first position
				this.myHero.setY2(650);
			}
			oldx=100;
			checker2=1;
		}
		if(checker==1) { //if the hero is in the ground
			Hero.isfalling=true; //meaning the hero is not falling
			gravity=0;
		}else{
			Hero.isfalling=false; //else make the hero fall
		}
		if(jump==true) { //if the player presses the jump button
			if(checker2==1 || checker3==1) { //if the player collides with a land, make them fall and not jump any further
				gravity=23;
			}
			this.myHero.setDY(-23 + gravity); //make the player jump
			gravity++; //to make them lose the momentum of the jump
			for(int i=0; i<this.Lands.size() ; i++) { //for the collision of land (except the main ground) and hero
				if(this.myHero.collidesWith2(this.Lands.get(i))) {
					checker2=1;
				}else {
					oldx=this.myHero.getX(); //get the old x coordinate of the hero while it doesnt collide with the land
				}
			}
			this.myHero.move();
			if(gravity>23) { //if the player reaches the max height of the jump
				
				jump=false; //to prevent the player from further jumping
			}
		}else {
			this.myHero.move();
		}
		for(int i=0; i<this.Elevators.size() ; i++) { //move the elevators
			this.Elevators.get(i).move();
		}
		for(int i=0; i<this.Enemies.size() ; i++) { //move the enemies
			this.Enemies.get(i).move();
		}
		for(int i=0; i<this.Pushobj.size() ; i++) { //for the movement of the pushable obj
			this.Pushobj.get(i).move();
		}
		
		long currenttime = TimeUnit.NANOSECONDS.toSeconds(currentNanoTime); //variable for getting current nano time of handle as seconds
		long starttime = TimeUnit.NANOSECONDS.toSeconds(GameTimer.startshift); // variable for holding current system time
		for(int i=0; i<this.Flowers.size();i++) {
			if((currenttime - starttime)%3 == 0) { //change flower's state every 3 seconds		
				this.Flowers.get(i).setOpen(true);
				this.Flowers.get(i).loadImage(PhantomFlower.PHANTOMFLOWER_OPEN);
				this.Flowers.get(i).render(this.gc);
			}
			else{				
				this.Flowers.get(i).setOpen(false);
				this.Flowers.get(i).loadImage(PhantomFlower.PHANTOMFLOWER_CLOSED);
				this.Flowers.get(i).render(this.gc);
			}
		}
		
		if(level < 3) {
			for(int i=0; i<this.Flowers.size();i++) { //collision detection that's only active on levels 1-2
				if(this.myHero.collidesWith(this.Flowers.get(i)) && this.Flowers.get(i).isOpen() == false) {
					Hero.isfalling = false;
					this.myHero.setX(oldx);
					this.myHero.setDY(0);
				}else {
					oldx=this.myHero.getX();
				}
			}
		}
		
		if(level<5) { //collision detection between hero and key will only be active during levels 1-4
			if(this.myHero.collidesWith(this.Keys.get(0)) && this.Keys.get(0).isVisible() != false) { //check if player gets a key
				this.myHero.holdKey(this.Keys.get(0));
				this.Keys.get(0).setVisible(false);
				this.Keys.get(0).loadImage(null);
				GameTimer.SCORE+=10; //add 	10 to the score of player if he gets a key
			}
		}
		
		if(level < 5) { //collision detection between hero and doors while holding a key will only be active during levels 1-4
			if(myHero.collidesWith(this.Doors.get(0)) && this.myHero.getKey() != null) { //proceed to next stage
				GameTimer.SCORE+=20; //add 20 to the score of player of opens a door
				this.stop();
				GameStage gamestage2 = new GameStage(this.oldstage, this.menuScene,  ++this.level);
				gamestage2.setStage(this.oldstage);
			}
		}else { //collision detection between hero and princess will only be active during level 5
			if(this.myHero.collidesWith(this.peach)) {
				GameTimer.SCORE+=50;
				GameWinStage gamewin = new GameWinStage(this.oldstage, this.menuScene); //GAMEWIN SCENE
				gamewin.setStage(this.oldstage);
				this.stop();
			}
		}
		if(checker2==1 && checker==1) {
			Hero.isfalling=false;
			jump=false;
		}
	}
	
	
	//method for listening and handling events on key press/release
	private void handleKeyPressEvent() {
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
            	KeyCode code = e.getCode();
                movePlayer(code);
			}
			
		});
		
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
		            public void handle(KeyEvent e){
		            	KeyCode code = e.getCode();
		                stopPlayer(code);
		            }
		        });
    }
	private void movePushableObj() { //move the pushable objects
		if(this.myHero.getDX()>0 && this.myHero.getX()+this.myHero.getDX()==this.Pushobj.get(objpushed).getX()-40 && jump==false && Hero.isfalling) { //if the hero goes to the right and is facing right and is not jumping
			this.Pushobj.get(objpushed).setDX(10);
		}else if(this.myHero.getDX()<0  && this.myHero.getX()+this.myHero.getDX()>this.Pushobj.get(objpushed).getX()+Hero.HERO_WIDTH && jump==false && Hero.isfalling){ //if the hero goes to the left and is facing left and is not jumping
			this.Pushobj.get(objpushed).setDX(-10);
		}else {
			this.Pushobj.get(objpushed).setDX(0);
			facingleft=false;
		}
	}
	
	private void moveHeroElevator() { //to move the hero according to the elevator
		if(Elevator.up==false) {
			this.myHero.setDY(this.Elevators.get(elevatorpush).getDY());
		}else {
			this.myHero.setDY(-this.Elevators.get(elevatorpush).getDY());
		}
	}
	
	
	private void moveElevator() { // move elevators
		for(int i=0; i<this.Elevators.size() ; i++) { //move the enemies depending on their assigned speed
			this.Elevators.get(i).setDY(this.Elevators.get(i).getSpeed());
		}
	}
	
	private void moveEnemies() {
		for(int i=0; i<this.Enemies.size() ; i++) { //move the enemies depending on their assigned speed
			this.Enemies.get(i).setDX(this.Enemies.get(i).getSpeed());
		}
	}
	
	//method that will move the ship depending on the key pressed
	private void movePlayer(KeyCode ke) {
		if(ke==KeyCode.UP && gravity==0) { //if the player presses jump
			jump=true; //set the jump marker to true
			if(faceright == true) this.myHero.loadImage(Hero.HERO_IMAGE_STANDRIGHT);
			else if(faceright == false) this.myHero.loadImage(Hero.HERO_IMAGE_STANDLEFT);	 
		}

		if(ke==KeyCode.LEFT) {
			this.myHero.setDX(-10);
			facingleft=true;
			faceright = false;
			if(animationdelay%8>=4) {
				this.myHero.loadImage(Hero.HERO_IMAGE_STANDLEFT);
			}else {
				this.myHero.loadImage(Hero.HERO_IMAGE_WALKLEFT);
			}
			animationdelay++;
			
		}

//		if(ke==KeyCode.DOWN) this.myHero.setDY(3);
		
		if(ke==KeyCode.RIGHT) {
			this.myHero.setDX(10);
			facingleft=false;
			faceright = true;
			if(animationdelay%8>=4) {
				this.myHero.loadImage(Hero.HERO_IMAGE_STANDRIGHT);
				
			}else {
				
				this.myHero.loadImage(Hero.HERO_IMAGE_WALKRIGHT);
			}
			animationdelay++;
			
		}
		
		if(ke==KeyCode.SPACE) {
			if(this.level == 1 || this.level == 2) {
				this.myHero.setX(150); //make the player go to its first position
				this.myHero.setY2(100);
			}
			else{
				this.myHero.setX(100); //make the player go to its first position
				this.myHero.setY2(650);
			}
			
		}
		System.out.println(animationdelay);
		System.out.println(ke+" key pressed.");
   	}
	
	//method that will stop the ship's movement; set the ship's DX and DY to 0
	private void stopPlayer(KeyCode ke){
		this.myHero.setDX(0);
		this.myHero.setDY(0);
		if(faceright == true) this.myHero.loadImage(Hero.HERO_IMAGE_STANDRIGHT);
		else if(faceright == false) this.myHero.loadImage(Hero.HERO_IMAGE_STANDLEFT);
		if(objtofall!=-1) {
			this.Pushobj.get(objpushed).setDX(0); //to make the program stop the pushable object if its not longer being used
		}
		animationdelay=1; //turn back the animation delay to 1

	}
	
}
