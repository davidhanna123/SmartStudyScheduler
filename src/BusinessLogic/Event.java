package BusinessLogic;
//Abstract class that other different kinds of event will extend
public abstract class Event implements Comparable<Event>{
	protected String title;
	protected String description;
	protected Hour startingTime;
	protected int duration;
	
	
	protected Homework homework;
	protected Assignment assignment; 

	protected Event(String title, String description, Hour startingTime, int duration) {
		// TODO Auto-generated constructor stub
		super();
		this.title = title;
		this.description = description;
		this.startingTime = startingTime;
		this.duration = duration;
	}
	

	public Event() {
		// TODO Auto-generated constructor stub
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
