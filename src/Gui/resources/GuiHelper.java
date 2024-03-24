package Gui.resources;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import BusinessLogic.CalendarApp;
import BusinessLogic.Day;
import BusinessLogic.Hour;
import BusinessLogic.Month;
import BusinessLogic.Year;
import BusinessLogic.Reminders;

public class GuiHelper {

	static CalendarApp calendar = new CalendarApp();
	static final List<Reminders> remindersList = new ArrayList<>();
	static String monthStartingDay;
	static Month monthNow;
	
	public static void initialize() {
		
    	LocalDate date = LocalDate.now();
    	calendar = new CalendarApp();
    	calendar.addYear(date.getYear());

    	try {
			monthNow = calendar.getYear(date.getYear()).findMonthByNumber(date.getMonthValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	LocalDate firstDayOfMonth = LocalDate.of(date.getYear(), date.getMonthValue(), 1);
    	DayOfWeek dayOfWeekEnum = firstDayOfMonth.getDayOfWeek();
        // Convert the DayOfWeek enum to a string
        monthStartingDay = dayOfWeekEnum.toString();
       
		
		Year year = new Year(date.getYear());
		calendar.addYear(year);
		
		calendar.setCurrentYear(date.getYear());
		calendar.setCurrentMonth(date.getMonthValue());
		
	}
	
	
	// calling this when a reminder is added to an event
	public static void addReminder(Reminders reminder) {
		remindersList.add(reminder);
	}
	
	// getting all the reminders
	public static List<Reminders> getReminders(){
		return new ArrayList<>(remindersList);
	}
	
	//calendar getter
	public static CalendarApp getCalendar() {
		return calendar;
	}


	public static String getMonthStartingDay() {
		return monthStartingDay;
	}


	public static Month getMonthNow() {
		return monthNow;
	}


	public static void setMonthStartingDay(String monthStartingDay) {
		GuiHelper.monthStartingDay = monthStartingDay;
	}


	public static void setMonthNow(Month monthNow) {
		GuiHelper.monthNow = monthNow;
	}
	
	
}
