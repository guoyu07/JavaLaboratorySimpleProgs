package pl.polsl.Szymon.Bartnik.controller;

import pl.polsl.Szymon.Bartnik.models.ConversionResult;
import pl.polsl.Szymon.Bartnik.models.ConversionResultBuilder;
import pl.polsl.Szymon.Bartnik.models.NegativeNumberException;
import pl.polsl.Szymon.Bartnik.models.NumeralSystem;
import pl.polsl.Szymon.Bartnik.models.NumeralSystemFactory;

/**
 * Controller class responsible for controlling process of calculating
 * between numeral systems. Object can be used directly from view class.
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 2.0
 */
public class CalculatorController {

    private NumeralSystem inNumSystem = null;  // stores input numeral system
    private NumeralSystem outNumSystem = null; // stores output numeral system
    
    /**
     * Constructor taking arguments passed to the main method. Creates an instance
     * of CalculationController class and object can be used directly from the 
     * appropriate view
     * 
     * @param args console arguments passed to the main method
     * @throws ArrayIndexOutOfBoundsException when specified too little arguments
     * @throws IllegalArgumentException when there was specified not supported numeral system
     */
    public CalculatorController(String[] args) 
        throws ArrayIndexOutOfBoundsException, IllegalArgumentException{
        
        readInputAndOutputNumeralSystems(args);
    }
    
    /**
     * Converts number number basing on (in/out)put numeral systems in the current
     * instance of the class.
     * 
     * @param inputNumber
     * @return conversion result class storing all required information
     * @throws NegativeNumberException if passed negative number
     */
    public ConversionResult convertNumber(String inputNumber) 
            throws NumberFormatException, NullPointerException, NegativeNumberException{
        
        String result = inNumSystem.convertToSpecifiedNumSystem(inputNumber, outNumSystem);
        
        return new ConversionResultBuilder()
                .setInNumSys(inNumSystem)
                .setOutNumSys(outNumSystem)
                .setInNum(inputNumber)
                .setOutNum(result)
                .createConversionResult();
    }
    
    /**
     * Reads input and output numeral systems and remembers them in the current
     * instance of the class. 
     * 
     * @param args console arguments passed to the main method
     * @throws ArrayIndexOutOfBoundsException when specified too little arguments
     * @throws IllegalArgumentException when there was specified not supported numeral system
     */
    private void readInputAndOutputNumeralSystems(String[] args)
        throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
       
        try {
            inNumSystem = NumeralSystemFactory.getObject(args[0]);
            outNumSystem = NumeralSystemFactory.getObject(args[1]);
        } 
        catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Too little arguments specified. "
                    + "Use following syntax: inputNumSys:[bin/dec] outputNumSys:[bin/dec] numbersToFormat[]");
            throw ex;
        }
        catch(IllegalArgumentException ex) {
            System.out.println("Error in one or more arguments: " + ex.getMessage());
            throw ex;
        }
    }
}
