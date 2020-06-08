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
        boolean actual = arithmeticService.isTwoEvenNumbers(5, 8, 3, 1, 7, 2);
        assertTrue(actual);
    }

    @Test
    public void testIsTwoEvenNumbersNegative() {
        boolean actual = arithmeticService.isTwoEvenNumbers(5, 9, 3, 1, 7, 2);
        assertNotEquals(actual, true);
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void testIsTwoEvenNumbersException() {
        arithmeticService.isTwoEvenNumbers(2);
    }

    @Test
    public void testIsNumberPerfectPositive() {
        boolean actual = arithmeticService.isNumberPerfect(2305843008139952128L);
        assertTrue(actual);
    }

    @Test
    public void testIsNumberPerfectNegative() {
        boolean actual = arithmeticService.isNumberPerfect(2305843008139952120L);
        assertNotEquals(actual, true);
    }

    @Test(timeOut = 100)
    public void testIsNumberPerfectTimeout() {
        arithmeticService.isNumberPerfect(2305843008139952120L);
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void testIsNumberPerfectException() {
        arithmeticService.isNumberPerfect(-2305843008139952120L);
    }

    @DataProvider(name = "arguments")
    public Object[][] createArgumentData() {
        return new Object[][]{{0, -0.167}, {1, -0.2}, {3, 9}, {4, 5}};
    }

    @Test(dataProvider = "arguments")
    public void testCalculateArithmeticFunctionPositive(double argument, double expected) {
        double actual = arithmeticService.calculateArithmeticFunction(argument);
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testCalculateArithmeticFunctionNegative() {
        double actual = arithmeticService.calculateArithmeticFunction(3);
        double expected = 10;
        assertNotEquals(actual, expected, 0.001);
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void testCalculateArithmeticFunctionException() {
        arithmeticService.calculateArithmeticFunction(Math.cbrt(6));
    }

    @Test
    public void testCalculateTrigonometricFunctionPositive() {
        SortedMap<Double, Double> actual = arithmeticService.calculateTrigonometricFunction(3, 8, 2);
        SortedMap<Double, Double> expected = new TreeMap<>();
        expected.put(3.0, -0.1425465430742778);
        expected.put(5.0, -3.380515006246586);
        expected.put(7.0, 0.8714479827243187);
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTrigonometricFunctionNegative() {
        SortedMap<Double, Double> actual = arithmeticService.calculateTrigonometricFunction(3, 8, 2);
        SortedMap<Double, Double> expected = new TreeMap<>();
        expected.put(-0.1425465430742778, 3.0);
        expected.put(-3.380515006246586, 5.0);
        expected.put(0.8714479827243187, 7.0);
        assertNotEquals(actual, expected);
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
    public void testCalculateTrigonometricFunctionException(double firstPoint, double secondPoint, double step) {
        SortedMap<Double, Double> actual = arithmeticService.calculateTrigonometricFunction(firstPoint, secondPoint, step);

    }
}