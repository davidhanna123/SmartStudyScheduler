package Gui;

import javafx.scene.paint.Color;
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
public class Add_Homework extends Application implements EventHandler<ActionEvent> {
	
	//GUI Variables
	Stage window; 
	Scene scene; 
	Button button;
	Label label;
	Label errorMsg;
	TextField input;
	int inputIndex = 0;
	
	//Data Variables
	String task;
	String course; 
	int hour; 
	int min; 
	int date; 
	String dayOfWeek; 
	Homework hw = new Homework(); 
	
	/**
	 * Main, launches GUI for this class
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args); 

	}
	
	/**
	 * Creates GUI for class
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Add Homework");
		
		label = new Label("Name the task: ");
		input = new TextField();
		input.setPromptText("task name");
		
		errorMsg = new Label();
		
		button = new Button("Enter"); 
		button.setOnAction(this);
		
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(label, input, errorMsg, button);
		
		
		scene = new Scene(layout,300, 250); 
		window.setScene(scene); 
		window.show();
	}
	
	/**
	 * Takes user inputs when the "Enter" button is pressed
	 */
	@Override
	public void handle(ActionEvent event) {
		
		//Gets task name and sets GUI to ask for course code
		if(inputIndex == 0) { 
			task = input.getText();
			label.setText("Course code: ");
			input.setPromptText("course code");
			input.setText("");
			inputIndex++;
		}
		
		//Gets course code and sets GUI to ask for #of hours to complete
		else if(inputIndex == 1) { 
			course = input.getText();
			label.setText("How long will this task take to complete?");
			input.setPromptText("Hours?: ");
			input.setText("");
			inputIndex++;
			
		}
		
		//Gets hours to complete and sets GUI to ask for #of minutes to complete
		else if(inputIndex == 2) { 
			
			//Make sure input is an int
			if(isInt(input, input.getText()) == false) { 
				input.setText("");
			}
			
			else { 
				hour = Integer.valueOf((input.getText()));
				input.setPromptText("Minutes?: ");
				input.setText("");
				errorMsg.setText("");
				inputIndex++;
			}
		}
		
		//Gets minutes to complete and sets GUI to ask if the task has a due date
		else if(inputIndex == 3) { 
			
			//Make sure input is an int
			if(isInt(input, input.getText()) == false) { 
				input.setText("");
			}
			
			else { 
				min = Integer.valueOf((input.getText()));
				label.setText("Does this task have a due date? (Y/N)");
				input.setPromptText("Y/N");
				input.setText("");
				errorMsg.setText("");
				inputIndex++;
			}	
		}
		
		//Creates homework object if no due date, otherwise set GUI to ask for due date
		else if(inputIndex == 4) { 
			char assignmentCheck = input.getText().charAt(0);
			
			if (assignmentCheck == 'Y' || assignmentCheck == 'y' ) {
				label.setText("When is the due date?");
				input.setPromptText("Day of Month (int)");
				input.setText("");
				inputIndex++;
			}
			else { 
				//Creates new Homework object to be added to Calendar
				hw = new Homework(task, course, hour, min);
				window.close();
				//TODO: Add created object to Calendar
				//System.out.println(hw);
			}
			
		}
		
		//Gets day of month due, and sets GUI to ask for day of week due
		else if(inputIndex == 5) { 
			
			//Make sure input is an int
			if(isInt(input, input.getText()) == false) { 
				input.setText("");
			}
			
			else { 
				date = Integer.valueOf((input.getText()));
				input.setPromptText("Day of Week");
				input.setText("");
				errorMsg.setText("");
				inputIndex++;
			}	
		}
		
		//Gets day of week and creates Homework object to be added to Calendar
		else if(inputIndex == 6) { 
			dayOfWeek = input.getText();
			hw = new Assignment(task, course, hour, min, date, dayOfWeek);
			window.close();
			//TODO: Add created object to Calendar
			//System.out.println(hw);
		}		
	}
	
	/**
	 * Checks to make sure input is an int, returns error message on window if not
	 * @param input
	 * @param message
	 * @return boolean
	 */
	private boolean isInt(TextField input, String message) { 
		try { 
			int x = Integer.valueOf((input.getText()));
			return true;
		}catch(NumberFormatException e) { 
			errorMsg.setText("Error: Expected value of int");
			errorMsg.setTextFill(Color.RED);
			return false;
		}
	}
}
