package titleScreen;

import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.animation.Timeline;

public class SplashScreen {

	private Scene scene;
	private Group roots;
	private Canvas canvas;
	private GraphicsContext gc; 
	private Stage oldstage;
	private Label label;
	
	public static Scene truescene;
	
	public final static Image bg= new Image("castlemenuimages/japanese castle.jpg",1300,768,false,false);

	
	public SplashScreen (){
		this.roots=new Group();
		this.scene = new Scene(this.roots, 1300, 768); //create the scene
		this.canvas = new Canvas(1300,768);	//canvas ulit ginagamit
		this.gc = canvas.getGraphicsContext2D();
		this.oldstage=new Stage();
		this.label=new Label("Press Space to continue...");
		handleKeyPressEvent();
	}
	
	public void setStageComponents(Scene oldscene, Stage stage, Group group) {
		
		this.gc.drawImage(SplashScreen.bg, 0, 0);
		
		this.oldstage=stage; //put a mark in the old stage
		
//		this.gc.setFill(Color.RED);										//set font color of text
		//gc.fillRect(0,0,100,100);
//		Font theFont = Font.font("Times New Roman",FontWeight.BOLD,30);//set font type, style and size
//		this.gc.setFont(theFont);	
		FadeTransition ft= new FadeTransition(Duration.millis(3000), roots); //fade transition animation
		ft.setToValue(1.0);
		ft.setFromValue(0.1);
//		ft.setCycleCount(Timeline.INDEFINITE);		
//		ft.setAutoReverse(true);
		ft.play();
		
//		this.gc.fillText("Press Space to continue...", 490, 700);	
		
		label.setTextFill(Color.DARKRED); // set the label to dark red
		label.setStyle("-fx-font-weight: bold"); //set the label to bold
		label.setLayoutX(440); //set the x and y of the label
		label.setLayoutY(550);
		label.setFont(new Font("Times New Roman",40)); //set the font
		FadeTransition ft2= new FadeTransition(Duration.millis(2000), label); //fade transition animation
		ft2.setToValue(1.0);
		ft2.setFromValue(0.3);
		ft2.setCycleCount(Timeline.INDEFINITE);		
		ft2.setAutoReverse(true);
		ft2.play();
		
		this.roots.getChildren().addAll(canvas, this.label);
		
//		menuClicking(back, oldscene, oldstage);
		SplashScreen.truescene=oldscene;
		
		stage.setScene(this.scene); //set mo yung scene
		stage.show();
	}
	

	private void handleKeyPressEvent() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
            	KeyCode code = e.getCode();
                ExitSplash(code);
			}
			
		});
		
    }
	
	private void ExitSplash(KeyCode ke) {
		if(ke==KeyCode.SPACE) {   
			oldstage.setScene(SplashScreen.truescene); // balik sa old na scene
			
			oldstage.show();
		}
	}
	
		
}
