package pl.polsl.Szymon.Bartnik.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Szymon
 */
public class Result {
    
    private int id;
    private int userId;
    private String fromNumeralSystem;
    private String numberToConvert;
    private String toNumeralSystem;
    private String convertedNumber;

    public Result(ResultSet rs) 
            throws SQLException {
        
        id = rs.getInt("id");
        userId = rs.getInt("userid");
        fromNumeralSystem = rs.getString("fromnumeralsystem");
        toNumeralSystem = rs.getString("tonumeralsystem");
        numberToConvert = rs.getString("numbertoconvert");
        convertedNumber = rs.getString("convertednumber");
    }
    
    public Result(){
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the fromNumeralSystem
     */
    public String getFromNumeralSystem() {
        return fromNumeralSystem;
    }
    
    /**
     * @return the toNumeralSystem
     */
    public String getToNumeralSystem() {
        return toNumeralSystem;
    }

    /**
     * @return the numberToConvert
     */
    public String getNumberToConvert() {
        return numberToConvert;
    }
    
    /**
     * @return the convertedNumber
     */
    public String getConvertedNumber() {
        return convertedNumber;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
}
