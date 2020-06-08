package test.balashevich.oopstyle.validator;

import com.balashevich.oopstyle.validator.ArithmeticValidator;
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

    @Test
    public void testValidateNumbersSequencePositive() {
        boolean actual = arithmeticValidator.validateNumbersSequence(6, 7, 8);
        assertTrue(actual);
    }

    @Test
    public void testValidateNumbersSequenceNegative() {
        boolean actual = arithmeticValidator.validateNumbersSequence(3);
        assertNotEquals(actual, true);
    }

    @Test
    public void testValidateFunctionArgumentPositive() {
        boolean actual = arithmeticValidator.validateFunctionArgument(2);
        assertTrue(actual);
    }

    @Test
    public void testValidateFunctionArgumentNegative() {
        boolean actual = arithmeticValidator.validateFunctionArgument(Math.cbrt(6));
        assertNotEquals(actual, true);
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