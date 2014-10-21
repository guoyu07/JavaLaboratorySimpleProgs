package pl.polsl.Szymon.Bartnik.controller;

import pl.polsl.Szymon.Bartnik.models.NumeralSystem;
import pl.polsl.Szymon.Bartnik.models.NumeralSystemFactory;

/**
 *
 * @author Szymon
 */
public class CalculatorController {

    public NumeralSystem inNumSystem = null;
    public NumeralSystem outNumSystem = null;
    
    public CalculatorController(String[] args) 
        throws ArrayIndexOutOfBoundsException, IllegalArgumentException{
        
        readInputAndOutputNumeralSystems(args);
    }
    
    public String convertNumber(String inputNumber){
        
        return inNumSystem.convertToSpecifiedNumSystem(inputNumber, outNumSystem);
    }
    
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
