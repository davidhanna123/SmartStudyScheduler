//Hour Class for SmartStudyScheduler 
//Kamil Ginyatov
//218715508
package BusinessLogic;


import java.util.*;

public class Hour implements Comparable<Hour> {
	private int time;
	private double minuteModifier;
	
	public Hour() {}
	
	
	
	public Hour(int time, double minuteModifier) {
		super();
		this.time = time;
		this.minuteModifier = minuteModifier;
	}



	public int getTime() {
        return time;
    }

    public void setTime(int time) {
        // setting the hour ensuring that it is in the 0-23 range
    	if (time >= 0 && time < 24) {
    		this.time = time;
    	} else {
    		throw new IllegalArgumentException("Hour range must be from 0 to 23");
    	}
    }

    public double getMinuteModifier() {
        return minuteModifier;
    }

    public void setMinuteModifier(double minuteModifier) {
    	// setting the minute ensuring that it is in the 0.0 - 59.9.. range
    	if(minuteModifier >= 0.0 && minuteModifier < 60.0) {
    		this.minuteModifier = minuteModifier;
    	} else {
    		throw new IllegalArgumentException("Minutes range must be between 0-59");
    	}
    }

    @Override
    public int compareTo(Hour other) {
    	/* <compares the time fields first,  if they are not equal returns the result
    	 * of that comparison>
    	 * <if equal, it uses Double.compare to compare minuteModifier fields>
    	 */ 
        int hourComparison = Integer.compare(this.time, other.getTime());
        if(hourComparison != 0) {
        	return hourComparison;
        }
        return Double.compare(this.minuteModifier, other.getMinuteModifier());
    }
}
