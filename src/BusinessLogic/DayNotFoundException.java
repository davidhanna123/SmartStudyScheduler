package BusinessLogic;
/**
 * An exception that gets thrown if a month does not have a specified day
 */
public class DayNotFoundException extends Exception {

	/**
	 * No argument constructor
	 */
	public DayNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * A constructor that takes an exception message
	 * @param message
	 */
	public DayNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
