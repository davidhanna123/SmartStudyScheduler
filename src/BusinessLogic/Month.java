//Month Class for SmartStudyScheduler 
//Kamil Ginyatov 
//218715508
package BusinessLogic;


import java.util.*;

public class Month implements Comparable<Month> {
    private String monthName;
    private int monthNumber; // months position number in the year
    private int numOfDays;
    private LimitedTreeSet<Day> days;

    public Month(int maxDays) {
        // Initialize days TreeSet or any other initialization needed
        this.days = new LimitedTreeSet<Day>(maxDays);//set to max 30 by default, but can be changed
    }
    
    public Month(int monthNumber, int numOfDays) {
		this(numOfDays);
		this.monthNumber = monthNumber;
		this.numOfDays = numOfDays;
	}

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }
    
    public int getMonthNumber() {
    	return monthNumber;
    }
    
    public void setMonthNumber(int monthNumber) {
    	this.monthNumber = monthNumber;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public LimitedTreeSet<Day> getDays() {
        return days;
    }

    public void setDays(LimitedTreeSet<Day> days) {
        this.days = days;
    }
    
    public void addDay(Day day) {
    	this.days.add(day);
    }

    @Override
    public int compareTo(Month other) {
    	// Compare based on the month's position in the year
        return Integer.compare(this.monthNumber, other.getMonthNumber());
    }
}