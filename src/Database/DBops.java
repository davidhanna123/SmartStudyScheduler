package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import BusinessLogic.InvalidEventTimeException;
import BusinessLogic.Reminders;
import BusinessLogic.Year;
import BusinessLogic.negativeReminderOffsetException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public interface DBops {
//	public static void addYear() {
//		Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM CUSTOMERS LIMIT 10");
//	}
	
	public static void addMonthDB(String monthName, int monthNumber, int numOfDays, int year, int yearId) throws SQLException {
		databaseConnection dbConnect = new databaseConnection();
		Connection connection = dbConnect.getConnection();
		
		String sql = "INSERT INTO main.months (monthName, monthNumber, numOfDays, yearId) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, monthName);
            statement.setInt(2, monthNumber);
            statement.setInt(3, numOfDays);
            statement.setInt(4, year);
            statement.setInt(5, yearId);
            statement.executeUpdate();
        }
	}
	
	//public static void addDayDB()
	
	
	public static void  addRemindersDB(String title, LocalDate  reminderDate, int eventTime, int offsetMinutes, String message) throws SQLException {
		databaseConnection dbConnect = new databaseConnection();
		Connection connection  = dbConnect.getConnection();
		
		String SQL = "INSERT INTO main.reminders(title, reminder_date, reminder_time, offset_minutes, message) VALUES(?, ?, ?, ?, ?)";
		try(PreparedStatement statement = connection.prepareStatement(SQL)){
			statement.setString(1, title);
	        statement.setDate(2, java.sql.Date.valueOf(reminderDate)); 
	        statement.setTime(3, java.sql.Time.valueOf(LocalTime.of(eventTime, 0))); 
	        statement.setInt(4, offsetMinutes);
	        statement.setString(5, message);
	        statement.executeUpdate();
		}catch (SQLException  e) {
			e.printStackTrace();
		}
	}
	
	// method to retrieve all the reminders from the database, which returns the list of Reminders objects
	public static List<Reminders> getAllRemindersDB() throws SQLException, InvalidEventTimeException, negativeReminderOffsetException {
	    List<Reminders> reminderList = new ArrayList<>();
	   
	    databaseConnection  dbConnect = new databaseConnection();
	    try (Connection connection = dbConnect.getConnection();
	         Statement statement = connection.createStatement();
	         ResultSet rs = statement.executeQuery("SELECT * FROM main.reminders")) {

	        while (rs.next()) {
	            String title = rs.getString("title");
	            LocalDate reminderDate = rs.getDate("reminder_date").toLocalDate();
	            LocalTime reminderTime = rs.getTime("reminder_time").toLocalTime();
	            int offsetMinutes = rs.getInt("offset_minutes");
	            String message = rs.getString("message");
	            
	            Reminders reminder = new Reminders(title, reminderTime.getHour(), Duration.ofMinutes(offsetMinutes), reminderDate);
	        
	            reminder.setMessage(message); 
	            reminderList.add(reminder);
	           
	            reminder.setMessage(message); 
	            reminderList.add(reminder);
	        }
	    }
	    return reminderList;
	} 
}
