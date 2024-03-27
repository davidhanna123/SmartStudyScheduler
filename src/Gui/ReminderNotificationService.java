package Gui;


import BusinessLogic.Reminders;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class ReminderNotificationService extends Service<Void> {

    private final Reminders reminder;

    public ReminderNotificationService(Reminders reminder) {
        this.reminder = reminder;
    }

	
	 @Override 
	protected Task<Void> createTask() { 
		 return new Task<>() {
			 @Override 
			 protected Void call() throws Exception { 
				 Duration timeUntilEvent = Duration.between(LocalTime.now(), LocalTime.of(reminder.getEventTime(), 0));
				 Duration timeUntilNotification = timeUntilEvent.minus(reminder.getOffset());
				 
				 if (!timeUntilNotification.isNegative()) { 
					 Timer timer = new Timer(true);
					 timer.schedule(new TimerTask() {
						 @Override 
						  public void run() { 
							 showReminderPopup();
						 }
					 }, timeUntilNotification.toMillis());
				 }
				 return null;
			 }
		 };
	 }
						  

    private void showReminderPopup() {
    	Platform.runLater(() -> {
            LocalTime eventTime = LocalTime.of(reminder.getEventTime(), 0);
            String eventTimeText = eventTime.format(DateTimeFormatter.ofPattern("h:mm a"));

            String eventTitle = reminder.getEventTitle();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Reminder");
            alert.setHeaderText("Don't forget your upcoming event!");
            alert.setContentText("Your event '" + eventTitle + "' is scheduled at " + eventTimeText + ".");
            alert.showAndWait();
        });
    }
}