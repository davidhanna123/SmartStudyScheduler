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
import BusinessLogic.Assignment;

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
	
	static Label yearLabel;
	static Label monthLabel;
	static Label dueDate;  
	static TextField yearInput = new TextField(); 
	static TextField monthInput = new TextField();
	static TextField dateInput = new TextField(); 
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
			handleEnter();
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
		
		yearLabel = new Label("Year due: ");
		GridPane.setConstraints(yearLabel, 0, 6, 2, 1);
		yearInput.setPromptText("ex. 2024");
		yearInput.setMaxWidth(75);
		GridPane.setConstraints(yearInput, 1, 6, 3, 1);
		
		monthLabel = new Label("Month due: ");
		GridPane.setConstraints(monthLabel, 0, 7, 2, 1);
		GridPane.setConstraints(monthInput, 1, 7);
		
		dueDate = new Label("Day of Month due: "); 
		GridPane.setConstraints(dueDate, 0, 8, 2, 1);
		GridPane.setConstraints(dateInput, 1, 8);
		
		grid.getChildren().addAll(yearLabel, yearInput, monthLabel, monthInput, dueDate, dateInput);
	}
	
	/**
	 * runs when yes selection is chosen 
	 */
	public static void noCheck() { 
		assignCheck = false;
		grid.getChildren().removeAll(yearLabel, yearInput, monthLabel, monthInput, dueDate, dateInput);
	}
	
	/**
	 * runs when enter button is pressed
	 */
	public static void handleEnter() { 
		if(checkEmpty(taskInput) == false && checkEmpty(ccInput) == false && checkEmpty(timeInput) == false) {
			if (assignCheck.booleanValue() == true) {
				if(checkEmpty(yearInput) == false && checkEmpty(monthInput) == false && checkEmpty(dateInput) == false)  {
					
					//Creates Assignment if all data is entered correctly
					if (isInt(timeInput) == true && isInt(yearInput) == true && isInt(monthInput) == true && isInt(dateInput) == true) { 
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
	public static Homework createHw() { 
		
		task = taskInput.getText();
		course = ccInput.getText();
		duration = Integer.valueOf(timeInput.getText());
		
		//Creates and Assignment object if due date is given
		if(assignCheck.booleanValue() == true) { 
			year = Integer.valueOf(yearInput.getText());
			month = Integer.valueOf(monthInput.getText());
			date = Integer.valueOf(dateInput.getText());
			hw = new Assignment(task, course, duration, year, month, date);
		}
		
		else { 
			hw = new Homework(task, course, duration);
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
			return true;
		}catch(NumberFormatException e) { 
			errorMsg.setText("Error: Expected value of int in field Completion Time or Date");
			errorMsg.setTextFill(Color.RED);
			return false;
		}
	}
}
