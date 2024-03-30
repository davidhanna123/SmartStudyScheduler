package Gui;

import java.awt.Button;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import BusinessLogic.InvalidEventTimeException;
import BusinessLogic.Reminders;
import BusinessLogic.negativeReminderOffsetException;
import Database.DBops;
import Gui.resources.GuiHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ReminderController {
	@FXML
    private TextField titleTextField;

    @FXML
    private TextField datePicker; 

    @FXML
    private TextField timeTextField;

    @FXML
    private TextField offsetTextField;

    @FXML
    private Button saveButton;
    
    
    @FXML
    private void handleSaveReminder(ActionEvent event) throws SQLException {
        try {
        	String message = titleTextField.getText();
            String title = titleTextField.getText();
            LocalDate date = LocalDate.parse(datePicker.getText(), DateTimeFormatter.ISO_DATE); // This assumes the date is in (YYYY-MM-DD)
            LocalTime time = LocalTime.parse(timeTextField.getText(), DateTimeFormatter.ofPattern("HH:mm")); // This assumes the time is in HH:mm format
            int offsetMinutes = Integer.parseInt(offsetTextField.getText().replaceAll("[^\\d]", "")); 

            Duration offset = Duration.ofMinutes(offsetMinutes);
            int eventTime = time.getHour();
            //int reminderId = DBops.addRemindersDB(title, date, eventTime, offsetMinutes, message);
            // creating a reminder with the localDate
            Reminders newReminder = new Reminders(0, message, title, eventTime, offset, date, "EventTitle");
            int reminderId = DBops.addRemindersDB(newReminder);
            
            if (reminderId != -1) {
            	newReminder.setId(reminderId);
            	// adding a new reminder to a stub database
                GuiHelper.addReminder(newReminder);
            }
            
  
            titleTextField.clear();
            datePicker.clear();
            timeTextField.clear();
            offsetTextField.clear();

           
        } catch (InvalidEventTimeException | negativeReminderOffsetException e) {
            //
        } catch (NumberFormatException e) {
        	//
        }
    }
}
