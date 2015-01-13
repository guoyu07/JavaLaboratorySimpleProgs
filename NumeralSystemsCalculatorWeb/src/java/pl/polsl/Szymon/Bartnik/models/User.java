package pl.polsl.Szymon.Bartnik.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Model class accumulating user's name and his password.
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
public class User {
    
    /** User id identifying the user */
    private final int userId;
    /** User name identifying the user */
    private final String userName;
    /** Password credential used for logging in purposes */
    private final String password;
    
    /**
     * Constructor setting userName and password for
     * creating instance
     * 
     * @param userId id of the user
     * @param userName userName of the user
     * @param password password of the user
     */
    public User(int userId, String userName, String password){
        this.userId   = userId;
        this.userName = userName;
        this.password = password;
    }

    public User(ResultSet rs) 
            throws SQLException {
        
        userId = rs.getInt("id");
        userName = rs.getString("username");
        password = rs.getString("password");
    }

    /**
     * Gets user id
     * 
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }
    
    /**
     * Gets user name
     * 
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Gets password
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    
}
