package titleScreen;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainTitle extends Application {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}  

	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Menu theGameStage = new Menu();
		theGameStage.setStageComponents(stage);
	}

}

// TODO:

//	Game Over Stage (Play Again and Main Menu)
//	Animation when dying (GIF then fade when respawn??)
//	CREDITS
