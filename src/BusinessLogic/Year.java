//Year Class for SmartStudyScheduler 
//Kamil Ginyatov 
//218715508
package BusinessLogic;

import java.sql.SQLException;

import java.util.*;

import Database.Database;
/**
 * Represents a year with its associated months.
 * Implements the Comparable interface to enable comparison between years.
 */
public class Year implements Comparable<Year> {
    private int currentYear;
    private TreeSet<Month> months;

    /**
     * Constructs a Year object with the specified current year.
     * Initializes the set of months.
     * 
     * @param currentYear The current year to set.
     */
    public Year(int currentYear) {
        this.currentYear = currentYear;
        this.months = new TreeSet<>();
        
        for(int i = 1; i<=12; i++) {
			this.months.add(new Month(i, currentYear));
		}
    }
    /**
     * Retrieves the current year.
     * 
     * @return The current year.
     */
    public int getCurrentYear() {
        return currentYear;
    }
    /**
     * Sets the current year.
     * 
     * @param currentYear The current year to set.
     */
    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }
    /**
     * Retrieves the set of months in the year.
     * 
     * @return The set of months.
     */
    public TreeSet<Month> getMonths() {
        return months;
    }
    /**
     * Adds a month to the set of months in the year.
     * 
     * @param month The month to add.
     */
    public void addMonth(Month month) {
    	this.months.add(month);
    }
    /**
     * Sets the set of months in the year.
     * 
     * @param months The set of months to set.
     */
    public void setMonths(TreeSet<Month> months) {
        this.months = months;
    }
    /**
     * Compares this Year object with another Year object based on their current years.
     * 
     * @param other The Year object to compare with.
     * @return A negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Year other) {
        return Integer.compare(this.currentYear, other.getCurrentYear());
    }
    /**
     * Finds and returns the month with the specified month number.
     * 
     * @param monthNumber The number of the month to find.
     * @return The Month object with the specified month number.
     * @throws MonthNotFoundException If the specified month number is not found in the year.
     */
    public Month findMonthByNumber(int monthNumber) throws MonthNotFoundException {
    	for (Month month : months) {
    		if (month.getMonthNumber() == monthNumber) {
    			return month;
    		}
    	}
    	throw new MonthNotFoundException("Month: " + monthNumber + " not found in year " + currentYear);
    }
    

}
