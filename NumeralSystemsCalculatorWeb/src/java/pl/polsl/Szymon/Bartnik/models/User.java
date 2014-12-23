package pl.polsl.Szymon.Bartnik.models;

/**
 *
 * @author Szymon
 */
public class User {
    
    private final String userName;
    private final String password;
    
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    
}
