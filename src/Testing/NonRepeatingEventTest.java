package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BusinessLogic.Hour;
import BusinessLogic.NonRepeatingEvent;

class NonRepeatingEventTest {

	public NonRepeatingEvent event;
	
	@BeforeEach
	void initialization() {
		event = new NonRepeatingEvent();
		event.setTitle("Math Homework");
        event.setDescription("Finish the crowdmark assignment");
        event.setStartingTime(new Hour(14, 0)); 
        event.setDuration(120); // in minutes
	}
	
	@Test
    void testGetTitle() {
        assertEquals("Math Homework", event.getTitle(), "The title should match the one set in initialization.");
    }
	
	@Test
    void testGetDescription() {
        assertEquals("Finish the crowdmark assignment", event.getDescription(), "The description should match the one set in initialization.");
    }
	
	@Test
    void testGetStartingTime() {
        Hour expectedHour = new Hour(14, 0); 
        assertEquals(expectedHour, event.getStartingTime(), "The starting time should match the one set in initialization.");
    }
	
	@Test
    void testGetDuration() {
        assertEquals(120, event.getDuration(), "The duration should match the one set in initialization.");
    }

}
