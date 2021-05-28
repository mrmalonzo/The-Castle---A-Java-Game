package mainGame;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
//import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import titleScreen.Menu;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameWinStage {
	
	private Scene scene;
	private Scene menuScene;
	private Stage stage;
	private Group root;
	private Canvas canvas;
	private GraphicsContext gc;
	private GameTimerWinStage gametimer;
	private int finalscore;
	public static final ImageView health =new ImageView( new Image("castlestageimages/health.png",200,75,false,false));
	public final static ImageView confetti = new ImageView(new Image("castlemenuimages/confettigif.gif", 1000, 768, false, false));
	public final static ImageView confetti2 = new ImageView(new Image("castlemenuimages/confettigif.gif", 1000, 768, false, false));
	public final static ImageView bg =  new ImageView(new Image("castlemenuimages/WinBackground.png",1300,768,false,false));
	public final static ImageView BACK_TO_MAIN_MENU =  new ImageView(new Image("castlemenuimages/menubutton.png",200,75,false,false));
	public static final ImageView scoreimage = new ImageView( new Image("castlestageimages/score.png",400,75,false,false));
	//the class constructor

	public GameWinStage(Stage stage, Scene menuScene) {		//Yung menuScene ung nagpinagpapasa na scene ng menu, kailangan ito para makabalik sa menu
		this.stage = stage;									//Stage na pinagpapasa pasa				
		this.root = new Group();
		this.scene = new Scene(root, 1300, 768);	
		this.menuScene = menuScene;							//holder lng ng menuScene
		this.canvas = new Canvas(1300,768);	
		this.gc = canvas.getGraphicsContext2D();
		//instantiate an animation timer
		this.gametimer = new GameTimerWinStage(this.gc,this.scene, this.stage);
		Hero.health = 3;
		this.finalscore = GameTimer.SCORE;
		GameTimer.SCORE = 0;
	}

	//method to add the stage elements
	public void setStage(Stage stage) {					//YOU WIN
		Label label= new Label("You Win!");//add a label
		label.setTextFill(Color.YELLOW); // set the label to dark red
		label.setStyle("-fx-font-weight: bold"); //set the label to bold
		label.setLayoutX(450); //set the x and y of the label
		label.setLayoutY(150);
		label.setFont(new Font("Times New Roman",100)); //set the font
		
		scoreimage.setTranslateX(900);
		scoreimage.setTranslateY(30);
		
		String score = Integer.toString(finalscore);
		this.gc.setStroke(Color.WHITE); //show the score
		Label label2= new Label(score);//add a label
		label2.setTextFill(Color.BLACK); // set the label to dark red
		label2.setStyle("-fx-font-weight: bold"); //set the label to bold
		label2.setLayoutX(1050); //set the x and y of the label
		label2.setLayoutY(10);
		label2.setFont(new Font("Times New Roman",100)); //set the font
		
		FadeTransition ft= new FadeTransition(Duration.millis(3000), label); //fade transition animation ng YOU WIN
		ft.setToValue(1.0);
		ft.setFromValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);		
		ft.setAutoReverse(true);
		ft.play();
		
		
		Button back = new Button("");
		back.setId("Back");
		back.setTranslateX(1000);
		back.setTranslateY(550);
		back.setPrefSize(190, 70);
		back.setGraphic(BACK_TO_MAIN_MENU);
		back.setStyle("-fx-background-image: url(castlemenuimages/back.png); -fx-background-size: 200px 80px; -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-background-color: rgb(112,120,112);");
		
		confetti.setTranslateX(0);
		confetti2.setTranslateX(450);
		this.root.getChildren().addAll(bg,canvas, health,label, scoreimage, label2,confetti,confetti2, back);
		
		menuClicking(back, this.menuScene, stage);		//self-made method 
		
		this.stage.setTitle("The Castle");
		this.stage.setScene(this.scene);
		
		
		//invoke the start method of the animation timer
		//this.gametimer.start();

		this.stage.show();
	}
		public Scene getScene() {
			return this.scene;
	}
		private void menuClicking(final Button button, final Scene menuScene, final Stage oldstage) {
			button.setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent arg0) {
					if(button.getId()=="Back") {
					// TODO Auto-generated method stub
						handleButtonClick("back", menuScene, oldstage); 
					}
					
				}
			});
		}
		
		private void handleButtonClick(String btnName, Scene menuScene, Stage oldStage) {
			if(btnName.equals("back")){
				System.out.println("Main Menu");
				this.gametimer.stop();
				oldStage.setScene(menuScene); // balik sa old na scene
				oldStage.show();
					
			}
		}
	
	
	
}