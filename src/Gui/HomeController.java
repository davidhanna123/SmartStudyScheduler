package Gui;

import java.sql.Date;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import BusinessLogic.*;
import BusinessLogic.Event;
import Database.*;
import Database.DBops;
import Database.Database;
import Gui.resources.GuiControllerHelper;
import Gui.resources.GuiHelper;
import Gui.resources.ScheduleInputComponents;
import Gui.resources.ScheduleOutputComponents;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class HomeController implements GuiControllerHelper{

    @FXML
    private Button removeEventButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button signOutButton;
    @FXML
    private MenuItem action1;
    @FXML
    private MenuItem action2;
    @FXML
    private VBox remindersVBox;
    
    @FXML
    private Label day1;

    @FXML
    private Label day2;

    @FXML
    private Label day3;

    @FXML
    private Label day4;

    @FXML
    private Label day5;

    @FXML
    private Label day6;

    @FXML
    private Label day7;

    @FXML
    private Label day8;

    @FXML
    private Label day9;

    @FXML
    private Label day10;

    @FXML
    private Label day11;

    @FXML
    private Label day12;

    @FXML
    private Label day13;

    @FXML
    private Label day14;

    @FXML
    private Label day15;

    @FXML
    private Label day16;

    @FXML
    private Label day17;

    @FXML
    private Label day18;

    @FXML
    private Label day19;

    @FXML
    private Label day20;

    @FXML
    private Label day21;

    @FXML
    private Label day22;

    @FXML
    private Label day23;

    @FXML
    private Label day24;

    @FXML
    private Label day25;

    @FXML
    private Label day26;

    @FXML
    private Label day27;

    @FXML
    private Label day28;

    @FXML
    private Label day29;

    @FXML
    private Label day30;

    @FXML
    private Label day31;

    @FXML
    private Label day32;

    @FXML
    private Label day33;

    @FXML
    private Label day34;

    @FXML
    private Label day35;
    
    @FXML
    private Label day36;

    @FXML
    private Label day37;

    @FXML
    private Label day38;

    @FXML
    private Label day39;

    @FXML
    private Label day40;

    @FXML
    private Label day41;

    @FXML
    private Label day42;
    
    @FXML
    private Label monthName;
    
    @FXML
    private Label yearLabel;
    
    @FXML
    private Pane detailPane;

    @FXML
    private Button addEventButton;
    
    @FXML
    private Button seeReminders;
    
    
    List<Reminders> remindersList = new ArrayList<>();
    public static CalendarApp calendar;
    
    //StubDatabase stub;
    public HomeController() {
    	super();
    	
    	//getting a calendar with the current year for all business logic operations
    	GuiHelper.initialize();
    	calendar = GuiHelper.getCalendar();
    	//adding all of the users events to this calendar
    	addEventsToCalendar(calendar);
        
//    	updateDayLabels(GuiHelper.getMonthStartingDay(), GuiHelper.getMonthNow());
//    	yearLabel.setText(String.valueOf(LocalDate.now().getYear()));
    }
    /**
     * Helper method for adding all the events in a database to a current calendar
     * @param calendar
     */
    private static void addEventsToCalendar(CalendarApp calendar) {
    	//fetching all the events currently saved in the database
    	TreeSet<Event> events = null;
    	try {
			events = DBops.getAllEventDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //adding every year that there is an event for to prepare for operations later
    	for(Event e: events) {
    		calendar.addYear(e.getDate().getYear());
    	}

    	//adding each event in the database to its corresponding day in the calendar
    	for(Event e: events) {
    		Year eventYear = null;
    		try {
				eventYear = calendar.findYear(e.getDate().getYear());
			} catch (CalendarException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

    		//getting the month that the event is on
    		Month eventMonth = null;	
    		try {
    			eventMonth = eventYear.findMonthByNumber(e.getDate().getMonthValue());
    		} catch (MonthNotFoundException e1) {
    			e1.printStackTrace();
    		}

    		Day eventDay = null;
    		eventDay = eventMonth.getDayByNumber(e.getDate().getDayOfMonth());

    		try {
				eventDay.addEvent(e);
				System.out.println(e.toString());
			} catch (EventOverlapException e1) {
				e1.printStackTrace();
			} catch (EventSurpassesDayException e2) {
				e2.printStackTrace();
			}
    	}
    }
    
  //list of labels for months that start on a monday
    public List<Label> initializeMon() {
    	List<Label> dayList = new ArrayList<>();
        dayList.add(day2);
        dayList.add(day3);
        dayList.add(day4);
        dayList.add(day5);
        dayList.add(day6);
        dayList.add(day7);
        dayList.add(day8);
        dayList.add(day9);
        dayList.add(day10);
        dayList.add(day11);
        dayList.add(day12);
        dayList.add(day13);
        dayList.add(day14);
        dayList.add(day15);
        dayList.add(day16);
        dayList.add(day17);
        dayList.add(day18);
        dayList.add(day19);
        dayList.add(day20);
        dayList.add(day21);
        dayList.add(day22);
        dayList.add(day23);
        dayList.add(day24);
        dayList.add(day25);
        dayList.add(day26);
        dayList.add(day27);
        dayList.add(day28);
        dayList.add(day29);
        dayList.add(day30);
        dayList.add(day31);
        dayList.add(day32);
        dayList.add(day33);
        dayList.add(day34);
        dayList.add(day35);
        dayList.add(day36);
        dayList.add(day37);
        dayList.add(day38);
        dayList.add(day39);
        dayList.add(day40);
        dayList.add(day41);
        dayList.add(day42);
        
        return dayList;
    }
  //list of labels for months that start on a tuesday
    public List<Label> initializeTue() {
    	List<Label> dayList = new ArrayList<>();
        
        dayList.add(day3);
        dayList.add(day4);
        dayList.add(day5);
        dayList.add(day6);
        dayList.add(day7);
        dayList.add(day8);
        dayList.add(day9);
        dayList.add(day10);
        dayList.add(day11);
        dayList.add(day12);
        dayList.add(day13);
        dayList.add(day14);
        dayList.add(day15);
        dayList.add(day16);
        dayList.add(day17);
        dayList.add(day18);
        dayList.add(day19);
        dayList.add(day20);
        dayList.add(day21);
        dayList.add(day22);
        dayList.add(day23);
        dayList.add(day24);
        dayList.add(day25);
        dayList.add(day26);
        dayList.add(day27);
        dayList.add(day28);
        dayList.add(day29);
        dayList.add(day30);
        dayList.add(day31);
        dayList.add(day32);
        dayList.add(day33);
        dayList.add(day34);
        dayList.add(day35);
        dayList.add(day36);
        dayList.add(day37);
        dayList.add(day38);
        dayList.add(day39);
        dayList.add(day40);
        dayList.add(day41);
        dayList.add(day42);
        
        return dayList;
    }
  //list of labels for months that start on a wednesday
    public List<Label> initializeWed() {
    	List<Label> dayList = new ArrayList<>();
    
        dayList.add(day4);
        dayList.add(day5);
        dayList.add(day6);
        dayList.add(day7);
        dayList.add(day8);
        dayList.add(day9);
        dayList.add(day10);
        dayList.add(day11);
        dayList.add(day12);
        dayList.add(day13);
        dayList.add(day14);
        dayList.add(day15);
        dayList.add(day16);
        dayList.add(day17);
        dayList.add(day18);
        dayList.add(day19);
        dayList.add(day20);
        dayList.add(day21);
        dayList.add(day22);
        dayList.add(day23);
        dayList.add(day24);
        dayList.add(day25);
        dayList.add(day26);
        dayList.add(day27);
        dayList.add(day28);
        dayList.add(day29);
        dayList.add(day30);
        dayList.add(day31);
        dayList.add(day32);
        dayList.add(day33);
        dayList.add(day34);
        dayList.add(day35);
        dayList.add(day36);
        dayList.add(day37);
        dayList.add(day38);
        dayList.add(day39);
        dayList.add(day40);
        dayList.add(day41);
        dayList.add(day42);
        
        return dayList;
    }
  //list of labels for months that start on a thursday
    public List<Label> initializeThur() {
    	List<Label> dayList = new ArrayList<>();
        
        dayList.add(day5);
        dayList.add(day6);
        dayList.add(day7);
        dayList.add(day8);
        dayList.add(day9);
        dayList.add(day10);
        dayList.add(day11);
        dayList.add(day12);
        dayList.add(day13);
        dayList.add(day14);
        dayList.add(day15);
        dayList.add(day16);
        dayList.add(day17);
        dayList.add(day18);
        dayList.add(day19);
        dayList.add(day20);
        dayList.add(day21);
        dayList.add(day22);
        dayList.add(day23);
        dayList.add(day24);
        dayList.add(day25);
        dayList.add(day26);
        dayList.add(day27);
        dayList.add(day28);
        dayList.add(day29);
        dayList.add(day30);
        dayList.add(day31);
        dayList.add(day32);
        dayList.add(day33);
        dayList.add(day34);
        dayList.add(day35);
        dayList.add(day36);
        dayList.add(day37);
        dayList.add(day38);
        dayList.add(day39);
        dayList.add(day40);
        dayList.add(day41);
        dayList.add(day42);
        
        return dayList;
    }
  //list of labels for months that start on a friday
    public List<Label> initializeFri() {
    	List<Label> dayList = new ArrayList<>();
        
        dayList.add(day6);
        dayList.add(day7);
        dayList.add(day8);
        dayList.add(day9);
        dayList.add(day10);
        dayList.add(day11);
        dayList.add(day12);
        dayList.add(day13);
        dayList.add(day14);
        dayList.add(day15);
        dayList.add(day16);
        dayList.add(day17);
        dayList.add(day18);
        dayList.add(day19);
        dayList.add(day20);
        dayList.add(day21);
        dayList.add(day22);
        dayList.add(day23);
        dayList.add(day24);
        dayList.add(day25);
        dayList.add(day26);
        dayList.add(day27);
        dayList.add(day28);
        dayList.add(day29);
        dayList.add(day30);
        dayList.add(day31);
        dayList.add(day32);
        dayList.add(day33);
        dayList.add(day34);
        dayList.add(day35);
        dayList.add(day36);
        dayList.add(day37);
        dayList.add(day38);
        dayList.add(day39);
        dayList.add(day40);
        dayList.add(day41);
        dayList.add(day42);
        
        return dayList;
    }
  //list of labels for months that start on a saturday
    public List<Label> initializeSat() {
    	List<Label> dayList = new ArrayList<>();
        dayList.add(day8);
        dayList.add(day9);
        dayList.add(day10);
        dayList.add(day11);
        dayList.add(day12);
        dayList.add(day13);
        dayList.add(day14);
        dayList.add(day15);
        dayList.add(day16);
        dayList.add(day17);
        dayList.add(day18);
        dayList.add(day19);
        dayList.add(day20);
        dayList.add(day21);
        dayList.add(day22);
        dayList.add(day23);
        dayList.add(day24);
        dayList.add(day25);
        dayList.add(day26);
        dayList.add(day27);
        dayList.add(day28);
        dayList.add(day29);
        dayList.add(day30);
        dayList.add(day31);
        dayList.add(day32);
        dayList.add(day33);
        dayList.add(day34);
        dayList.add(day35);
        dayList.add(day36);
        dayList.add(day37);
        dayList.add(day38);
        dayList.add(day39);
        dayList.add(day40);
        dayList.add(day41);
        dayList.add(day42);
        
        return dayList;
    }
  //list of labels for months that start on a sunday
    public List<Label> initializeSun() {
    	List<Label> dayList = new ArrayList<>();
    	dayList.add(day1);
        dayList.add(day2);
        dayList.add(day3);
        dayList.add(day4);
        dayList.add(day5);
        dayList.add(day6);
        dayList.add(day7);
        dayList.add(day8);
        dayList.add(day9);
        dayList.add(day10);
        dayList.add(day11);
        dayList.add(day12);
        dayList.add(day13);
        dayList.add(day14);
        dayList.add(day15);
        dayList.add(day16);
        dayList.add(day17);
        dayList.add(day18);
        dayList.add(day19);
        dayList.add(day20);
        dayList.add(day21);
        dayList.add(day22);
        dayList.add(day23);
        dayList.add(day24);
        dayList.add(day25);
        dayList.add(day26);
        dayList.add(day27);
        dayList.add(day28);
        dayList.add(day29);
        dayList.add(day30);
        dayList.add(day31);
        dayList.add(day32);
        dayList.add(day33);
        dayList.add(day34);
        dayList.add(day35);
        dayList.add(day36);
        dayList.add(day37);
        dayList.add(day38);
        dayList.add(day39);
        dayList.add(day40);
        dayList.add(day41);
        dayList.add(day42);
        
        return dayList;
    }
    

    // Implement methods for handling button actions
    @FXML
    private void addEventAction() {
        // Add logic for adding an event
    }
    
    @FXML
    private void removeEventAction() {
        // Add logic for removing an event
    }

    @FXML
    private void saveAction() {
        // Add logic for saving events
    }

    @FXML
    private void signOutAction() {
        // Add logic for signing out
    }
    
    public void nextMonth(ActionEvent e) {
    	//view next month
    }
    
    @FXML
    private void handleAction1(ActionEvent event) {
    	// adding event goes here  
    }
    
    @FXML
    private void handleAction2() {
    	showReminders();
    }
    
    
    // method to show and refresh the reminders in the VBox
    private void showReminders() {
    	remindersVBox.getChildren().clear(); // clearing previous reminders
    	List<Reminders> reminderList = GuiHelper.getReminders(); // getting reminders from stub database
    	
    	for (Reminders reminder : reminderList) {
    		Label reminderLabel = new Label(reminder.toString());
    		remindersVBox.getChildren().add(reminderLabel); // adding to the VBox
    	}
    }
    
    
    @FXML
    public void updateDayLabelsMonthIncrease() throws IllegalArgumentException, MonthNotFoundException {
    	clearDayLabels();
		
		int yearNow;
		int monthNow;
		Month month;
    	
    	if(calendar.getCurrentMonth() == 12) {
    		calendar.incCurrentYear();
    		yearNow = calendar.getCurrentYear();
    		calendar.addYear(yearNow);
        	
        	//current month and month label configurations
        	calendar.setCurrentMonth(1);
        	monthNow = calendar.getCurrentMonth();
        	
        	month = calendar.getYear(yearNow).findMonthByNumber(monthNow);
        	monthName.setText(month.getMonthName());
        	
        	//setting the year label
        	yearLabel.setText(String.valueOf(yearNow));
    	}else {
    		yearNow = calendar.getCurrentYear();
        	
        	//current month and month label configurations
        	calendar.setCurrentMonth(calendar.getCurrentMonth()+1);
        	monthNow = calendar.getCurrentMonth();
        	
        	month = calendar.getYear(yearNow).findMonthByNumber(monthNow);
        	monthName.setText(month.getMonthName());
        	
        	//setting the year label
        	yearLabel.setText(String.valueOf(yearNow));
    	}
    	
    	// Create a LocalDate object
        LocalDate date = LocalDate.of(yearNow, monthNow, 1); 
        // Get the day of the week as a DayOfWeek enum
        DayOfWeek dayOfWeekEnum = date.getDayOfWeek();
        // Convert the DayOfWeek enum to a string
        String dayOfWeek = dayOfWeekEnum.toString();
    	
    	updateDayLabels(dayOfWeek, month);
    }
    
    @FXML
    public void updateDayLabelsMonthDecrease() throws IllegalArgumentException, MonthNotFoundException {
    	clearDayLabels();
		
		int yearNow;
		int monthNow;
		Month month;
    	
    	if(calendar.getCurrentMonth() == 1) {
    		calendar.decCurrentYear();
    		yearNow = calendar.getCurrentYear();
    		calendar.addYear(yearNow);
        	
        	//current month and month label configurations
        	calendar.setCurrentMonth(12);
        	monthNow = calendar.getCurrentMonth();
        	
        	month = calendar.getYear(yearNow).findMonthByNumber(monthNow);
        	monthName.setText(month.getMonthName());
        	
        	//setting the year label
        	yearLabel.setText(String.valueOf(yearNow));
    	}else {
    		yearNow = calendar.getCurrentYear();
        	
        	//current month and month label configurations
        	calendar.setCurrentMonth(calendar.getCurrentMonth()-1);
        	monthNow = calendar.getCurrentMonth();
        	
        	month = calendar.getYear(yearNow).findMonthByNumber(monthNow);
        	monthName.setText(month.getMonthName());
        	
        	//setting the year label
        	yearLabel.setText(String.valueOf(yearNow));
    	}
    	
    	// Create a LocalDate object
        LocalDate date = LocalDate.of(yearNow, monthNow, 1); 
        // Get the day of the week as a DayOfWeek enum
        DayOfWeek dayOfWeekEnum = date.getDayOfWeek();
        // Convert the DayOfWeek enum to a string
        String dayOfWeek = dayOfWeekEnum.toString();
    	
        updateDayLabels(dayOfWeek, month);
    }
    
    //updating the calendar and the year label when the next year is selected
    @FXML
    public void updateYearLabelNext() throws IllegalArgumentException, MonthNotFoundException {
    	clearDayLabels();
		
    	int yearNow;
		int monthNow;
		Month month;
		
    	if(calendar.contains(calendar.getCurrentYear() + 1)) {
    		calendar.setCurrentYear(calendar.getCurrentYear() + 1);
    		yearNow = calendar.getCurrentYear();
    		monthNow = calendar.getCurrentMonth();
    		month = calendar.getYear(yearNow).findMonthByNumber(monthNow);
    		
    		//calendar.getYear(yearNow).findMonthByNumber(monthNow);
    		
    		// Create a LocalDate object
            LocalDate date = LocalDate.of(yearNow, monthNow, 1); 
            // Get the day of the week as a DayOfWeek enum
            DayOfWeek dayOfWeekEnum = date.getDayOfWeek();
            // Convert the DayOfWeek enum to a string
            String dayOfWeek = dayOfWeekEnum.toString();
        	
            //setting the year label
        	yearLabel.setText(String.valueOf(yearNow));
            
            int dayNow = 0;
            
            updateDayLabels(dayOfWeek, month);
    	}else {
    		calendar.addYear(calendar.getCurrentYear()+1);
    		updateYearLabelNext();
    	}
    }
    
    //updating the calendar and the year label when the last year is selected
    @FXML
    public void updateYearLabelPrev() throws IllegalArgumentException, MonthNotFoundException {
    	clearDayLabels();
		
    	int yearNow;
		int monthNow;
		Month month;
		
    	if(calendar.contains(calendar.getCurrentYear() - 1)) {
    		calendar.setCurrentYear(calendar.getCurrentYear() - 1);
    		yearNow = calendar.getCurrentYear();
    		monthNow = calendar.getCurrentMonth();
    		month = calendar.getYear(yearNow).findMonthByNumber(monthNow);
    		
    		// Create a LocalDate object
            LocalDate date = LocalDate.of(yearNow, monthNow, 1); 
            // Get the day of the week as a DayOfWeek enum
            DayOfWeek dayOfWeekEnum = date.getDayOfWeek();
            // Convert the DayOfWeek enum to a string
            String dayOfWeek = dayOfWeekEnum.toString();
        	
            //setting the year label
        	yearLabel.setText(String.valueOf(yearNow));
            
        	updateDayLabels(dayOfWeek, month);
    	}else {
    		calendar.addYear(calendar.getCurrentYear()-1);
    		updateYearLabelPrev();
    	}
    }
    
    /**
     * Updates all the day labels when a current year or month is changed on the calendar. 
     * @param dayOfWeek
     * @param month
     */
    public void updateDayLabels(String dayOfWeek, Month month) {
    	int dayNow = 0;
        
    	if(dayOfWeek.equals("MONDAY")) {
    		List<Label> dayList = initializeMon();
    		for(Day d : month.getDays()) {
    			dayList.get(dayNow).setText(String.valueOf(dayNow+1));//setting day label to a certain integer
    			dayNow++;
    		}
    	}
    	if(dayOfWeek.equals("TUESDAY")) {
    		List<Label> dayList = initializeTue();
    		for(Day d : month.getDays()) {
    			dayList.get(dayNow).setText(String.valueOf(dayNow+1));//setting day label to a certain integer
    			dayNow++;
    		}
    	}
    	if(dayOfWeek.equals("WEDNESDAY")) {
    		List<Label> dayList = initializeWed();
    		for(Day d : month.getDays()) {
    			dayList.get(dayNow).setText(String.valueOf(dayNow+1));//setting day label to a certain integer
    			dayNow++;
    		}
    	}
    	if(dayOfWeek.equals("THURSDAY")) {
    		List<Label> dayList = initializeThur();
    		for(Day d : month.getDays()) {
    			dayList.get(dayNow).setText(String.valueOf(dayNow+1));//setting day label to a certain integer
    			dayNow++;
    		}
    	}
    	if(dayOfWeek.equals("FRIDAY")) {
    		List<Label> dayList = initializeFri();
    		for(Day d : month.getDays()) {
    			dayList.get(dayNow).setText(String.valueOf(dayNow+1));//setting day label to a certain integer
    			dayNow++;
    		}
    	}
    	if(dayOfWeek.equals("SATURDAY")) {
    		List<Label> dayList = initializeSat();
    		for(Day d : month.getDays()) {
    			dayList.get(dayNow).setText(String.valueOf(dayNow+1));//setting day label to a certain integer
    			dayNow++;
    		}
    	}
    	if(dayOfWeek.equals("SUNDAY")) {
    		List<Label> dayList = initializeSun();
    		for(Day d : month.getDays()) {
    			dayList.get(dayNow).setText(String.valueOf(dayNow+1));//setting day label to a certain integer
    			dayNow++;
    		}
    	}
    }
    
    /**
     * clearing before resetting text on all day labels
     */
    public void clearDayLabels() {
    	List<Label> XdayList = initializeSun();
		for(Label x: XdayList) {
			x.setText("-");
		}
    }
    
    @FXML
    public void addEvent() {
    	//clearing details of last event
    	detailPane.getChildren().clear();
    	
    	//data to be stored in the database:
    	TextField title = new TextField();
    	TextField description = new TextField();
    	Spinner<Integer> startTime = new Spinner<>();
    	Spinner<Integer> endTime = new Spinner<>();
    	DatePicker eventDate = new DatePicker();
    	Button finish = new Button();
    	Button clear = new Button();
    	Spinner<Integer> repeat = new Spinner<>();
    	
        //initializing event title input box
        title.setPromptText("Enter Event Title");
        title.setPrefWidth(150);
        title.setLayoutX(0);
        title.setLayoutY(20);
        title.setId("titleBox");
        //initializing event description input box
        description.setPromptText("Enter Event Description");
        description.setPrefWidth(150);
        description.setLayoutX(0);
        description.setLayoutY(60);
        description.setId("eventBox");    
        //initializing start time select spinner and label
        Label startTimeLabel = new Label("Event's starting time:");
        startTimeLabel.setLayoutX(0);
        startTimeLabel.setLayoutY(100);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
        startTime.setValueFactory(valueFactory);
        startTime.setPromptText("Event Starts");
        startTime.setLayoutX(0);
        startTime.setLayoutY(120);
       //initializing start time select spinner and label
        Label endTimeLabel = new Label("Event's ending time:");
        endTimeLabel.setLayoutX(0);
        endTimeLabel.setLayoutY(150);
        SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
        endTime.setValueFactory(valueFactory2);
        endTime.setPromptText("Event Ends");
        endTime.setLayoutX(0);
        endTime.setLayoutY(170);
        //initializing repeat label and spinner for repeat frequency
        Label repeatLabel = new Label("Repeat times:");
        repeatLabel.setLayoutX(0);
        repeatLabel.setLayoutY(195);
        SpinnerValueFactory<Integer> valueFactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50, 0);
        repeat.setValueFactory(valueFactory3);
        repeat.setValueFactory(valueFactory3);
        repeat.setPromptText("Repeat times");
        repeat.setLayoutX(0);
        repeat.setLayoutY(215);
        //setting up date picker for the event and date picker label
        Label datePick = new Label("Choose Event Date");
        datePick.setLayoutX(0);
        datePick.setLayoutY(240);
        eventDate.setMaxWidth(150);
        eventDate.setLayoutX(0);
        eventDate.setLayoutY(260);
        
        //Label to indicate if event has been added
        Label resultMessage = new Label();
		resultMessage.setTextFill(Color.LIGHTGREEN);
		resultMessage.setLayoutX(-10);
	    resultMessage.setLayoutY(405);
    	
    	// Kamil's Reminders functionality implementation 
    	Button addReminderButton = new Button("Add Reminder");

    	// action handler to open the new dialog 
    	addReminderButton.setOnAction(e -> {
    		showAddReminderPopup();
    	});
    	
    	//Button to open Add_Homework class to create a homework object
    	Button addHomeworkButton = new Button("Add HW"); 
    	
    	addHomeworkButton.setOnAction(e -> { 
    		try {
				Add_Homework.start();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	});
        
    	//Hbox containing the add homeowrk and add reminder button (to save vertical space for error message)
    	HBox reminderAndHomework = new HBox(5);
    	reminderAndHomework.getChildren().addAll(addHomeworkButton, addReminderButton);
    	reminderAndHomework.setLayoutX(-8);
    	reminderAndHomework.setLayoutY(295);
    	detailPane.getChildren().add(reminderAndHomework);
    	
    	// Automatic scheduling feature
    	//Button to trigger auto scheduling feature 
    	Button autoAddButton = new Button("Automatically Schedule");
    	autoAddButton.setLayoutX(0);
    	autoAddButton.setLayoutY(325);
    	
    	// action handler to open the new dialog for automatic event scheduling 
    	autoAddButton.setOnAction(e -> {
    		openAutomaticSchedulingWindow(eventDate, startTime, endTime);
    	});
    	
        //adding the event to database when the finish button is clicked
        EventHandler<ActionEvent> eventAddHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(title.getText() == "") {
            		resultMessage.setTextFill(Color.RED);
    				resultMessage.setLayoutX(10);
	        	    resultMessage.setLayoutY(405);
    				resultMessage.setText("Error: The event does not\nhave a title");
            	}else if(description.getText() == "") {
            		resultMessage.setTextFill(Color.RED);
    				resultMessage.setLayoutX(10);
	        	    resultMessage.setLayoutY(405);
    				resultMessage.setText("Error: The event does not\nhave a description");
            	}else if(eventDate.getValue() == null) {
            		resultMessage.setTextFill(Color.RED);
    				resultMessage.setLayoutX(10);
	        	    resultMessage.setLayoutY(405);
    				resultMessage.setText("Error: An event date\nwas not chosen.");
            	}else if(startTime.getValue() >= endTime.getValue()) {
            		resultMessage.setTextFill(Color.RED);
    				resultMessage.setLayoutX(-8);
	        	    resultMessage.setLayoutY(405);
    				resultMessage.setText("Error: The event's starting time\ncannot be greater than or\nequal to it's ending time.");
            	}else {
            		//capturing event title and description
                	String titleData = title.getText();;
                	String descriptionData = description.getText();
                	//capturing event start time
                	int startingTimeData = startTime.getValue();
                	//event duration will be end time - start time
                    //setting event duration
                    int durationData = endTime.getValue() - startTime.getValue();
                    //capturing event date
                	LocalDate dateData = eventDate.getValue();
                	
                	int repeatData = repeat.getValue();
    	              try {
    	            	Hour eventStartingHour = new Hour(startingTimeData, 0);//initializing event starting hour
    	    			NonRepeatingEvent eventToBeAdded = new NonRepeatingEvent(titleData, descriptionData, eventStartingHour, durationData, dateData);//creating event object
    	    			
    	    			//checking if the event can be added to that day and adding if it can
    	    			if(calendar.getYear(dateData.getYear()).findMonthByNumber(dateData.getMonthValue()).getDayByNumber(dateData.getDayOfMonth()).checkEventAddable(eventToBeAdded)) {
    	    				//adding the event to the database
    		            	DBops.addNREventDB(titleData, descriptionData, startingTimeData, durationData, dateData, repeatData);
    		            	//displaying message indicating successful adding
    		            	resultMessage.setTextFill(Color.LIGHTGREEN);
    		            	resultMessage.setLayoutX(25);
    	    			    resultMessage.setLayoutY(420);
    		            	resultMessage.setText("Event Added");
    		            	//fetching the day object that corresponds to the selected date and adding an event to the calendar since the GUI's calendar has not been updated yet
    		    			try {
    							calendar.getYear(dateData.getYear()).findMonthByNumber(dateData.getMonthValue()).getDayByNumber(dateData.getDayOfMonth()).addEvent(eventToBeAdded);
    						} catch (EventSurpassesDayException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
    	    			}else {
    	    				resultMessage.setTextFill(Color.RED);
    	    				resultMessage.setLayoutX(-10);
    		        	    resultMessage.setLayoutY(405);
    	    				resultMessage.setText("Error: Event Overlaps with\nanother or it can't be finished\non the starting day");
    	    			}
    	    			
    	    			//clearing all info of added event from the gui to prepare for next event 
    	    			title.clear();
    	    			description.clear();
    	    			startTime.getValueFactory().setValue(0);
    	    			endTime.getValueFactory().setValue(0);
    	    			eventDate.setValue(null);
    	    			repeat.getValueFactory().setValue(0);
    	    			
    	    		} catch (SQLException e) {
    	    			e.printStackTrace();
    	    		} catch (IllegalArgumentException e) {
    					e.printStackTrace();
    				} catch (EventOverlapException e) {
    					e.printStackTrace();
    				} catch (MonthNotFoundException e) {
    					e.printStackTrace();
    				}
            	}
            	
            }
        };
        
        EventHandler<ActionEvent> eventHandlerClear = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            //clearing all info of added event from the gui to prepare for next event 
			title.clear();
			description.clear();
			startTime.getValueFactory().setValue(0);
			endTime.getValueFactory().setValue(0);
			eventDate.setValue(null);
			repeat.getValueFactory().setValue(0);
            }         
        };
        
        //setting up finish button and clear button
        finish.setText("Finish");
        finish.setLayoutX(105);
        finish.setLayoutY(460);
        finish.setId("finishButton");
        finish.setOnAction(eventAddHandler);
        
        clear.setText("Clear");
        clear.setLayoutX(0);
        clear.setLayoutY(460);
        clear.setId("clearButton");
        clear.setOnAction(eventHandlerClear);
        //adding ui components onto the detail pane   	
    	detailPane.getChildren().add(title);
    	detailPane.getChildren().add(description);
    	detailPane.getChildren().add(startTime);
    	detailPane.getChildren().add(endTime);
    	detailPane.getChildren().add(repeat);
    	detailPane.getChildren().add(eventDate);
    	detailPane.getChildren().add(startTimeLabel);
    	detailPane.getChildren().add(endTimeLabel);
    	detailPane.getChildren().add(repeatLabel);
    	detailPane.getChildren().add(datePick);
    	//detailPane.getChildren().add(addHomeworkButton);
    	detailPane.getChildren().add(autoAddButton);
    	detailPane.getChildren().add(resultMessage);
    	detailPane.getChildren().add(finish);
    	detailPane.getChildren().add(clear);   	
    }
    
    
    // Method to open a new window for automatic event scheduling
    private static void openAutomaticSchedulingWindow(DatePicker date, Spinner<Integer> startTime, Spinner<Integer> endTime) {
        Stage newWindow = new Stage();
        Image icon = new Image("logo5.jpg");
		newWindow.getIcons().add(icon);
        newWindow.setTitle("Auto-Schedule");

        VBox layout = new VBox(10);
    
        Scene scene = new Scene(layout, 425, 360);
        newWindow.setScene(scene);
        //initializing the window components
        Label minimumDateLabel = new Label("The event should be on the day of or after: ");
        
        DatePicker minEventDate = new DatePicker();
        
        Label maximumDateLabel = new Label("The event should be on the day of or before: ");
        
        DatePicker maxEventDate = new DatePicker();
        
        Label durationLabel = new Label("What is the duration of the event in Hours?");
        
        Spinner<Integer> duration = new Spinner<>();
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
        duration.setValueFactory(valueFactory);
        
        Label startTimeLabel = new Label("How late into the day are you willing to start this event?(Hour of the day)");
        
        Spinner<Integer> maxStartTime = new Spinner<>();
        SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
        maxStartTime.setValueFactory(valueFactory2);
        
        Label startTimeLabel2 = new Label("How early are you willing to start this event?(Hour of the day)");
        		
        Spinner<Integer> minStartTime = new Spinner<>();
        SpinnerValueFactory<Integer> valueFactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
        minStartTime.setValueFactory(valueFactory3);
        
        Label errorText = new Label("");
        errorText.setTextFill(Color.RED);
        
        Button schedule = new Button("Schedule");
        //adding the schedule button and error text to a horizontal box to add to the bottom of the window
        HBox scheduleAndError = new HBox(10); 
        scheduleAndError.getChildren().addAll(schedule, errorText);
        
        schedule.setOnAction(e -> {
        	//checking for invalid inputs
        	if(minEventDate.getValue() == null || maxEventDate.getValue() == null) {
        		errorText.setText("Please enter event boundary dates.");
        	}else if(maxEventDate.getValue().compareTo(minEventDate.getValue()) < 0) {
        		errorText.setText("Latest day of event cannot be before the earliest day of event.");
        	}else if(duration.getValue() == 0) {
        		errorText.setText("The duration of the event can not be less than one hour.");
        	}else if(maxStartTime.getValue() < minStartTime.getValue()) {
        		errorText.setText("The maximum starting time has to be greater than or \nequal to the minimum starting time");
        	}else if(minEventDate.getValue().getYear() != maxEventDate.getValue().getYear()) {//different boundary years
        		//initializing input and output objects (GUI components)
        		ScheduleInputComponents inputs = new ScheduleInputComponents(maxStartTime, minStartTime,
        															duration, minEventDate, maxEventDate);
        		ScheduleOutputComponents outputs = new ScheduleOutputComponents(startTime, endTime, date,
        																			errorText, newWindow);
        		
        		GuiControllerHelper.scheduleYearsRange(calendar, inputs, outputs);
        		
        	}else if(minEventDate.getValue().getMonthValue() != maxEventDate.getValue().getMonthValue()) {//same boundary years but different boundary months
        		//initializing input and output objects (GUI components)
        		ScheduleInputComponents inputs = new ScheduleInputComponents(maxStartTime, minStartTime,
        				duration, minEventDate, maxEventDate);
        	    ScheduleOutputComponents outputs = new ScheduleOutputComponents(startTime, endTime, date,
        	        					errorText, newWindow);
        	    
        	    GuiControllerHelper.scheduleMonthsRange(calendar, inputs, outputs);
        	}else {//same boundary months and years, but different boundary days
        	  //initializing input and output objects (GUI components)
        		ScheduleInputComponents inputs = new ScheduleInputComponents(maxStartTime, minStartTime,
        				duration, minEventDate, maxEventDate);
        	    ScheduleOutputComponents outputs = new ScheduleOutputComponents(startTime, endTime, date,
        	        					errorText, newWindow);
        	    
        	    GuiControllerHelper.scheduleDaysRange(calendar, inputs, outputs);
        	}
        	 
        });
        
        //adding all the components of the new window to the scene
        layout.getChildren().add(minimumDateLabel);
        layout.getChildren().add(minEventDate);
        layout.getChildren().add(maximumDateLabel);
        layout.getChildren().add(maxEventDate);
        layout.getChildren().add(durationLabel);
        layout.getChildren().add(duration);
        layout.getChildren().add(startTimeLabel2);
        layout.getChildren().add(minStartTime);
        layout.getChildren().add(startTimeLabel);
        layout.getChildren().add(maxStartTime);
        layout.getChildren().add(scheduleAndError);
        
        // Show the new window
        newWindow.show();
    }
    
    public void showAddReminderPopup() {
        Stage window = new Stage();
        //Yadon added the logo, feel free to remove it if u want to
        Image icon = new Image("logo5.jpg");
		window.getIcons().add(icon);
		
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(400);
        window.setMinHeight(470);
        

        window.setTitle("Add Reminder");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        TextField titleField = new TextField();
        titleField.setPromptText("Enter reminder title");

        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Select date");

        Spinner<Integer> timeSpinner = new Spinner<>(0, 23, 12, 1);
        timeSpinner.setEditable(true);

        TextField offsetField = new TextField();
        offsetField.setPromptText("Offset in minutes");

        Button saveButton = new Button("Save Reminder");
        
        
        
        saveButton.setOnAction(e -> {
            //  after clicking on save button probably database implementation will be here
        	//  by  creating a new reminders objects 
        	try {
        		//String message = titleField.getText();
				String title = titleField.getText();
				String message = title;
				LocalDate reminderDate = datePicker.getValue();
				int eventTime = timeSpinner.getValue();
				int offsetMinutes = Integer.parseInt(offsetField.getText());
	
				
				int id = DBops.addRemindersDB(title,reminderDate, eventTime, offsetMinutes, message);
				
				if (id != -1) {
					Reminders newReminder = new Reminders(id, message, title, eventTime, Duration.ofMinutes(offsetMinutes), reminderDate);
					remindersList.add(newReminder);
				}
				displayReminders();
				window.close();
				// saving the reminders to database
				//try {
				//	DBops.addRemindersDB(title, 
				//			reminderDate, 
				//			eventTime, 
				//			offsetMinutes, 
				//			newReminder.getMessage());
				//			reminderId
						
				//} catch (SQLException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();
				//}
				
				//try {
				//	displayReminders();
				//} catch (SQLException e1) {
				//	// TODO Auto-generated catch block
				//	e1.printStackTrace();
				//}
	            // window.close(); 
	            
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidEventTimeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (negativeReminderOffsetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });

        layout.getChildren().addAll(
            new Label("Title"), titleField,
            new Label("Date"), datePicker,
            new Label("Time"), timeSpinner,
            new Label("Notify Me..."), offsetField, saveButton
        );

        Scene scene = new Scene(layout, 470, 400);
        window.setScene(scene);
        window.showAndWait();  
    }
    
    
    private void displayReminders() throws SQLException, InvalidEventTimeException, negativeReminderOffsetException {
    	detailPane.getChildren().clear(); 
    	
        VBox layout = new VBox(10); 
        layout.setPadding(new Insets(10));
        
        List<Reminders> fetchedReminders = DBops.getAllRemindersDB();

        for (Reminders reminder : fetchedReminders) {
            String reminderText = String.format("Message: %s\nDate %s\nTime: %d\nOffset: %s minutes",
                    reminder.getMessage(),
                    // displaying date
                    reminder.getReminderDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),                 
                    reminder.getEventTime(),
                    reminder.getOffset().toMinutes());
            Label reminderLabel = new Label(reminderText);
            Button deleteButton = new Button("Delete");
            //layout.getChildren().add(reminderLabel);
            
            deleteButton.setOnAction(e -> { 	
            	//layout.getChildren().remove(reminderLabel);
            	//layout.getChildren().remove(deleteButton);  
				try {
					deleteReminder(reminder, fetchedReminders);
					displayReminders();
				} catch (SQLException | InvalidEventTimeException | negativeReminderOffsetException e1) {		
					e1.printStackTrace();
				}
            });
            
            VBox reminderBox = new VBox(5);
            reminderBox.getChildren().addAll(reminderLabel, deleteButton);
            layout.getChildren().add(reminderBox);
            //layout.getChildren().addAll(reminderLabel,deleteButton);
        }

        ScrollPane scrollPane =  new ScrollPane(layout);
   
        scrollPane.setPrefWidth(150);
        scrollPane.setPrefHeight(494);

        detailPane.getChildren().add(scrollPane); // Add the VBox to the detail pane
    }
    
    public void deleteReminder(Reminders reminder, List<Reminders> fetchedReminders) throws SQLException, InvalidEventTimeException, negativeReminderOffsetException {
    	System.out.println("Deleting reminder");
    	DBops.deleteReminderDB(reminder.getId());
    	fetchedReminders.remove(reminder);
    	displayReminders();
    }
    
    public void initialize() throws SQLException, InvalidEventTimeException, negativeReminderOffsetException {
        seeReminders.setOnAction(event -> { 
			try {
				displayReminders();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidEventTimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (negativeReminderOffsetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        //displayReminders();
    }
    

}
