package pl.polsl.Szymon.Bartnik.models;

import java.lang.annotation.*;

/**
 * AdditionalInfo interface - adnotation storing information
 * about class modifiers
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface AdditionalInfo {
    
    /**
     * Declaration of Padding enum, storing information
     * about padding of text in console
     */
    public enum Exclusion {

        ACTIVE, INACTIVE
    };
    
    Exclusion exclusion() default Exclusion.INACTIVE;
}
