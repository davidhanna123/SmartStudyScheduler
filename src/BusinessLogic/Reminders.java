

package BusinessLogic;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reminders {
	private String message;
	private int eventTime;
	private Duration offset;
	
	public Reminders(String message, int eventTime, Duration offset) throws InvalidEventTimeException, negativeReminderOffsetException {
		if (eventTime < 0 || eventTime > 23) {
			throw new InvalidEventTimeException("Event time cannot be emtpy");
		}
		if (offset.isNegative()) {
			throw new negativeReminderOffsetException("Offset cannot be negative");
		}
		
		this.message = message;
		this.eventTime = eventTime;
		this.offset = offset;
	}
	
	// setting the offset duration
	public void setReminders(String message, int reminder_time) {
		this.message = message;
		this.eventTime = reminder_time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	} 

	public int getEvenTime() {
		return eventTime;
	}

	public void setEvenTime(int evenTime) {
		this.eventTime = evenTime;
	}

	public Duration getOffset() {
		return offset;
	}

	public void setOffset(Duration offset) {
		this.offset = offset;
	}
	
	
	// Calculating reminder time when it should trigger
	public int getReminderTime() {
		// converting time to minutes for easier logic 
		int eventTimeInMinutes = eventTime * 60;
		// subtract the offset in minutes from the eventTime
		int remindersTimeInMinutes = (int) (eventTimeInMinutes - offset.toMinutes());
		// converting reminders time back to hours
		int reminderTimeInHours = remindersTimeInMinutes / 60;
		return reminderTimeInHours;
	}
	
	// method to check if reminder should trigger by comparing the current time with the calculated reminder time
	public boolean isTimeForReminder() {
		LocalTime currentTime = LocalTime.now();
		LocalTime eventTime = LocalTime.of(this.eventTime, 0); // eventTime is in hours, set minutes to 0
		LocalTime reminderTime = eventTime.minus(this.offset); // subtracting the offset, gives us time when reminder should trigger
		
		if (currentTime.equals(reminderTime)) {
			return true; // time for the reminder
		}else {
			return false; // not the time for the reminder yet
		}
	}

	@Override
    public String toString() {
        return "Reminder{" +
                "message='" + message + '\'' +
                ", eventTime=" + eventTime +
                ", offset=" + offset +
                '}';
    }
	
}
