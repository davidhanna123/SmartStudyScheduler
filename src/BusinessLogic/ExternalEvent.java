package BusinessLogic;
//External event not related to school*
public class ExternalEvent extends Event{
	private String eventName;
	private String eventLink;
	private String location;
	private String organizer;

	public ExternalEvent() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hour getStartingTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String getEventName() {
		return eventName;
	}

	public String getEventLink() {
		return eventLink;
	}

	public String getLocation() {
		return location;
	}

	public String getOrganizer() {
		return organizer;
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStartingTime(Hour startingTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDuration(int duration) {
		// TODO Auto-generated method stub
		
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setEventLink(String eventLink) {
		this.eventLink = eventLink;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	
}
