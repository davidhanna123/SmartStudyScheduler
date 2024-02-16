package BusinessLogic;

import java.sql.Date;

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
	
	public void AddRepeatingEvent(Event event, int repeat, Date startDate, int hour, int min) {
		for (int i =0; i < repeat; i++) {
			Day.addEvent(event);
		}
	}
}
