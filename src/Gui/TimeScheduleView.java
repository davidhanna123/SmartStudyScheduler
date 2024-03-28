package Gui;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.TreeSet;

import BusinessLogic.Event;
public class TimeScheduleView {
    private GridPane scheduleGrid;

    public TimeScheduleView(GridPane scheduleGrid) {
        this.scheduleGrid = scheduleGrid;
        scheduleGrid.getChildren().clear();
        createScheduleGrid();
    }

    private void createScheduleGrid() {
        scheduleGrid.setHgap(10);
        scheduleGrid.setVgap(10);

        // Create time labels 24 hr format
        for (int hour = 0; hour < 24; hour++) {
            Label timeLabel = new Label(String.format("%02d:00", hour));
            scheduleGrid.add(timeLabel, 0, hour);
        }

        // Create placeholder labels for each hour to represent available slots
        for (int hour = 0; hour < 24; hour++) {
            Label slotLabel = new Label();
            slotLabel.setMinWidth(150);
            slotLabel.setStyle("-fx-background-color: #FFFFFF;"); 
            scheduleGrid.add(slotLabel, 1, hour);
        }
    }

    public void updateSchedule(TreeSet<Event> events) {
        // Reset all slot colors to default
        for (int hour = 0; hour < 24; hour++) {
            Label slotLabel = (Label) scheduleGrid.getChildren().get(hour * 2 + 1);
            slotLabel.setStyle("-fx-background-color: #FFFFFF;"); 
        }

        
        for (Event event : events) {
            int startHour = event.getStartingTime().getTime();
            int endHour = startHour + event.getDuration();
            
            for (int hour = startHour; hour <= endHour; hour++) {
            	if (hour == startHour) {
            		String combinedText = event.getTitle()+ " | "+event.getDescription();
            		Label titleLabel = new Label(combinedText);
            		titleLabel.setStyle("-fx-background-color: lightgreen;");
                    scheduleGrid.add(titleLabel, 1, startHour); 
            	}
                Label slotLabel = (Label) scheduleGrid.getChildren().get(hour);
                slotLabel.setStyle("-fx-background-color: lightgreen;");
            }
            
            
        }
    }

}



