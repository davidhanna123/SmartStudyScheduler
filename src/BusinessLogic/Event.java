package BusinessLogic;

import java.util.Objects;

/**
 * 1Abstract class that other different kinds of event will extend. Parent abstract class of ExternalEvent, NonRepeatingEvent, Extracurricular, and NonRepeatingEvent
 */
public abstract class Event implements Comparable<Event>{
	protected String title;
	protected String description;
	protected Hour startingTime;
	protected int duration;
	
	protected Homework homework;
	protected Assignment assignment; 

	/**
	 * Constructor
	 * @param title
	 * @param description
	 * @param startingTime
	 * @param duration
	 */
	protected Event(String title, String description, Hour startingTime, int duration) {
		// TODO Auto-generated constructor stub
		super();
		this.title = title;
		this.description = description;
		this.startingTime = startingTime;
		this.duration = duration;
	}
	/**
	 * No argument constructor for testing
	 */
	public Event() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param homework
	 */
	public void setHomework(Homework homework) {
		this.homework = homework;
		// logic to set up the duration time based on hw's completion time
		// here ...............
	}
	/**
	 * 
	 * @param assignment
	 */
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
		// logic to set up the duration time based on assignment's completion time
		// here ...............
	}
	/**
	 * 
	 * @return Event title
	 */
	protected abstract String getTitle();
	/**
	 * 
	 * @return Event Description
	 */
	protected abstract String getDescription();
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
}
