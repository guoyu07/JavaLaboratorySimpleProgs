package pl.polsl.Szymon.Bartnik.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Szymon
 */
public class BinaryNumeralSystemTest {
    
    private BinaryNumeralSystem instance;
    
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
    public void testConvertToSpecifiedNumSystem() {
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
        Long numberToConvert1 = 0L;
        Long numberToConvert2 = 3L;
        Long numberToConvert3 = 5L;
        Long numberToConvert4 = 34234L;
        Long numberToConvert5 = 3423654675L;
        
        String expResult1 = "0";
        String expResult2 = "11";
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
}
