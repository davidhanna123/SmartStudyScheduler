package BusinessLogic;
/**
 ** Exception to be thrown if event getting added to a Day is overlapping with another event happening at the same time.
 */
public class EventOverlapException extends Exception {
	/**
	 * No argument constructor
	 */
	public EventOverlapException() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor with an error message
	 * @param message
	 */
	public EventOverlapException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
