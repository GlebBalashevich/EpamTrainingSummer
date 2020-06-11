package com.balashevich.oopstyle.service;

import com.balashevich.oopstyle.exception.ProjectInvalidDataException;
import org.testng.annotations.BeforeClass;
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
    public void testDetermineDaysInMonthPositive() {
        try {
            int actual = timeService.determineDaysInMonth(2, 2020);
            int expected = 29;
            assertEquals(actual, expected, "error in test on Positive result");
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test
    public void testDetermineDaysInMonthNegative() {
        try {
            int actual = timeService.determineDaysInMonth(2, 2019);
            int expected = 29;
            assertNotEquals(actual, expected, "error in test on Negative result");
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void testDetermineDaysInMonthException() throws ProjectInvalidDataException {
        timeService.determineDaysInMonth(16, 2020);
    }

    @Test
    public void testIsLeapYearPositive() {
        try {
            boolean actual = timeService.isLeapYear(2020);
            assertTrue(actual, "error in test on Positive result");
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test
    public void testIsLeapYearNegative() {
        try {
            boolean actual = timeService.isLeapYear(2019);
            assertNotEquals(actual, true, "error in test on Negative result");
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void testIsLeapYearException() throws ProjectInvalidDataException {
        timeService.isLeapYear(500);
    }

    @Test
    public void testCalculateDayClockPositive() {
        try {
            LocalTime actual = timeService.calculateDayClock(85530);
            LocalTime expected = LocalTime.of(23, 45, 30);
            assertEquals(actual, expected, "error in Test on Positive result");
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test
    public void testCalculateDayClockNegative() {
        try {
            LocalTime actual = timeService.calculateDayClock(85530);
            LocalTime expected = LocalTime.of(23, 10, 30);
            assertNotEquals(actual, expected, "error in Test on Negative result");
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void testCalculateDayClockException() throws ProjectInvalidDataException{
        timeService.calculateDayClock(-100);
    }
}