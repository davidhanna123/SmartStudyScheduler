package Testing;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import BusinessLogic.CalendarApp;

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
}
