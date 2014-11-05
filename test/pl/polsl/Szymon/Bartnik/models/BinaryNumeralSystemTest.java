package pl.polsl.Szymon.Bartnik.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Set of tests for BinaryNumeralSystem class
 * 
 * @author Szymon
 * @version 1.0
 */
public class BinaryNumeralSystemTest {
    
    private BinaryNumeralSystem instance;
    
    /**
     * Setup which invokes before each test from this class
     */
    @Before
    public void setUp() {
        instance = new BinaryNumeralSystem();
    }

    /**
     * Test of getSystemName method, of class BinaryNumeralSystem.
     */
    @Test
    public void testGetSystemName() {
        // assign
        String expResult = "Binary";
        
        // act
        String result = instance.getSystemName();
        
        // assert
        assertEquals(expResult, result);
    }

    /**
     * Test of convertToSpecifiedNumSystem method, of class BinaryNumeralSystem.
     */
    @Test
    public void testConvertToSpecifiedNumSystem() 
            throws NumberFormatException, NullPointerException, NegativeNumberException {
        // assign
        NumeralSystem outputNumeralSystem1 = new BinaryNumeralSystem();
        NumeralSystem outputNumeralSystem2 = new DecimalNumeralSystem();
        
        String numberToConvert1 = "0";
        String numberToConvert2 = "1010101";
        String numberToConvert3 = "1010101001011";
        String numberToConvert4 = "101100";
        String numberToConvert5 = "0100000000000";
        
        String expResult1 = "0";
        String expResult2 = "1010101";
        String expResult3 = "5451";
        String expResult4 = "44";
        String expResult5 = "2048";
        
        // act
        String result1 = instance.convertToSpecifiedNumSystem(numberToConvert1, outputNumeralSystem1);
        String result2 = instance.convertToSpecifiedNumSystem(numberToConvert2, outputNumeralSystem1);
        String result3 = instance.convertToSpecifiedNumSystem(numberToConvert3, outputNumeralSystem2);
        String result4 = instance.convertToSpecifiedNumSystem(numberToConvert4, outputNumeralSystem2);
        String result5 = instance.convertToSpecifiedNumSystem(numberToConvert5, outputNumeralSystem2);
        
        // assert
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
        assertEquals(expResult5, result5);
    }

    /**
     * Test of convertFromDecimal method, of class BinaryNumeralSystem.
     */
    @Test
    public void testConvertFromDecimal() {
        // assign
        Long numberToConvert1 = -45L;
        Long numberToConvert2 = 0L;
        Long numberToConvert3 = 5L;
        Long numberToConvert4 = 34234L;
        Long numberToConvert5 = 3423654675L;
        
        String expResult1 = "0";
        String expResult2 = "0";
        String expResult3 = "101";
        String expResult4 = "1000010110111010";
        String expResult5 = "11001100000100001101001100010011";
        
        // act
        String result1 = instance.convertFromDecimal(numberToConvert1);
        String result2 = instance.convertFromDecimal(numberToConvert2);
        String result3 = instance.convertFromDecimal(numberToConvert3);
        String result4 = instance.convertFromDecimal(numberToConvert4);
        String result5 = instance.convertFromDecimal(numberToConvert5);
        
        // assert
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
        assertEquals(expResult5, result5);
    }
    
    /**
     * Tests if method convertToSpecifiedNumSystem from BinaryNumeralSystem
     * throws an exception if output numeral system string is null
     * 
     * @throws NumberFormatException
     * @throws NullPointerException
     * @throws NegativeNumberException
     */
    @Test(expected = NullPointerException.class)
    public void testThrowsExceptionIfOutputNumeralSystemIsNull() 
            throws NumberFormatException, NullPointerException, NegativeNumberException{
        // assign
        NumeralSystem outputNumeralSystem = null;
        String numberToConvert = "10101";
        
        // act
        instance.convertToSpecifiedNumSystem(numberToConvert, outputNumeralSystem);
        
        // assert
        fail("Should have thrown an exception because passed numeral system is null");
    }
    
    /**
     * Tests if method convertToSpecifiedNumSystem from BinaryNumeralSystem
     * throws an exception if number to convert string is null
     * 
     * @throws NumberFormatException
     * @throws NullPointerException
     * @throws NegativeNumberException
     */
    @Test(expected = NullPointerException.class)
    public void testThrowsExceptionIfNumberToConvertIsNull() 
            throws NumberFormatException, NullPointerException, NegativeNumberException{
        // assign
        NumeralSystem outputNumeralSystem = new BinaryNumeralSystem();
        String numberToConvert = null;
        
        // act
        instance.convertToSpecifiedNumSystem(numberToConvert, outputNumeralSystem);
        
        // assert
        fail("Should have thrown an exception because passed number to convert is null");
    }
    
    /**
     * Tests if method convertToSpecifiedNumSystem from BinaryNumeralSystem
     * throws an exception if number to convert string is negative.
     * 
     * @throws NumberFormatException
     * @throws NullPointerException
     * @throws NegativeNumberException
     */
    @Test(expected = NegativeNumberException.class)
    public void testThrowsExceptionIfPassedNegativeNumberToConvert() 
            throws NumberFormatException, NullPointerException, NegativeNumberException{
        // assign
        NumeralSystem outputNumeralSystem = new DecimalNumeralSystem();
        String numberToConvert = "-10110";
        
        // act
        instance.convertToSpecifiedNumSystem(numberToConvert, outputNumeralSystem);
        
        // assert
        fail("Should have thrown an exception because passed number to convert is negative");
    }
    
    /**
     * Tests if method convertToSpecifiedNumSystem from BinaryNumeralSystem
     * throws an exception if number to convert string is empty.
     * 
     * @throws NumberFormatException
     * @throws NullPointerException
     * @throws NegativeNumberException
     */
    @Test(expected = NumberFormatException.class)
    public void testThrowsExceptionIfPassedNumberToConvertIsZeroLength() 
            throws NumberFormatException, NullPointerException, NegativeNumberException{
        // assign
        NumeralSystem outputNumeralSystem = new DecimalNumeralSystem();
        String numberToConvert = "";
        
        // act
        instance.convertToSpecifiedNumSystem(numberToConvert, outputNumeralSystem);
        
        // assert
        fail("Should have thrown an exception because passed number to convert is empty");
    }
    
    /**
     * Tests if method convertToSpecifiedNumSystem from BinaryNumeralSystem
     * throws an exception if number to convert contains illegal characters.
     *
     * @throws NumberFormatException
     * @throws NullPointerException
     * @throws NegativeNumberException
     */
    @Test(expected = NumberFormatException.class)
    public void testThrowsExceptionIfPassedNumberToConvertHasIllegalCharacters() 
            throws NumberFormatException, NullPointerException, NegativeNumberException{
        // assign
        NumeralSystem outputNumeralSystem = new DecimalNumeralSystem();
        String numberToConvert = "1001f0";
        
        // act
        instance.convertToSpecifiedNumSystem(numberToConvert, outputNumeralSystem);
        
        // assert
        fail("Should have thrown an exception because passed number to convert has illegal characters");
    }
}
