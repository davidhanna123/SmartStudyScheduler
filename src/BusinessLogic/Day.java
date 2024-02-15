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
	
	// default constructor
	public Day() {}
	
	
	public Day(LocalDate date) {
		super();
		this.date = LocalDate.now();
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
	public Event findEventByTitle(String title) {
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
	
	//Yadon added this. Kamil can remove it but we might need it.
	public void addHour(Hour hour) {
		this.hours.add(hour);
	}
	
	// list all of the events for the day
	public List<Event> listEvents(){
		return new ArrayList<>(events);
	}
	
	// checking the availability (time slot availability)
	public boolean isTimeSlotAvailable(Hour startingHour, int duration) {
		// TODO
		return false;
	}
	
	// Update an event
	public boolean updateAnEvent(String title, Event updateEvent) {
		// TODO
		return false;
	}


	@Override
	public String toString() {
		return dayOfWeek + ", " + date; 
	}
	
	
}
