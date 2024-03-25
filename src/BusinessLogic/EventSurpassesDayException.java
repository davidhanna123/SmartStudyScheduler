package BusinessLogic;
/**
 * An exception that will be thrown if the starting time of an event is not on the same day as the ending time of an event
 */
public class EventSurpassesDayException extends Exception {
	/**
	 * No argument constructor 
	 */
	public EventSurpassesDayException() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor with desired error message
	 * @param message
	 */
	public EventSurpassesDayException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
