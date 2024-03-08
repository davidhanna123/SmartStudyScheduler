package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import BusinessLogic.Assignment;
import BusinessLogic.Day;
import BusinessLogic.Homework;

import java.util.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;

class Assignment_Test {

	@Test
	void test() {
		LocalDate date = LocalDate.of(2024, 2, 16);
		Assignment work = new Assignment("Assignment 1", "EECS2101", 1, date); 
		assertEquals((work.getDue()).getDayOfMonth(), 16 );
	}
	
	@Test
	void test2() {
		LocalDate date = LocalDate.of(2024, 2, 16);
		Assignment work = new Assignment("Assignment 1", "EECS2101", 1, date); 
		assertEquals((work.getDue()), date);
	}
	
	@Test
	void test3() {
		LocalDate date = LocalDate.of(2024, 2, 16);
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		Assignment work = new Assignment("Assignment 1", "EECS2101", 1, date); 
		assertEquals((work.getDue()).getDayOfWeek(), dayOfWeek );
	}
}
