package pl.polsl.Szymon.Bartnik.models;

/**
 *
 * @author Szymon
 */
public class NegativeNumberException extends Exception {

    NegativeNumberException(String msg) {
        super(msg);
    }
    
    NegativeNumberException() {
        super();
    }
}
