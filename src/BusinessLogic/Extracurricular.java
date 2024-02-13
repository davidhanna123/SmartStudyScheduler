package BusinessLogic;

public class Extracurricular extends Event{
	private String location;
	private String organizer;

	public Extracurricular() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	@Override
	public Hour getStartingTime() {
		// TODO Auto-generated method stub
		return this.startingTime;
	}

	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return this.duration;
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
		this.title = title;
		
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		this.description = description;
		
	}

	@Override
	public void setStartingTime(Hour startingTime) {
		// TODO Auto-generated method stub
		this.startingTime = startingTime;
	}

	@Override
	public void setDuration(int duration) {
		// TODO Auto-generated method stub
		this.duration = duration;
		
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	
	

}
