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
    
    public ConversionResult(NumeralSystem inNumSys, NumeralSystem outNumSys, String inNum, String outNum) {
        
        this.inputNumeralSystem = inNumSys;
        this.outputNumeralSystem = outNumSys;
        this.inputNumber = inNum;
        this.outputNumber = outNum;
    }

    /**
     * @return the inputNumeralSystem
     */
    public NumeralSystem getInputNumeralSystem() {
        return inputNumeralSystem;
    }

    /**
     * @return the outputNumeralSystem
     */
    public NumeralSystem getOutputNumeralSystem() {
        return outputNumeralSystem;
    }

    /**
     * @return the inputNumber
     */
    public String getInputNumber() {
        return inputNumber;
    }

    /**
     * @return the outputNumber
     */
    public String getOutputNumber() {
        return outputNumber;
    }
}
