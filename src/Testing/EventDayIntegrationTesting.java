package Testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
			months[i] = new Month(i, 30);
			for(int j = 1; j<=30; j++) {
				days[j] = new Day();//we should make day have an integer between 0 and 32 and make a constructor for that. Up to Kamil though.
				for(int k = 1; k <=24; k++) {
					hours[k] = new Hour(k, 0.0);
					days[j].addHour(hours[k]);
				}
				months[i].addDay(days[j]);
			}
			year.addMonth(months[i]);
		}
		
		
	}
	
	@AfterEach
	void clearing() {
		calendar.clear();
	}

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
	void AddEventTest() {
		Day testDay = new Day();
		
		Assignment event = new Assignment("Study", "calc-midterm study session", 3, testDay);
		// adding event to the day
		testDay.addEvent(event);
		
		// getting all events for the day
		TreeSet<Event> events = testDay.getEvent();
		assertTrue(events.contains(event), "The test event should be added to the day's events.");
		
		
	}
	
	@Test
	void addingOverlappingEventTest() {
		Day testDay = new Day();
		
		Assignment event1 = new Assignment("Study Session", "Java", 12, testDay);
		Assignment event2 = new Assignment("Extra Session", "Java", 12, testDay); // same start time as event1
		
		assertThrows(EventOverlapException.class, () -> {
			testDay.addEvent(event1);
			testDay.addEvent(event2);
		},"adding overlapping event should throw overlap exception");
	}
}
