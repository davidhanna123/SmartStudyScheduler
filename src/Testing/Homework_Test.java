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
		Hour time = new Hour(); 
		time.setTime(1);
		Homework task = new Homework("Math Problems", "MATH2000", time); 
		assertEquals((task.getCompletionTime()).getTime(), 1);
		
	
	}
	
	@Test
	void test3() {
		Homework task = new Homework("Math Problems", "MATH2000", 1, 30); 
		assertEquals((task.getCompletionTime()).getMinuteModifier(), 30);
		
	}

}
