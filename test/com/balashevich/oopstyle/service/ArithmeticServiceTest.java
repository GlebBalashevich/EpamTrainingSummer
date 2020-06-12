package com.balashevich.oopstyle.service;

import com.balashevich.oopstyle.exception.ProjectInvalidDataException;
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
    public void calculateSquareLastDigitTestPositive() {
        int actual = arithmeticService.calculateSquareLastDigit(18);
        int expected = 4;
        assertEquals(actual, expected);
    }

    @Test
    public void calculateSquareLastDigitTestNegative() {
        int actual = arithmeticService.calculateSquareLastDigit(18);
        int expected = 18;
        assertNotEquals(actual, expected);
    }

    @Test
    public void isTwoEvenNumbersTestPositive() {
        try {
            boolean actual = arithmeticService.isTwoEvenNumbers(5, 8, 3, 1, 7, 2);
            assertTrue(actual);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test
    public void isTwoEvenNumbersTestNegative() {
        try {
            boolean actual = arithmeticService.isTwoEvenNumbers(5, 9, 3, 1, 7, 2);
            assertNotEquals(actual, true);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void isTwoEvenNumbersTestException() throws ProjectInvalidDataException {
        arithmeticService.isTwoEvenNumbers(2);
    }

    @Test
    public void isNumberPerfectTestPositive() {
        try {
            boolean actual = arithmeticService.isNumberPerfect(2_305_843_008_139_952_128L);
            assertTrue(actual);
        } catch (
                ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test
    public void isNumberPerfectTestNegative() {
        try {
            boolean actual = arithmeticService.isNumberPerfect(2_305_843_008_139_952_120L);
            assertNotEquals(actual, true);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(timeOut = 100)
    public void isNumberPerfectTestTimeout() {
        try {
            arithmeticService.isNumberPerfect(2_305_843_008_139_952_120L);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void isNumberPerfectTestException() throws ProjectInvalidDataException {
        arithmeticService.isNumberPerfect(-2_305_843_008_139_952_120L);
    }

    @DataProvider(name = "argumentsPositive")
    public Object[][] createArgumentDataPositive() {
        return new Object[][]{
                {0, -0.167},
                {1, -0.2},
                {3, 9},
                {4, 5}};
    }

    @Test(dataProvider = "argumentsPositive")
    public void calculateArithmeticFunctionTestPositive(double argument, double expected) {
        try {
            double actual = arithmeticService.calculateArithmeticFunction(argument);
            assertEquals(actual, expected, 0.001);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @DataProvider(name = "argumentsNegative")
    public Object[][] createArgumentDataNegative() {
        return new Object[][]{
                {0, 0.167},
                {1, 0.2},
                {3, 3},
                {4, -5}};
    }

    @Test(dataProvider = "argumentsNegative")
    public void calculateArithmeticFunctionTestNegative(double argument, double expected) {
        try {
            double actual = arithmeticService.calculateArithmeticFunction(argument);
            assertNotEquals(actual, expected, 0.001);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void calculateArithmeticFunctionTestException() throws ProjectInvalidDataException {
        arithmeticService.calculateArithmeticFunction(Math.cbrt(6));
    }

    @Test
    public void calculateTrigonometricFunctionTestPositive() {
        try {
            SortedMap<Double, Double> actual = arithmeticService.calculateTrigonometricFunction(3, 8, 2);
            SortedMap<Double, Double> expected = new TreeMap<>();
            expected.put(3.0, -0.142);
            expected.put(5.0, -3.380);
            expected.put(7.0, 0.872);
            assertEquals(actual, expected);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test
    public void calculateTrigonometricFunctionTestNegative() {
        try {
            SortedMap<Double, Double> actual = arithmeticService.calculateTrigonometricFunction(3, 8, 2);
            SortedMap<Double, Double> expected = new TreeMap<>();
            expected.put(-0.142, 3.0);
            expected.put(-3.381, 5.0);
            expected.put(0.871, 7.0);
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
    public void calculateTrigonometricFunctionTestException(double firstPoint, double secondPoint, double step)
            throws ProjectInvalidDataException {
        arithmeticService.calculateTrigonometricFunction(firstPoint, secondPoint, step);
    }
}