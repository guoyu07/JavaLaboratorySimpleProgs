package pl.polsl.Szymon.Bartnik.views;

import pl.polsl.Szymon.Bartnik.controller.CalculatorController;

/**
 * Application is simple calculator of numeral systems which can operate
 * (for now) on decimal and binary numbers using object-oriented architecture.
 * 
 * @author Szymon Bartnik (grupa 2)
 */
public class ViewManager {
    
    private final String[] args;
    
    public ViewManager(String[] args) {
        this.args = args;
    }
    
    public void printPassedParameters() {
        
        System.out.println("Program parameters: ");
        
        // write all the parameters passed to the program
        for (int i=0; i<args.length; i++) {
            System.out.println("parameter " + (i + 1) + ":" + args[i]);
        }
    }    

    public void parseNumbersAndPrintResults(CalculatorController calcController) 
        throws NumberFormatException, NullPointerException {
        
        try {
            // for each number convert to the output numeral system
            for(int i=2; i<args.length; i++) {
                // invoke convert method and present the result
                System.out.println(
                    args[i] + " in " + calcController.inNumSystem + " is " + 
                    calcController.convertNumber(args[i]) + " in " + calcController.outNumSystem);
            }
        } 
        catch(NumberFormatException | NullPointerException ex){
            System.out.println("Error occured and numbers convertion cannot be continued. "
                    + "Error: " + ex.getMessage());
            throw ex;
        }
    }
}