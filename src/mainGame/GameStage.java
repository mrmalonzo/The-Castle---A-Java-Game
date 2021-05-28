package mainGame;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import titleScreen.Menu;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Label;

public class GameStage {
	
	private Scene menuScene;
	private Scene scene;
	private Stage stage;
	private Group root;
	private Canvas canvas;
	private GraphicsContext gc;
	private GameTimer gametimer;
	public static final Image bg = new Image("castlestageimages/dungeonbackground.jpg",720,460,false,false);
	public static final ImageView health =new ImageView( new Image("castlestageimages/health.png",200,75,false,false));
	public static final ImageView backg=new ImageView(bg);
	public static final ImageView back2 = new ImageView(new Image("castlestageimages/dark2.png", 1300, 768, false, false));
	public static final ImageView back3 = new ImageView(new Image("castlestageimages/dark1.jpg", 1300, 768, false, false));
	public static final ImageView back4 = new ImageView(new Image("castlestageimages/insidedungeon.jpg", 1300, 768, false, false));
	public static final ImageView back5 = new ImageView(new Image("castlestageimages/insidedungeon2.png", 1300, 768, false, false));
	private Label label;
	private Label resetlabel;
	public static final ImageView label2 = new ImageView(new Image ("castlestageimages/rescure.png",800, 400, false, false));
	public static final ImageView score = new ImageView( new Image("castlestageimages/score.png",400,75,false,false));
	private int level;
	
	public static String path1 = Menu.class.getResource("/music/guiltycrown.mp3").toString();
	public static Media menusong1 = new Media(path1);
	public static MediaPlayer player1 = new MediaPlayer(menusong1);
	
	public static String path2 = Menu.class.getResource("/music/sao.mp3").toString();
	public static Media menusong2 = new Media(path2);
	public static MediaPlayer player2 = new MediaPlayer(menusong2);
	
	public static String path3 = Menu.class.getResource("/music/tokyoghoul.mp3").toString();
	public static Media menusong3 = new Media(path3);
	public static MediaPlayer player3 = new MediaPlayer(menusong3);
	
	public static String path4 = Menu.class.getResource("/music/aot.mp3").toString();
	public static Media menusong4 = new Media(path4);
	public static MediaPlayer player4 = new MediaPlayer(menusong4);
	//the class constructor
	public GameStage(Stage stage, Scene menuScene,  int level) {
		this.root = new Group();
		this.scene = new Scene(root, 1300, 768, Color.BLACK);	
		this.menuScene = menuScene;
		this.canvas = new Canvas(1300,768);	
		this.gc = canvas.getGraphicsContext2D();
		if(level==1) {
			this.label=new Label("Stage 1-1");
		}else if(level==2) {
			this.label=new Label("Stage 2-1");
		}else if(level==3) {
			this.label=new Label("Stage 3-1");
		}else if(level==4) {
			this.label=new Label("Stage 4-1");
		}else if(level==5) {
			this.label=new Label("Stage 5-1");
		}
		this.resetlabel=new Label("Press spacebar to reset position");
		
		
		//instantiate an animation timer
		this.gametimer = new GameTimer(this.gc,this.scene, this.menuScene, stage, level);
		this.level=level;

	}

	//method to add the stage elements
	public void setStage(Stage stage) {
		this.stage = stage;
		health.setTranslateX(25);
		health.setTranslateY(30);
		score.setTranslateX(900);
		score.setTranslateY(30);
		label2.setTranslateX(275);
		label2.setTranslateY(175);
		FadeTransition ft= new FadeTransition(Duration.millis(4000), root); //fade transition animation
		ft.setToValue(1.0);
		ft.setFromValue(0.1);
		ft.play();
		
		label.setTextFill(Color.DARKRED); // set the label to dark red
		label.setStyle("-fx-font-weight: bold"); //set the label to bold
		label.setLayoutX(475); //set the x and y of the label
		label.setLayoutY(550);
		label.setFont(new Font("Times New Roman",90)); //set the font
		
		resetlabel.setTextFill(Color.DARKRED); // set the label to dark red
		resetlabel.setStyle("-fx-font-weight: bold"); //set the label to bold
		resetlabel.setTranslateX(800);
		resetlabel.setTranslateY(700);
		resetlabel.setFont(new Font("Times New Roman",30)); //set the font
		
		FadeTransition ft2= new FadeTransition(Duration.millis(3000), label); //fade transition animation for the stage name
		ft2.setToValue(0.0);
		ft2.setFromValue(1.0);
		ft2.setCycleCount(3);		
		ft2.setAutoReverse(true);
		ft2.play();
		
		FadeTransition ft3= new FadeTransition(Duration.millis(3000), label2); //fade transition animation for the rescure the princess
		ft3.setToValue(0.0);
		ft3.setFromValue(1.0);
		ft3.setCycleCount(3);		
		ft3.setAutoReverse(true);
		ft3.play();
		
		
		
		FadeTransition ft4= new FadeTransition(Duration.millis(5000), resetlabel); //fade transition animation
		ft4.setToValue(1.0);
		ft4.setFromValue(0.1);
		ft4.setCycleCount(Timeline.INDEFINITE);		
		ft4.setAutoReverse(true);
		ft4.play();

		if(this.level==1) { //if its the first stage
			this.root.getChildren().addAll(back3,canvas,label,health, label2, score, resetlabel);
		}
		
		if(this.level==2) { //for the second stage
			this.root.getChildren().addAll(back2,canvas,label,health, score, resetlabel);
		}
		
		if(this.level==3) { //for the third stage
			backg.setTranslateX(275); //set the position of background
			backg.setTranslateY(100);
			
			//set stage elements here
			this.root.getChildren().addAll(backg, canvas, label, health, score , resetlabel);
		}
		if(this.level==4) { //fourth stage
			//set stage elements here
			this.root.getChildren().addAll(back4, canvas, label, health, score , resetlabel);
		}
		if(this.level==5) { //last stage
			//set stage elements here
			this.root.getChildren().addAll(back5, canvas, label, health, score , resetlabel);
		}
		
		
		this.stage.setTitle("The Castle");
		this.stage.setScene(this.scene);
		
		//invoke the start method of the animation timer
		this.gametimer.start();
		this.stage.show();
	}
	
	
	
}