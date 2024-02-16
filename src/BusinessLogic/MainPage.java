package com.example.login;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creating a label to display the text
        Label label = new Label("This is the main page");

        // Creating a StackPane layout
        StackPane root = new StackPane();
        root.getChildren().add(label);
        root.setAlignment(Pos.CENTER);

        // Creating scene
        Scene scene = new Scene(root, 600, 400);

        // Adding a title
        primaryStage.setTitle("Main Page");

        // Adding Scene
        primaryStage.setScene(scene);

        // Display Stage contents
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
