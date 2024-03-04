package Gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;


public class Login extends Application {

    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("/Gui/resources/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Image icon = new Image("logo5.jpg");
		stage.getIcons().add(icon);
		stage.setTitle("Smart Study Scheduler");
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml) throws IOException {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Gui/resources/" + fxml));
            Parent pane = loader.load();
            stg.getScene().setRoot(pane);
            SignupController controller = loader.getController();
            LoginController controller1 = loader.getController();

    }


    public static void main(String[] args) {
        launch();
    }
}