package Gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginController {

    // This is a simple in-memory store for usernames and passwords.
    // In a real application, you would use a secure database.
    private static Map<String, String> users = new HashMap<>();

    @FXML
    private Button loginButton;
    @FXML
    private Button signupButton;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label errorLabel;

    public void loginAction(ActionEvent event) throws IOException {
        checkLogin();
    }

    @FXML
    public void signupAction(ActionEvent event) {
        Login LoginPage2 = new Login();
        try {
            LoginPage2.changeScene("signup.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkLogin() throws IOException {
        Login LoginPage = new Login();

        if(checkCredentials(username.getText(), password.getText())) {
            errorLabel.setText("Success!");
            LoginPage.changeScene("home.fxml");
        } else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            errorLabel.setText("Please enter your data.");
        } else {
            errorLabel.setText("Wrong username or password!");
        }
    }

    private boolean checkCredentials(String username, String password) {
        return password.equals(users.get(username));
    }

    public static void addUser(String username, String password) {
        users.put(username, password);
    }
}
