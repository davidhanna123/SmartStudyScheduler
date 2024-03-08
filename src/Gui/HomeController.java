package Gui;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import BusinessLogic.*;
import Database.StubDatabase;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class HomeController {

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
    
    //StubDatabase stub;
    public HomeController() {
    	super();
    	//stub = new StubDatabase();
    	StubDatabase.initialize();
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
    	List<Reminders> reminderList = StubDatabase.getReminders(); // getting reminders from stub database
    	
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
    	
    	CalendarApp calendar = StubDatabase.getCalendar();
    	
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
    	
    	CalendarApp calendar = StubDatabase.getCalendar();
    	
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
    	
    	//
        
        updateDayLabels(dayOfWeek, month);
    }
    
    //updating the calendar and the year label when the next year is selected
    @FXML
    public void updateYearLabelNext() throws IllegalArgumentException, MonthNotFoundException {
    	clearDayLabels();
		
    	CalendarApp calendar = StubDatabase.getCalendar();
    	
    	int yearNow;
		int monthNow;
		Month month;
		
    	if(calendar.contains(calendar.getCurrentYear() + 1)) {
    		calendar.setCurrentYear(calendar.getCurrentYear() + 1);
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
		
    	CalendarApp calendar = StubDatabase.getCalendar();
    	
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
    	detailPane.getChildren().clear();
    	
    	TextField title = new TextField();
    	TextField description = new TextField();
    	Spinner<Integer> startTime = new Spinner<>();
    	Spinner<Integer> endTime = new Spinner<>();
    	DatePicker eventDate = new DatePicker();
    	Button finish = new Button();
    	
        //initializing event title input box
        title.setPromptText("Enter Event Title");
        title.setPrefWidth(150);
        title.setLayoutX(5);
        title.setLayoutY(20);
        title.setId("titleBox");
        //initializing event description input box
        description.setPromptText("Enter Event Description");
        description.setPrefWidth(150);
        description.setLayoutX(5);
        description.setLayoutY(60);
        description.setId("eventBox");
        //initializing start time select spinner and label
        Label startTimeLabel = new Label("Event's starting time:");
        startTimeLabel.setLayoutX(5);
        startTimeLabel.setLayoutY(100);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 24, 0);
        startTime.setValueFactory(valueFactory);
        startTime.setPromptText("Select Event Starting Time");
        startTime.setLayoutX(5);
        startTime.setLayoutY(120);
       //initializing start time select spinner and label
        Label endTimeLabel = new Label("Event's ending time:");
        endTimeLabel.setLayoutX(5);
        endTimeLabel.setLayoutY(150);
        SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 24, 0);
        endTime.setValueFactory(valueFactory2);
        endTime.setPromptText("Select Event Starting Time");
        endTime.setLayoutX(5);
        endTime.setLayoutY(170);
        
        //event duration will be end time - start time
        
        //setting up date picker for the event and date picker label
        Label datePick = new Label("Choose Event Date");
        datePick.setLayoutX(5);
        datePick.setLayoutY(240);
        eventDate.setMaxWidth(150);
        eventDate.setLayoutX(5);
        eventDate.setLayoutY(260);
        
        //setting up finish button
        finish.setText("Finish");
        finish.setLayoutX(105);
        finish.setLayoutY(460);
        finish.setId("finishButton");
        
    	detailPane.getChildren().add(title);
    	detailPane.getChildren().add(description);
    	detailPane.getChildren().add(startTime);
    	detailPane.getChildren().add(endTime);
    	detailPane.getChildren().add(eventDate);
    	detailPane.getChildren().add(startTimeLabel);
    	detailPane.getChildren().add(endTimeLabel);
    	detailPane.getChildren().add(datePick);
    	detailPane.getChildren().add(finish);
    }
    
    
}
