package Testing.UnitTesting;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.TreeSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BusinessLogic.Event;
import BusinessLogic.Hour;
import BusinessLogic.InvalidEventTimeException;
import BusinessLogic.NonRepeatingEvent;
import BusinessLogic.Reminders;
import BusinessLogic.negativeReminderOffsetException;
import Database.DBops;
import Database.databaseConnection;

public class DatabaseTesting implements DBops{
//	static String title ="event 1";
//	static String description = "description 1";
//	static int startingTime = 10;
//	static int duration =2;
//	static LocalDate eventDate = LocalDate.of(2023,3,15);
//	static int repeat = 0;  //  non repeating event.
//	static NonRepeatingEvent event = new NonRepeatingEvent(1, title, description, new Hour(startingTime, 0), duration, eventDate);
//	static boolean e1add = false;
//	
//	static String title2 ="event 2";
//	static String description2 = "description 2";
//	static int startingTime2 = 15;
//	static int duration2 = 4;
//	static LocalDate eventDate2 = LocalDate.of(2023,3,16);
//	static int repeat2 = 0;  //  non repeating event.
//	static NonRepeatingEvent event2 = new NonRepeatingEvent(2, title2, description2, new Hour(startingTime2, 0), duration2, eventDate2);
//	static boolean e2add = false;
//	
//	static String title3 ="event 3";
//	static String description3 = "description 3";
//	static int startingTime3 = 6;
//	static int duration3 = 2;
//	static LocalDate eventDate3 = LocalDate.of(2023,3,17);
//	static int repeat3 = 0;  //  non repeating event.
//	static NonRepeatingEvent event3 = new NonRepeatingEvent(3, title3, description3, new Hour(startingTime3, 0), duration3, eventDate3);
//	static boolean e3add = false;
	
	private String title;
    private String description;
    private int startingTime;
    private int duration;
    private LocalDate eventDate;
    private int repeat;
    private NonRepeatingEvent event;
    private boolean e1Added;

    private String title2;
    private String description2;
    private int startingTime2;
    private int duration2;
    private LocalDate eventDate2;
    private int repeat2;
    private NonRepeatingEvent event2;
    private boolean e2Added;

    private String title3;
    private String description3;
    private int startingTime3;
    private int duration3;
    private LocalDate eventDate3;
    private int repeat3;
    private NonRepeatingEvent event3;
    private boolean e3Added;
    
    Reminders reminder;
    Reminders reminder2;
    Reminders reminder3;
    boolean r1Added;
	boolean r2Added;
	boolean r3Added;
	
	@BeforeEach
	void initialize() throws InvalidEventTimeException, negativeReminderOffsetException {
		title = "event 1";
		description = "description 1";
		startingTime = 10;
		duration = 2;
		eventDate = LocalDate.of(2023, 3, 15);
		repeat = 0;  // non repeating event.
		event = new NonRepeatingEvent(1, title, description, new Hour(startingTime, 0), duration, eventDate);
		e1Added = false;

		title2 = "event 2";
		description2 = "description 2";
		startingTime2 = 15;
		duration2 = 4;
		eventDate2 = LocalDate.of(2023, 3, 16);
		repeat2 = 0;  // non repeating event.
		event2 = new NonRepeatingEvent(2, title2, description2, new Hour(startingTime2, 0), duration2, eventDate2);
		e2Added = false;

		title3 = "event 3";
		description3 = "description 3";
		startingTime3 = 6;
		duration3 = 2;
		eventDate3 = LocalDate.of(2023, 3, 17);
		repeat3 = 0;  // non repeating event.
		event3 = new NonRepeatingEvent(3, title3, description3, new Hour(startingTime3, 0), duration3, eventDate3);
		e3Added = false;
		
		reminder = new Reminders(54, "Reminder 1", "remember", 12, Duration.ofHours(3).plusMinutes(30).plusSeconds(15), LocalDate.of(2024, 3, 29), "description A");
		reminder2 = new Reminders(23, "Reminder 2", "remember", 5, Duration.ofHours(4).plusMinutes(30).plusSeconds(15), LocalDate.of(2024, 3, 30), "description B");
		reminder3 = new Reminders(75, "Reminder 3", "remember", 8, Duration.ofHours(5).plusMinutes(00).plusSeconds(15), LocalDate.of(2024, 3, 12), "description C");
		
		r1Added = false;
		r2Added = false;
		r3Added = false;
	}
	
