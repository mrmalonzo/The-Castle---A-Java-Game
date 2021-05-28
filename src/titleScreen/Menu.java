package titleScreen;

import mainGame.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import mainGame.GameStage;
import javafx.animation.Timeline;

/*TODO: 
 * 	
 * 	-Dapat may scene before yung menu with pic tapos transition sa menu after ng keypress
 * 	-Ayusin layout ng buttons
 * 	-Lagyan ng mga pics yung menu and pagandahin yung buttons
 * 	*if kaya may transition yung mismong button pag dinadaan ng mouse
 * 
 */


public class Menu {

	private Scene scene;
	private Group roots;
	private Stage stage;
	private Canvas canvas;
	private GraphicsContext gc; 
	public MediaPlayer player;
	
	public final static Image bg =  new Image("castlemenuimages/japanese castle.jpg",1300,768,false,false);
	
	public final static Image title= new Image("castlemenuimages/thecastlemainlogo.png",500,200,false,false);
	
	public final static ImageView title2= new ImageView(new Image("castlemenuimages/thecastlemainlogo.png",500,200,false,false));
	
	public final static ImageView start_image= new ImageView(new Image("castlemenuimages/start.png", 150, 50, false, false)); //kaiangan image view para maview mo yung picture, para siyang draw image kasi ayaw ng set graphics ng diretsong image
	
	public final static ImageView INSTRUCTIONS_IMAGE = new ImageView(new Image("castlemenuimages/instructions_button.png", 150, 50, false, false)); //kaiangan image view para maview mo yung picture, para siyang draw image kasi ayaw ng set graphics ng diretsong image
	
	public final static ImageView CREDITS_IMAGE = new ImageView(new Image("castlemenuimages/credits.png", 150, 50, false, false)); //kaiangan image view para maview mo yung picture, para siyang draw image kasi ayaw ng set graphics ng diretsong image
	
	public final static ImageView EXIT_IMAGE = new ImageView(new Image("castlemenuimages/exit.png", 150, 50, false, false)); //kaiangan image view para maview mo yung picture, para siyang draw image kasi ayaw ng set graphics ng diretsong image
	
	private static String path = Menu.class.getResource("/castlemenuimages/cherryblossoms23gif.gif").toString();
	
	public final static ImageView cherryb = new ImageView(new Image(path, 1500, 768, false, false));
	
	
	
	public Menu() {
		this.roots=new Group();
		this.scene = new Scene(this.roots, 1300, 768 ); //ito na yung nakikita mo physically. Eto yung sa window. Andito din yung roots
		this.canvas = new Canvas(1300,768);	//canvas ang ginagamit para pangpatong. Lalagyan pero di siya scene. Eto yung paliitin at palakihin pero di madadamy yung window
		this.gc = canvas.getGraphicsContext2D();
		String path = Menu.class.getResource("/music/thecastlemenumusic.mp3").toString();
		Media menusong = new Media(path);
		MediaPlayer player = new MediaPlayer(menusong);
		player.setAutoPlay(true);
		player.setCycleCount(MediaPlayer.INDEFINITE);
		this.player=player;
	}
	
