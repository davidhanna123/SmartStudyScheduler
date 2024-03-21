package Database;

import java.sql.*;

public class databaseConnection {
	Connection con = null;

	public static Connection connectDB()

	{

		try {
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/main",
				"root", "davidhanna");
			
			return con;
		}

		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		    return null;
		}
	}

}
