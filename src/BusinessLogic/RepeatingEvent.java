package BusinessLogic;
//Repeating event(like reoccuring labs, homeworks, assignments etc)*
public class RepeatingEvent extends Event{
	private String repeatRate;
	private int repeatGapDay;
	private int repeatGapYear;
	private Day endRepeatDay;
	private Month endRepeatMonth;
	private Year endRepeatYear;

	public RepeatingEvent() {
		// TODO Auto-generated constructor stub
		super();
	}

	public void AddRepeatingEvent(int repeat) {
		for (int i =0; i < repeat; i++) {
		
		}
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
	
	

}
