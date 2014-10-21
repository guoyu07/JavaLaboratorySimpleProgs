package pl.polsl.Szymon.Bartnik.views;

import pl.polsl.Szymon.Bartnik.controller.CalculatorController;

/**
 *
 * @author Szymon
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
            ViewManager viewManager = new ViewManager(args);
            viewManager.printPassedParameters();

            CalculatorController calcController = new CalculatorController(args);
            viewManager.parseNumbersAndPrintResults(calcController);
        } 
        catch(Exception ex) { } // all exceptions are handled in lower layers
    }
}
