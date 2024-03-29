package Gui;
//import com.sun.prism.paint.Color;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.stage.*;
//first page after login
public class Home extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Gui/resources/homePage.fxml"));
			Scene scene = new Scene(root);
			
			Image icon = new Image("logo5.jpg");
			stage.getIcons().add(icon);
			stage.setTitle("Smart Study Scheduler");
			
			stage.setScene(scene);
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

