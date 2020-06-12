package com.balashevich.oopstyle.service;

import com.balashevich.oopstyle.exception.ProjectInvalidDataException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalTime;

import static org.testng.Assert.*;

public class TimeServiceTest {
    TimeService timeService;

    @BeforeClass
    public void setUp() {
        timeService = new TimeService();
    }

    @Test
    public void determineDaysInMonthTestPositive() {
        try {
            int actual = timeService.determineDaysInMonth(2, 2020);
            int expected = 29;
            assertEquals(actual, expected, "error in test on Positive result");
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test
    public void determineDaysInMonthTestNegative() {
        try {
            int actual = timeService.determineDaysInMonth(2, 2019);
            int expected = 29;
            assertNotEquals(actual, expected, "error in test on Negative result");
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @DataProvider(name = "dateValues")
    public Object[][] createDateValues() {
        return new Object[][]{
                {16, 2020},
                {11, 1402},
                {-5, 1989},
                {5, -123},
        };
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class, dataProvider = "dateValues")
    public void determineDaysInMonthTestException(int month, int year) throws ProjectInvalidDataException {
        timeService.determineDaysInMonth(month, year);
    }

    @DataProvider(name = "yearValuesPositive")
    public Object[][] createYearsPositiveData() {
        return new Object[][]{
                {true, 2020},
                {false, 1981},
                {false, 1900},
                {true, 2000},
        };
    }

    @Test(dataProvider = "yearValuesPositive")
    public void isLeapYearTestPositive(boolean expected, int year) {
        try {
            boolean actual = timeService.isLeapYear(year);
            assertEquals(actual, expected, "error in test on Positive result");
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @DataProvider(name = "yearValuesNegative")
    public Object[][] createYearsNegativeData() {
        return new Object[][]{
                {false, 2016},
                {true, 1593},
                {true, 1700},
                {false, 2000},
        };
    }

    @Test(dataProvider = "yearValuesNegative")
    public void isLeapYearTestNegative(boolean expected, int year) {
        try {
            boolean actual = timeService.isLeapYear(year);
            assertNotEquals(actual, expected, "error in test on Negative result");
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void isLeapYearTestException() throws ProjectInvalidDataException {
        timeService.isLeapYear(500);
    }

    @Test
    public void calculateDayClockTestPositive() {
        try {
            LocalTime actual = timeService.calculateDayClock(85530);
            LocalTime expected = LocalTime.of(23, 45, 30);
            assertEquals(actual, expected, "error in Test on Positive result");
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test
    public void calculateDayClockTestNegative() {
        try {
            LocalTime actual = timeService.calculateDayClock(85530);
            LocalTime expected = LocalTime.of(23, 10, 30);
            assertNotEquals(actual, expected, "error in Test on Negative result");
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void calculateDayClockTestException() throws ProjectInvalidDataException {
        timeService.calculateDayClock(-100);
    }
}