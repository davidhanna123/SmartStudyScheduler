package BusinessLogic;

import java.time.LocalDate;
import java.util.Objects;

//
/**
 * 1Abstract class that other different kinds of event will extend. Parent abstract class of ExternalEvent, NonRepeatingEvent, Extracurricular, and NonRepeatingEvent
 */
public abstract class Event implements Comparable<Event>{
	private int id;
	protected String title;
	protected String description;
	protected Hour startingTime;
	protected int duration;
	public LocalDate date;
	
	protected Homework homework;
	protected Assignment assignment; 

	/**
	 * Constructor
	 * @param title
	 * @param description
	 * @param startingTime
	 * @param duration
	 */
	protected Event(int id, String title, String description, Hour startingTime, int duration, LocalDate date) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.startingTime = startingTime;
		this.duration = duration;
		this.date = date;
	}
	/**
	 * No argument constructor for testing
	 */
	public Event() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Sets up event using fields of Homework object
	 * @param homework
	 */
	public void setHomework(Homework homework) {
		this.homework = homework;
		this.title = this.homework.getWork();
		this.description = this.homework.getCourse();
		this.duration = this.homework.getCompletionTime();
		
	}
	/**
	 * Sets up event using fields of Assignment object
	 * @param assignment
	 */
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
		// logic to set up the duration time based on assignment's completion time
		this.setHomework(assignment);
		this.date = this.assignment.getDue();
	}
	
	/**
	 * Creates Homework object using Event fields
	 */
	public void createHomework() { 
		this.homework = new Homework(this.title, this.description, this.duration);
	}
	
	/**
	 * Creates Assignment object using Event fields
	 */
	public void createAssignment() { 
		this.assignment = new Assignment(this.title, this.description, this.duration, this.date);
	}
	
	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return Event title
	 */
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}
	/**
	 * 
	 * @return Event Description
	 */
	public String getDescription() {

		return this.description;
	}
	/**
	 * 
	 * @return event starting Hour object
	 */
	protected abstract Hour getStartingTime();
	/**
	 * 
	 * @return event Duration(integer)
	 */
	protected abstract int getDuration();
	/**
	 * Sets event title
	 * @param title
	 */
	protected abstract void setTitle(String title);
	/**
	 * Sets event description
	 * @param description
	 */
	protected abstract void setDescription(String description);
	/**
	 * Sets event starting time
	 * @param startingTime
	 */
	protected abstract void setStartingTime(Hour startingTime);
	/**
	 * Sets event duration
	 * @param duration
	 */
	protected abstract void setDuration(int duration);
	
	public void SetDate(LocalDate date) {
		this.date =date;
	}
	//@Override
	public LocalDate getDate() {
		return date;
	}
	/**
	 * Compares events based on their starting time. See the compareTo method of the Hour class for more details.
	 */
	@Override
	public int compareTo(Event o) {
	    if (this.startingTime == null || o.startingTime == null) {
	        if (this.startingTime == null && o.startingTime == null) {
	            // Both starting times are null then comparing titles 
	        } else if (this.startingTime == null) {
	            return -1; 
	        } else {
	            return 1; 
	        }
	    } else {
	        // Compare non null starting times
	        int compared = this.startingTime.compareTo(o.startingTime);
	        if (compared != 0) {
	            return compared;
	        }
	    }

	    // If starting times are the same or both are null then compare by title
	    if (this.title == null || o.title == null) {
	        if (this.title == null && o.title == null) {
	            return 0; // Both titles are null, consider equal
	        } else if (this.title == null) {
	            return -1; 
	        } else {
	            return 1; 
	        }
	    }
	    // Compare non null titles
	    return this.title.compareTo(o.title);
	}
	
	@Override 
	public int hashCode() {
		return Objects.hash(title, startingTime);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return Objects.equals(date, other.date)
				&& Objects.equals(description, other.description) && duration == other.duration
				&& id == other.id
				&& Objects.equals(startingTime.getTime(), other.startingTime.getTime()) && Objects.equals(title, other.title);
	}
}
