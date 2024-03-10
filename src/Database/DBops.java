package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusinessLogic.Year;

import java.sql.Connection;
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
	
	public static void addDayDB()
	
	
}