	public void setStageComponents(Stage stage) {
		this.stage=stage;
			
		this.gc.drawImage(Menu.bg, 0, 0); //lagay mo muna background, x and y
//		this.gc.drawImage(Menu.title, 750 , 40); //lagay mo title
		Menu.title2.setTranslateX(750); //set the position of the title
		Menu.title2.setTranslateY(40);
		FadeTransition ft= new FadeTransition(Duration.millis(3000), Menu.title2); //fade transition animation
		ft.setToValue(1.0);
		ft.setFromValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);		
		ft.setAutoReverse(true);
		ft.play(); //start the animation
		// TODO Auto-generated method stub
		//add widgets here
		Button start = new Button(); //gawa ka button
		start.setId("Start"); //set mo id for later pag kinclick
		start.setTranslateX(170); //set mo x
		start.setTranslateY(620); //set mo y
		start.setPrefSize(190, 70); //set mo size
		start.setStyle("-fx-background-image: url(castlemenuimages/start.png); -fx-background-size: 200px 80px; -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-background-color: rgb(26,42,33);");
//		start.setGraphic(start_image);
		Button instructions = new Button();
		instructions.setId("Instructions");
		instructions.setTranslateX(440);
		instructions.setTranslateY(620);
		instructions.setPrefSize(190, 70);
		instructions.setStyle("-fx-background-image: url(castlemenuimages/instructions_button.png); -fx-background-size: 200px 80px; -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-background-color: rgb(26,42,33); ");
//		instructions.setGraphic(INSTRUCTIONS_IMAGE);
		Button credits = new Button();
		credits.setId("Credits");
		credits.setTranslateX(710);
		credits.setTranslateY(620);
		credits.setPrefSize(190, 70);
		credits.setStyle("-fx-background-image: url(castlemenuimages/credits.png); -fx-background-size: 200px 80px; -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-background-color: rgb(26,42,33);");
//		credits.setGraphic(CREDITS_IMAGE);
		Button exit = new Button();
		exit.setId("Exit");
		exit.setTranslateX(980);
		exit.setTranslateY(620);
		exit.setPrefSize(190, 70);
		exit.setStyle("-fx-background-image: url(castlemenuimages/exit.png); -fx-background-size: 200px 80px; -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-background-color: rgb(26,42,33);");
//		exit.setGraphic(EXIT_IMAGE);
		
		cherryb.setTranslateX(50);
		
		this.roots.getChildren().addAll(this.canvas, start, instructions, credits, exit, title2, Menu.cherryb); //ipasok mo sila lahat sa group
		
			 
		menuClicking(start); //mahalaga to para pag kinlick yung buttons
		menuClicking(instructions);
		menuClicking(credits);
		menuClicking(exit);
		
		stage.setTitle("The Castle"); //set title
		
		
		stage.setScene(this.scene);//add mo lang yung scene sa stage since yung root ay nasa scene na
		
		this.player.setOnEndOfMedia(new Runnable() {
		       public void run() { //if the song ends, loop
		         player.seek(Duration.ZERO);
		       }
		   });
		this.player.play();
		stage.show(); //show mo lahat hehe
		SplashScreen splashscreen= new SplashScreen(); //for the splashscreen at the start
		splashscreen.setStageComponents(scene, stage, this.roots);
	}
	
//	public static void music() {
//		String path= new File("".)getAbsolutePath()+"\\src"+"\\audio"+"\\thecastlemenumusic.mp3";
//	}
	
	
	private void menuClicking(Button button) {
		button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) { //kailangan tong mga to
				if(button.getId()=="Exit") { // if same dun sa binagay na id
				// TODO Auto-generated method stub
					handleButtonClick("exit"); //ginawa na method
				}
				else if(button.getId()=="Start") {
					handleButtonClick("start"); //ginawa na method
				}
				else if(button.getId()=="Instructions") {
					handleButtonClick("instructions"); // punta ka dito sa intructions na file
				}
				else if(button.getId()=="Credits") {
					handleButtonClick("credits"); //Punta ka sa credits
				}	
			}
		});
	}
			
			
	private void handleButtonClick(String btnName){ //ginawa na method
		if(btnName.equals("start")){
			System.out.println("Start the Game!");
			//set game stage here
			this.player.stop();
			GameStage gamestage = new GameStage(stage,this.scene, 1); //start the game with level 1
			gamestage.setStage(stage);
		}
		else if(btnName.equals("instructions")){
			Instructions PopInstructions = new Instructions(); //generate ng bagong object na instructions
			PopInstructions.setStageComponents(scene, stage, this.roots); //punta ka sa set stage ng instructions tapos mo mga to para makabalik ka sa menu
			System.out.println("Instructions: ");
		}
		else if(btnName.equals("credits")){
			Credits PopCredits = new Credits(); //generate ng bagong object na creduts
			PopCredits.setStageComponents(scene, stage, this.roots); //punta ka sa set stage ng credits tapos mo mga to para makabalik ka sa menu
			System.out.println("Credits");
		}
		else{
			System.out.println("End of program! Bye!");
			System.exit(0);
		}
		
	}
	
	
	
}
