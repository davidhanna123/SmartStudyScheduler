package Gui;

import java.sql.SQLException;

import Database.DBops;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ViewHomework {
	
	 public static void viewHomeworkWindow() throws SQLException{ 
	    	Stage window = new Stage(); 
	    	window.setTitle("View Homework");
	    	ToggleGroup group = new ToggleGroup();
			
			GridPane grid = new GridPane(); 
			grid.setPadding(new Insets(20, 20, 20, 20));
			grid.setVgap(8);
			grid.setHgap(10);
			
			Label hwLabel = new Label("View Homework");
			GridPane.setConstraints(hwLabel, 0, 0);
			RadioButton hwButton = new RadioButton(); 
			hwButton.setToggleGroup(group);
			GridPane.setConstraints(hwButton, 1, 0);
			
			Label assignLabel = new Label("View Assignment");
			GridPane.setConstraints(assignLabel, 0, 1);
			RadioButton assignButton = new RadioButton(); 
			assignButton.setToggleGroup(group);
			GridPane.setConstraints(assignButton, 1, 1);
			
			Label bothLabel = new Label("View Both");
			GridPane.setConstraints(bothLabel, 0, 2);
			RadioButton bothButton = new RadioButton(); 
			bothButton.setToggleGroup(group);
			GridPane.setConstraints(bothButton, 1, 2);

			Label errorText = new Label(""); 
			errorText.setTextFill(Color.RED);
			GridPane.setConstraints(errorText, 0, 3, 3, 1);
			
			Button viewHwButton = new Button("View");
			GridPane.setConstraints(viewHwButton, 3, 3);
			viewHwButton.setOnAction(event -> {
				
				if(hwButton.isSelected() == true) { 
					try {
						System.out.println(DBops.getJustHomeworkDB());
						window.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				
				else if(assignButton.isSelected() == true) {
					try {
						System.out.println(DBops.getJustAssignmentDB());
						window.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				else if(bothButton.isSelected() == true) { 
					try {
						System.out.println(DBops.getAllHomeworkDB());
						window.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				else { 
					errorText.setText("Please select and option");
				}
			});
			
			grid.getChildren().addAll(hwLabel, hwButton, assignLabel, assignButton, bothLabel, bothButton, viewHwButton, errorText);
			Scene scene = new Scene(grid, 300, 300); 
			window.setScene(scene);
			window.show();
	    	
	    }
}


