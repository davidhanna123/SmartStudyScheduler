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
	
	public void AddRepeatingEvent(Event event, int repeat) {
		for (int i =0; i < repeat; i++) {
			
		}
	}
}
