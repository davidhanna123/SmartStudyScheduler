package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import BusinessLogic.Assignment;
import BusinessLogic.Day;
import BusinessLogic.Homework;

import java.util.*;
import java.time.LocalDate;
import java.time.ZoneId;

class Assignment_Test {

	@Test
	void test() {
		int date = 16;
		Assignment work = new Assignment("Assignment 1", "EECS2101", 1, date, "Friday"); 
		assertEquals((work.getDue()).getDayOfWeek(), "Friday" );
	}
	
	@Test
	void test2() {
		int date = 16;
		Assignment work = new Assignment("Assignment 1", "EECS2101", 1, date, "Friday"); 
		assertEquals((work.getDue()).getDate(), date);
	}
}
