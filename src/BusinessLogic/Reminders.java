

package BusinessLogic;

import java.time.Duration;

public class Reminders {
	private String message;
	private int eventTime;
	private Duration offset;
	
	public Reminders(String message, int eventTime, Duration offset) {
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
		return 0;
	}

	@Override
	public String toString() {
		return "Reminders [message=" + message + ", eventTime=" + eventTime + ", offset=" + offset + "]";
	}
	
}
