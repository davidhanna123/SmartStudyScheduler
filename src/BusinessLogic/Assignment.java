package BusinessLogic;

import java.time.LocalDate;
import java.util.*;

//Assingment subclass for SmartStudyScheduler
//Jonah Ottini 
//218945030 

public class Assignment extends Homework {
	private Day due = new Day(); 
	
	//Empty Constructor
	public Assignment() {}

	//Constructor with min
	public Assignment(String work, String course, int hour, int min, Day due) {
		super(work, course, hour, min);
		this.setDue(due);
	}

	//Base Constructor 
	public Assignment(String work, String course, int hour, Day due) {
		super(work, course, hour);
		this.setDue(due);
	}
	
	//Constructor with min and Day parameters
	public Assignment(String work, String course, int hour, int min, LocalDate day, String dayOfWeek) {
		super(work, course, hour, min);
		this.setDue(day, dayOfWeek);
	}

	//Constructor with Day parameters
	public Assignment(String work, String course, int hour, LocalDate day, String dayOfWeek) {
		super(work, course, hour);
		this.setDue(day, dayOfWeek);
	}

	public Day getDue() {
		return due;
	}
	
	//Set due date using a Day
	public void setDue(Day due) {
		this.due = due; 
	}

	//Set due date manually 
	public void setDue(LocalDate day, String dayOfWeek) {
		due.setDate(day);
		due.setDayOfWeek(dayOfWeek);
	}

	@Override
	public String toString() {
		return "Homework [Task:" + work + ", Course Code:" + course + ", Time to complete:" + completionTime + ", due:" + due + "]";
	} 
	
}
