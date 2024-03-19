package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import BusinessLogic.InvalidEventTimeException;
import BusinessLogic.Reminders;
import BusinessLogic.negativeReminderOffsetException;
import BusinessLogic.Event;
import BusinessLogic.Hour;
import BusinessLogic.Month;
import BusinessLogic.NonRepeatingEvent;
import BusinessLogic.Year;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public interface DBops {
	
	public static boolean addNREventDB(String title, String description, int startingTime, int duration, LocalDate eventDate) throws SQLException {
		databaseConnection dbConnect = new databaseConnection();
		Connection connection = dbConnect.getConnection();
		
		String setSchema = "SET search_path TO main";
		try(PreparedStatement stmt = connection.prepareStatement(setSchema)){
			stmt.execute();
		}catch(SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		
		String sql = "INSERT INTO events (title, description, startingTime, duration, eventDate) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Set parameters for the PreparedStatement
        	Date sqlDate = Date.valueOf(eventDate);
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setInt(3, startingTime);
            stmt.setInt(4, duration);
            stmt.setObject(5, sqlDate);
           
            // Execute the PreparedStatement
            int rowsInserted = stmt.executeUpdate();
            connection.close();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            connection.close();
            return false;
       
        }
	}
	

	public static Event getNREventDB(String title, LocalDate eventDate) throws SQLException {
		databaseConnection dbConnect = new databaseConnection();
		Connection connection = dbConnect.getConnection();
		NonRepeatingEvent event = null;
		String sql = "SELECT * FROM main.events WHERE title = ? AND eventDate = ?";
		
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            statement.setObject(2, eventDate);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String retrievedTitle = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    int startingTime = resultSet.getInt("startingTime");
                    int duration = resultSet.getInt("duration");
                    Date retrievedEventDate = resultSet.getDate("eventDate");
                    
                    Hour eventHour = new Hour(startingTime, 0);
                    event = new NonRepeatingEvent(retrievedTitle, description, eventHour, duration, retrievedEventDate.toLocalDate());
                }
            }
        }catch(SQLException e) {
        	System.out.println("SQL Exception" + e.getMessage());
        }
        
        connection.close();
        return event;
	}
        


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
	            
	            Reminders reminder = new Reminders(message, title, reminderTime.getHour(), Duration.ofMinutes(offsetMinutes), reminderDate);
	        
	            reminder.setMessage(message); 
	            reminderList.add(reminder);
	           
	            reminder.setMessage(message); 
	            reminderList.add(reminder);
	        }
	    }
	    return reminderList;
	} 

//	public static void addYearDB(int yearNumber) throws SQLException {
//	databaseConnection dbConnect = new databaseConnection();
//	Connection connection = dbConnect.getConnection();
//	
//	String sql = "INSERT INTO main.years (currentyear) VALUES (?)";
//    try (PreparedStatement statement = connection.prepareStatement(sql)) {
//        statement.setInt(1, yearNumber);
//        //statement.setInt(2, calendarId);
//        statement.executeUpdate();
//    }
//    connection.close();
//}
//
//public static void addMonthDB(String monthName, int monthNumber, int numOfDays, int year) throws SQLException {
//	databaseConnection dbConnect = new databaseConnection();
//	Connection connection = dbConnect.getConnection();
//	
//	String sql = "INSERT INTO main.months (monthName, monthNumber, numOfDays, yearNumber) VALUES (?, ?, ?, ?)";
//    try (PreparedStatement statement = connection.prepareStatement(sql)) {
//        statement.setString(1, monthName);
//        statement.setInt(2, monthNumber);
//        statement.setInt(3, numOfDays);
//        statement.setInt(4, year);
//        //statement.setInt(5, yearId);
//        statement.executeUpdate();
//    }
//    
//    connection.close();
//}
//
//public static void addDayDB(String dayOfWeek, int yearNumber, int monthNumber, int dayNumber) throws SQLException {
//	databaseConnection dbConnect = new databaseConnection();
//	Connection connection = dbConnect.getConnection();
//	
//	String sql = "INSERT INTO main.days (dayOfWeek, yearNumber, monthNumber, dayNumber) VALUES (?, ?, ?, ?)";
//    try (PreparedStatement statement = connection.prepareStatement(sql)) {
//        statement.setString(1, dayOfWeek);
//        statement.setInt(2, yearNumber);
//        statement.setInt(3, monthNumber);
//        statement.setInt(4, dayNumber);
//        //statement.setInt(5, monthId);
//        statement.executeUpdate();
//    }
//    connection.close();
//}
//
//public static void addHourDB(int time, double minuteModifier, int day, int month, int year) throws SQLException {
//	databaseConnection dbConnect = new databaseConnection();
//	Connection connection = dbConnect.getConnection();
//	
//	String sql = "INSERT INTO main.hours (timeNumber, minuteModifier, dayNumber, monthNumber, yearNumber) VALUES (?, ?, ?, ?, ?)";
//    try (PreparedStatement statement = connection.prepareStatement(sql)) {
//        statement.setInt(1, time);
//        statement.setDouble(2, minuteModifier);
//        statement.setInt(3, day);
//        statement.setInt(4, month);
//        statement.setInt(5, year);
//        statement.executeUpdate();
//    }
//    connection.close();
//}
//
//
//public static Month getMonthDB(int year, int month){
//	int id;
//    String monthName = null;
//    int monthNumber = 0;
//    int numOfDays = 0;
//    int yearNumber = 0;
//    
//	databaseConnection dbConnect = null;
//	try {
//		dbConnect = new databaseConnection();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	Connection connection = dbConnect.getConnection();
//	
//	String query = "SELECT * FROM main.months WHERE yearNumber = " + String.valueOf(year) + " AND monthNumber = " + String.valueOf(month);
//	
//	try (
//            // Prepare the SQL statement for execution
//        PreparedStatement statement = connection.prepareStatement(query);
//            // Execute the query and get the result set
//		ResultSet resultSet = statement.executeQuery();
//    ) {
//            // Iterate through the result set and process each row
//            while (resultSet.next()) {
//                // Retrieve data from the current row
//                id = resultSet.getInt("id");
//                monthName = resultSet.getString("monthName");
//                monthNumber = resultSet.getInt("monthNumber");
//                numOfDays = resultSet.getInt("numOfDays");
//                yearNumber = resultSet.getInt("yearNumber");
//               
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//	
//	return new Month(monthNumber, yearNumber);
//}
//
//
	
	//	THE METHODS ABOVE WERE COMMENTED OUT BECAUSE THEY ARE UNECESSARY...IF AT SOME POINT ANYONE NEEDS THEM, FEEL FREE TO UNCOMMENT

	
}
