package titleScreen;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.MoveTo;
import javafx.animation.TranslateTransition;
import javafx.animation.Timeline;

public class Credits {

	private Scene scene;
	private Group roots;
	private Canvas canvas;
	private GraphicsContext gc; 
	private Stage oldstage;
	
//	public final static Image title= new Image("castlemenuimages/creditbg.png",1000,700,false,false);
	
	public final static ImageView BACK_IMAGE = new ImageView(new Image("castlemenuimages/back.png", 150, 50, false, false)); //kaiangan image view para maview mo yung picture, para siyang draw image kasi ayaw ng set graphics ng diretsong image

	public final static ImageView Credits1 = new ImageView(new Image("castlemenuimages/credits1.png", 1000, 700, false, false));
	public final static ImageView Credits2 = new ImageView(new Image("castlemenuimages/credits2.png", 1000, 700, false, false));
	public final static ImageView Credits3 = new ImageView(new Image("castlemenuimages/credits3.png", 1000, 700, false, false));
	private static String path = Menu.class.getResource("/castlemenuimages/samurai.gif").toString();
	
	public final static ImageView Samurai = new ImageView(new Image(path, 125, 150, false, false));
	
	public Credits (){
		this.roots=new Group();
		this.scene = new Scene(this.roots, 1300, 768, Color.BLACK); //create the scene
		this.canvas = new Canvas(1300,768);	//canvas ulit ginagamit
		this.gc = canvas.getGraphicsContext2D();
		this.oldstage=new Stage();
	}
	
	public void setStageComponents(Scene oldscene, Stage stage, Group group) {
		
		this.oldstage=stage; //put a mark in the old stage
		
		Button back = new Button("");
		back.setId("Back");
		back.setTranslateX(50);
		back.setTranslateY(75);
		back.setPrefSize(190, 70);
		back.setStyle("-fx-background-image: url(castlemenuimages/back.png); -fx-background-size: 200px 80px; -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-background-color: rgb(0,0,0);");
		
		Credits1.setTranslateX(175);
		Credits1.setTranslateY(780);
		Credits2.setTranslateX(175);
		Credits2.setTranslateY(1300);
		
		TranslateTransition TransT = new TranslateTransition();
		TransT.setDuration(Duration.millis(12000));
		TransT.setByY(-1600);
		TransT.setNode(Credits1);
		
		TranslateTransition TransT2 = new TranslateTransition();
		TransT2.setDuration(Duration.millis(18000));
		TransT2.setByY(-2100);
		TransT2.setNode(Credits2);
		
		
		Credits.Samurai.setTranslateX(1100);
		Credits.Samurai.setTranslateY(550);
		
		TransT.play();
		TransT2.play();
	
	
		
		
		this.roots.getChildren().addAll(canvas, back, Credits1, Credits2, Credits.Samurai);
		
		menuClicking(back, oldscene, oldstage);
		
		stage.setScene(this.scene); //set mo yung scene
		stage.show();
	}
	
	private void menuClicking(Button button, Scene oldscene, Stage oldstage) {
		button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				if(button.getId()=="Back") {
				// TODO Auto-generated method stub
					handleButtonClick("back", oldscene, oldstage); 
				}
				
			}
		});
	}
	
	private void handleButtonClick(String btnName, Scene oldscene, Stage oldStage) {
		if(btnName.equals("back")){
			System.out.println("Main Menu");
			oldStage.setScene(oldscene); // balik sa old na scene
			oldStage.show();
			
		}
	}
		
}
