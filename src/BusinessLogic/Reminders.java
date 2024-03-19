

package BusinessLogic;

import java.time.Duration;
import java.time.LocalTime;
import java.time.LocalDate;


/*
 * This class represents reminders for events. 
 * */
public class Reminders {
	private String message;
	private String title;
	private int eventTime;
	private Duration offset;
	private LocalTime currentTime; // storing the current time
	private Day reminderDay;
	private LocalDate reminderDate;
	
	
	/**
	 * Constructor
	 * @param message
	 * @param title
	 * @param eventTime
	 * @param offset
	 * @param reminderDate
	 * @throws InvalidEventTimeException
	 * @throws negativeReminderOffsetException
	 */
	public Reminders(String message, String title, int eventTime, Duration offset, LocalDate reminderDate) throws InvalidEventTimeException, negativeReminderOffsetException {
		if (eventTime < 0 || eventTime > 23) {
			throw new InvalidEventTimeException("Event time must be between 0 and 23");
		}
		if (offset.isNegative()) {
			throw new negativeReminderOffsetException("Offset cannot be negative");
		}
		
		this.message = message;
		this.title = title;
		this.eventTime = eventTime;
		this.offset = offset;
		//this.currentTime = LocalTime.now();
		this.reminderDate = reminderDate;
	}
	
	/**
	 * Gets a reminder
	 * @param message
	 * @param title
	 * @param eventTime
	 * @param offset
	 * @param reminderDay
	 * @throws InvalidEventTimeException
	 * @throws negativeReminderOffsetException
	 */
	public Reminders(String message, String title,  int eventTime, Duration offset, Day reminderDay) throws InvalidEventTimeException, negativeReminderOffsetException {
        this.message = message;
        this.title = title;
        this.eventTime = eventTime;
        this.offset = offset;
        this.reminderDay = reminderDay;
    }
	
	/**
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets a reminder's date
	 * @return reminderDate
	 */
	public LocalDate getReminderDate() {
		return reminderDate;
	}
	
	
	/**
	 * Gets a reminder's day
	 * @return reminderDay
	 */
	public Day getReminderDay() {
        return reminderDay;
    }
	
	/**
	 * Sets a reminder's day
	 * @param reminderDay
	 */
	public void setReminderDay(Day reminderDay) {
        this.reminderDay = reminderDay;
    }
	
	/**
	 * Sets the reminder with the specified message and event time.
	 * @param message
	 * @param reminder_time
	 */
	
	public void setReminders(String message, int reminder_time) {
		this.message = message;
		this.eventTime = reminder_time;
	}
	
	/**
	 * Sets the current time
	 * @param currentTime
	 */
	public void setCurrentTime(LocalTime currentTime) {
		this.currentTime = currentTime;
	}

	/**
	 * Gets the message of the reminder
	 * @return the message of the reminder
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message of the reminder
	 * @param message to send
	 */
	public void setMessage(String message) {
		this.message = message;
	} 

	/**
	 * Gets the event time of the reminder
	 * @return the event time of the reminder
	 */
	public int getEventTime() {
		return eventTime;
	}

	/**
	 * Sets the event time of the reminder
	 * @param eventTime the event time to set
	 */
	public void setEventTime(int eventTime) {
		this.eventTime = eventTime;
	}

	/**
	 * Gets the offset duration of the reminder
	 * @return the offset duration of the reminder
	 */
	public Duration getOffset() {
		return offset;
	}

	
	/**
	 * Sets the offset duration of the reminder
	 * @param offset the offset duration to set
	 */
	public void setOffset(Duration offset) {
		this.offset = offset;
	} 
	
	/**
	 * Calculating reminder time when it should trigger
	 * @return the time when the reminder should trigger (in hours)
	 */
	public int getReminderTime() {
		// converting time to minutes for easier logic 
		int eventTimeInMinutes = eventTime * 60;
		// subtract the offset in minutes from the eventTime
		int remindersTimeInMinutes = (int) (eventTimeInMinutes - offset.toMinutes());
		// converting reminders time back to hours
		int reminderTimeInHours = remindersTimeInMinutes / 60;
		return reminderTimeInHours;
	}
	
	
	/**
	 * Checks if its time for the reminder to trigger
	 * @return true if its time for the reminder, false otherwise
	 */
	public boolean isTimeForReminder() {
		//LocalTime currentTime = LocalTime.now();
		LocalTime eventTime = LocalTime.of(this.eventTime, 0); // eventTime is in hours, set minutes to 0
		LocalTime reminderTime = eventTime.minus(this.offset); // subtracting the offset, gives us time when reminder should trigger
		
		if (this.currentTime.equals(reminderTime)) {
			return true; // time for the reminder
		}else {
			return false; // not the time for the reminder yet
		}
		//return this.currentTime.equals(reminderTime) || this.currentTime.isAfter(reminderTime) && this.currentTime.isBefore(eventTime);
	}
		

	/**
	 * Returns a string version of the reminder.
	 */
	@Override
    public String toString() {
        return "Reminder{" +
                "message='" + message + '\'' +
                ", eventTime=" + eventTime +
                ", offset=" + offset +
                '}';
    }
}
