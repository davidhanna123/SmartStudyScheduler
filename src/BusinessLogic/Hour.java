//Hour Class for SmartStudyScheduler 
//Kamil Ginyatov
//218715508
package BusinessLogic;


import java.util.*;

public class Hour implements Comparable<Hour> {
	private int time;
	private double minuteModifier;
	
	public Hour() {}
	
	public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getMinuteModifier() {
        return minuteModifier;
    }

    public void setMinuteModifier(double minuteModifier) {
        this.minuteModifier = minuteModifier;
    }

    @Override
    public int compareTo(Hour other) {
        return Integer.compare(this.time, other.getTime());
    }
}
