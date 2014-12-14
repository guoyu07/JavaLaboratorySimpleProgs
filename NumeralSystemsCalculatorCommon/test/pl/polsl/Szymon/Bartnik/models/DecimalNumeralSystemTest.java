package pl.polsl.Szymon.Bartnik.models;

import pl.polsl.Szymon.Bartnik.models.exceptions.NegativeNumberException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Set of tests for DecimalNumeralSystem class
 * 
 * @author Szymon
 * @version 1.0
 */
public class DecimalNumeralSystemTest {
    
    private DecimalNumeralSystem instance;
    
    /**
     * Setup which invokes before each test from this class
     */
    @Before
    public void setUp() {
        instance = new DecimalNumeralSystem();
    }

    /**
     * Test of getSystemName method, of class DecimalNumeralSystem.
     */
    @Test
    public void testGetSystemName() {
        // assign
        String expResult = "Decimal";
        
        // act
        String result = instance.getSystemName();
        
        // assert
        assertEquals(expResult, result);
    }

    /**
     * Test of convertToSpecifiedNumSystem method, of class DecimalNumeralSystem.
     */
    @Test
    public void testConvertToSpecifiedNumSystem() 
            throws NumberFormatException, NullPointerException, NegativeNumberException {
        // assign
        NumeralSystem outputNumeralSystem1 = new DecimalNumeralSystem();
        NumeralSystem outputNumeralSystem2 = new BinaryNumeralSystem();
        
        String numberToConvert1 = "0";
        String numberToConvert2 = "342343";
        String numberToConvert3 = "676756";
        String numberToConvert4 = "67546676756756";
        String numberToConvert5 = "77567563";
        
        String expResult1 = "0";
        String expResult2 = "342343";
        String expResult3 = "10100101001110010100";
        String expResult4 = "1111010110111011101111101011001000000100010100";
        String expResult5 = "100100111111001011001001011";
        
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
     * Test of convertFromDecimal method, of class DecimalNumeralSystem.
     */
    @Test
    public void testConvertFromDecimal() {
        // assign
        Long numberToConvert1 = -34L;
        Long numberToConvert2 = 0L;
        Long numberToConvert3 = 334L;
        Long numberToConvert4 = 532423L;
        
        String expResult1 = "0";
        String expResult2 = "0";
        String expResult3 = "334";
        String expResult4 = "532423";
        
        // act
        String result1 = instance.convertFromDecimal(numberToConvert1);
        String result2 = instance.convertFromDecimal(numberToConvert2);
        String result3 = instance.convertFromDecimal(numberToConvert3);
        String result4 = instance.convertFromDecimal(numberToConvert4);
        
        // assert
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
    }
    
    /**
     * Tests if method convertToSpecifiedNumSystem from DecimalNumeralSystem
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
        String numberToConvert = "45346673";
        
        // act
        instance.convertToSpecifiedNumSystem(numberToConvert, outputNumeralSystem);
        
        // assert
        fail("Should have thrown an exception because passed numeral system is null");
    }
    
    /**
     * Tests if method convertToSpecifiedNumSystem from DecimalNumeralSystem
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
     * Tests if method convertToSpecifiedNumSystem from DecimalNumeralSystem
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
        String numberToConvert = "-2434";
        
        // act
        instance.convertToSpecifiedNumSystem(numberToConvert, outputNumeralSystem);
        
        // assert
        fail("Should have thrown an exception because passed number to convert is negative");
    }
    
    /**
     * Tests if method convertToSpecifiedNumSystem from DecimalNumeralSystem
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
     * Tests if method convertToSpecifiedNumSystem from DecimalNumeralSystem
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
        String numberToConvert = "3235f3425";
        
        // act
        instance.convertToSpecifiedNumSystem(numberToConvert, outputNumeralSystem);
        
        // assert
        fail("Should have thrown an exception because passed number to convert has illegal characters");
    }
}
