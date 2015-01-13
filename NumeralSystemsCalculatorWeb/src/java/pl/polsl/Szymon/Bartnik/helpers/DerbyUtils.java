package pl.polsl.Szymon.Bartnik.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    
    public static Connection connectToDatabase() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            return DriverManager.getConnection("jdbc:derby://localhost:1527/numeralSystemsBase", "lab", "lab");
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
}