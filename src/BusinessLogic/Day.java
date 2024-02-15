//Day Class for SmartStudyScheduler 
//Kamil Ginyatov
//218715508
package BusinessLogic;

import java.time.LocalDate;
import java.util.*;

public class Day implements Comparable<Day>{
	private LocalDate date; // using localDate as it has richer API for date operations
	private String dayOfWeek;
	private TreeSet<Hour> hours;
	private TreeSet<Event> events;
	
	
	public Day() {
		this.hours = new TreeSet<>();
		this.events = new TreeSet<>();
	}
	
	// adding an event
	public void addEvent(Event event) {
		events.add(event);
	}
	
	// removing an event
	public boolean removeEvent(Event event) {
		return events.remove(event);
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
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
	
	public TreeSet<Event> getEvent(){
		return events;
	}
	
	// finding an event by title
	public Event findEvenByTitle(String title) {
		for(Event event : events) {
			if (event.getTitle().equals(title)) {
				return event;
			}
		}
		return null;
	}
	
	@Override
	public int compareTo(Day other) {
		return this.date.compareTo(other.getDate());
	}
}
