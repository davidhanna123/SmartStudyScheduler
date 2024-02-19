package BusinessLogic;
/**
 * *A subclass of the Events abstract class. It is for events that are school related, but not related to course work.
 */
public class Extracurricular extends Event{
	private String location;
	private String organizer;

	/**
	 * No argument constructor
	 */
	public Extracurricular() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	/**
	 * @return title
	 */
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}

	/**
	 * @param event description
	 */
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	/**
	 * @return event starting time
	 */
	@Override
	public Hour getStartingTime() {
		// TODO Auto-generated method stub
		return this.startingTime;
	}

	/**
	 * @return event duration
	 */
	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return this.duration;
	}
	/**
	 * returns event location for Extracurricular event(a location on campus for example)
	 * @return location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * returns event organizer's name
	 * @return organizer
	 */
	public String getOrganizer() {
		return organizer;
	}
	/**
	 * Sets event title
	 * @param title
	 */
	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
		
	}
	/**
	 * Sets event description
	 * @param description
	 */
	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		this.description = description;
		
	}
	/**
	 * Sets event starting time
	 * @param startingTime
	 */
	@Override
	public void setStartingTime(Hour startingTime) {
		// TODO Auto-generated method stub
		this.startingTime = startingTime;
	}
	/**
	 * Sets event duration
	 * @param duration
	 */
	@Override
	public void setDuration(int duration) {
		// TODO Auto-generated method stub
		this.duration = duration;
		
	}
	/**
	 * sets the location of the event(a location on campus for example)
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * sets the name of the event organizer
	 * @param organizer
	 */
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	
	

}
