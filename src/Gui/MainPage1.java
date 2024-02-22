package Gui;
import com.sun.prism.paint.Color;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.stage.*;

public class MainPage1 extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception{
		Group root = new Group();
		Scene scene = new Scene(root);
		
		Image icon = new Image("logo5.jpg");
		stage.getIcons().add(icon);
		stage.setTitle("Smart Study Scheduler");
		
		stage.setScene(scene);
		stage.show();
	}

}
