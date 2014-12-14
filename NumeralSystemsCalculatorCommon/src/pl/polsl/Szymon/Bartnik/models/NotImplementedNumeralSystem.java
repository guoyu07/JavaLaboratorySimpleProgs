package pl.polsl.Szymon.Bartnik.models;

import pl.polsl.Szymon.Bartnik.models.exceptions.NegativeNumberException;

/**
 * Not implemented numeral system presenting capabilities of
 * exclusion parameter of AdditionalInfo adnotation.
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 2.0
 */
@AdditionalInfo(exclusion = AdditionalInfo.Exclusion.ACTIVE)
public class NotImplementedNumeralSystem extends NumeralSystem {

    /**
     * Gets system full name
     * 
     * @return system full name
     */
    @Override
    protected String getSystemName() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /**
     * Converts passed number from input system system to the NumeralSystem 
     * identified by passed NumeralSystem implementation object.
     * 
     * @param numberToConvert number to convert from input to other numeral system
     * @param outputNumeralSystem instance of NumeralSystem which represents output numeral system.
     * @return passed number representation in numeral system 
     * identified by outputNumeralSystem argument
     * @throws pl.polsl.Szymon.Bartnik.models.NegativeNumberException when negative number occur
     */
    @Override
    public String convertToSpecifiedNumSystem(String numberToConvert, NumeralSystem outputNumeralSystem) 
            throws NumberFormatException, NullPointerException, NegativeNumberException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Converts passed integer number (in decimal system) to the output system
     * 
     * @param numberToConvert number in decimal system which we want to convert to output system.
     * @return input integer number converted to the output system.
     */
    @Override
    public String convertFromDecimal(Long numberToConvert) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
