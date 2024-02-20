package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import BusinessLogic.InvalidEventTimeException;
import BusinessLogic.Reminders;
import BusinessLogic.negativeReminderOffsetException;

class RemindersTest {

	@Test
	void testInvalidEventTime() throws InvalidEventTimeException, negativeReminderOffsetException{
		Reminders reminder = new Reminders("Test", 12, Duration.ofMinutes(30));
	}
	
	@Test
	void testNegativeOffset() {
        assertThrows(negativeReminderOffsetException.class, () -> {
            Reminders reminder = new Reminders("Test2", 23, Duration.ofMinutes(-30));
        });
    }
	
	@Test
	void testGetReminderTime() throws InvalidEventTimeException, negativeReminderOffsetException{
		Reminders reminder = new Reminders("Test3", 10, Duration.ofMinutes(30));
		assertEquals(9, reminder.getReminderTime());
	}
	
	@Test
	void isTimeForReminder() throws InvalidEventTimeException, negativeReminderOffsetException{
		Reminders reminder = new Reminders("Test4", 9, Duration.ofMinutes(30));
		
		// Change the event time to 10 AM
        reminder.setEventTime(10);

        // Set current time to test the reminder trigger
        reminder.setCurrentTime(LocalTime.of(9, 30)); // Time when the reminder should trigger for a 10 AM event with a 30-minute offset
        assertTrue(reminder.isTimeForReminder(), "Reminder should trigger at 9:30 AM for a 10 AM event with a 30-minute offset");

        reminder.setEventTime(11); // Change event time to 11 AM
        reminder.setCurrentTime(LocalTime.of(10, 30)); // Adjust current time for the new event time
        assertTrue(reminder.isTimeForReminder(), "Reminder should trigger at 10:30 AM for an 11 AM event with a 30-minute offset");
    }
}
