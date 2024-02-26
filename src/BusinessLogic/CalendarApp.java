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


import java.util.*;

public class CalendarApp {
	private TreeSet<Year> years;
	private int lastYear;
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
	 * 
	 * @param Year
	 */
	public void addYear(Year year) {
		years.add(year);
		this.lastYear = this.years.last().getCurrentYear();
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
	 * Clears the years TreeSet of the Calendar object
	 */
	public void clear() {
		this.years.clear();
		this.lastYear = 0;
	}
	
	public Year getYear(int yearNumber) throws IllegalArgumentException{
		for(Year y: this.years) {
			if (y.getCurrentYear() == yearNumber) {
				return y;
			}
		}
		throw new IllegalArgumentException("Year not found");
	}
	
	public void setCurrentMonth(int month) {
		this.currentMonth = month;
	}
	public void setCurrentYear(int year) {
		this.currentYear = year;
	}
	
	public void incCurrentMonth() {
		this.currentMonth++;
	}
	public void decCurrentMonth() {
		this.currentMonth--;
	}
	public void incCurrentYear() {
		this.currentYear++;
	}
	public void decCurrentYear() {
		this.currentYear--;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public int getCurrentMonth() {
		return currentMonth;
	}
	
	
	
}

