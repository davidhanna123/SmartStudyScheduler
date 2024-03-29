//Hour Class for SmartStudyScheduler 
//Kamil Ginyatov
//218715508
package BusinessLogic;


import java.util.*;

/**
 * Hour class that has an integer called time which represents the time of day from 0 to 24 and a minute modifier that represents the minute of that hour
 */
public class Hour implements Comparable<Hour> {
	private int time;
	private double minuteModifier;
	private int day;
	private int month;
	private int year;
	
	/**
	 * No argument constructor
	 */
	public Hour() {}
	
	
	/**
	 * Hour constructor with parameters
	 * @param time
	 * @param minuteModifier
	 */
	public Hour(int time, double minuteModifier) {
		super();
		this.time = time;
		this.minuteModifier = minuteModifier;
	}
	
	public Hour(int time, double minuteModifier, int day, int month, int year) {
		super();
		this.time = time;
		this.minuteModifier = minuteModifier;
		this.year = year;
		this.day = day;
		this.month = month;
	}
	/**
	 * 
	 * @return
	 */
	public int getTime() {
        return time;
    }
	/**
	 * Sets the time (hour) of the day.
	 * 
	 * @param time The time (hour) to set.
	 * @throws IllegalArgumentException If the provided time is not within the valid range of 0 to 23.
	 */
    public void setTime(int time) {
        // setting the hour ensuring that it is in the 0-23 range
    	if (time >= 0 && time < 24) {
    		this.time = time;
    	} else {
    		throw new IllegalArgumentException("Hour range must be from 0 to 23");
    	}
    }
    /**
     * Retrieves the minute modifier.
     * 
     * @return The minute modifier.
     */
    public double getMinuteModifier() {
        return minuteModifier;
    }
    /**
     * Sets the minute modifier.
     * 
     * @param minuteModifier The minute modifier to set.
     * @throws IllegalArgumentException If the provided minute modifier is not within the valid range of 0.0 to 59.9.
     */
    public void setMinuteModifier(double minuteModifier) {
    	// setting the minute ensuring that it is in the 0.0 - 59.9.. range
    	if(minuteModifier >= 0.0 && minuteModifier < 60.0) {
    		this.minuteModifier = minuteModifier;
    	} else {
    		throw new IllegalArgumentException("Minutes range must be between 0-59");
    	}
    }
    /**
     * Compares this Hour object with another Hour object for order.
     * 
     * <p>
     * This method compares the time fields first. If they are not equal, it returns the result
     * of that comparison. If they are equal, it uses {@link Double#compare} to compare the
     * minuteModifier fields.
     * </p>
     * 
     * @param other The Hour object to be compared.
     * @return A negative integer, zero, or a positive integer as this Hour object is less than,
     *         equal to, or greater than the specified Hour object.
     */
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


    /**
     * Provides String version of the object. Format:  time + ":" + minuteModifier
     */
	@Override
	public String toString() {
		return time + ":" + minuteModifier;
	}
	/**
	 * Generates a hashcode for the hour object
	 */
	@Override
	public int hashCode() {
		return Objects.hash(day, minuteModifier, month, time, year);
	}
	/**
	 * Establishes equality based on hour and minute of the hour object
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hour other = (Hour) obj;
		return Double.doubleToLongBits(minuteModifier) == Double.doubleToLongBits(other.minuteModifier)
				&& time == other.time;
	}
	
    
    
}
