package pl.polsl.Szymon.Bartnik.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Set of tests for NumeralSystemFactory class
 * 
 * @author Szymon
 * @version 1.0
 */
public class NumeralSystemFactoryTest {
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getObject method, of class NumeralSystemFactory.
     */
    @Test
    public void testGetObject() {
        // assign
        String numeralSystem1 = "bin";
        String numeralSystem2 = "dec";
        
        NumeralSystem expResult1 = new BinaryNumeralSystem();
        NumeralSystem expResult2 = new DecimalNumeralSystem();
        
        // act
        NumeralSystem result1 = NumeralSystemFactory.getObject(numeralSystem1);
        NumeralSystem result2 = NumeralSystemFactory.getObject(numeralSystem2);
        
        // assert
        assertEquals(expResult1.getClass(), result1.getClass());
        assertEquals(expResult2.getClass(), result2.getClass());
    }
    
    /**
     * Tests if method getObject from class NumeralSystemFactory 
     * throws an exception when trying to get not existing numeral system.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testThrowsExceptionIfTryingToGetNumeralSystemWhichDoesNotExists() {
        // assign
        String numeralSystem = "notExistingSystem";
        
        // act
        NumeralSystemFactory.getObject(numeralSystem);
        
        // assert
        fail("Should have thrown an exception because specified numeral system does not exists");
    }
    
    /**
     * Tests if method getObject from class NumeralSystemFactory
     * throws an exception when trying to invoke it with null argument
     */
    @Test(expected = NullPointerException.class)
    public void testThrowsExceptionIfTryingToGetNumeralSystemSpecifyingNullArgument() {
        // assign
        String numeralSystem = null;
        
        // act
        NumeralSystemFactory.getObject(numeralSystem);
        
        // assert
        fail("Should have thrown an exception because argument was null");
    }
}
