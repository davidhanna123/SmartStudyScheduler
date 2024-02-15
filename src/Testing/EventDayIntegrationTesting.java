package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;


import BusinessLogic.Assignment;
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
	void test() {
		//calendar.findYear(2024).findMonthByNumber(2).getDays().first().
	}
}
