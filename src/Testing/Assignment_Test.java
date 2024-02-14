package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import BusinessLogic.Assignment;
import BusinessLogic.Day;
import BusinessLogic.Homework;

import java.util.*;

class Assignment_Test {

	@Test
	void test() {
		Calendar dueDate = Calendar.getInstance();
		dueDate.set(2024, 01, 16);
		Date date = dueDate.getTime();
		Assignment work = new Assignment("Assignment 1", "EECS2101", 1, date, "Friday"); 
		assertEquals((work.getDue()).getDayOfWeek(), "Friday" );
	}
	
	@Test
	void test2() {
		Calendar dueDate = Calendar.getInstance();
		dueDate.set(2024, 01, 16);
		Date date = dueDate.getTime();
		Assignment work = new Assignment("Assignment 1", "EECS2101", 1, date, "Friday"); 
		assertEquals((work.getDue()).getDate(), dueDate.getTime() );
	}

}
