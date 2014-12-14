package pl.polsl.Szymon.Bartnik.exceptions;

/**
 * Exception occuring when there was an error
 * while server answer was answering.
 * 
 * @author Szymon Bartnik (Grupa 2)
 * @version 1.0
 */
public class ServerAnswerException extends Exception {

    public ServerAnswerException(String errorMessage) {
        super(errorMessage);
    }
}
