package Gui;


import java.util.List;

import BusinessLogic.Reminders;
import Database.StubDatabase;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

public class HomeController {

    @FXML
    private Button addEventButton;
    @FXML
    private Button removeEventButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button signOutButton;
    @FXML
    private MenuItem action1;
    @FXML
    private MenuItem action2;
    @FXML
    private VBox remindersVBox;

    // Implement methods for handling button actions
    @FXML
    private void addEventAction() {
        // Add logic for adding an event
    }
    
    @FXML
    private void removeEventAction() {
        // Add logic for removing an event
    }

    @FXML
    private void saveAction() {
        // Add logic for saving events
    }

    @FXML
    private void signOutAction() {
        // Add logic for signing out
    }
    
    public void nextMonth(ActionEvent e) {
    	//view next month
    }
    
    @FXML
    private void handleAction1(ActionEvent event) {
    	// adding event goes here  
    }
    
    @FXML
    private void handleAction2() {
    	showReminders();
    }
    
    
    // method to show and refresh the reminders in the VBox
    private void showReminders() {
    	remindersVBox.getChildren().clear(); // clearing previous reminders
    	List<Reminders> reminderList = StubDatabase.getReminders(); // getting reminders from stub database
    	
    	for (Reminders reminder : reminderList) {
    		Label reminderLabel = new Label(reminder.toString());
    		remindersVBox.getChildren().add(reminderLabel); // adding to the VBox
    	}
    }
    
    
}
