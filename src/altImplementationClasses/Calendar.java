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

package altImplementationClasses;

import java.util.*;

import BusinessLogic.CalendarException;
import BusinessLogic.Year;

public class Calendar {
	private TreeSet<Year> years;
	
	public Calendar() {
		years = new TreeSet<>();
	}
	
	public TreeSet<Year> getYears(){
		return years;
	}
	
	public void addYear(Year year) {
		years.add(year);
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
		return yearToRemove;
	}
	
	public static void main(String[] args) {
		// code here
	}
}
//>>>>>>> refs/remotes/origin/master
