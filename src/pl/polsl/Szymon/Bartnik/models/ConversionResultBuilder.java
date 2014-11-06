package pl.polsl.Szymon.Bartnik.models;


public class ConversionResultBuilder {
    private NumeralSystem inNumSys;
    private NumeralSystem outNumSys;
    private String inNum;
    private String outNum;

    public ConversionResultBuilder() {
    }

    public ConversionResultBuilder setInNumSys(NumeralSystem inNumSys) {
        this.inNumSys = inNumSys;
        return this;
    }

    public ConversionResultBuilder setOutNumSys(NumeralSystem outNumSys) {
        this.outNumSys = outNumSys;
        return this;
    }

    public ConversionResultBuilder setInNum(String inNum) {
        this.inNum = inNum;
        return this;
    }

    public ConversionResultBuilder setOutNum(String outNum) {
        this.outNum = outNum;
        return this;
    }

    public ConversionResult createConversionResult() {
        return new ConversionResult(inNumSys, outNumSys, inNum, outNum);
    }
}
