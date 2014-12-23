package pl.polsl.Szymon.Bartnik.models;

/**
 * Model class accumulating user's name and his password.
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
public class User {
    
    /** User name identifying the user */
    private final String userName;
    /** Password credential used for logging in purposes */
    private final String password;
    
    /**
     * Constructor setting userName and password for
     * creating instance
     * 
     * @param userName userName of the user
     * @param password password of the user
     */
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
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
