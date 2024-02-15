package BusinessLogic;
//Abstract class that other different kinds of event will extend
public abstract class Event implements Comparable<Event>{
	protected String title;
	protected String description;
	protected Hour startingTime;
	protected int duration;

	protected Event() {
		// TODO Auto-generated constructor stub
		super();
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
		return 0;
	}
	
	

}
