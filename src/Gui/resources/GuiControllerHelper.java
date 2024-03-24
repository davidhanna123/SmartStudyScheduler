package Gui.resources;

import java.time.LocalDate;

import BusinessLogic.CalendarApp;
import BusinessLogic.Day;
import BusinessLogic.Hour;
import BusinessLogic.Month;
import BusinessLogic.NonRepeatingEvent;
import BusinessLogic.Year;

public interface GuiControllerHelper {

	public static void scheduleYearsRange(CalendarApp calendar, ScheduleInputComponents inputs, ScheduleOutputComponents outputs) {
		try {
			boolean added = false;//a boolean indicating if an event can be added
			for(Year y : calendar.getYears()) {
				int maxYear = inputs.getMaxYear();//maximum allowable year for this event to be on
    			int minYear = inputs.getMinYear();//minimum allowable year for this event to be on
    			//checking if it can be added in the specified year range
    			if(y.getCurrentYear() >= minYear && y.getCurrentYear() <= maxYear) {
    				for(Month m : y.getMonths()) {
    					for(Day d : m.getDays()) {
    						int minStartHour = inputs.getMinStartHour();//maximum allowable Hour for this event to be on
    						int maxStartHour = inputs.getMaxStartHour();//minimum allowable Hour for this event to be on
    						int eventDuration = inputs.getDurationInteger();
    						//checking if it can be added in the specified hour range
    						for(int i = minStartHour; i <= maxStartHour; i++) {
    							LocalDate newEventDate = LocalDate.of(y.getCurrentYear(), m.getMonthNumber(), d.getDate());
    							added = d.checkEventAddable(new NonRepeatingEvent("", "", new Hour(i, 0), eventDuration, newEventDate));//checking if the event can be added at the specified time for the current loop using a method in the Day class
    							if(added == true) {
    								//setting the values of the gui components to be seen
    								outputs.setEventDate(newEventDate);
    								outputs.setStartingTimeSpinner(i);
    								outputs.setEndingTimeSpinner(i+eventDuration);
    								break;//breaking out of the loop since event has been scheduled
    							}
    						}
    						if(added == true) {
								break;//breaking out of the loop since event has been scheduled
							} 
    					}
    					if(added == true) {
							break;//breaking out of the loop since event has been scheduled
						} 
    				}
    			}
    			if(added == true) {
					break;//breaking out of the loop since event has been scheduled
				} 
			}
			
			if(added == true) {
				outputs.closeWindow();//closing the window if it has been scheduled
    		}else {
    			outputs.setErrorText("This event can not be scheduled in the given time gap.\nPlease complete the event is less time or choose a different timeframe.");//printing an error if event can not be scheduled
    		}
		}catch(NumberFormatException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void scheduleMonthsRange(CalendarApp calendar, ScheduleInputComponents inputs, ScheduleOutputComponents outputs) {
		try {
			boolean added = false;//a boolean indicating if an event can be added
			for(Year y : calendar.getYears()) {
				int maxYear = inputs.getMaxYear();//maximum allowable year for this event to be on
    			int minYear = inputs.getMinYear();//minimum allowable year for this event to be on
    			//checking if it can be added in the specified year range
    			if(y.getCurrentYear() >= minYear && y.getCurrentYear() <= maxYear) {
    				for(Month m : y.getMonths()) {
    					int maxMonth = inputs.getMaxMonth();//maximum allowable month for this event to be on
            			int minMonth = inputs.getMinMonth();//minimum allowable month for this event to be on
            			//checking if it can be added in the specified month range
            			if(m.getMonthNumber() >= minMonth && m.getMonthNumber() <= maxMonth) {
            				for(Day d : m.getDays()) {
        						int minStartHour = inputs.getMinStartHour();//maximum allowable Hour for this event to be on
        						int maxStartHour = inputs.getMaxStartHour();//minimum allowable Hour for this event to be on
        						int eventDuration = inputs.getDurationInteger();
        						//checking if it can be added in the specified hour range
        						for(int i = minStartHour; i <= maxStartHour; i++) {
        							LocalDate newEventDate = LocalDate.of(y.getCurrentYear(), m.getMonthNumber(), d.getDate());
        							added = d.checkEventAddable(new NonRepeatingEvent("", "", new Hour(i, 0), eventDuration, newEventDate));//checking if the event can be added at the specified time for the current loop using a method in the Day class
        							if(added == true) {
        								outputs.setEventDate(newEventDate);
        								outputs.setStartingTimeSpinner(i);
        								outputs.setEndingTimeSpinner(i+eventDuration);
        								break;//breaking out of the loop since event has been scheduled
        							}
        						}
        						if(added == true) {
    								break;//breaking out of the loop since event has been scheduled
    							}  
        					}
            			}
    				}
    				if(added == true) {
						break;//breaking out of the loop since event has been scheduled
					} 
    			}
    			if(added == true) {
					break;//breaking out of the loop since event has been scheduled
				} 
			}
			
			if(added == true) {
				outputs.closeWindow();//closing the window if it has been scheduled
    		}else {
    			outputs.setErrorText("This event can not be scheduled in the given time gap.\nPlease complete the event is less time or choose a different timeframe.");//printing an error if event can not be scheduled
        	}
		}catch(NumberFormatException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void scheduleDaysRange(CalendarApp calendar, ScheduleInputComponents inputs, ScheduleOutputComponents outputs) {
		try {
			boolean added = false;//a boolean indicating if an event can be added
    		for(Year y : calendar.getYears()) {
    			int maxYear = inputs.getMaxYear();//maximum allowable year for this event to be on
    			int minYear = inputs.getMinYear();//minimum allowable year for this event to be on
    			//checking if it can be added in the specified year range
    			if(y.getCurrentYear() >= minYear && y.getCurrentYear() <= maxYear) {
    				for(Month m : y.getMonths()) {
    					int maxMonth = inputs.getMaxMonth();//maximum allowable month for this event to be on
            			int minMonth = inputs.getMinMonth();//minimum allowable month for this event to be on
            			//checking if it can be added in the specified month range
            			if(m.getMonthNumber() >= minMonth && m.getMonthNumber() <= maxMonth) {
            				int maxDay = inputs.getMaxDay();//maximum allowable Day for this event to be on
                			int minDay = inputs.getMinDay();//minimum allowable Day for this event to be on
                			//checking if it can be added in the specified day range
                			for(Day d : m.getDays()) {
            					if(d.getDate() >= minDay && d.getDate() <= maxDay) {
            						int minStartHour = inputs.getMinStartHour();//maximum allowable Hour for this event to be on
            						int maxStartHour = inputs.getMaxStartHour();//minimum allowable Hour for this event to be on
            						int eventDuration = inputs.getDurationInteger();
            						//checking if it can be added in the specified hour range
            						for(int i = minStartHour; i <= maxStartHour; i++) {
            							LocalDate newEventDate = LocalDate.of(y.getCurrentYear(), m.getMonthNumber(), d.getDate());
            							added = d.checkEventAddable(new NonRepeatingEvent("", "", new Hour(i, 0), eventDuration, newEventDate));//checking if the event can be added at the specified time for the current loop using a method in the Day class
            							if(added == true) {
            								outputs.setEventDate(newEventDate);
            								outputs.setStartingTimeSpinner(i);
            								outputs.setEndingTimeSpinner(i+eventDuration);
            								break;//breaking out of the loop since event has been scheduled
            							}
            						}
            					}
            					if(added == true) {
    								break;//breaking out of the loop since event has been scheduled
    							}
            				}
            			}
            			if(added == true) {
							break;//breaking out of the loop since event has been scheduled
						} 
        			}
    			}
    			if(added == true) {
					break;//breaking out of the loop since event has been scheduled
				}
    		}

    		if(added == true) {
    			outputs.closeWindow();//closing the window if it has been scheduled
    		}else {
    			outputs.setErrorText("This event can not be scheduled in the given time gap.\nPlease complete the event is less time or choose a different timeframe.");//printing an error if event can not be scheduled
        	}  
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
