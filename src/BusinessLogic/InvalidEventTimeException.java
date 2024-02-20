package BusinessLogic;

public class InvalidEventTimeException extends Exception {
	public InvalidEventTimeException(String msg) {
		super(msg);
	}
}
