package pl.polsl.Szymon.Bartnik.views;

import pl.polsl.Szymon.Bartnik.models.NumeralSystem;
import pl.polsl.Szymon.Bartnik.models.NumeralSystemFactory;

/**
 * Application is simple calculator of numeral systems which can operate
 * (for now) on decimal and binary numbers using object-oriented architecture.
 * 
 * @author Szymon Bartnik (grupa 2)
 */
public class ProgramParameters {

    static NumeralSystem inNumSystem = null;
    static NumeralSystem outNumSystem = null;

    static boolean errorOccured = false;
    
    /**
     * Main method of application.
     * 
     * @param args with following sytax:
     * 1. input numeral system (bin / dec)
     * 2. output numeral system (bin / dec)
     * 3. array of numbers to convert
     *  
     * For example: 'bin dec 1010' parameters should
     * return '1010' binary number in decimal format (10).
     */
    public static void main(String[] args) {
        
        // print console arguments passed to the application
        PrintPassedParamters(args);
        
        // checking if parsing input and output systems failed
        if(!ReadInputAndOutputNumeralSystems(args))
            return;
        
        // parse numbers intended to convert to another system and print results
        ParseNumbersAndPrintResults(args);
    }

    private static void PrintPassedParamters(String[] args) {
        
        System.out.println("Program parameters: ");
        
        // write all the parameters passed to the program
        for (int i=0; i<args.length; i++) {
            System.out.println("parameter " + (i + 1) + ":" + args[i]);
        }
    }

    private static boolean ReadInputAndOutputNumeralSystems(String[] args) {
        
        try {
            inNumSystem = NumeralSystemFactory.GetObject(args[0]);
            outNumSystem = NumeralSystemFactory.GetObject(args[1]);
        } 
        catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Too little arguments specified. "
                    + "Use following syntax: inputNumSys:[bin/dec] outputNumSys:[bin/dec] numbersToFormat[]");
            return false;
        }
        catch(IllegalArgumentException ex){
            System.out.println("Error in one or more arguments: " + ex.getMessage());
            return false;
        }
        
        // if any error occured
        return true;
    }

    private static void ParseNumbersAndPrintResults(String[] args) {
        
        try{
            // for each number convert to the output numeral system
            for(int i=2; i<args.length; i++){
                // convert the number
                String result = inNumSystem.convertToSpecifiedNumSystem(args[i], outNumSystem);
                // present the result
                System.out.println(
                    args[i] + " in " + inNumSystem.getSystemName() + " is " + 
                    result + " in " + outNumSystem.getSystemName());
            }
        } 
        catch(NumberFormatException | NullPointerException ex){
            System.out.println("Error occured and numbers convertion cannot be continued. "
                    + "Error: " + ex.getMessage());
        }
    }
}