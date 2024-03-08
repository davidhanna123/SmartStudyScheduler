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
	protected int completionTime;
	
	/**
	 * Empty Constructor
	 */
	public Homework() {}
	
	/**
	 * Constructor using Hour class parameters
	 * @param work
	 * @param course
	 * @param duration
	 */
	public Homework(String work, String course, int duration) {
		super();
		this.work = work;
		this.course = course;
		this.completionTime = duration;
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
	public int getCompletionTime() {
		return completionTime;
	}
	
	/**
	 * Set completion time using Hour parameters
	 * @param duration
	 */
	public void setCompletionTime(int duration) {
		this.completionTime = duration;
	} 

	/**
	 * toString function that prints all parameters of Homework object
	 */
	@Override
	public String toString() {
		return "Homework [work=" + work + ", course=" + course + ", completionTime=" + completionTime + "]";
	} 
	
}
