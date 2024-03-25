package Testing.UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BusinessLogic.Homework;
import BusinessLogic.Hour;

class Homework_Test {

	@Test
	void test() {
		Homework task = new Homework("Math Problems", "MATH2000", 1); 
		assertEquals(task.getCourse(), "MATH2000");
		
	}
	
	@Test
	void test2() {
		int time = 1;
		Homework task = new Homework("Math Problems", "MATH2000", time); 
		assertEquals(task.getCompletionTime(), 1);
		
	
	}
	
	@Test
	void test3() {
		String taskName = "Math Problems";
		Homework task = new Homework(taskName, "MATH2000", 1); 
		assertEquals(task.getWork(),taskName);
		
	}

}
