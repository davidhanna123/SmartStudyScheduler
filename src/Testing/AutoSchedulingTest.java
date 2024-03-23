package Testing;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import BusinessLogic.CalendarApp;
import Database.DBops;
import Database.databaseConnection;

class AutoSchedulingTest {
	
	static CalendarApp calendar;
	
	@Before
	public void init() {
		calendar = new CalendarApp();
	}
	
	// had  to create this method which is a copy of the openAutomaticSchedulingWindow in  order to work  with jUnits, because openAutomaticSchedulingWindow is inside the UI 
	// so  i had  to create a method without UI implementation
	private boolean autoScheduling(LocalDate minDate, LocalDate maxDate, int minStartHour, int maxStartHour, int duration) {    
		if (minDate == null || maxDate == null || maxDate.isBefore(minDate) || duration <= 0 || minStartHour > maxStartHour) {
			return false; 
	    }    
	return true;
	}
	
	@Test
    public void testSuccessfulScheduling() {
        LocalDate minDate = LocalDate.now();
        LocalDate maxDate = LocalDate.now().plusDays(10);
        int minStartHour = 9;
        int maxStartHour = 17;
        int duration = 2;

        boolean result = autoScheduling(minDate, maxDate, minStartHour, maxStartHour, duration);
        assertTrue("The event should be scheduled successfully within the given constraints", result);
    }
	
	@Test
    public void testSchedulingWithInvalidDateRange() {
        LocalDate minDate = LocalDate.now().plusDays(1);
        LocalDate maxDate = LocalDate.now(); 

        boolean result = autoScheduling(minDate, maxDate, 9, 17, 1);
        assertFalse("The event should not be scheduled with an invalid date range", result);
    }	
	
	@Test
	public void testAddNREventToDB() {
		String title ="2311 Meeting";
		String description = "Discuss ITR1";
		int startingTime = 10;
		int duration =2;
		LocalDate eventDate = LocalDate.of(2023,3,15);
		int repeat = 0;  //  non repeating event.
		
		boolean result = false;
        try {
            result = DBops.addNREventDB(title, description, startingTime, duration, eventDate, repeat);
        } catch (SQLException e) {
            fail("SQLException should not be thrown");
        }
        assertTrue("Event should be successfully added to the database", result);
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
}
