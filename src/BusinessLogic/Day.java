//Day Class for SmartStudyScheduler 
//Kamil Ginyatov
//218715508
package BusinessLogic;

import java.util.*;

public class Day implements Comparable<Day>{
	private Date date;
	private String dayOfWeek;
	private TreeSet<Hour> hours;
	
	public Day() {
		this.hours = new TreeSet<>();
	}
	
	
	
	public Day(Date date) {
		super();
		this.date = date;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
	public TreeSet<Hour> getHours(){
		return hours;
	}
	
	@Override
	public int compareTo(Day other) {
		return this.date.compareTo(other.getDate());
	}
	
	//Yadon added this. Kamil can remove it but we might need it.
	public void addHour(Hour hour) {
		this.hours.add(hour);
	}
}
