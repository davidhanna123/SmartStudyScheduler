package Gui;

import java.sql.SQLException;
import java.util.*;

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
import BusinessLogic.Homework;
import BusinessLogic.Assignment;

public class ViewHomework {
	static Stage window = new Stage(); 
	static GridPane grid = new GridPane();
	
	static Label hwLabel = new Label("View Homework");
	static Label assignLabel = new Label("View Assignment");
	static Label bothLabel = new Label("View Both");
	
	static ToggleGroup group = new ToggleGroup();
	static RadioButton hwButton = new RadioButton(); 
	static RadioButton assignButton = new RadioButton(); 
	static RadioButton bothButton = new RadioButton();
	static Label errorText = new Label(""); 

	static Button viewHwButton = new Button("View");
	static Button closeButton = new Button("Close");
	
	public static void viewHomeworkWindow() throws SQLException { 
		window.setTitle("View Homework");
		
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(8);
		grid.setHgap(10);
				
		GridPane.setConstraints(hwLabel, 0, 0);
		hwButton.setToggleGroup(group);
		GridPane.setConstraints(hwButton, 1, 0);
		
		GridPane.setConstraints(assignLabel, 0, 1);
		assignButton.setToggleGroup(group);
		GridPane.setConstraints(assignButton, 1, 1);
		
		GridPane.setConstraints(bothLabel, 0, 2);
		bothButton.setToggleGroup(group);
		GridPane.setConstraints(bothButton, 1, 2);
	
		errorText.setTextFill(Color.RED);
		GridPane.setConstraints(errorText, 0, 3, 3, 1);
				
		GridPane.setConstraints(viewHwButton, 3, 3);
		viewHwButton.setOnAction(event -> {
			buttonHandler();
					
		});
		
		closeButton.setOnAction(event -> { 
			handleClose();
		});
		
			
		grid.getChildren().addAll(hwLabel, hwButton, assignLabel, assignButton, bothLabel, bothButton, viewHwButton, errorText);
		Scene scene = new Scene(grid, 750, 450); 
		window.setScene(scene);
		window.show(); 
		
	   }
	
	public static void buttonHandler() { 
		if(hwButton.isSelected() == true) { 
			try {
				List<Homework> hwList = DBops.getJustHomeworkDB();
				if (hwList.isEmpty() == true) { 
					errorText.setText("No Homework found");	
				}
				else { 
					grid.getChildren().removeAll(hwLabel, hwButton, assignLabel, assignButton, bothLabel, bothButton, viewHwButton, errorText);
					
					for(int i = 0; i< hwList.size(); i++) {
						Label tempLabel = new Label();
						tempLabel.setText((hwList.get(i)).toString());
						GridPane.setConstraints(tempLabel, 0, i);
						grid.getChildren().add(tempLabel);
						grid.getChildren().remove(closeButton);
						GridPane.setConstraints(closeButton, 3, i+1);
						grid.getChildren().add(closeButton);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
						
		}
		
		else if(assignButton.isSelected() == true) { 
			try {
				List<Homework> hwList = DBops.getJustAssignmentDB();
				if (hwList.isEmpty() == true) { 
					errorText.setText("No Assignments found");	
				}
				else { 
					grid.getChildren().removeAll(hwLabel, hwButton, assignLabel, assignButton, bothLabel, bothButton, viewHwButton, errorText);
					
					for(int i = 0; i< hwList.size(); i++) {
						Label tempLabel = new Label();
						tempLabel.setText((hwList.get(i)).toString());
						GridPane.setConstraints(tempLabel, 0, i);
						grid.getChildren().add(tempLabel);
						grid.getChildren().remove(closeButton);
						GridPane.setConstraints(closeButton, 3, i+1);
						grid.getChildren().add(closeButton);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
						
		}
		
		else if(bothButton.isSelected() == true) { 
			try {
				List<Homework> hwList = DBops.getAllHomeworkDB();
				if (hwList.isEmpty() == true) { 
					errorText.setText("No Homework or Assignments found");	
				}
				else { 
					grid.getChildren().removeAll(hwLabel, hwButton, assignLabel, assignButton, bothLabel, bothButton, viewHwButton, errorText);
					
					for(int i = 0; i< hwList.size(); i++) {
						Label tempLabel = new Label();
						tempLabel.setText((hwList.get(i)).toString());
						GridPane.setConstraints(tempLabel, 0, i);
						grid.getChildren().add(tempLabel);
						grid.getChildren().remove(closeButton);
						GridPane.setConstraints(closeButton, 3, i+1);
						grid.getChildren().add(closeButton);
					}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
						
		}
			
		else { 
			errorText.setText("Please select and option");
		}
	}
	
	public static void handleClose() { 
		window.close();
		
	}
}


