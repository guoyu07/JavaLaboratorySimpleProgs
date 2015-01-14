package pl.polsl.Szymon.Bartnik.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletContext;

public class DerbyUtils {

    public static boolean tableAlreadyExists(SQLException e) {
        boolean exists;
        if(e.getSQLState().equals("X0Y32")) {
            exists = true;
        } else {
            exists = false;
        }
        return exists;
    }
    
    public static Connection connectToDatabase(ServletContext context) {
        
        String dbDriverName = context.getInitParameter("dbDriverName");
        String dbServerName = context.getInitParameter("dbServerName");
        String dbPort = context.getInitParameter("dbPort");
        
        String dbBaseName = context.getInitParameter("dbBaseName");
        String dbUserName = context.getInitParameter("dbUserName");
        String dbPassword = context.getInitParameter("dbPassword");
        
        
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
        }
        catch (Exception e) {
            System.err.println("Another exception: " + e.getMessage());
        }
        return null;
    }
    
    public static void createTablesIfNecessary(Connection connection) {

        if(connection == null){
            return;
        }
            
        try {
            // Tworzymy obiekt wyrażenia
            Statement statement = connection.createStatement();
            // Tworzymy pola tabeli
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
            statement.executeUpdate("INSERT INTO Users(username, password) VALUES ('kneefer', 'kupa')");
            System.out.println("Tables created");
        } catch (SQLException sqle) {
            if(tableAlreadyExists(sqle)) {
                return; 
            }
            System.err.println("SQL exception: " + sqle.getMessage());
        } catch (Exception e) {
            System.err.println("Another exception: " + e.getMessage());
        }
    }
}