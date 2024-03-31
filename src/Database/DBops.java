package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.time.LocalDate;
import BusinessLogic.InvalidEventTimeException;
import BusinessLogic.Reminders;
import BusinessLogic.negativeReminderOffsetException;
import BusinessLogic.Assignment;
import BusinessLogic.Event;
import BusinessLogic.Homework;
import BusinessLogic.Hour;
import BusinessLogic.Month;
import BusinessLogic.NonRepeatingEvent;
import BusinessLogic.Year;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public interface DBops {//
	
	public static boolean addNREventDB(NonRepeatingEvent event, int repeat) throws SQLException {
		String title = event.getTitle(); 
		String description = event.getDescription();
		int startingTime = event.getStartingTime().getTime();
		int duration = event.getDuration();
		LocalDate eventDate = event.getDate();
		
		databaseConnection dbConnect = new databaseConnection();
		Connection connection = dbConnect.getConnection();
		
		
		
		String sql = "INSERT INTO main.events (title, description, startingTime, duration, eventDate) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Set parameters for the PreparedStatement
        	int rowsInserted = 0;
        	for (int i = 0; i <= repeat; i++) {
            	Date sqlDate = Date.valueOf(eventDate.plusWeeks(i));
                stmt.setString(1, title);
                stmt.setString(2, description);
                stmt.setInt(3, startingTime);
                stmt.setInt(4, duration);
                stmt.setObject(5, sqlDate);
                
                rowsInserted = stmt.executeUpdate();
            }
        	
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
                	int id = resultSet.getInt("id");
                    String retrievedTitle = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    int startingTime = resultSet.getInt("startingTime");
                    int duration = resultSet.getInt("duration");
                    Date retrievedEventDate = resultSet.getDate("eventDate");
                    
                    Hour eventHour = new Hour(startingTime, 0);
                    event = new NonRepeatingEvent(id, retrievedTitle, description, eventHour, duration, retrievedEventDate.toLocalDate());
                }
            }
        }catch(SQLException e) {
        	System.out.println("SQL Exception" + e.getMessage());
        }
        
        connection.close();
        return event;
	}
	
	public static TreeSet<Event> getEventsByDate(LocalDate eventDate) throws SQLException {
		databaseConnection dbConnect = new databaseConnection();
		Connection connection = dbConnect.getConnection();
		NonRepeatingEvent event = null;
		String sql = "SELECT * FROM main.events WHERE eventDate = ?";
		TreeSet<Event> eventSet = new TreeSet<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
        	 statement.setObject(1, eventDate);
            try (ResultSet resultSet = statement.executeQuery()) {
            	
                while (resultSet.next()) {
                	
                	int id = resultSet.getInt("id");
                    String retrievedTitle = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    int startingTime = resultSet.getInt("startingTime");
                    int duration = resultSet.getInt("duration");
                    Date retrievedEventDate = resultSet.getDate("eventDate");

                    Hour eventHour = new Hour(startingTime, 0);
                    event = new NonRepeatingEvent(id, retrievedTitle, description, eventHour, duration, retrievedEventDate.toLocalDate());
                    eventSet.add(event);
                }
            }
        }catch(SQLException e) {
        	System.out.println("SQL Exception" + e.getMessage());
        	e.printStackTrace();
        }

        connection.close();
        return eventSet;
	}
    
	public static TreeSet<Event> getAllEventDB() throws SQLException {
		databaseConnection dbConnect = new databaseConnection();
		Connection connection = dbConnect.getConnection();
		NonRepeatingEvent event = null;
		String sql = "SELECT * FROM main.events";
		TreeSet<Event> eventSet = new TreeSet<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                	int id = resultSet.getInt("id");
                    String retrievedTitle = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    int startingTime = resultSet.getInt("startingTime");
                    int duration = resultSet.getInt("duration");
                    Date retrievedEventDate = resultSet.getDate("eventDate");

                    Hour eventHour = new Hour(startingTime, 0);
                    event = new NonRepeatingEvent(id, retrievedTitle, description, eventHour, duration, retrievedEventDate.toLocalDate());
                    eventSet.add(event);
                }
            }
        }catch(SQLException e) {
        	System.out.println("SQL Exception" + e.getMessage());
        	e.printStackTrace();
        }

        connection.close();
        return eventSet;
	}

	public static int addRemindersDB(Reminders reminder) throws SQLException {
		// we have to get an ID of each reminder that was added
		int id = -1; 
		databaseConnection dbConnect = new databaseConnection();
		Connection connection  = dbConnect.getConnection();
		
		String SQL = "INSERT INTO main.reminders(title, reminder_date, reminder_time, offset_minutes, message) VALUES(?, ?, ?, ?, ?) RETURNING id";
		try(PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)){
			statement.setString(1, reminder.getTitle());
	        statement.setDate(2, java.sql.Date.valueOf(reminder.getReminderDate())); 
	        statement.setTime(3, java.sql.Time.valueOf(LocalTime.of(reminder.getEventTime(), 0))); 
	        statement.setInt(4, (int) reminder.getOffset().toMinutes());
	        statement.setString(5, reminder.getMessage());
	   
	        int addedRows = statement.executeUpdate();
	        
	        if (addedRows > 0) {
	        	ResultSet rs = statement.getGeneratedKeys();
	        	if(rs.next()) {
	        		id = rs.getInt(1);
	        	}
	        }
		}catch (SQLException  e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return id;
	}
	
	// method to retrieve all the reminders from the database, which returns the list of Reminders objects
	public static List<Reminders> getAllRemindersDB() throws SQLException, InvalidEventTimeException, negativeReminderOffsetException {
	    List<Reminders> reminderList = new ArrayList<>();
	   
	    databaseConnection  dbConnect = new databaseConnection();
	    try (Connection connection = dbConnect.getConnection();
	         Statement statement = connection.createStatement();
	         ResultSet rs = statement.executeQuery("SELECT * FROM main.reminders")) {

	        while (rs.next()) {
	        	int id = rs.getInt("id");
	            String title = rs.getString("title");
	            LocalDate reminderDate = rs.getDate("reminder_date").toLocalDate();
	            LocalTime reminderTime = rs.getTime("reminder_time").toLocalTime();
	            int offsetMinutes = rs.getInt("offset_minutes");
	            String message = rs.getString("message");
	           
	            
	            Reminders reminder = new Reminders(id, message, title, reminderTime.getHour(), Duration.ofMinutes(offsetMinutes), reminderDate, "EventTitle");
	        
	            reminder.setMessage(message); 
	            reminderList.add(reminder);	             
	           
	            //reminder.setMessage(message); 
	            //reminderList.add(reminder);
	        }
	    }
	    return reminderList;
	} 
	
	public static boolean deleteReminderDB(int id) throws SQLException {
		boolean result = false;
        databaseConnection dbConnect = new databaseConnection();
        Connection connection = dbConnect.getConnection();
        
        String SQL = "DELETE FROM main.reminders WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                //System.out.println("A reminder was deleted successfully!");
                result = true;
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return result;
    }
	
	// method for the testing
	public static boolean reminderExistsDB(int id) throws SQLException {
		boolean exists = false;
		databaseConnection dbConnect = new databaseConnection();
		Connection connection = dbConnect.getConnection();
		
		PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM main.reminders WHERE id = ?");
		
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			// if count is more than zero then the reminder exists
			exists = rs.getInt(1) > 0;
		}
		
		return exists;
	}
	
	public static boolean addHomework(Homework hw)throws SQLException { 
		databaseConnection dbConnect = new databaseConnection(); 
		Connection connection = dbConnect.getConnection();
		
		String sql = "INSERT INTO main.homework (title, course, duration) VALUES(?,?,?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){ 
			stmt.setString(1, hw.getWork());
			stmt.setString(2, hw.getCourse());
			stmt.setInt(3, hw.getCompletionTime());
			stmt.executeUpdate();
			connection.close();
			return true;
		} catch (SQLException e) { 
			System.out.println("SQLException: " + e.getMessage()); 
			connection.close();
			return false;
		}
	}
	
	public static boolean addAssignment(Assignment asign)throws SQLException { 
		databaseConnection dbConnect = new databaseConnection(); 
		Connection connection = dbConnect.getConnection();
		
		String sql = "INSERT INTO main.homework (title, course, duration, eventDate) VALUES(?,?,?,?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){ 
			Date sqlDate = Date.valueOf(asign.getDue());
			stmt.setString(1, asign.getWork());
			stmt.setString(2, asign.getCourse());
			stmt.setInt(3, asign.getCompletionTime());
			stmt.setDate(4, sqlDate);
			stmt.executeUpdate();
			connection.close();
			return true;
		} catch (SQLException e) { 
			System.out.println("SQLException: " + e.getMessage()); 
			connection.close();
			return false;
		}
	}
	
	// method to delete the event from database
	public static boolean deleteEventDB(int id) throws SQLException {
		boolean result = false;
		databaseConnection dbConnect = new databaseConnection();
		Connection connection = dbConnect.getConnection();
		
		String SQL = "DELETE FROM main.events WHERE id = ?";
		try(PreparedStatement statement = connection.prepareStatement(SQL)){
			statement.setInt(1, id);
			
			int rowsDeleted = statement.executeUpdate();
			if(rowsDeleted > 0) {
				result = true;
			}
		}catch(SQLException e) {
			System.out.print("SQLException: " + e.getMessage());
			e.printStackTrace();
		}finally {
			if (connection != null) {
				try {
					connection.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		return result;
	}
	public static boolean updateEvent(int id, int newStartTime, int newDuration, LocalDate newDate) throws SQLException {
	    boolean result = false;
	    databaseConnection dbConnect = new databaseConnection();
	    Connection connection = dbConnect.getConnection();

	    String SQL = "UPDATE main.events SET eventDate = ?, duration = ?, startingTime = ? WHERE id = ?";
	    try (PreparedStatement statement = connection.prepareStatement(SQL)) {
	        
	        statement.setDate(1, java.sql.Date.valueOf(newDate));
	        statement.setInt(2, newDuration);
	        statement.setInt(3, newStartTime);
	        statement.setInt(4, id);

	        
	        int rowsUpdated = statement.executeUpdate();
	        if (rowsUpdated > 0) {
	            result = true;
	        }
	    } catch (SQLException e) {
	        System.out.println("SQLException: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
	    return result;
	}


}
