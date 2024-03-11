package Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class databaseConnection {
	public Connection connection;
	
	public databaseConnection() throws SQLException {
		// TODO Auto-generated constructor stub
		String url = null;
		String username = null;
		String password = null;
		
		Properties properties = new Properties();
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("Database/db.properties")) {
            properties.load(input);

            // Access individual properties
            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		connection = DriverManager.getConnection(url, username, password);
	}

	public Connection getConnection() {
		return this.connection;
	}


}
