package BusinessLogic;

import java.time.LocalDate;

//Assingment subclass for SmartStudyScheduler
//Jonah Ottini 
//218945030 

/**
 * Class for Assignment object 
 * Subclass of Homework that add a due date parameter
 */
public class Assignment extends Homework {
	private LocalDate dueDate; 
	
	/**
	 * Empty Constructor
	 */
	public Assignment() {}

	/**
	 * Base Constructor 
	 * @param work
	 * @param course
	 * @param duration
	 * @param due
	 */
	public Assignment(String work, String course, int duration, LocalDate due) {
		super(work, course, duration);
		this.dueDate = due;
	}

	/**
	 * Constructor with LocalDate parameters
	 * @param work
	 * @param course
	 * @param duration
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 */
	public Assignment(String work, String course, int duration, int year, int month, int dayOfMonth) {
		super(work, course, duration);
		this.setDue(year, month, dayOfMonth);
	}

	/**
	 * 
	 * @return due date
	 */
	public LocalDate getDue() {
		return this.dueDate;
	}
	
	/**
	 * Set due date using a LocalDate object
	 * @param due
	 */
	public void setDue(LocalDate date) {
		this.dueDate = date; 
	}
	
	/**
	 * Set due date using LocalDate fields
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 */
	public void setDue(int year, int month, int dayOfMonth) {
		this.dueDate = LocalDate.of(year, month, dayOfMonth);
	}

	/**
	 * toString function that prints all parameters of Assignment object 
	 */
	@Override
	public String toString() {
		return "Homework [Task:" + work + ", Course Code:" + course + ", Time to complete:" + completionTime + ", due:" + dueDate + "]";
	} 
	
}
