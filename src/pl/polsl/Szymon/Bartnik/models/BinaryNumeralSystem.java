package pl.polsl.Szymon.Bartnik.models;

/**
 * Class representing binary numeral system and implementing methods used for
 * computing binary system from/to other numeral systems.
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
public class BinaryNumeralSystem extends NumeralSystem{

    /**
     * Gets binary system full name
     * 
     * @return binary system full name
     */
    @Override
    protected String getSystemName() {
        return "Binary";
    }
    
    /**
     * Converts passed number from binary system to the NumeralSystem 
     * identified by passed NumeralSystem implementation object.
     * 
     * @param numberToConvert number to convert from binary to other numeral system
     * @param outputNumeralSystem instance of NumeralSystem which represents output numeral system.
     * @return passed number representation in numeral system 
     * identified by outputNumeralSystem argument
     * 
     * @throws NumberFormatException when found not allowed character in input binary number
     * @throws NullPointerException when any of parameters is null
     */
    @Override
    public String convertToSpecifiedNumSystem(String numberToConvert, NumeralSystem outputNumeralSystem) {
        
        if(outputNumeralSystem == null) {
            throw new NullPointerException("Output numeral system string cannot be null object.");
        }
        
        if(numberToConvert == null) {
            throw new NullPointerException("Number to convert cannot be null object");
        }
        
        Double numberToConvertAsDecimal = 0.0;
       
        // in loop read every character to convert to decimal
        for(int i=0; i<numberToConvert.length(); i++) {
            char currentCharacter = numberToConvert.charAt(i);
            
            if(currentCharacter == '1') {
                numberToConvertAsDecimal += Math.pow(2, numberToConvert.length()-1-i);
            }
            else if(currentCharacter != '0') { // if used illegal character in binary number
                throw new NumberFormatException("Not allowed character in input binary "
                        + "number found: '" + currentCharacter + "'");
            }
        }
        return outputNumeralSystem.convertFromDecimal(Double.valueOf(numberToConvertAsDecimal).longValue());
    }

    /**
     * Converts passed integer number (in decimal system) to the binary system
     * 
     * @param numberToConvert number in decimal system which we want to convert to binary system.
     * @return input integer number converted to the binary system.
     */
    @Override
    public String convertFromDecimal(Long numberToConvert) {
        
        Long numberToConvertAsBinary[] = new Long[200];
        int index = 0;
        
        // compute binary number from decimal
        while(numberToConvert > 0){
            numberToConvertAsBinary[index++] = (numberToConvert%2);
            numberToConvert = numberToConvert/2;
        }
        
        // store computed binary number as string
        StringBuilder strBuilder = new StringBuilder();
        for(int i = index-1; i>=0; i--)
            strBuilder.append(numberToConvertAsBinary[i]);
        
        return strBuilder.toString();
    }
}