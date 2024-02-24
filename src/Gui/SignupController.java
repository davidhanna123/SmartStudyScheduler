package Gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.IOException;

public class SignupController {

    @FXML
    private Button signupButton;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void signupAction(ActionEvent event) throws IOException {
        // Save the new user's credentials
        LoginController.addUser(username.getText(), password.getText());

        // After signing up, redirect the user back to the login page
        Login loginPage = new Login();
        loginPage.changeScene("/Gui/resources/login.fxml");
    }
}
