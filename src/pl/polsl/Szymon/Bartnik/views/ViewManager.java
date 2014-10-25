package pl.polsl.Szymon.Bartnik.views;

import pl.polsl.Szymon.Bartnik.controller.CalculatorController;

/**
 * View class using to cooperate with the user (user interface class).
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
public class ViewManager {
    
    // arguments passed to the main method
    private final String[] args;
    
    /**
     * Constructor taking arguments passed to the main method.
     * @param args run arguments passed usually to the main method
     */
    public ViewManager(String[] args) {
        this.args = args;
    }
    
    /**
     * Prints run arguments passed to the program.
     */
    public void printPassedParameters() {
        
        System.out.println("Program parameters: ");
        
        // write all the parameters passed to the program
        for (int i=0; i<args.length; i++) {
            System.out.println("parameter " + (i + 1) + ":" + args[i]);
        }
    }    

    /**
     * Parses numbers and prints result using passed instance of CalculationController.
     * 
     * 
     * @param calcController instance of CalculationController class 
     * @throws NumberFormatException if in any step of conversion occured an error connected
     * with wrong format of converted number.
     * @throws NullPointerException if passed null argument
     */
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