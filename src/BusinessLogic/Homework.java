package BusinessLogic;

//Homework Class for SmartStudyScheduler
//Jonah Ottini 
//218945030 

public class Homework {
	protected String work; 
	protected String course; 
	protected Hour completionTime = new Hour();
	
	//Empty Constructor
	public Homework() {}
	
	//Base Constructor
	public Homework(String work, String course, Hour hour) {
		super();
		this.work = work;
		this.course = course;
		this.completionTime = hour; 
	}
	
	//Constructor using Hour parameters
	public Homework(String work, String course, int hour) {
		super();
		this.work = work;
		this.course = course;
		this.setCompletionTime(hour);
	}
	
	//Constructor using Hour parameters
	public Homework(String work, String course, int hour, int min) {
		super();
		this.work = work;
		this.course = course;
		this.setCompletionTime(hour, min);
	} 
	
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Hour getCompletionTime() {
		return completionTime;
	}
	
	//Base completion time setter
	public void setCompletionTime(Hour hour) {
		this.completionTime = hour; 
	} 
	
	//Set completion time using Hour parameters
	public void setCompletionTime(int hour) {
		completionTime.setTime(hour);
	} 
	
	//Set completion time using Hour parameters
	public void setCompletionTime(int hour, int min) {
		completionTime.setTime(hour);
		completionTime.setMinuteModifier(min);
	}

	@Override
	public String toString() {
		return "Homework [work=" + work + ", course=" + course + ", completionTime=" + completionTime + "]";
	} 
	
}
