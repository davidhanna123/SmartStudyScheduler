package BusinessLogic;

import java.time.LocalDate;

/**
 * A non-repeating event that is a subclass of the Event abstract class.
 * This event can be added to a Day by using methods in the Day class.
 */
public class NonRepeatingEvent extends Event{

	/**
     * Constructs a new NonRepeatingEvent object.
     */
	public NonRepeatingEvent() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Non repeating event constructor that takes an event title, description, starting time as an hour, duration as an integer, and date
	 * @param title
	 * @param description
	 * @param startingTime
	 * @param duration
	 * @param date
	 */ 
	public NonRepeatingEvent(String title, String description, Hour startingTime, int duration, LocalDate date) {
		// TODO Auto-generated constructor stub
		super();
		this.title = title;
		this.description = description;
		this.startingTime = startingTime;
	    this.duration = duration;
		this.date = date;
	}

	/**
     * Retrieves the title of the non-repeating event.
     * 
     * @return The title of the event.
     */
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}
	 /**
     * Retrieves the description of the non-repeating event.
     * 
     * @return The description of the event.
     */
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}
	/**
     * Retrieves the starting time of the non-repeating event.
     * 
     * @return The starting time of the event.
     */
	@Override
	public Hour getStartingTime() {
		// TODO Auto-generated method stub
		return this.startingTime;
	}
	/**
     * Retrieves the duration of the non-repeating event.
     * 
     * @return The duration of the event.
     */
	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return this.duration;
	}
	/**
     * Sets the title of the non-repeating event.
     * 
     * @param title The title to be set for the event.
     */
	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
		
	}
	/**
     * Sets the description of the non-repeating event.
     * 
     * @param description The description to be set for the event.
     */
	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		this.description = description;
		
	}
	/**
     * Sets the starting time of the non-repeating event.
     * 
     * @param startingTime The starting time to be set for the event.
     */
	@Override
	public void setStartingTime(Hour startingTime) {
		// TODO Auto-generated method stub
		this.startingTime = startingTime;
	}
	/**
     * Sets the duration of the non-repeating event.
     * 
     * @param duration The duration to be set for the event.
     */
	@Override
	public void setDuration(int duration) {
		// TODO Auto-generated method stub
		this.duration = duration;
		
	}
	/**
     * Sets the homework associated with the non-repeating event.
     * 
     * @param homework The homework to be associated with the event.
     */
	@Override
	public void setHomework(Homework homework) {
		// TODO Auto-generated method stub
		super.setHomework(homework);
	}
	/**
     * Sets the assignment associated with the non-repeating event.
     * 
     * @param assignment The assignment to be associated with the event.
     */
	@Override
	public void setAssignment(Assignment assignment) {
		// TODO Auto-generated method stub
		super.setAssignment(assignment);
	}
	/**
	 * Returns a string version of a non repeating event object
	 */
	@Override
	public String toString() {
		return "NonRepeatingEvent [title=" + title + ", description=" + description + ", startingTime=" + startingTime
				+ ", duration=" + duration + ", date=" + date + "]";
	}
	
}
