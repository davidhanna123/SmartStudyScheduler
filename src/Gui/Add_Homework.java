package Gui;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import BusinessLogic.Homework;

import java.sql.SQLException;
import java.time.LocalDate;

import BusinessLogic.Assignment;
import Database.DBops;

//Add_Homework class for SmartStudyScheduler
//Jonah Ottini 
//218945030 

/**
 * 
 * Creates a Homework or Assignment object using user input, and adds it to the Calendar
 */
public class Add_Homework {
	
	 //GUI Variables
	static Stage window; 
	static Scene scene; 
	static Label errorMsg;
	static GridPane grid;

	static TextField taskInput = new TextField();
	static TextField ccInput = new TextField();
	static TextField timeInput = new TextField(); 
	
	static Label datePickLabel; 
	static DatePicker eventDate = new DatePicker();
	static Boolean assignCheck = false;
	
	static Button enter = new Button();
	static RadioButton yes = new RadioButton();
	static RadioButton no = new RadioButton(); 
	static final ToggleGroup group = new ToggleGroup();
	
	
	//Data Variables
	static String task;
	static String course; 
	static int duration; 
	static int year;
	static int month;
	static int date; 
	static Homework hw;
	
	/**
	 * Creates GUI for class
	 */
	public static void start() throws Exception {
		window = new Stage();
		window.setTitle("Add Homework");
		
		grid = new GridPane(); 
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(8);
		grid.setHgap(10);
		
		grid.getColumnConstraints().add(0, new ColumnConstraints(100));
		grid.getColumnConstraints().add(1, new ColumnConstraints(35));
		grid.getColumnConstraints().add(2, new ColumnConstraints(1));
		
		
		//Task label and input
		Label taskLabel = new Label("Name the task: ");
		GridPane.setConstraints(taskLabel, 0, 0);
		
		taskInput.setPromptText("ex. Math Homework");
		GridPane.setConstraints(taskInput, 1, 0, 3, 1);
		
		//Course Code label and input
		Label ccLabel = new Label("Course Code : ");
		GridPane.setConstraints(ccLabel, 0, 1);
		
		ccInput.setPromptText("ex. EECS2311");
		GridPane.setConstraints(ccInput, 1, 1, 3, 1);
		
		//Completion Time label and input
		Label timeLabel = new Label("Time to complete: ");
		GridPane.setConstraints(timeLabel, 0, 2);
		
		timeInput.setPromptText("hrs");
		GridPane.setConstraints(timeInput, 1, 2); 
		
		//Ask if homework has due date 
		Label askLabel = new Label("Due date?"); 
		GridPane.setConstraints(askLabel, 0, 3);
		
		yes.setToggleGroup(group);
		GridPane.setConstraints(yes, 1, 4);
		Label yesLabel = new Label("Yes"); 
		GridPane.setConstraints(yesLabel, 1, 3);
		
		no.setToggleGroup(group);
		GridPane.setConstraints(no, 3, 4);
		Label noLabel = new Label("No"); 
		GridPane.setConstraints(noLabel, 3, 3);

		yes.setOnAction(e ->{
			yesCheck();
		});
		no.setOnAction(e -> { 
			noCheck();
		});
		
		//Enter Button
		enter = new Button("Enter"); 
		enter.setOnAction(e -> {
			try {
				handleEnter();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		GridPane.setConstraints(enter, 6, 9);
		
		//Error Message
		errorMsg = new Label();
		GridPane.setConstraints(errorMsg, 0, 9, 5, 1);
		
		grid.getChildren().addAll(taskLabel, taskInput, ccLabel, ccInput, timeLabel, timeInput, askLabel, yes, yesLabel, no, noLabel, enter, errorMsg);
		
		scene = new Scene(grid,500, 500); 
		window.setScene(scene); 
		window.show();
	}
	
	/**
	 * runs when yes selection is chosen 
	 */
	public static void yesCheck() { 
		assignCheck = true;
		
		datePickLabel = new Label("Choose due date");
		GridPane.setConstraints(datePickLabel, 0, 6, 2, 1);
		GridPane.setConstraints(eventDate, 0, 7, 3, 1);
		eventDate.setPromptText("ex. 01/01/2024");
		
		grid.getChildren().addAll(datePickLabel, eventDate);
	}
	
	/**
	 * runs when yes selection is chosen 
	 */
	public static void noCheck() { 
		assignCheck = false;
		grid.getChildren().removeAll(datePickLabel, eventDate);
	}
	
	/**
	 * runs when enter button is pressed
	 * @throws SQLException 
	 */
	public static void handleEnter() throws SQLException { 
		if(checkEmpty(taskInput) == false && checkEmpty(ccInput) == false && checkEmpty(timeInput) == false) {
			if (assignCheck.booleanValue() == true) {
				if(checkEmpty(eventDate.getEditor()) == false)  {
					
					//Creates Assignment if all data is entered correctly
					if (isInt(timeInput) == true && isLocalDate(eventDate) == true) { 
						System.out.println(createHw());
					}
				}
			}
			//Creates Homework if all data is entered correctly
			else if (isInt(timeInput) == true) {
				System.out.println(createHw());
			}	
		}	
	}
	
	/**
	 * Creates Homework or Assignment Object with user inputs
	 * @return Homework or Assignment
	 */
	public static Homework createHw() throws SQLException { 
		
		task = taskInput.getText();
		course = ccInput.getText();
		duration = Integer.valueOf(timeInput.getText());
		
		//Creates and Assignment object if due date is given
		if(assignCheck.booleanValue() == true) { 
			LocalDate due = eventDate.getValue();
			hw = new Assignment(task, course, duration, due);
			DBops.addAssignment((Assignment) hw);
			
		}
		
		else { 
			hw = new Homework(task, course, duration);
			DBops.addHomework(hw);
		}
		
		window.close();
		return hw; 
	}

	/** 
	 * Checks user inputs to make sure it is not empty
	 * @param input
	 * @return boolean
	 */
	private static boolean checkEmpty(TextField input) { 
		
		if(input.getText().equals("")) { 
			errorMsg.setText("Error: Please fill out all fields");
			errorMsg.setTextFill(Color.RED);
			return true; 
		}
		
		else { 
			return false;
		}
	}
	
	
	/**
	 * Checks to make sure input is an int, returns error message on window if not
	 * @param input
	 * @return boolean
	 */
	private static boolean isInt(TextField input) { 
		try { 
			int x = Integer.valueOf((input.getText()));
			if(x <= 0 || x > 24) {
				errorMsg.setText("Error: int values in fields Completion TIme or Date are out of bounds");
				errorMsg.setTextFill(Color.RED);
				return false;
			}
			else { 
				return true;
			}
		}catch(NumberFormatException e) { 
			errorMsg.setText("Error: Expected value of int in field Completion Time or Date");
			errorMsg.setTextFill(Color.RED);
			return false;
		}
	}
	
	/**
	 * Checks to make sure date picker input is a valid date
	 * @param input
	 * @return
	 */
	private static boolean isLocalDate(DatePicker input) { 
		try { 
			LocalDate x = input.getValue();
			return true;
		}catch(NumberFormatException e) { 
			errorMsg.setText("Error: Please enter date value correctly, or select date on the date picker");
			errorMsg.setTextFill(Color.RED);
			return false;
		}
	}
}
