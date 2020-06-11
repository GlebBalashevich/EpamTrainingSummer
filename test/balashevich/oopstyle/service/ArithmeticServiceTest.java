package balashevich.oopstyle.service;

import balashevich.oopstyle.exception.ProjectInvalidDataException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.SortedMap;
import java.util.TreeMap;

import static org.testng.Assert.*;

public class ArithmeticServiceTest {
    ArithmeticService arithmeticService;

    @BeforeTest
    public void setUp() {
        arithmeticService = new ArithmeticService();
    }

    @Test
    public void testCalculateSquareLastDigitPositive() {
        int actual = arithmeticService.calculateSquareLastDigit(18);
        int expected = 4;
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateSquareLastDigitNegative() {
        int actual = arithmeticService.calculateSquareLastDigit(18);
        int expected = 8;
        assertNotEquals(actual, expected);
    }

    @Test
    public void testIsTwoEvenNumbersPositive() {
        try {
            boolean actual = arithmeticService.isTwoEvenNumbers(5, 8, 3, 1, 7, 2);
            assertTrue(actual);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test
    public void testIsTwoEvenNumbersNegative() {
        try {
            boolean actual = arithmeticService.isTwoEvenNumbers(5, 9, 3, 1, 7, 2);
            assertNotEquals(actual, true);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void testIsTwoEvenNumbersException() throws ProjectInvalidDataException {
        arithmeticService.isTwoEvenNumbers(2);
    }

    @Test
    public void testIsNumberPerfectPositive() {
        try {
            boolean actual = arithmeticService.isNumberPerfect(2_305_843_008_139_952_128L);
            assertTrue(actual);
        } catch (
                ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test
    public void testIsNumberPerfectNegative() {
        try {
            boolean actual = arithmeticService.isNumberPerfect(2_305_843_008_139_952_120L);
            assertNotEquals(actual, true);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(timeOut = 100)
    public void testIsNumberPerfectTimeout() {
        try {
            arithmeticService.isNumberPerfect(2_305_843_008_139_952_120L);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void testIsNumberPerfectException() throws ProjectInvalidDataException {
        arithmeticService.isNumberPerfect(-2_305_843_008_139_952_120L);
    }

    @DataProvider(name = "arguments")
    public Object[][] createArgumentData() {
        return new Object[][]{
                {0, -0.167},
                {1, -0.2},
                {3, 9},
                {4, 5}};
    }

    @Test(dataProvider = "arguments")
    public void testCalculateArithmeticFunctionPositive(double argument, double expected) {
        try {
            double actual = arithmeticService.calculateArithmeticFunction(argument);
            assertEquals(actual, expected, 0.001);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test
    public void testCalculateArithmeticFunctionNegative() {
        try {
            double actual = arithmeticService.calculateArithmeticFunction(3);
            double expected = 10;
            assertNotEquals(actual, expected, 0.001);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void testCalculateArithmeticFunctionException() throws ProjectInvalidDataException {
        arithmeticService.calculateArithmeticFunction(Math.cbrt(6));
    }

    @Test
    public void testCalculateTrigonometricFunctionPositive() {
        try {
            SortedMap<Double, Double> actual = arithmeticService.calculateTrigonometricFunction(3, 8, 2);
            SortedMap<Double, Double> expected = new TreeMap<>();
            expected.put(3.0, -0.1425465430742778);
            expected.put(5.0, -3.380515006246586);
            expected.put(7.0, 0.8714479827243187);
            assertEquals(actual, expected);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test
    public void testCalculateTrigonometricFunctionNegative() {
        try {
            SortedMap<Double, Double> actual = arithmeticService.calculateTrigonometricFunction(3, 8, 2);
            SortedMap<Double, Double> expected = new TreeMap<>();
            expected.put(-0.1425465430742778, 3.0);
            expected.put(-3.380515006246586, 5.0);
            expected.put(0.8714479827243187, 7.0);
            assertNotEquals(actual, expected);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @DataProvider(name = "trigonometricExceptionData")
    public Object[][] createTrigonometricExceptionData() {
        return new Object[][]{
                {3, 5, -2},
                {8, 1, 3},
                {1, 5, 10}
        };
    }

    @Test(dataProvider = "trigonometricExceptionData", expectedExceptions = ProjectInvalidDataException.class)
    public void testCalculateTrigonometricFunctionException(double firstPoint, double secondPoint, double step)
            throws ProjectInvalidDataException{
        arithmeticService.calculateTrigonometricFunction(firstPoint, secondPoint, step);
    }
}