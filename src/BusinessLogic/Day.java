//Day Class for SmartStudyScheduler 
//Kamil Ginyatov
//218715508
package BusinessLogic;

import java.time.LocalDate;
import java.util.*;

public class Day implements Comparable<Day>{
	private int date; // using localDate as it has richer API for date operations
	private String dayOfWeek;
	private TreeSet<Hour> hours;
	private TreeSet<Event> events;
	
	/**
	 * Default constructor
	 */
	public Day() {
		super();
		this.hours = new TreeSet<>();
		this.events = new TreeSet<>();
	}
	
	/**
	 * Constructor
	 * @param day of month integer
	 */
	public Day(int date) {
		super();
		this.date = date;
		this.hours = new TreeSet<>();
		this.events = new TreeSet<>();
	}
	
	/**
	 * Adds an event to the event TreeSet of a Day Object
	 * @param event
	 * @throws EventOverlapException
	 */
	public void addEvent(Event event) throws EventOverlapException{
		if(!(this.events.isEmpty())) {
			for(Event e: events) {
				if(event.startingTime.getTime() >= e.startingTime.getTime() && event.startingTime.getTime() < (e.startingTime.getTime() + e.duration)) {
					throw new EventOverlapException("Event overlaps with another");
				}
				if(e.startingTime.getTime() >= event.startingTime.getTime() && e.startingTime.getTime() < (event.startingTime.getTime() + event.duration)) {
					throw new EventOverlapException("Event overlaps with another");
				}
			}
		}
		events.add(event);
	}
	
	/**
	 * Removes event from the Day object's events TreeSet
	 * @param event
	 * @return removed event
	 */
	public boolean removeEvent(Event event) {
		return events.remove(event);
	}
	
	/**
	 * 
	 * @return day of month integer
	 */
	public int getDate() {
		return date;
	}
	
	/**
	 * sets day of month integer
	 * @param date
	 */
	public void setDate(int date) {
		this.date = date;
	}
	
	/**
	 * 
	 * @return String name of the day(Monday, Tuesday...)
	 */
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	
	/**
	 * sets String name of the day(Monday, Tuesday...)
	 * @param dayOfWeek
	 */
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
	/**
	 * 
	 * @return hours of day
	 */
	public TreeSet<Hour> getHours(){
		return hours;
	}
	
	/**
	 * 
	 * @return events of day 
	 */
	public TreeSet<Event> getEvent(){
		return events;
	}
	
	/**
	 * 
	 * @param title
	 * @return event with matching title
	 */
	public Event findEventByTitle(String title) {
		for(Event event : events) {
			if (event.getTitle().equals(title)) {
				return event;
			}
		}
		return null;
	}
	
	/**
	 * Compares two days based on their day of the month integer(between 0 and 32)
	 */
	@Override
	public int compareTo(Day other) {
		if(this.date > other.getDate()) {
			return 1;
		}else if(this.date < other.getDate()) {
			return -1;
		}else {
			return 0;
		}
	}
	
	/**
	 * 
	 * @param hour
	 */
	public void addHour(Hour hour) {
		this.hours.add(hour);
	}
	
	/**
	 * Gives an arrayList representation of the events of the day
	 * @return List<Event>
	 */
	public List<Event> listEvents(){
		return new ArrayList<>(events);
	}
	


	/**
	 * To string method: format is dayOfWeek + ", " + date
	 */
	@Override
	public String toString() {
		return dayOfWeek + ", " + date; 
	}
	
	
}
