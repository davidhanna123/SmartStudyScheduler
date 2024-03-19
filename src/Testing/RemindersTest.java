package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BusinessLogic.InvalidEventTimeException;
import BusinessLogic.Reminders;
import BusinessLogic.negativeReminderOffsetException;
import Database.DBops;
import Database.databaseConnection;

class RemindersTest {
	
	@Test 
	void testAddReminder() throws SQLException, InvalidEventTimeException, negativeReminderOffsetException {
		String title = "Test Reminder";
		LocalDate reminderDate = LocalDate.of(2023, 5, 12);
		int eventTime = 14;
		int offsetMinutes = 30;
		
		String message = "Test Message";
		
		// adding reminder to db
		DBops.addRemindersDB(title, reminderDate, eventTime, offsetMinutes, message);
		
		// fetching a newly  added reminder
		List<Reminders> reminders = DBops.getAllRemindersDB();
		
		assertFalse(reminders.isEmpty(), "The reminders list should not be empty.");
        Reminders addedReminder = reminders.get(reminders.size() - 1); 
        assertEquals(title, ( addedReminder).getTitle(), "The reminder title should match.");
        assertEquals(reminderDate, addedReminder.getReminderDate(), "The reminder date should match.");
        assertEquals(eventTime, addedReminder.getEventTime(), "The reminder event time should match.");
        assertEquals(Duration.ofMinutes(offsetMinutes), addedReminder.getOffset(), "The reminder offset should match.");
        assertEquals(message, addedReminder.getMessage(), "The reminder message should match.");
		
	}
	
	@Test
	void testCheckIfReminderInDatabase() throws SQLException, InvalidEventTimeException, negativeReminderOffsetException {
		List<Reminders> reminders = DBops.getAllRemindersDB();
		assertFalse(reminders.isEmpty(), "The reminders list should not be empty");
	}
	
	@Test
	void testInvalidEventTime() throws InvalidEventTimeException, negativeReminderOffsetException{
		// added localdate 
		LocalDate date = LocalDate.of(2023, Month.AUGUST, 12);
		Reminders reminder = new Reminders("Test Message", "Test", 12, Duration.ofMinutes(30), date);
	}
	
	@AfterEach
	void deleteTestingReminder() throws SQLException {
		Connection connection = new databaseConnection().getConnection();
		Statement statement = connection.createStatement();
		
		String sqlDeleteTestReminder = "DELETE FROM main.reminders WHERE title LIKE 'Test Reminders' OR message LIKE '%test'";
		statement.executeUpdate(sqlDeleteTestReminder);
	}
	
	@Test
	void testNegativeOffset() {
        assertThrows(negativeReminderOffsetException.class, () -> {
        	LocalDate date = LocalDate.of(2023, Month.AUGUST, 21);
            Reminders reminder = new Reminders("Test Message", "Test2", 23, Duration.ofMinutes(-30),date);
        });
    }
	
	@Test
	void testGetReminderTime() throws InvalidEventTimeException, negativeReminderOffsetException{
		LocalDate date = LocalDate.of(2023, Month.MARCH, 15);
		Reminders reminder = new Reminders("Test Message", "Test3", 10, Duration.ofMinutes(30), date);
		assertEquals(9, reminder.getReminderTime());
		assertEquals(date, reminder.getReminderDate());
	}
	
	@Test
	void isTimeForReminder() throws InvalidEventTimeException, negativeReminderOffsetException{
		LocalDate date = LocalDate.of(2022, Month.APRIL, 23);
		Reminders reminder = new Reminders("Test Message", "Test4", 9, Duration.ofMinutes(30), date);
		
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
