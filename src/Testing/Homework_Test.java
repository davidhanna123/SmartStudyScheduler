package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BusinessLogic.Homework;
import BusinessLogic.Hour;

class Homework_Test {

	@Test
	void test() {
		Homework task = new Homework("Math Problems", "MATH2000", 1, 30); 
		assertEquals(task.getCourse(), "MATH2000");
		
	}
	
	@Test
	void test2() {
		Homework task = new Homework("Math Problems", "MATH2000", 1); 
		Hour time = new Hour(); 
		time.setTime(1);
		
		//Hour.compareTo returns int instead of boolean
//		assertTrue((time.compareTo(task.getCompletionTime())));
	
	}
	
	@Test
	void test3() {
		Homework task = new Homework("Math Problems", "MATH2000", 1, 30); 
		assertEquals((task.getCompletionTime()).getMinuteModifier(), 30);
		
	}

}
