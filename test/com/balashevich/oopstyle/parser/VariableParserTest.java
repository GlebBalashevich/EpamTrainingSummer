package com.balashevich.oopstyle.parser;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class VariableParserTest {
    VariableParser variableParser;

    @BeforeTest
    public void setUp() {
        variableParser = new VariableParser();
    }

    @DataProvider(name = "integerData")
    public Object[][] createIntegerData() {
        return new Object[][]{
                {"15", 15},
                {"-10", -10},
                {"29435348", 29435348}};
    }

    @Test(dataProvider = "integerData")
    public void parseIntTest(String integerData, int expected) {
        int actual = variableParser.parseInt(integerData);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void parseIntNumberFormatExceptionTest() {
        variableParser.parseInt("abc");
    }

    @DataProvider(name = "integerArrayData")
    public Object[][] createIntegerArrayData() {
        return new Object[][]{
                {"5,8,10,6", new int[]{5, 8, 10, 6}},
                {"-132532,5345,86956,0", new int[]{-132532, 5345, 86956, 0}}
        };
    }

    @Test(dataProvider = "integerArrayData")
    public void parseIntArrayTest(String integerArrayData, int[] expected) {
        int[] actual = variableParser.parseIntArray(integerArrayData);

    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void parseIntArrayExceptionTest() {
        variableParser.parseIntArray("32432,,ds,asd,.,");
    }

    @DataProvider(name = "longData")
    public Object[][] createLongData() {
        return new Object[][]{
                {"9223372036854775807", 9223372036854775807L},
                {"-9223372036854775808", -9223372036854775808L},
                {"0", 0L}
        };
    }

    @Test(dataProvider = "longData")
    public void parseLongTest(String longData, long expected) {
        long actual = variableParser.parseLong(longData);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void parseLongExceptionTest() {
        variableParser.parseLong("abc");
    }

    @DataProvider(name = "doubleData")
    public Object[][] createDoubleData() {
        return new Object[][]{
                {"123.343", 123.343},
                {"0", 0},
                {"-23532.12312331", -23532.12312331}
        };
    }

    @Test(dataProvider = "doubleData")
    public void parseDoubleTest(String doubleData, double expected) {
        double actual = variableParser.parseDouble(doubleData);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void parseDoubleExceptionTest() {
        variableParser.parseDouble("1sdf-.dv3");
    }
}