	@Test
	public void testAddNREventToDB() {
		boolean result = false;
        try {
            result = DBops.addNREventDB(event, repeat);
        } catch (SQLException e) {
            fail("SQLException should not be thrown");
        }
        assertTrue(result, "Event should be successfully added to the database");
	}
	
	@Test
	public void testAddAndGetNREventToDB() {
		try {
			DBops.addNREventDB(event, repeat);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		e1Added = true;
		
		NonRepeatingEvent dbEvent = null;
		try {
			dbEvent = (NonRepeatingEvent) DBops.getNREventDB(title, eventDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		assertEquals(event, dbEvent, "The event added to the database is not equal to the event fetched");		
	}
	
	@Test
	public void testGetAllEvents() throws SQLException {
		try {
			DBops.addNREventDB(event, repeat);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		e1Added = true;
		
		try {
			DBops.addNREventDB(event2, repeat2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		e2Added = true;
		
		try {
			DBops.addNREventDB(event3, repeat3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		e3Added = true;
		
		TreeSet<Event> eventList = DBops.getAllEventDB();
		
		assertAll("Only two events hsould have been returned from the database",
				() -> assertTrue(eventList.contains(event)),
				() -> assertTrue(eventList.contains(event2)),
				() -> assertTrue(eventList.contains(event3))
		);		
	}
	
	@Test
	void testGetEventsByDate() throws SQLException {
		//adding event 1 to db
		try {
			DBops.addNREventDB(event, repeat);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		e1Added = true;
		//setting the day of event 2 to the same day as event 1 and adding it to db
		event2.SetDate(eventDate);
		try {
			DBops.addNREventDB(event2, repeat2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		e2Added = true;
		//adding event 3 to db
		try {
			DBops.addNREventDB(event3, repeat3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		e3Added = true;
		
		TreeSet<Event> events = DBops.getEventsByDate(eventDate);
		
		assertAll("Checking if only the two events were returned from the database",
				() -> assertTrue(events.contains(event)),
				() -> assertTrue(events.contains(event2)),
				() -> assertFalse(events.contains(event3))
		);
	}
	
	
	@Test
	void testAddingReminder() throws SQLException{
		
		int expectedId = 54;
		int returnedId = 0;
		
		try {
			returnedId = DBops.addRemindersDB(reminder);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		r1Added = true;
		
		assertEquals(expectedId, returnedId, "Reminder not added to database");
	}
	
	@Test 
	void testGetAllReminders() throws SQLException, InvalidEventTimeException, negativeReminderOffsetException {
		try {
			DBops.addRemindersDB(reminder);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		r1Added = true;
		
		try {
			DBops.addRemindersDB(reminder2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		r2Added = true;
		
		try {
			DBops.addRemindersDB(reminder3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		r3Added = true;
		
		List<Reminders> reminderList = DBops.getAllRemindersDB();
		
		assertAll("Only the two reminders were not returned from the database",
				() -> assertTrue(reminderList.contains(reminder)),
				() -> assertTrue(reminderList.contains(reminder2)),
				() -> assertFalse(reminderList.contains(reminder3))
		);
	}
	
	@Test
	void testDeleteReminderDB() {
		try {
			DBops.addRemindersDB(reminder);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		r1Added = true;
		
		try {
			DBops.deleteReminderDB(reminder.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		r1Added = false;
		
		List<Reminders> reminderList = null;
		try {
			reminderList = DBops.getAllRemindersDB();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidEventTimeException e) {
			e.printStackTrace();
		} catch (negativeReminderOffsetException e) {
			e.printStackTrace();
		}
		
		assertFalse(reminderList.contains(reminder), "The reminder is still in the database");
	}

	@Test
	void testReminderExistsDB() {
		try {
			DBops.addRemindersDB(reminder);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		r1Added = true;
		
		boolean expected = false;
		try {
			expected = DBops.reminderExistsDB(reminder.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		assertTrue(expected, "The reminder was not added to the database");
	}
	
	@Test
	void testDeleteEventDB() {
		try {
			DBops.addNREventDB(event, 0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		e1Added = true;
		
		try {
			DBops.deleteEventDB(event.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		e1Added = false;
		
		TreeSet<Event> eventList = null;
		try {
			eventList = DBops.getAllEventDB();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		assertFalse(eventList.contains(event), "Event is still in the database");
	}
	
	@Test
	void testUpdateEvent() throws SQLException {
		try {
			DBops.addNREventDB(event, 0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		e1Added = true;
		
		int newDuration = 10;
		int newStartTime = 2;
		LocalDate newDate = LocalDate.of(2030, 12, 1);
		
		try {
			DBops.updateEvent(event.getId(), newStartTime, newDuration, newDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Event fetchedEvent = DBops.getNREventDB(event.getTitle(), event.getDate());
		
		assertAll("Event was not edited",
				() -> assertEquals(fetchedEvent.getStartingTime(), newStartTime),
				() -> assertEquals(fetchedEvent.getDuration(), newDuration),
				() -> assertEquals(fetchedEvent.getDate(), newDate)
		);
	}
	
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
	void deleteAllReminders() {
		//deleting reminder 1 from the database if it was added
		if(r1Added == true) {
			try (Connection connection = new databaseConnection().getConnection();
			        PreparedStatement statement = connection.prepareStatement("DELETE FROM main.reminders WHERE title = ?")) {
			        statement.setInt(1, reminder.getId());
			        statement.executeUpdate();
			} catch (SQLException e) {
			        e.printStackTrace();
			        fail("Failed to clean up the reminder after test");
			}
			
			r1Added = false;
		}
		//deleting reminder 2 from the database if it was added
		if(r2Added == true) {
			try (Connection connection = new databaseConnection().getConnection();
			        PreparedStatement statement = connection.prepareStatement("DELETE FROM main.reminders WHERE title = ?")) {
					statement.setInt(1, reminder2.getId());
			        statement.executeUpdate();
			} catch (SQLException e) {
			        e.printStackTrace();
			        fail("Failed to clean up the reminder after test");
			}
			
			r2Added = false;
		}
		//deleting reminder 3 from the database if it was added
		if(r3Added == true) {
			try (Connection connection = new databaseConnection().getConnection();
			        PreparedStatement statement = connection.prepareStatement("DELETE FROM main.reminders WHERE title = ?")) {
					statement.setInt(1, reminder3.getId());
			        statement.executeUpdate();
			} catch (SQLException e) {
			        e.printStackTrace();
			        fail("Failed to clean up the reminder after test");
			}
			
			r3Added = false;
		}
		
	}
	
	@AfterEach
	void deleteAllEvents() {
		//deleting event 1 from the database if it was added
		if(e1Added == true) {
			try (Connection connection = new databaseConnection().getConnection();
			        PreparedStatement statement = connection.prepareStatement("DELETE FROM main.events WHERE title = ? AND eventDate = ?")) {
			        statement.setString(1, title);
			        statement.setDate(2, java.sql.Date.valueOf(eventDate));
			        statement.executeUpdate();
			} catch (SQLException e) {
			        e.printStackTrace();
			        fail("Failed to clean up the event after test");
			}
			
			e1Added = false;
		}
		//deleting event 2 from the database if it was added
		if(e2Added == true) {
			try (Connection connection = new databaseConnection().getConnection();
			        PreparedStatement statement = connection.prepareStatement("DELETE FROM main.events WHERE title = ? AND eventDate = ?")) {
			        statement.setString(1, title2);
			        statement.setDate(2, java.sql.Date.valueOf(eventDate2));
			        statement.executeUpdate();
			} catch (SQLException e) {
			        e.printStackTrace();
			        fail("Failed to clean up the event after test");
			}
			
			e2Added = false;
		}
		//deleting event 3 from the database if it was added
		if(e3Added == true) {
			try (Connection connection = new databaseConnection().getConnection();
			        PreparedStatement statement = connection.prepareStatement("DELETE FROM main.events WHERE title = ? AND eventDate = ?")) {
			        statement.setString(1, title3);
			        statement.setDate(2, java.sql.Date.valueOf(eventDate3));
			        statement.executeUpdate();
			} catch (SQLException e) {
			        e.printStackTrace();
			        fail("Failed to clean up the event after test");
			}
			
			e3Added = false;
		}
		
	}

	

}
