//Year Class for SmartStudyScheduler 
//Kamil Ginyatov 
//218715508
package BusinessLogic;

import java.util.*;

public class Year implements Comparable<Year> {
    private int currentYear;
    private TreeSet<Month> months;

    public Year() {
        // Initialize months TreeSet or any other initialization needed
        this.months = new TreeSet<>();
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public TreeSet<Month> getMonths() {
        return months;
    }

    public void setMonths(TreeSet<Month> months) {
        this.months = months;
    }

    @Override
    public int compareTo(Year other) {
        return Integer.compare(this.currentYear, other.getCurrentYear());
    }
}
