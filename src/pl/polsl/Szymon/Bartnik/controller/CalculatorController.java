package pl.polsl.Szymon.Bartnik.controller;

import pl.polsl.Szymon.Bartnik.models.NumeralSystem;
import pl.polsl.Szymon.Bartnik.models.NumeralSystemFactory;

/**
 * Controller class responsible for controlling process of calculating
 * between numeral systems. Object can be used directly from view class.
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
public class CalculatorController {

    public NumeralSystem inNumSystem = null;  // stores input numeral system
    public NumeralSystem outNumSystem = null; // stores output numeral system
    
    /**
     * Constructor taking arguments passed to the main method. Creates an instance
     * of CalculationController class and object can be used directly from the 
     * appropriate view
     * 
     * @param args console arguments passed to the main method
     * @throws ArrayIndexOutOfBoundsException
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
     * @return converted number coded in output numeral system
     */
    public String convertNumber(String inputNumber){
        
        return inNumSystem.convertToSpecifiedNumSystem(inputNumber, outNumSystem);
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
