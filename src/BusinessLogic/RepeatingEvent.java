package BusinessLogic;


import java.time.LocalDate;
import java.util.*;

//Repeating event(like reoccuring labs, homeworks, assignments etc)*
public abstract class RepeatingEvent extends Event{
	private String repeatRate;
	private int repeatGapDay;
	private int repeatGapYear;
	private Day endRepeatDay;
	private Month endRepeatMonth;
	private Year endRepeatYear;

	//public RepeatingEvent() {
		// TODO Auto-generated constructor stub
		//super();
	//}
	
	public void AddRepeatingEvent(Event event, int repeat, LocalDate startDate, int hour, int min) {
		for (int i =0; i < repeat; i++) {
			LocalDate incrementedDate = startDate.plusDays(7*i);
			//add event (..,..,incrementedDate.getMonth.getvalue(), incrementedDate.getDay.getvalue(),incrementedDate.getYear.getvalue());
			//Day.addEvent(event);
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

	@Override
	public void setHomework(Homework homework) {
		// TODO Auto-generated method stub
		super.setHomework(homework);
	}

	@Override
	public void setAssignment(Assignment assignment) {
		// TODO Auto-generated method stub
		super.setAssignment(assignment);
	}
}
