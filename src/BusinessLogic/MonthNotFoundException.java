package BusinessLogic;
/**
 * Month not found exception that will be called when a year des not have a specified month.
 */
public class MonthNotFoundException extends Exception{
	/**
	 * Constructs a new MonthNotFoundException with the specified detail message.
	 * 
	 * @param msg The detail message (which is saved for later retrieval by the getMessage() method).
	 */
	public MonthNotFoundException(String msg) {
		super(msg);
	}
}
