package Gui;

import java.awt.Button;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import BusinessLogic.InvalidEventTimeException;
import BusinessLogic.Reminders;
import BusinessLogic.negativeReminderOffsetException;
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
    private void handleSaveReminder(ActionEvent event) {
        try {
            String title = titleTextField.getText();
            LocalDate date = LocalDate.parse(datePicker.getText(), DateTimeFormatter.ISO_DATE); // This assumes the date is in (YYYY-MM-DD)
            LocalTime time = LocalTime.parse(timeTextField.getText(), DateTimeFormatter.ofPattern("HH:mm")); // This assumes the time is in HH:mm format
            int offsetMinutes = Integer.parseInt(offsetTextField.getText().replaceAll("[^\\d]", "")); 

            Duration offset = Duration.ofMinutes(offsetMinutes);
            int eventTime = time.getHour();

            // creating a reminder with the localDate
            Reminders newReminder = new Reminders(title, eventTime, offset, date);
            
            // adding a new reminder to a stub database
            GuiHelper.addReminder(newReminder);
  
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
