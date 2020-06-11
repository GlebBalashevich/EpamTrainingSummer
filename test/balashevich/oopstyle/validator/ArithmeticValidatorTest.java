package balashevich.oopstyle.validator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArithmeticValidatorTest {
    ArithmeticValidator arithmeticValidator;

    @BeforeTest
    public void setUp() {
        arithmeticValidator = new ArithmeticValidator();
    }

    @DataProvider(name = "numberSequencePositiveData")
    public Object[][] createNumberSequencePositiveData() {
        return new Object[][]{
                {false, null},
                {false, 1},
                {true, new int[]{2, 3, 6, 1}}
        };
    }

    @Test(dataProvider = "numberSequencePositiveData")
    public void testValidateNumbersSequencePositive(boolean expected, int... numbers) {
        boolean actual = arithmeticValidator.validateNumbersSequence(numbers);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "numberSequenceNegativeData")
    public Object[][] createNumberSequenceNegativeData() {
        return new Object[][]{
                {true, null},
                {true, 1},
                {false, new int[]{2, 3, 6, 1}}
        };
    }

    @Test(dataProvider = "numberSequenceNegativeData")
    public void testValidateNumbersSequenceNegative(boolean expected, int... numbers) {
        boolean actual = arithmeticValidator.validateNumbersSequence(numbers);
        assertNotEquals(actual, expected);
    }

    @DataProvider(name = "functionArgumentPositiveData")
    public Object[][] createFunctionArgumentPositiveData() {
        return new Object[][]{
                {3, true},
                {-5, true},
                {3.7, true},
                {Math.cbrt(6), false}
        };
    }

    @Test(dataProvider = "functionArgumentPositiveData")
    public void testValidateFunctionArgumentPositive(double argument, boolean expected) {
        boolean actual = arithmeticValidator.validateFunctionArgument(argument);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "functionArgumentNegativeData")
    public Object[][] createFunctionArgumentNegativeData() {
        return new Object[][]{
                {3, false},
                {-5, false},
                {3.7, false},
                {Math.cbrt(6), true}
        };
    }

    @Test(dataProvider = "functionArgumentNegativeData")
    public void testValidateFunctionArgumentNegative(double argument, boolean expected) {
        boolean actual = arithmeticValidator.validateFunctionArgument(argument);
        assertNotEquals(actual, expected);
    }

    @DataProvider(name = "lineSegmentPositiveData")
    public Object[][] createSegmentPositiveData() {
        return new Object[][]{
                {3, 10, 1},
                {10, 3, -1},
                {1, 10, 0.5}
        };
    }

    @Test(dataProvider = "lineSegmentPositiveData")
    public void testValidateLineSegmentPositive(double firstPoint, double secondPoint, double step) {
        boolean actual = arithmeticValidator.validateLineSegment(firstPoint, secondPoint, step);
        assertTrue(actual);
    }

    @DataProvider(name = "lineSegmentNegativeData")
    public Object[][] createSegmentNegativeData() {
        return new Object[][]{
                {3, 10, -1},
                {10, 3, 1},
                {1, 10, 20}
        };
    }

    @Test(dataProvider = "lineSegmentNegativeData")
    public void testValidateLineSegmentNegative(double firstPoint, double secondPoint, double step) {
        boolean actual = arithmeticValidator.validateLineSegment(firstPoint, secondPoint, step);
        assertNotEquals(actual, true);
    }


}