package pl.polsl.Szymon.Bartnik.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Szymon
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
}
