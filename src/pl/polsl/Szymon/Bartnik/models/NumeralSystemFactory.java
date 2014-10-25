package pl.polsl.Szymon.Bartnik.models;

/**
 * Static class with static method implementing abstract factory design pattern
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
public class NumeralSystemFactory {
    
    /**
     * Returns instance of appropriate implementation of NumeralSystem by passed argument
     * 
     * @param numeralSystem identifies concrete implementation of NumeralSystem class
     * @return instance of implementation of NumeralSystem class
     * 
     * @throws NullPointerException when input string is null
     * @throws IllegalArgumentException when specified numeral system is not supported
     */
    public static NumeralSystem getObject(String numeralSystem) 
            throws NullPointerException, IllegalArgumentException{
        
        if(numeralSystem == null) {
            throw new NullPointerException("Numeral system string cannot be null object");
        }
        
        switch(numeralSystem) {
            case "bin": 
                return new BinaryNumeralSystem();
            case "dec": 
                return new DecimalNumeralSystem();
            default: 
                throw new IllegalArgumentException("Specified numeral system not supported: '" + numeralSystem + "'");
        }
    }
}