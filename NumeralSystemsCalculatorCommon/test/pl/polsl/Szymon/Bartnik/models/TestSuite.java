package pl.polsl.Szymon.Bartnik.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Runs all test classes
 * 
 * @author Szymon
 * @version 1.0
 */
@RunWith(Suite.class)
@SuiteClasses({
    BinaryNumeralSystemTest.class,
    DecimalNumeralSystemTest.class,
    NumeralSystemFactoryTest.class,})
public class TestSuite {
}
