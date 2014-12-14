package pl.polsl.Szymon.Bartnik.models;

/**
 * Static class with static method implementing abstract factory design pattern
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 2.0
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
        
        NumeralSystem numeralSystemToReturn = null;
        
        switch(numeralSystem) {
            case "bin": 
                numeralSystemToReturn = new BinaryNumeralSystem();
                break;
            case "dec": 
                numeralSystemToReturn = new DecimalNumeralSystem();
                break;
            case "notImplemented":
                numeralSystemToReturn = new NotImplementedNumeralSystem();
                break;
            default: 
                throw new IllegalArgumentException("Specified numeral system not supported: '" + numeralSystem + "'");
        }
        
        // checking if selected class has not been deactivated
        Class runtimeClass = numeralSystemToReturn.getClass();
        if(runtimeClass.isAnnotationPresent(AdditionalInfo.class)) {
            
            AdditionalInfo addInfo = (AdditionalInfo) runtimeClass.getAnnotation(AdditionalInfo.class);
            
            if(addInfo.exclusion() == AdditionalInfo.Exclusion.ACTIVE){
                throw new IllegalArgumentException("The " + runtimeClass.getName() + " class has been deactivated");
            }
        }
        
        return numeralSystemToReturn;
    }
}