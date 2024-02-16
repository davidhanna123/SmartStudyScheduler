package newBusinessLogic;
import java.util.*;
//Abstract class that other different kinds of event will extend
public abstract class Event implements Comparable<Event>{
	protected String title;
	protected String description;
	protected int duration;
	protected Calendar startingTime;
	protected Calendar endingTime;
	

	protected Event(String title, String description, Calendar startingTime, Calendar endingTime, int duration) {
		// TODO Auto-generated constructor stub
		super();
		this.title = title;
		this.description = description;
		this.startingTime = Calendar.getInstance();
		this.startingTime.set(Calendar.MONTH, Calendar.HOUR, Calendar.MINUTE);
		this.endingTime = Calendar.getInstance();
		this.endingTime.set(Calendar.MONTH, Calendar.HOUR, Calendar.MINUTE);
		this.duration = this.startingTime;
	}
	
	public void setHomework(Homework homework) {
		this.homework = homework;
		// logic to set up the duration time based on hw's completion time
		// here ...............
	}
	
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
		// logic to set up the duration time based on assignment's completion time
		// here ...............
	}

	protected abstract String getTitle();
	
	protected abstract String getDescription();

	protected abstract Hour getStartingTime();

	protected abstract int getDuration();

	protected abstract void setTitle(String title);

	protected abstract void setDescription(String description);

	protected abstract void setStartingTime(Hour startingTime);

	protected abstract void setDuration(int duration);

	@Override
	public int compareTo(Event o) {
		// comparing startingTime 
		int compared = this.startingTime.compareTo(o.startingTime);
		if (compared != 0) {
			return compared;
		}
		
		// if startingTimes are the same, then we compare by title
		// it would prevent them from both being added to the set 
		return this.title.compareTo(o.title);
	}
	
	

}
