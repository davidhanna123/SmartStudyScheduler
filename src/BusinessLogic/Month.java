//Month Class for SmartStudyScheduler 
//Kamil Ginyatov 
//218715508
package BusinessLogic;


import java.sql.SQLException;
import java.util.*;
import BusinessLogic.Day;

import Database.Database;
/**
 * Month class that contains Day objects in a limited tree set. Each Year object should have 12 months.
 */
public class Month implements Comparable<Month> {
    private String monthName;
    private int monthNumber; // months position number in the year
    private int numOfDays;
    private LimitedTreeSet<Day> days;
    private int year;
    
    /**
     * Constructs a Month object with the specified month number and year.
     * 
     * <p>
     * This constructor initializes the number of days in the month based on the month number and year provided.
     * </p>
     * 
     * @param monthNumber The number representing the month (1 for January, 2 for February, etc.).
     * @param year The Year object representing the year associated with this month.
     */
    public Month(int monthNumber, int year) {
    	
    	switch(monthNumber) {
    	case 1:
    		this.numOfDays = 31;
    		this.days = new LimitedTreeSet<>(this.numOfDays);
    		this.monthName = "January";
    		break;
    	case 2:
    		if((year%4 == 0 && year%100 != 0) || year%400 == 0) {
    			this.numOfDays = 29;
    		}else {
    			this.numOfDays = 28;
    		}
    		this.days = new LimitedTreeSet<>(this.numOfDays);
    		this.monthName = "February";
    		break;
    	case 3:
    		this.numOfDays = 31;
    		this.days = new LimitedTreeSet<>(this.numOfDays);
    		this.monthName = "March";
    		break;
    	case 4:
    		this.numOfDays = 30;
    		this.days = new LimitedTreeSet<>(this.numOfDays);
    		this.monthName = "April";
    		break;
    	case 5:
    		this.numOfDays = 31;
    		this.days = new LimitedTreeSet<>(this.numOfDays);
    		this.monthName = "May";
    		break;
    	case 6:
    		this.numOfDays = 30;
    		this.days = new LimitedTreeSet<>(this.numOfDays);
    		this.monthName = "June";
    		break;
    	case 7:
    		this.numOfDays = 31;
    		this.days = new LimitedTreeSet<>(this.numOfDays);
    		this.monthName = "July";
    		break;
    	case 8:
    		this.numOfDays = 31;
    		this.days = new LimitedTreeSet<>(this.numOfDays);
    		this.monthName = "August";
    		break;
    	case 9:
    		this.numOfDays = 30;
    		this.days = new LimitedTreeSet<>(this.numOfDays);
    		this.monthName = "September";
    		break;
    	case 10:
    		this.numOfDays = 31;
    		this.days = new LimitedTreeSet<>(this.numOfDays);
    		this.monthName = "October";
    		break;
    	case 11:
    		this.numOfDays = 30;
    		this.days = new LimitedTreeSet<>(this.numOfDays);
    		this.monthName = "November";
    		break;
    	case 12:
    		this.numOfDays = 31;
    		this.days = new LimitedTreeSet<>(this.numOfDays);
    		this.monthName = "December";
    		break;
    	}
    	this.year = year;
		this.monthNumber = monthNumber;
		
		LimitedTreeSet<Day> daysA = new LimitedTreeSet<>(this.numOfDays);
		
		for(int j = 1; j<=31; j++) {
			try {
				daysA.add(new Day(j, monthNumber, year));
			}catch(Exception e) {	
				//purposefully unhandled because we want it to just not add an extra day
			}
		}
		
		this.days = daysA;
	}
    /**
     * Retrieves the name of the month.
     * 
     * @return The name of the month.
     */
    public String getMonthName() {
        return monthName;
    }
    /**
     * Sets the name of the month.
     * 
     * @param monthName The name of the month to set.
     */
    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }
    /**
     * Retrieves the number representing the month.
     * 
     * @return The number representing the month.
     */
    public int getMonthNumber() {
    	return monthNumber;
    }
    /**
     * Sets the number representing the month.
     * 
     * @param monthNumber The number representing the month to set.
     */
    public void setMonthNumber(int monthNumber) {
    	this.monthNumber = monthNumber;
    }
    /**
     * Retrieves the number of days in the month.
     * 
     * @return The number of days in the month.
     */
    public int getNumOfDays() {
        return numOfDays;
    }
    /**
     * Sets the number of days in the month.
     * 
     * @param numOfDays The number of days in the month to set.
     */
    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }
    /**
     * Retrieves the set of days in the month.
     * 
     * @return The set of days in the month.
     */
    public LimitedTreeSet<Day> getDays() {
        return days;
    }
    /**
     * Sets the set of days in the month.
     * 
     * @param days The set of days in the month to set.
     */
    public void setDays(LimitedTreeSet<Day> days) {
        this.days = days;
    }
    /**
     * Adds a day to the set of days in the month.
     * 
     * @param day The day to add.
     */
    public void addDay(Day day) {
    	this.days.add(day);
    }
    /**
     * Returns a Day object whose day of month corresponds to the dayNum input 
     * @param dayNum: an integer that is the day number of Day object to be returned 
     * @return Day object whose day number corresponds to the specified dayNum input integer
     */
    public Day getDayByNumber(int dayNum) {
    	Day day = null;
    	
    	for(Day d : this.getDays()) {
    		if(d.getDate() == dayNum)
    			day = d;
    	}
    	return day;
    }
    /**
     * Compares this Month object with another Month object for order.
     * 
     * <p>
     * This method compares the months based on their position in the year.
     * </p>
     * 
     * @param other The Month object to be compared.
     * @return A negative integer, zero, or a positive integer as this Month object is less than,
     *         equal to, or greater than the specified Month object.
     */
    @Override
    public int compareTo(Month other) {
    	// Compare based on the month's position in the year
        return Integer.compare(this.monthNumber, other.getMonthNumber());
    }
}