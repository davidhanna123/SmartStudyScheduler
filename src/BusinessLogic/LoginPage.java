package com.example.login;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPage extends Application {
    @Override
    public void start(Stage stage) {

        // Creating a "Username" and "Password" Text Labels
        Text Label1 = new Text("Username");
        Text Label2 = new Text("Password");

        // Creating a text field for Username
        TextField Field1 = new TextField();

        // Creating a password field for Password
        PasswordField Field2 = new PasswordField();

        // Creating a login, clear and Signup buttons
        Button Button1 = new Button("Login");
        Button Button2 = new Button("Clear");
        Button Button3 = new Button("Signup");

        // Creating a Grid pane
        GridPane gridPane = new GridPane();

        // Setting the size of the pane
        gridPane.setMinSize(400, 200);

        // Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        // Setting vertical and horizontal gaps b/n columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        // Setting the grid alignment
        gridPane.setAlignment(Pos.CENTER);

        // Align All the nodes in the grid
        gridPane.add(Label1, 0, 0);
        gridPane.add(Field1, 1, 0);
        gridPane.add(Label2, 0, 1);
        gridPane.add(Field2, 1, 1);
        gridPane.add(Button1, 0, 2);
        gridPane.add(Button2, 1, 2);
        gridPane.add(Button3, 2, 2);

        // Styling the nodes
       // Button1.setStyle("-fx-background-color: blue; -fx-text-fill:white;");
       // Button2.setStyle("-fx-background-color: blue; -fx-text-fill:white;");
       // Button3.setStyle("-fx-background-color: blue; -fx-text-fill:white;");

        Label1.setStyle("-fx-font: normal bold 20px 'serif");
        Label2.setStyle("-fx-font: normal bold 20px 'serif");

        // Creating scene
        Scene scene = new Scene(gridPane);

        // Adding a title
        stage.setTitle("Smart Study Scheduler");

        // Adding Scene
        stage.setScene(scene);

        // Handling login action
        Button1.setOnAction(e -> {
            String username = Field1.getText();
            String password = Field2.getText();
            if (username.equals("user") && password.equals("pass")) {
                // If login is successful, switch to MainPage
                MainPage mainPage = new MainPage();
                try {
                    mainPage.start(new Stage());
                    stage.close(); // Close the login page
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                // Display an error message or handle invalid login
                System.out.println("Invalid username or password");
            }
        });

        // Display Stage contents
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
