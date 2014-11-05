package pl.polsl.Szymon.Bartnik.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Szymon
 */
public class DecimalNumeralSystemTest {
    
    private DecimalNumeralSystem instance;
    
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
    public void testConvertToSpecifiedNumSystem() {
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
        Long numberToConvert1 = 0L;
        Long numberToConvert2 = 334L;
        Long numberToConvert3 = 532423L;
        
        String expResult1 = "0";
        String expResult2 = "334";
        String expResult3 = "532423";
        
        // act
        String result1 = instance.convertFromDecimal(numberToConvert1);
        String result2 = instance.convertFromDecimal(numberToConvert2);
        String result3 = instance.convertFromDecimal(numberToConvert3);
        
        // assert
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }
    
}
