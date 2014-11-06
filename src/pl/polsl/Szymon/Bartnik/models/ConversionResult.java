package pl.polsl.Szymon.Bartnik.models;

/**
 * Class storing result of internumeral system conversion.
 * 
 * @author Szymon
 * @version 1.0
 */
public class ConversionResult {
    
    private final NumeralSystem inputNumeralSystem;
    private final NumeralSystem outputNumeralSystem;
    
    private final String inputNumber;
    private final String outputNumber;
    
    /**
     * Constructor creating result of internumeral system conversion
     * 
     * @param inNumSys input numeral system
     * @param outNumSys output numeral system
     * @param inNum input number
     * @param outNum output number
     */
    public ConversionResult(NumeralSystem inNumSys, NumeralSystem outNumSys, String inNum, String outNum) {
        
        this.inputNumeralSystem = inNumSys;
        this.outputNumeralSystem = outNumSys;
        this.inputNumber = inNum;
        this.outputNumber = outNum;
    }

    /**
     * Gets input numeral system
     * 
     * @return the inputNumeralSystem
     */
    public NumeralSystem getInputNumeralSystem() {
        return inputNumeralSystem;
    }

    /**
     * Gets output numeral system
     * 
     * @return the outputNumeralSystem
     */
    public NumeralSystem getOutputNumeralSystem() {
        return outputNumeralSystem;
    }

    /**
     * Gets input number
     * 
     * @return the inputNumber
     */
    public String getInputNumber() {
        return inputNumber;
    }

    /**
     * Gets output converted number
     * 
     * @return the outputNumber
     */
    public String getOutputNumber() {
        return outputNumber;
    }
}
