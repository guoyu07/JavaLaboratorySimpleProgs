package pl.polsl.Szymon.Bartnik.views;

import pl.polsl.Szymon.Bartnik.controller.CalculatorController;

/**
 * Application is simple calculator of numeral systems which can operate
 * (for now) on decimal and binary numbers using object-oriented architecture.
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
public class EntryPoint {
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
        
        try {
            // Creating class of view
            ViewManager viewManager = new ViewManager(args);
            
            // Printing passed arguments to the output.
            viewManager.printPassedParameters();

            // Creating an instance of calculator controller class
            CalculatorController calcController = new CalculatorController(args);
            
            // Parsing numbers and printing the results
            viewManager.parseNumbersAndPrintResults(calcController);
        } 
        catch(Exception ex) { } // all exceptions are handled in lower layers
    }
}
