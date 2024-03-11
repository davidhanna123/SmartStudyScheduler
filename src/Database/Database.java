package Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusinessLogic.Month;

public class Database {

	public Database() {
		// TODO Auto-generated constructor stub
	}
	
	public static void addYearDB(int yearNumber) throws SQLException {
		databaseConnection dbConnect = new databaseConnection();
		Connection connection = dbConnect.getConnection();
		
		String sql = "INSERT INTO main.years (currentyear) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, yearNumber);
            //statement.setInt(2, calendarId);
            statement.executeUpdate();
        }
        connection.close();
	}
	
	public static void addMonthDB(String monthName, int monthNumber, int numOfDays, int year) throws SQLException {
		databaseConnection dbConnect = new databaseConnection();
		Connection connection = dbConnect.getConnection();
		
		String sql = "INSERT INTO main.months (monthName, monthNumber, numOfDays, yearNumber) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, monthName);
            statement.setInt(2, monthNumber);
            statement.setInt(3, numOfDays);
            statement.setInt(4, year);
            //statement.setInt(5, yearId);
            statement.executeUpdate();
        }
        
        connection.close();
	}
	
	public static void addDayDB(String dayOfWeek, int yearNumber, int monthNumber, int dayNumber) throws SQLException {
		databaseConnection dbConnect = new databaseConnection();
		Connection connection = dbConnect.getConnection();
		
		String sql = "INSERT INTO main.days (dayOfWeek, yearNumber, monthNumber, dayNumber) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dayOfWeek);
            statement.setInt(2, yearNumber);
            statement.setInt(3, monthNumber);
            statement.setInt(4, dayNumber);
            //statement.setInt(5, monthId);
            statement.executeUpdate();
        }
        connection.close();
	}
	
	public static void addHourDB(int time, double minuteModifier, int day, int month, int year) throws SQLException {
		databaseConnection dbConnect = new databaseConnection();
		Connection connection = dbConnect.getConnection();
		
		String sql = "INSERT INTO main.hours (timeNumber, minuteModifier, dayNumber, monthNumber, yearNumber) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, time);
            statement.setDouble(2, minuteModifier);
            statement.setInt(3, day);
            statement.setInt(4, month);
            statement.setInt(5, year);
            statement.executeUpdate();
        }
        connection.close();
	}

	
	public static Month getMonthDB(int year, int month){
		int id;
        String monthName = null;
        int monthNumber = 0;
        int numOfDays = 0;
        int yearNumber = 0;
        
		databaseConnection dbConnect = null;
		try {
			dbConnect = new databaseConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = dbConnect.getConnection();
		
		String query = "SELECT * FROM main.months WHERE yearNumber = " + String.valueOf(year) + " AND monthNumber = " + String.valueOf(month);
		
		try (
	            // Prepare the SQL statement for execution
	        PreparedStatement statement = connection.prepareStatement(query);
	            // Execute the query and get the result set
			ResultSet resultSet = statement.executeQuery();
	    ) {
	            // Iterate through the result set and process each row
	            while (resultSet.next()) {
	                // Retrieve data from the current row
	                id = resultSet.getInt("id");
	                monthName = resultSet.getString("monthName");
	                monthNumber = resultSet.getInt("monthNumber");
	                numOfDays = resultSet.getInt("numOfDays");
	                yearNumber = resultSet.getInt("yearNumber");
	               
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return new Month(monthNumber, yearNumber);
	}
	

}

