package Gui.resources;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;

public class ScheduleInputComponents {
	private Spinner<Integer> maxStartTime;
	private Spinner<Integer> minStartTime;
	private Spinner<Integer> duration;
	private DatePicker minDate;
	private DatePicker maxDate;

	public ScheduleInputComponents() {
		// TODO Auto-generated constructor stub
	}

	/**Constructs an input components package from the 
	 * @param maxStartTime
	 * @param minStartTime
	 * @param duration
	 * @param minDate
	 * @param maxDate
	 */
	public ScheduleInputComponents(Spinner<Integer> maxStartTime, Spinner<Integer> minStartTime,
			Spinner<Integer> duration, DatePicker minDate, DatePicker maxDate) {
		super();
		this.maxStartTime = maxStartTime;
		this.minStartTime = minStartTime;
		this.duration = duration;
		this.minDate = minDate;
		this.maxDate = maxDate;
	}

	/**
	 * Returns integer version of the maximum year value
	 * @return int
	 */
	public int getMaxYear() {
		return maxDate.getValue().getYear();
	}
	/**
	 * Returns integer version of the minimum year value
	 * @return int
	 */
	public int getMinYear() {
		return minDate.getValue().getYear();
	}
	/**
	 * Returns integer version of the maximum month value
	 * @return int
	 */
	public int getMaxMonth() {
		return maxDate.getValue().getMonthValue();
	}
	/**
	 * Returns integer version of the minimum month value
	 * @return int
	 */
	public int getMinMonth() {
		return minDate.getValue().getMonthValue();
	}
	/**
	 * Returns integer version of the maximum day value
	 * @return int
	 */
	public int getMaxDay() {
		return maxDate.getValue().getDayOfMonth();
	}
	/**
	 * Returns integer version of the minimum year value
	 * @return int
	 */
	public int getMinDay() {
		return minDate.getValue().getDayOfMonth();
	}
	/**
	 * Returns the user inputed duration of the duration integer spinner
	 * @return int
	 */
	public int getDurationInteger() {
		return duration.getValue();
	}
	/**
	 * Returns the user inputed minimum starting hour of the min starting hour integer spinner
	 * @return int
	 */
	public int getMinStartHour() {
		return minStartTime.getValue();
	}
	/**
	 * Returns the user inputed maximum starting hour of the max starting hour integer spinner
	 * @return int
	 */
	public int getMaxStartHour() {
		return maxStartTime.getValue();
	}

}
