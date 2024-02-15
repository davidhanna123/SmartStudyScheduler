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
		Calendar dueDate = Calendar.getInstance();
		dueDate.set(2024, 01, 16);
		Date date = dueDate.getTime();
		// converting Date to LocalDate
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Assignment work = new Assignment("Assignment 1", "EECS2101", 1, localDate, "Friday"); 
		assertEquals((work.getDue()).getDayOfWeek(), "Friday" );
	}
	
	@Test
	void test2() {
		Calendar dueDate = Calendar.getInstance();
		dueDate.set(2024, 01, 16);
		Date date = dueDate.getTime();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Assignment work = new Assignment("Assignment 1", "EECS2101", 1, localDate, "Friday"); 
		assertEquals((work.getDue()).getDate(), dueDate.getTime() );
	}

}
