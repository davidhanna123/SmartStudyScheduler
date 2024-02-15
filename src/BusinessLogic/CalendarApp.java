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
	int lastYear;
	
	public CalendarApp() {
		years = new TreeSet<>();
	}
	
	public TreeSet<Year> getYears(){
		return years;
	}
	
	public void addYear(Year year) {
		years.add(year);
		this.lastYear = this.years.last().getCurrentYear();
	}
	
	// find year
	public Year findYear(int yearNumber) throws CalendarException {
		for (Year year : years) {
			if (year.getCurrentYear() == yearNumber) {
				return year;
			}
		}
		throw new CalendarException("Year " + yearNumber + " not found in the calendar.");
	}
	
	// remove year
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
	
	public void clear() {
		this.years.clear();
		this.lastYear = 0;
	}
	
	public static void main(String[] args) {
		// code here
	}
}
//>>>>>>> refs/remotes/origin/master
