package BusinessLogic;
/**
 * This cass is an exception used by the CalendarApp class when adding Year objects
 */
public class CalendarException extends Exception {
	/**
	 * Exception to be used if Calendar does not contain a specific year
	 * @param msg
	 */
	public CalendarException(String msg) {
		super(msg);
	}
	/**
	 * Exception to be used if Calendar does not contain a specific year
	 * @param msg
	 * @param cause
	 */
	public CalendarException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
