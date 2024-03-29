//<<<<<<< HEAD
//package BusinessLogic;
//
//import java.util.TreeSet;
//
//public class Calendar {
//
//	private TreeSet<Year> years;
//	
//	public Calendar() {
//		// TODO Auto-generated constructor stub
//		this.years = new TreeSet<Year>();
//	}
//	
//	public void addYear(Year year) {
//		this.years.add(year);
//	}
//
//}
//=======
//Calendar Class for SmartStudyScheduler 
//Kamil Ginyatov 
//218715508

package BusinessLogic;


import java.sql.SQLException;
import java.util.*;

import Database.DBops;

/**
 * A class for a Calendar object. It keeps track of the years inside of a calendar and the current day, month, and year of the calendar
 * currentMonth - represents the current month that the user is viewing and not the current month in real life
 * currentYear - represents the current year that the user is viewing and not the current year in real life
 */
public class CalendarApp implements DBops{
	private TreeSet<Year> years;
	private int lastYear;
	private int currentDay;
	private int currentYear;
	private int currentMonth;
	
	/**
	 * No argument Constructor
	 */
	public CalendarApp() {
		years = new TreeSet<>();
	}
	
	/**
	 * 
	 * @return years TreeSet
	 */
	public TreeSet<Year> getYears(){
		return years;
	}
	
	/**
	 * Adds a year to the calendar
	 * @param Year
	 */
	public void addYear(Year year) {
		years.add(year);
		this.lastYear = this.years.last().getCurrentYear();
		
	}
	
	/**
	 * Adds a year along with its months and days to a calendar
	 * @param yearNum
	 */
	public void addYear(int yearNum) {
		Year year = new Year(yearNum);
		//adding the year if it is not already contained by the calendar
		if(!(this.contains(yearNum))) {
			this.addYear(year);
		}
	}
	
	/**
	 * 
	 * @param yearNumber
	 * @return Year
	 * @throws CalendarException
	 */
	public Year findYear(int yearNumber) throws CalendarException {
		for (Year year : years) {
			if (year.getCurrentYear() == yearNumber) {
				return year;
			}
		}
		throw new CalendarException("Year " + yearNumber + " not found in the calendar.");
	}
	
	/**
	 *  
	 * @param yearNumber
	 * @return Year
	 * @throws CalendarException
	 */
	public Year removeYear(int yearNumber) throws CalendarException {
		Year yearToRemove = null;
		for (Year  year : years) {
			if (year.getCurrentYear() == yearNumber) {
				yearToRemove = year;
				break;
			}
		}
		if (yearToRemove == null) {
			throw new CalendarException("Year " + yearNumber + " does not exist therefore cannot be removed");
		} else {
			years.remove(yearToRemove);
		}
		
		this.lastYear = this.years.last().getCurrentYear();
		return yearToRemove;
	}
	
	/**
	 * Returns a Day object of the specified year, month, and day numbers
	 * @param yearNum
	 * @param monthNum
	 * @param dayNum
	 * @return Day object on the inputed year, month, and day
	 * @throws DayNotFoundException
	 * @throws MonthNotFoundException
	 * @throws CalendarException
	 */
	public Day findDay(int yearNum, int monthNum, int dayNum) throws DayNotFoundException, MonthNotFoundException, CalendarException {
		Year year = this.findYear(yearNum);
		Month month = year.findMonthByNumber(monthNum);
		
		if(month.getDays().size() < dayNum) {
			throw new DayNotFoundException(month.getMonthName() + " does not contain day " + String.valueOf(dayNum));
		}else {
			return month.getDayByNumber(dayNum);
		}
	}
	
	/**
	 * Clears the years TreeSet of the Calendar object
	 */
	public void clear() {
		this.years.clear();
		this.lastYear = 0;
	}
	
	/**
	 * Gets year object of specified year number.
	 * @param yearNumber
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Year getYear(int yearNumber) throws IllegalArgumentException{
		for(Year y: this.years) {
			if (y.getCurrentYear() == yearNumber) {
				return y;
			}
		}
		throw new IllegalArgumentException("Year not found");
	}
	
	/**
	 * Sets current month of calendar
	 * @param month
	 */
	public void setCurrentMonth(int month) {
		this.currentMonth = month;
	}
	/**
	 * Sets current year of calendar
	 * @param year
	 */
	public void setCurrentYear(int year) {
		this.currentYear = year;
	}
	/**
	 * Sets current day of the calendar
	 * @param currentDay
	 */
	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}
	/**
	 * Increases the current month of the calendar
	 */
	public void incCurrentMonth() {
		this.currentMonth++;
	}
	/**
	 * Decreases the current month of the calendar
	 */
	public void decCurrentMonth() {
		this.currentMonth--;
	}
	/**
	 * Increases the current year of the calendar
	 */
	public void incCurrentYear() {
		this.currentYear++;
	}
	/**
	 * Decreases the current year of the calendar
	 */
	public void decCurrentYear() {
		this.currentYear--;
	}
	/**
	 * Returns the current year of the calendar
	 * @return currentYear
	 */
	public int getCurrentYear() {
		return currentYear;
	}
	/**
	 * Returns the current month of the calendar
	 * @return currentMonth
	 */
	public int getCurrentMonth() {
		return currentMonth;
	}
	/**
	 * Returns current day of the calendar
	 * @return currentDay
	 */
	public int getCurrentDay() {
		return currentDay;
	}

	/**
	 * Checks if a calendar contains a specific year.
	 * @param year
	 * @return
	 */
	public boolean contains(int year) {
		for(Year y : this.years) {
			if(y.getCurrentYear() == year) {
				return true;
			}
		}
		return false;
	}
	
	
}

