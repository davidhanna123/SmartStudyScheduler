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
import Database.DBops;

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
	 * 
	 * @param Year
	 */
	public void addYear(Year year) {
		years.add(year);
		this.lastYear = this.years.last().getCurrentYear();
		
	}
	
	
	public void addYear(int yearNum) {
		Year year = new Year(yearNum);
		this.addYear(year);
		
		Month[] months = new Month[12];
		Day[] days = new Day[31];
 		Hour[] hours = new Hour[24];
		
		
		for(int i = 1; i<=12; i++) {
			months[i-1] = new Month(i, yearNum);
			for(int j = 1; j<=31; j++) {
				days[j-1] = new Day(j);//we should make day have an integer between 0 and 32 and make a constructor for that. Up to Kamil though.
				for(int k = 1; k <=24; k++) {
					hours[k-1] = new Hour(k, 0.0);
					days[j-1].addHour(hours[k-1]);
				}
				try {
					months[i-1].addDay(days[j-1]);
				}catch(Exception e) {	
					//purposefully unhandled because we want it to just not add an extra day
				}	
			}
			year.addMonth(months[i-1]);
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
	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
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
	
	public int getCurrentDay() {
		return currentDay;
	}

	
	public boolean contains(int year) {
		for(Year y : this.years) {
			if(y.getCurrentYear() == year) {
				return true;
			}
		}
		return false;
	}
	
	
}

