//Day Class for SmartStudyScheduler 
//Kamil Ginyatov
//218715508
package BusinessLogic;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import Database.Database;
/**
 * Day class that represents a day of the month. Events are contained by this class.
 */
public class Day implements Comparable<Day>{
	private int date; // using localDate as it has richer API for date operations
	private String dayOfWeek;
	private TreeSet<Hour> hours;
	private TreeSet<Event> events;
	int month;
	int year;
	
	
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
		
		TreeSet<Hour> hours = new TreeSet<>();
		
		for(int k = 1; k <=24; k++) {
			hours.add(new Hour(k, 0.0));
		}
	}
	
	/**
	 * Alternative constructor for a day that keeps track of which month and which year it is in
	 * @param date
	 * @param month
	 * @param year
	 */
	public Day(int date, int month, int year) {
		super();
		this.date = date;
		this.month = month;
		this.year = year;
		this.hours = new TreeSet<>();
		this.events = new TreeSet<>();
		
		TreeSet<Hour> hours = new TreeSet<>();
		
		for(int k = 1; k <=24; k++) {
			hours.add(new Hour(k, 0.0, date, month, year)); 
		}
	}
	
	/**
	 * Adding an event to a specific Day
	 * @param event
	 * @return boolean: true is returned if the event is added. If the event is not added, an exception is thrown...false is never returned by this method.
	 * @throws EventOverlapException
	 */
	public boolean addEvent(Event event) throws EventOverlapException{
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
		return true;
	}
	/**
	 * Checks if an event can be added to a day or not. It does not actually add the event, it just returns a boolean indicating whether or not it can be added.
	 * @param event
	 * @return boolean: true is returned if the event can be added, false if it can not (example: there is an event overlap at the specified event time)
	 * @throws EventOverlapException
	 */
	public boolean checkEventAddable(Event event){
		if(!(this.events.isEmpty())) {
			for(Event e: events) {
				if(event.startingTime.getTime() >= e.startingTime.getTime() && event.startingTime.getTime() < (e.startingTime.getTime() + e.duration)) {
					return false;
				}
				if(e.startingTime.getTime() >= event.startingTime.getTime() && e.startingTime.getTime() < (event.startingTime.getTime() + event.duration)) {
					return false;
				}
			}
		}
		return true;
	}
	//
	public void AddRepeatingEvent(Event event, int repeat) throws EventOverlapException {
		
		for (int i =1; i < repeat; i++) {
			LocalDate incrementedDate = event.getDate().plusDays(7*i);
			
			Event event1 = new NonRepeatingEvent();
			
			event1.title = event.getTitle();
			event1.description = event.getDescription();
			event1.startingTime =event.getStartingTime();
			event1.duration = event.getDuration();
			//event1.date = incrementedDate;
			//Event event1 = new NonRepeatingEvent();
			event1.SetDate(incrementedDate); 
			addEvent(event);
			
		}
	}
	
	/**
	 * Removes event from the Day object's events TreeSet
	 * @param event
	 * @return removed event
	 */
	public boolean removeEvent(Event event) {
		return events.remove(event);
	}
	
//	/**
//	 * Removes all occurences of a certain event in 
//	 * @param event
//	 * @return amount of events removed
//	 */
//	public int removeAll(Event event) {
//		int amountRemoved = 0;
//		for(Event e : this.events) {
//			if (e.equals(event)){
//				removeEvent(e);
//				amountRemoved ++;
//			}
//		}
//		return amountRemoved;
//	}
	
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
