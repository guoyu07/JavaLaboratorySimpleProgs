package pl.polsl.Szymon.Bartnik.models;

import java.math.BigInteger;

/**
 * Class representing decimal numeral system and implementing methods used for
 * computing decimal system from/to other numeral systems.
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
public class DecimalNumeralSystem extends NumeralSystem{

    /**
     * Gets decimal system full name
     * 
     * @return decimal system full name
     */
    @Override
    protected String getSystemName() {
        return "Decimal";
    }
    
    /**
     * Converts passed number from decimal system to the NumeralSystem 
     * identified by passed NumeralSystem implementation object.
     * 
     * @param numberToConvert number to convert from decimal to other numeral system
     * @param outputNumeralSystem instance of NumeralSystem which represents output numeral system.
     * @return passed number representation in numeral system 
     * identified by outputNumeralSystem argument
     * 
     * @throws NumberFormatException when detected illegal characters in number to convert
     * @throws NullPointerException when any of parameters is null
     * @throws NegativeNumberException when number to convert is negative (not supported).
     */
    @Override
    public String convertToSpecifiedNumSystem(String numberToConvert, NumeralSystem outputNumeralSystem) 
            throws NumberFormatException, NullPointerException, NegativeNumberException {
        
        if(outputNumeralSystem == null) {
            throw new NullPointerException("Output numeral system string cannot be null object.");
        }
        
        if(numberToConvert == null) {
            throw new NullPointerException("Number to convert cannot be null object");
        }
        
        Long numberToConvertAsDecimal = Long.parseLong(numberToConvert);
        
        if(numberToConvertAsDecimal < 0){
            throw new NegativeNumberException();
        }
        
        return outputNumeralSystem.convertFromDecimal(numberToConvertAsDecimal);
    }

    /**
     * Converts passed integer number (in decimal system) to the decimal system.
     * 
     * @param numberToConvert number in decimal system which we want to convert to decimal system.
     * @return input integer number converted to the decimal system.
     */
    @Override
    public String convertFromDecimal(Long numberToConvert) {
        
        // we doesn't support numbers lower than 0
        if(numberToConvert < 0){
            numberToConvert = 0L;
        }
        
        // no conversion needed in this specific case (base system is decimal)
        return numberToConvert.toString();
    }
}
