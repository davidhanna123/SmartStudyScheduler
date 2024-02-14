package BusinessLogic;

public class CalendarException extends Exception {
	public CalendarException(String msg) {
		super(msg);
	}
	// constructor 
	public CalendarException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
