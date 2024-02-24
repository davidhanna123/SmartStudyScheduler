package Database;

import BusinessLogic.CalendarApp;
import BusinessLogic.Day;
import BusinessLogic.Hour;
import BusinessLogic.Month;
import BusinessLogic.Year;

public class StubDatabase {

	static CalendarApp calendar = new CalendarApp();
	
	static void initialize() {
		
		Year year = new Year(2024);
		calendar.addYear(year);
		Month[] months = new Month[12];
		Day[] days = new Day[30];
 		Hour[] hours = new Hour[24];
		
		for(int i = 1; i<=12; i++) {
			months[i-1] = new Month(i, year);
			for(int j = 1; j<=30; j++) {
				days[j-1] = new Day(j);//we should make day have an integer between 0 and 32 and make a constructor for that. Up to Kamil though.
				for(int k = 1; k <=24; k++) {
					hours[k-1] = new Hour(k, 0.0);
					days[j-1].addHour(hours[k-1]);
				}
				try {
					months[i-1].addDay(days[j-1]);
				}catch(Exception e) {	
			}
		}
			year.addMonth(months[i-1]);
		}
	}
	
}
