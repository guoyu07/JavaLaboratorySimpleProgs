package pl.polsl.Szymon.Bartnik.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletContext;

/**
 * Helper class with static methods which can be useful while working
 * with Derby DB.
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
public class DerbyUtils {

    /**
     * Checks if passed exception was caused by fact
     * the table to create already exists.
     * 
     * @param e exception thrown during executing SQL query.
     * @return if table already exists.
     */
    public static boolean tableAlreadyExists(SQLException e) {
        
        return e.getSQLState().equals("X0Y32");
    }
    
    /**
     * Connects to the database using specified servlet context.
     * 
     * @param context context of the servlet.
     * @return connection handle to the DB.
     */
    public static Connection connectToDatabase(ServletContext context) {
        
        // Get basic connection parameters from web.xml file.
        String dbDriverName = context.getInitParameter("dbDriverName");
        String dbServerName = context.getInitParameter("dbServerName");
        String dbPort = context.getInitParameter("dbPort");
        
        // Get authentication parameters from web.xml file.
        String dbBaseName = context.getInitParameter("dbBaseName");
        String dbUserName = context.getInitParameter("dbUserName");
        String dbPassword = context.getInitParameter("dbPassword");
        
        // Attempt to connect to the DB.
        try {
            Class.forName(dbDriverName);
            return DriverManager.getConnection("jdbc:derby://" + dbServerName + 
                    ":" + dbPort + "/" + 
                    dbBaseName, 
                    dbUserName, 
                    dbPassword);
            
        } catch (ClassNotFoundException cnfe) {
            System.err.println("ClassNotFound exception: " + cnfe.getMessage());
        } catch (SQLException sqle) {
            System.err.println("SQL exception: " + sqle.getMessage());
        } catch (Exception e) {
            System.err.println("Another exception: " + e.getMessage());
        }
        
        // Return null if connection attempt failed.
        return null;
    }
    
    /**
     * Creates all neccessary tables if do not exist.
     * 
     * @param connection describing connection to the DB.
     */
    public static void createTablesIfNecessary(Connection connection) {

        if(connection == null){
            return;
        }
            
        try {
            Statement statement = connection.createStatement();
            
            // Create tables.
            statement.executeUpdate("CREATE TABLE Users "
                    + "(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT USERS_PK PRIMARY KEY, "
                    + "username VARCHAR(50) NOT NULL, "
                    + "password VARCHAR(50) NOT NULL)");
            statement.executeUpdate("CREATE TABLE Results"
                    + "(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT RESULTS_PK PRIMARY KEY, "
                    + "userid INTEGER NOT NULL CONSTRAINT USERS_FK "
                    + "REFERENCES Users ON DELETE CASCADE ON UPDATE RESTRICT, "
                    + "fromnumeralsystem VARCHAR(50) NOT NULL, "
                    + "tonumeralsystem VARCHAR(50) NOT NULL, "
                    + "numbertoconvert VARCHAR(50) NOT NULL, "
                    + "convertednumber VARCHAR(50) NOT NULL)");
            
            // Create initial user.
            statement.executeUpdate("INSERT INTO Users(username, password) VALUES ('kneefer', 'kupa')");
        } catch (SQLException sqle) {
            // If exception caused by already existing table, ignore exception.
            if(tableAlreadyExists(sqle)) {
                return; 
            }
            System.err.println("SQL exception: " + sqle.getMessage());
        } catch (Exception e) {
            System.err.println("Another exception: " + e.getMessage());
        }
    }
}