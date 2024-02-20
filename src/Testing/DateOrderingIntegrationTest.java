package Testing;

import static org.junit.jupiter.api.Assertions.*;

//import java.time.Year;
//import java.time.Month;
//import java.time.Year;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import BusinessLogic.Day;
import BusinessLogic.LimitedTreeSet;
import BusinessLogic.Month;
import BusinessLogic.Year;


class DateOrderingIntegrationTest {

	@Test
	void testDayOrdering() {
		TreeSet<Day> days = new TreeSet<>();
		days.add(new Day(15));
		days.add(new Day(1));
		days.add(new Day(10));
		
		Day firstDay = days.first();
		assertEquals(1, firstDay.getDate(), "days are ordered by date starting from 1");
	}
	
	@Test
	void testMonthOrdering() {
		Month month = new Month(4, 30); // April with 30 days
		// adding days out of order
		month.addDay(new Day(20));
		month.addDay(new Day(5));
		month.addDay(new Day(15));
		
		LimitedTreeSet<Day> days = month.getDays();
		assertEquals(5, days.first().getDate(), "Days should be ordered by date within the month");
	}
	
	@Test
	void testMonthDayLimit() {
		final int MAX_DAYS = 30;
		Month month = new Month (4, MAX_DAYS); // April with 30 days
		
		// trying to add more than max days
		for (int i = 1; i <= MAX_DAYS; i++) {
			month.addDay(new Day(i));
		}
		
		// Expect an IllegalStateException when adding beyond the limit
		assertThrows(IllegalStateException.class, () -> month.addDay(new Day(MAX_DAYS + 1)),
				"Adding more than the maximum number of days should throw an IllegalStateException");
	}
	
	@Test
	void testYearOrdering() {
		TreeSet<Year> years = new TreeSet<>();
		years.add(new Year(2024));
		years.add(new Year(2022));
		years.add(new Year(2023));
		
		Year firstYear = years.first();
		assertEquals(2022, firstYear.getCurrentYear(), "years should be ordered starting with the earliest");
	}

}
