package BusinessLogic;

import java.time.LocalDate;
import java.util.*;

//Assingment subclass for SmartStudyScheduler
//Jonah Ottini 
//218945030 

/**
 * Class for Assignment object 
 * Subclass of Homework that add a due date parameter
 */
public class Assignment extends Homework {
	private Day due = new Day(); 
	
	/**
	 * Empty Constructor
	 */
	public Assignment() {}

	/**
	 * Constructor with min
	 * @param work
	 * @param course
	 * @param hour
	 * @param min
	 * @param due
	 */
	public Assignment(String work, String course, int hour, int min, Day due) {
		super(work, course, hour, min);
		this.setDue(due);
	}

	/**
	 * Base Constructor 
	 * @param work
	 * @param course
	 * @param hour
	 * @param due
	 */
	public Assignment(String work, String course, int hour, Day due) {
		super(work, course, hour);
		this.setDue(due);
	}
	
	/**
	 * Constructor with min and Day parameters
	 * @param work
	 * @param course
	 * @param hour
	 * @param min
	 * @param day
	 * @param dayOfWeek
	 */
	public Assignment(String work, String course, int hour, int min, int day, String dayOfWeek) {
		super(work, course, hour, min);
		this.setDue(day, dayOfWeek);
	}

	/**
	 * Constructor with Day parameters
	 * @param work
	 * @param course
	 * @param hour
	 * @param day
	 * @param dayOfWeek
	 */
	public Assignment(String work, String course, int hour, int day, String dayOfWeek) {
		super(work, course, hour);
		this.setDue(day, dayOfWeek);
	}

	/**
	 * 
	 * @return due date
	 */
	public Day getDue() {
		return due;
	}
	
	/**
	 * Set due date using a Day
	 * @param due
	 */
	public void setDue(Day due) {
		this.due = due; 
	}

	/**
	 * Set due date manually 
	 * @param day
	 * @param dayOfWeek
	 */
	public void setDue(int day, String dayOfWeek) {
		due.setDate(day);
		due.setDayOfWeek(dayOfWeek);
	}

	/**
	 * toString function that prints all parameters of Assignment object 
	 */
	@Override
	public String toString() {
		return "Homework [Task:" + work + ", Course Code:" + course + ", Time to complete:" + completionTime + ", due:" + due + "]";
	} 
	
}
