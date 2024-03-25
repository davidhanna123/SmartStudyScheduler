package Testing.IntegrationTesting;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import BusinessLogic.*;

public class EventDayIntegrationTesting {

	
	public EventDayIntegrationTesting() {
		// TODO Auto-generated constructor stub
	}
	static CalendarApp calendar = new CalendarApp();
	
	@BeforeEach
	void initialize() {
		
		Year year = new Year(2024);
		calendar.addYear(year);
		Month[] months = new Month[12];
		Day[] days = new Day[30];
 		Hour[] hours = new Hour[24];
		
		for(int i = 1; i<=12; i++) {
			months[i-1] = new Month(i, year.getCurrentYear());
			for(int j = 1; j<=30; j++) {
				days[j-1] = new Day(j);//we should make day have an integer between 0 and 32 and make a constructor for that. Up to Kamil though.
				for(int k = 1; k <=24; k++) {
					hours[k-1] = new Hour(k, 0.0);
					days[j-1].addHour(hours[k-1]);
				}
				try {
					months[i-1].addDay(days[j-1]);
				}catch(Exception e) {	
			}
		}
			year.addMonth(months[i-1]);
		}
	}
	
	@AfterEach
	void clearing() {
		calendar.clear();
	}
	
	// tests

	@Test
	void YearMonthDayExistenceTest() throws MonthNotFoundException, CalendarException {
		//calendar.findYear(2024).findMonthByNumber(2).getDays().first().
		Year year2024 = calendar.findYear(2024);
		assertNotNull(year2024, "Year 2024 should exist in the calendar");
		
		Month february = year2024.findMonthByNumber(2);
		assertNotNull(february, "February should exist in 2024");
		
		Day firstDayOfFebruary = february.getDays().first();
		assertNotNull(firstDayOfFebruary, "The first day of February should be retrievable.");
	}
	
	@Test
	void AddEventTest() throws EventOverlapException, EventSurpassesDayException {
		Day testDay = new Day();
		
		NonRepeatingEvent event1 = new NonRepeatingEvent();
		// adding event to the day
		//testDay.addEvent(event);
		event1.setStartingTime(new Hour(8,0));
		testDay.addEvent(event1);
		
		
		NonRepeatingEvent event2 = new NonRepeatingEvent();
		event2.setStartingTime(new Hour(12,0));
		testDay.addEvent(event2);
		
		// getting all events for the day
		TreeSet<Event> events = testDay.getEvent();
		assertTrue(events.contains(event1), "The first test event should be added to the day's events.");
		assertTrue(events.contains(event2), "The second test event should be added to the day's events.");
	}
	
	@Test
	void addingOverlappingEventTest() throws EventOverlapException, EventSurpassesDayException {
		Day testDay = new Day();
		
		NonRepeatingEvent event1 = new NonRepeatingEvent();
		event1.setStartingTime(new Hour(9,0));
		event1.setDuration(3);
		event1.setTitle("Event1");
		testDay.addEvent(event1);
		
		NonRepeatingEvent event2 = new NonRepeatingEvent(); 
		event2.setStartingTime(new Hour(9,30));
		event2.setDuration(2); // two hours
		event2.setTitle("Event2");
		
		
		// trying to add the second event that overlaps with the first event
		assertThrows(EventOverlapException.class, () -> testDay.addEvent(event2),
		        "adding overlapping event should throw overlap exception");
		
	}
	
	@Test
	void eventSurpassingDayExceptionTest() throws EventOverlapException, EventSurpassesDayException{
		Day testDay = new Day(15);
		
		NonRepeatingEvent event1 = new NonRepeatingEvent();
		event1.setStartingTime(new Hour(23,0));
		event1.setDuration(3);
		event1.setTitle("Event1");
		//testDay.addEvent(event1);
		
		// trying to add the second event that overlaps with the first event
		assertThrows(EventSurpassesDayException.class, () -> testDay.addEvent(event1),
				        "adding an event whose end time is on the next day should throw an EventSurpassesDayException");
	}
}
