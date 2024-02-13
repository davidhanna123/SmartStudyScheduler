//Month Class for SmartStudyScheduler 
//Kamil Ginyatov 
//218715508
package BusinessLogic;


import java.util.*;

public class Month implements Comparable<Month> {
    private String monthName;
    private int numOfDays;
    private TreeSet<Day> days;

    public Month() {
        // Initialize days TreeSet or any other initialization needed
        this.days = new TreeSet<>();
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public TreeSet<Day> getDays() {
        return days;
    }

    public void setDays(TreeSet<Day> days) {
        this.days = days;
    }

    @Override
    public int compareTo(Month other) {
        return Integer.compare(this.numOfDays, other.getNumOfDays());
    }
}