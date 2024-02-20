package BusinessLogic;
/**
 * An exception that will be thrown when the event time of a reminder is invalis
 */
public class InvalidEventTimeException extends Exception {
	/**
	 * Constructor that takes an exception message.
	 * @param msg
	 */
	public InvalidEventTimeException(String msg) {
		super(msg);
	}
}
