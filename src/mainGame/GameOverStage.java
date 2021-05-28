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

public class GameOverStage {
	
	private Scene scene;
	private Scene menuScene;
	private Stage stage;
	private Group root;
	private Canvas canvas;
	private GraphicsContext gc;
	private int finalscore;
	public static final ImageView health =new ImageView( new Image("castlestageimages/health.png",200,75,false,false));
	public final static ImageView bg =  new ImageView(new Image("castlemenuimages/LoseBackground.png",1300,768,false,false));
	public final static ImageView BACK_TO_MAIN_MENU =  new ImageView(new Image("castlemenuimages/menubutton.png",200,75,false,false));
	public final static ImageView slash =  new ImageView(new Image("castlemenuimages/slash.png",1150,708,false,false));
	public final static ImageView gameover = new ImageView(new Image("castlemenuimages/gameover.png",400,375,false,false));
	public static final ImageView scoreimage = new ImageView( new Image("castlestageimages/score.png",400,75,false,false));
	//the class constructor

	public GameOverStage(Stage stage, Scene menuScene) {
		this.stage = stage;
		this.root = new Group();
		this.scene = new Scene(root, 1300, 768);	
		this.menuScene = menuScene;					//galing pang GameTimer yung menuScene (menuScene ay yung scene sa Main menu)
		this.canvas = new Canvas(1300,768);	
		this.gc = canvas.getGraphicsContext2D();
		Hero.health = 3;
		this.finalscore = GameTimer.SCORE;
		GameTimer.SCORE = 0;
	}

	//method to add the stage elements
	public void setStage(Stage stage) {
		
		
		scoreimage.setTranslateX(900);
		scoreimage.setTranslateY(30);
		
		String score = Integer.toString(finalscore);
		Label label2= new Label(score);//add a label
		label2.setTextFill(Color.BLACK); // set the label to dark red
		label2.setStyle("-fx-font-weight: bold"); //set the label to bold
		label2.setLayoutX(1050); //set the x and y of the label
		label2.setLayoutY(10);
		label2.setFont(new Font("Times New Roman",100)); //set the font
		
		gameover.setTranslateX(450);
		gameover.setTranslateY(230);
//		FadeTransition ft= new FadeTransition(Duration.millis(3000), gameover); //fade transition animation
//		ft.setDelay(Duration.millis(3000));
//		ft.setToValue(1.0);
//		ft.setFromValue(0);
//		ft.setCycleCount(Timeline.INDEFINITE);		
//		ft.setAutoReverse(true);
//		ft.play();
		
		
		slash.setTranslateX(100);
		FadeTransition ftslash= new FadeTransition(Duration.millis(2000), slash); //fade transition animation
		ftslash.setToValue(1.0);
		ftslash.setFromValue(0);
		ftslash.setCycleCount(2);		
		ftslash.setAutoReverse(true);
		ftslash.play();
		
		
		Button back = new Button("");
		back.setId("Back");
		back.setTranslateX(1000);
		back.setTranslateY(600);
		back.setPrefSize(190, 70);
		back.setGraphic(BACK_TO_MAIN_MENU);
		back.setStyle("-fx-background-image: url(castlemenuimages/back.png); -fx-background-size: 200px 80px; -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-background-color: rgb(112,120,112);");
		
		this.root.getChildren().addAll(bg,canvas, health, scoreimage, label2, gameover ,slash,  back);
		
		menuClicking(back, this.menuScene, stage);
		
		this.stage.setTitle("The Castle");
		this.stage.setScene(this.scene);
		
		
		this.stage.show();
	}
		public Scene getScene() {
			return this.scene;
	}
		private void menuClicking(final Button button, final Scene menuScene, final Stage oldstage) {		//pag clinick yung back call handleButtonClick
			button.setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent arg0) {
					if(button.getId()=="Back") {
					// TODO Auto-generated method stub
						handleButtonClick("back", menuScene, oldstage); 
					}
					
				}
			});
		}
		
		private void handleButtonClick(String btnName, Scene menuScene, Stage oldStage) {	//palitan ung scene ng scene ng Main Menu
			if(btnName.equals("back")){
				System.out.println("Main Menu");
				oldStage.setScene(menuScene); // balik sa old na scene
				oldStage.show();
					
			}
		}
	
	
	
}
