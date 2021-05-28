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
import javafx.scene.Group;

public class Instructions {

	private Scene scene;
	private Group roots;
	private Canvas canvas;
	private GraphicsContext gc; 
	private Stage oldstage;
	
	public final static Image title= new Image("castlemenuimages/instructions.png",1000,700,false,false);
	
	public final static ImageView BACK_IMAGE = new ImageView(new Image("castlemenuimages/back.png", 150, 50, false, false)); //kaiangan image view para maview mo yung picture, para siyang draw image kasi ayaw ng set graphics ng diretsong image

	private static String path = Menu.class.getResource("/castlemenuimages/ninja.gif").toString();
	
	public final static ImageView Ninja = new ImageView(new Image(path, 125, 150, false, false));
	
	public Instructions (){
		this.roots=new Group();
		this.scene = new Scene(this.roots, 1300, 768); //create the scene
		this.canvas = new Canvas(1300,768);	//canvas ulit ginagamit
		this.gc = canvas.getGraphicsContext2D();
		this.oldstage=new Stage();
	}
	
	public void setStageComponents(Scene oldscene, Stage stage, Group group) {
		this.gc.drawImage(Menu.bg, 0, 0);
		this.gc.drawImage(Instructions.title, 150 , 30);
		
		this.oldstage=stage; //put a mark in the old stage
		
		Button back = new Button("");
		back.setId("Back");
		back.setTranslateX(50);
		back.setTranslateY(150);
		back.setPrefSize(190, 70);
//		back.setGraphic(BACK_IMAGE);
		back.setStyle("-fx-background-image: url(castlemenuimages/back.png); -fx-background-size: 200px 80px; -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-background-color: rgb(112,120,112);");
		
		Instructions.Ninja.setTranslateX(775);
		Instructions.Ninja.setTranslateY(500);
		
		this.roots.getChildren().addAll(canvas, back, Instructions.Ninja);
		
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
