package Testing.UnitTesting;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.TreeSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import BusinessLogic.Day;
import BusinessLogic.Event;
import BusinessLogic.Hour;
import BusinessLogic.InvalidEventTimeException;
import BusinessLogic.NonRepeatingEvent;
import BusinessLogic.Reminders;
import BusinessLogic.negativeReminderOffsetException;
import Database.DBops;
import Database.databaseConnection;

public class DatabaseTesting implements DBops{
	static String title ="event 1";
	static String description = "description 1";
	static int startingTime = 10;
	static int duration =2;
	static LocalDate eventDate = LocalDate.of(2023,3,15);
	static int repeat = 0;  //  non repeating event.
	static NonRepeatingEvent event = new NonRepeatingEvent(1, title, description, new Hour(startingTime, 0), duration, eventDate);
	static boolean e1add = false;
	
	static String title2 ="event 2";
	static String description2 = "description 2";
	static int startingTime2 = 15;
	static int duration2 = 4;
	static LocalDate eventDate2 = LocalDate.of(2023,3,16);
	static int repeat2 = 0;  //  non repeating event.
	static NonRepeatingEvent event2 = new NonRepeatingEvent(2, title2, description2, new Hour(startingTime2, 0), duration2, eventDate2);
	static boolean e2add = false;
	
	static String title3 ="event 3";
	static String description3 = "description 3";
	static int startingTime3 = 6;
	static int duration3 = 2;
	static LocalDate eventDate3 = LocalDate.of(2023,3,17);
	static int repeat3 = 0;  //  non repeating event.
	static NonRepeatingEvent event3 = new NonRepeatingEvent(3, title3, description3, new Hour(startingTime3, 0), duration3, eventDate3);
	static boolean e3add = false;
	
//	@Test
//	public void testAddNREventToDB() {
//		boolean result = false;
//        try {
//            result = DBops.addNREventDB(event, repeat);
//        } catch (SQLException e) {
//            fail("SQLException should not be thrown");
//        }
//        assertTrue("Event should be successfully added to the database", result);
//	}
//	
//	@Test
//	public void testAddAndGetNREventToDB() {
//		try {
//			DBops.addNREventDB(event, repeat);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		e1add = true;
//		
//		NonRepeatingEvent dbEvent = null;
//		try {
//			dbEvent = (NonRepeatingEvent) DBops.getNREventDB(title, eventDate);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		assertEquals(event, dbEvent, "The event added to the database is not equal to the event fetched");		
//	}
//	
//	@Test
//	public void testGetAllEvents() throws SQLException {
//		try {
//			DBops.addNREventDB(event, repeat);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		e1add = true;
//		
//		try {
//			DBops.addNREventDB(event2, repeat2);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		e2add = true;
//		
//		try {
//			DBops.addNREventDB(event3, repeat3);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		e3add = true;
//		
//		TreeSet<Event> eventList = DBops.getAllEventDB();
//		
//		assertAll("Checking all added methods",
//				() -> assertTrue(eventList.contains(event)),
//				() -> assertTrue(eventList.contains(event2)),
//				() -> assertTrue(eventList.contains(event3))
//		);		
//	}
	
//	@Test
//	void testAddingReminderAndGettingAllReminders() throws InvalidEventTimeException, negativeReminderOffsetException, SQLException {
//		try {
//			DBops.addRemindersDB("Reminder 1", LocalDate.of(2024, 3, 29), 7, 4, "description 1");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		List<Reminders> reminders = DBops.getAllRemindersDB();
//		Reminders addedReminder = new Reminders("Reminder 1", "description 1", 4, Duration.ofHours(3).plusMinutes(30).plusSeconds(15), new Day(2024, 3, 29));
//	}
//	
	
	
	@AfterEach
	void deleteTestEventFromDB() throws SQLException {
		String title = "2311 Meeting";
        LocalDate eventDate = LocalDate.of(2023, 3, 15);

        try (Connection connection = new databaseConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM main.events WHERE title = ? AND eventDate = ?")) {
            statement.setString(1, title);
            statement.setDate(2, java.sql.Date.valueOf(eventDate));
            statement.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
            fail("Failed to clean up the event after test");
        }
	}
	
	@AfterEach
	void deleteAllEvents() {
		if(e1add == true) {
			try (Connection connection = new databaseConnection().getConnection();
			        PreparedStatement statement = connection.prepareStatement("DELETE FROM main.events WHERE title = ? AND eventDate = ?")) {
			        statement.setString(1, title);
			        statement.setDate(2, java.sql.Date.valueOf(eventDate));
			        statement.executeUpdate();
			} catch (SQLException e) {
			        e.printStackTrace();
			        fail("Failed to clean up the event after test");
			}
			
			e1add = false;
		}
		
		if(e2add == true) {
			try (Connection connection = new databaseConnection().getConnection();
			        PreparedStatement statement = connection.prepareStatement("DELETE FROM main.events WHERE title = ? AND eventDate = ?")) {
			        statement.setString(1, title2);
			        statement.setDate(2, java.sql.Date.valueOf(eventDate2));
			        statement.executeUpdate();
			} catch (SQLException e) {
			        e.printStackTrace();
			        fail("Failed to clean up the event after test");
			}
			
			e2add = false;
		}
		
		if(e3add == true) {
			try (Connection connection = new databaseConnection().getConnection();
			        PreparedStatement statement = connection.prepareStatement("DELETE FROM main.events WHERE title = ? AND eventDate = ?")) {
			        statement.setString(1, title3);
			        statement.setDate(2, java.sql.Date.valueOf(eventDate3));
			        statement.executeUpdate();
			} catch (SQLException e) {
			        e.printStackTrace();
			        fail("Failed to clean up the event after test");
			}
			
			e3add = false;
		}
		
	}

	

}
