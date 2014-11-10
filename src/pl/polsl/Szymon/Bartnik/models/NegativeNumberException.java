package pl.polsl.Szymon.Bartnik.models;

/**
 * Exception occuring when negative number
 * is prohibited in current context
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 2.0
 */
public class NegativeNumberException extends Exception {

    NegativeNumberException(String msg) {
        super(msg);
    }
    
    NegativeNumberException() {
        super();
    }
}
