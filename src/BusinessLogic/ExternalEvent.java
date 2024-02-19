package BusinessLogic;
//External event not related to school
public class ExternalEvent extends Event{
	private String eventName;
	private String eventLink;
	private String location;
	private String organizer;

	/**
	 * No argument constructor
	 */
	public ExternalEvent() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * Returns event title.
	 */
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}

	/**
	 * Returns event description.
	 */
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	/**
	 * Returns event starting time.
	 */
	@Override
	public Hour getStartingTime() {
		// TODO Auto-generated method stub
		return this.startingTime;
	}

	/**
	 * Returns event duration.
	 */
	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return this.duration;
	}
	
	/**
	 * 
	 * @return event name
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * 
	 * @return event Link
	 */
	public String getEventLink() {
		return eventLink;
	}

	/**
	 * 
	 * @return event location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 
	 * @return event organizer
	 */
	public String getOrganizer() {
		return organizer;
	}

	/**
	 * sets event title
	 * @param title
	 */
	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * sets event title
	 * @param title
	 */
	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * sets event starting time
	 * @param starting time
	 */
	@Override
	public void setStartingTime(Hour startingTime) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * sets duration of event
	 * @param duration
	 */
	@Override
	public void setDuration(int duration) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * sets event name
	 * @param eventName
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * sets event link
	 * @param eventLink
	 */
	public void setEventLink(String eventLink) {
		this.eventLink = eventLink;
	}

	/**
	 * sets event location
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * sets event organizer
	 * @param organizer
	 */
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	
}
