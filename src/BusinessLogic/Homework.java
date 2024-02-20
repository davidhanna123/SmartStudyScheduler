package BusinessLogic;

//Homework Class for SmartStudyScheduler
//Jonah Ottini 
//218945030 

/** 
 * 
 * Class for the Homework object. 
 * 
 */
public class Homework {
	protected String work; 
	protected String course; 
	protected Hour completionTime = new Hour();
	
	/**
	 * Empty Constructor
	 */
	public Homework() {}
	
	/**
	 * Base Constructor
	 * @param work
	 * @param course
	 * @param hour
	 */
	public Homework(String work, String course, Hour hour) {
		super();
		this.work = work;
		this.course = course;
		this.completionTime = hour; 
	}
	
	/**
	 * Constructor using Hour class parameters
	 * @param work
	 * @param course
	 * @param hour
	 */
	public Homework(String work, String course, int hour) {
		super();
		this.work = work;
		this.course = course;
		this.setCompletionTime(hour);
	}
	
	/**
	 * Constructor using Hour class parameters
	 * @param work
	 * @param course
	 * @param hour
	 * @param min
	 */
	public Homework(String work, String course, int hour, int min) {
		super();
		this.work = work;
		this.course = course;
		this.setCompletionTime(hour, min);
	} 
	
	/**
	 * 
	 * @return name of Homework object
	 */
	public String getWork() {
		return work;
	}
	/**
	 * Sets name of Homework object
	 * @param work
	 */
	public void setWork(String work) {
		this.work = work;
	}
	/**
	 * 
	 * @return course code
	 */
	public String getCourse() {
		return course;
	}
	/**
	 * Sets course code of Homework object
	 * @param course
	 */
	public void setCourse(String course) {
		this.course = course;
	}
		
	/**
	 * 
	 * @return time to complete 
	 */
	public Hour getCompletionTime() {
		return completionTime;
	}
	
	/**
	 * Base completion time setter
	 * @param hour
	 */
	public void setCompletionTime(Hour hour) {
		this.completionTime = hour; 
	} 
	
	/**
	 * Set completion time using Hour parameters
	 * @param hour
	 */
	public void setCompletionTime(int hour) {
		completionTime.setTime(hour);
	} 
	
	/**
	 * Set completion time using Hour parameters
	 * @param hour
	 * @param min
	 */
	public void setCompletionTime(int hour, int min) {
		completionTime.setTime(hour);
		completionTime.setMinuteModifier(min);
	}

	/**
	 * toString function that prints all parameters of Homework object
	 */
	@Override
	public String toString() {
		return "Homework [work=" + work + ", course=" + course + ", completionTime=" + completionTime + "]";
	} 
	
}
