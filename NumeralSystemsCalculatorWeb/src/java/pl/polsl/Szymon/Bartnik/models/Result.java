package pl.polsl.Szymon.Bartnik.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Model class accumulating numeral systems computation result.
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
public class Result {
    
    /** Result id */
    private final int id;
    /** ID of owner of the record of result */
    private int userId;
    /** Source numeral system */
    private final String fromNumeralSystem;
    /** Number to convert */
    private final String numberToConvert;
    /** Destination numeral system */
    private final String toNumeralSystem;
    /** Converted number */
    private final String convertedNumber;

    /**
     * Initializes current instance of Result class by passed result set.
     * 
     * @param rs result set from which reading init values for current instance of Result class.
     * @throws SQLException when problems during reading from sql result set occured.
     */
    public Result(ResultSet rs) 
            throws SQLException {
        
        id = rs.getInt("id");
        userId = rs.getInt("userid");
        fromNumeralSystem = rs.getString("fromnumeralsystem");
        toNumeralSystem = rs.getString("tonumeralsystem");
        numberToConvert = rs.getString("numbertoconvert");
        convertedNumber = rs.getString("convertednumber");
    }

    /**
     * Gets the user ID.
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets source numeral system.
     * @return the fromNumeralSystem
     */
    public String getFromNumeralSystem() {
        return fromNumeralSystem;
    }
    
    /**
     * Gets destination numeral system.
     * @return the toNumeralSystem
     */
    public String getToNumeralSystem() {
        return toNumeralSystem;
    }

    /**
     * Gets number to convert.
     * @return the numberToConvert
     */
    public String getNumberToConvert() {
        return numberToConvert;
    }
    
    /**
     * Gets converted number.
     * @return the convertedNumber
     */
    public String getConvertedNumber() {
        return convertedNumber;
    }

    /**
     * Gets result db id.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Checks if class is appropriate after JSON deserialization
     * and throws an exception if not.
     * 
     * @throws IllegalArgumentException if validation was not successfull.
     */
    public void validateAfterDeserialization() 
        throws IllegalArgumentException {
        
        if(fromNumeralSystem != null && toNumeralSystem != null &&
                numberToConvert != null && convertedNumber != null){
            return;
        }
        
        throw new IllegalArgumentException(
                "One of the arguments of request hasn't been specified");
    }
}
