package balashevich.oopstyle.validator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TimeValidatorTest {
    TimeValidator timeValidator;

    @BeforeTest
    public void setUp() {
        timeValidator = new TimeValidator();
    }

    @DataProvider(name = "monthPositiveData")
    public Object[][] createMonthPositiveData() {
        return new Object[][]{
                {-1, false},
                {3, true},
                {15, false}};
    }

    @Test(dataProvider = "monthPositiveData")
    public void testValidateMonthNumberPositive(int month, boolean expected) {
        boolean actual = timeValidator.validateMonthNumber(month);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "monthNegativeData")
    public Object[][] createMonthNegativeData() {
        return new Object[][]{
                {0, true},
                {5, false},
                {100, true}};
    }

    @Test(dataProvider = "monthNegativeData")
    public void testValidateMonthNumberNegative(int month, boolean expected) {
        boolean actual = timeValidator.validateMonthNumber(month);
        assertNotEquals(actual, expected);
    }

    @DataProvider(name = "yearPositiveData")
    public Object[][] createYearPositiveData() {
        return new Object[][]{
                {-10, false},
                {1581, false},
                {1800, true}};
    }

    @Test(dataProvider = "yearPositiveData")
    public void testValidateYearNumberPositive(int year, boolean expected) {
        boolean actual = timeValidator.validateYearNumber(year);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "yearNegativeData")
    public Object[][] createYearNegativeData() {
        return new Object[][]{
                {0, true},
                {1582, false},
                {2020, false}};
    }

    @Test(dataProvider = "yearNegativeData")
    public void testValidateYearNumberNegative(int year, boolean expected) {
        boolean actual = timeValidator.validateYearNumber(year);
        assertNotEquals(actual, expected);
    }

    @DataProvider(name = "secondsDayPositiveData")
    public Object[][] createSecondsPositiveData() {
        return new Object[][]{
                {-1, false},
                {100, true},
                {100000, false}};
    }

    @Test(dataProvider = "secondsDayPositiveData")
    public void testValidateSecondsInDayPositive(int daySeconds, boolean expected) {
        boolean actual = timeValidator.validateSecondsInDay(daySeconds);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "secondsDayNegativeData")
    public Object[][] createSecondsNegativeData() {
        return new Object[][]{
                {-100, true},
                {85400, false},
                {100000, true}};
    }

    @Test(dataProvider = "secondsDayNegativeData")
    public void testValidateSecondsInDayNegative(int daySeconds, boolean expected) {
        boolean actual = timeValidator.validateSecondsInDay(daySeconds);
        assertNotEquals(actual, expected);
    }
}