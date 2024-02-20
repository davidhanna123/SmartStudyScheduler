package BusinessLogic;
/**
 * An exception that will be thrown when time of a reminder is invalid
 */
public class InvalidReminderTimeException extends Exception{
	/**
	 * Constructor that takes an exception message.
	 * @param msg
	 */
	public InvalidReminderTimeException(String msg) {
		super(msg);
	}
}
