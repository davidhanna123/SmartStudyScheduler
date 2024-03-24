package Gui.resources;

import java.time.LocalDate;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;

public class ScheduleOutputComponents {
	private Spinner<Integer> startTime;
	private Spinner<Integer> endTime;
	private DatePicker date;
	Label errorText;
	Stage newWindow;
	
	public ScheduleOutputComponents() {
		// TODO Auto-generated constructor stub
	}

	/**Constructs an object that is a package of output gui components 
	 * @param startTime
	 * @param endTime
	 * @param date
	 * @param errorText
	 * @param newWindow
	 */
	public ScheduleOutputComponents(Spinner<Integer> startTime, Spinner<Integer> endTime, DatePicker date,
			Label errorText, Stage newWindow) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
		this.errorText = errorText;
		this.newWindow = newWindow;
	}

	/**
	 * Sets the starting time spinner value
	 * @param value
	 */
	public void setStartingTimeSpinner(int value) {
		startTime.getValueFactory().setValue(value);
	}
	/**
	 * Sets the ending time spinner value
	 * @param value
	 */
	public void setEndingTimeSpinner(int value) {
		endTime.getValueFactory().setValue(value);
	}
	/**
	 * Closes the window
	 */
	public void closeWindow() {
		newWindow.close();
	}
	/**
	 * Sets the error text of the scheduling window
	 * @param errorTextValue
	 */
	public void setErrorText(String errorTextValue) {
		errorText.setText(errorTextValue);
	}
	/**
	 * Sets the Event date of the final decided event
	 * @param dateInput
	 */
	public void setEventDate(LocalDate dateInput) {
		date.setValue(dateInput);
	}
	

	
}
