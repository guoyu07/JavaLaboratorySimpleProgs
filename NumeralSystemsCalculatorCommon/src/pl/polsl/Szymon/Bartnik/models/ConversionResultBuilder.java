package pl.polsl.Szymon.Bartnik.models;

/**
 * Used to create instance of ConversionResult
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 2.0
 */
public class ConversionResultBuilder {
    private NumeralSystem inNumSys;
    private NumeralSystem outNumSys;
    private String inNum;
    private String outNum;

    /**
     * Default constructor, used to create instance of the class
     */
    public ConversionResultBuilder() {
    }

    /**
     * Sets input numeral system
     * 
     * @param inNumSys input numeral system
     * @return current instance of this class
     */
    public ConversionResultBuilder setInNumSys(NumeralSystem inNumSys) {
        this.inNumSys = inNumSys;
        return this;
    }

    /**
     * Sets output numeral system
     * 
     * @param outNumSys output numeral system
     * @return current instance of this class
     */
    public ConversionResultBuilder setOutNumSys(NumeralSystem outNumSys) {
        this.outNumSys = outNumSys;
        return this;
    }

    /**
     * Sets input number
     * 
     * @param inNum input number
     * @return current instance of this class
     */
    public ConversionResultBuilder setInNum(String inNum) {
        this.inNum = inNum;
        return this;
    }

    /**
     * Sets output converted number
     * 
     * @param outNum output converted number
     * @return current instance of this class
     */
    public ConversionResultBuilder setOutNum(String outNum) {
        this.outNum = outNum;
        return this;
    }

    /**
     * Builds conversion result class. 
     * @return ConversionResult instance created from internal variables
     */
    public ConversionResult createConversionResult() {
        return new ConversionResult(inNumSys, outNumSys, inNum, outNum);
    }
}
