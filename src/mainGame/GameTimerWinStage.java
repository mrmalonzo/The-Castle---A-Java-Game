package mainGame;

import java.util.concurrent.TimeUnit;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GameTimerWinStage extends AnimationTimer{

	private GraphicsContext gc;
	private Hero myHero;
	private long startSpawn;
	public GameTimerWinStage(GraphicsContext gc, Scene gameScene, Stage stage) {
			this.gc = gc;
			this.myHero = new Hero(3,225,500);
			this.startSpawn = System.nanoTime();
	}
	@Override
	public void handle(long currentNanoTime) {			//every 4 seconds, pagagalawin mo ung pictures.
		// TODO Auto-generated method stub
		long currentSec = TimeUnit.NANOSECONDS.toSeconds(currentNanoTime);
		long startSec = TimeUnit.NANOSECONDS.toSeconds(this.startSpawn);
		if((currentSec - startSec)%4 == 0){
			this.gc.clearRect(0, 0, 1300,768);
			this.myHero.render(this.gc);
			this.myHero.setDX(1);
			this.myHero.setDY(1);
			this.myHero.move();
		}
	}
	
}
