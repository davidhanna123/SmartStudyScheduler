package BusinessLogic;

import java.util.TreeSet;

public class Calendar {

	private TreeSet<Year> years;
	
	public Calendar() {
		// TODO Auto-generated constructor stub
		this.years = new TreeSet<Year>();
	}
	
	public void addYear(Year year) {
		this.years.add(year);
	}

}
