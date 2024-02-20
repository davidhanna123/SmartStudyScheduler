package BusinessLogic;
/**
 * Exception that will be thrown when the offset attribute of an instance of the Reminder class is negative.
 */
public class negativeReminderOffsetException extends Exception {
	/**
	 * Constructor that takes an exception message
	 * @param msg
	 */
	public negativeReminderOffsetException(String msg) {
		super(msg);
	}
}
