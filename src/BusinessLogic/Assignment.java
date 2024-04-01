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
	 * toString function that prints all parameters of Assignment object 
	 */
	@Override
	public String toString() {
		return "Assignment [Task:" + work + ", Course Code:" + course + ", Time to complete:" + completionTime + ", due:" + dueDate + "]";
	} 
	
}
