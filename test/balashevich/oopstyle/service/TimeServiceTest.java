package balashevich.oopstyle.service;

import com.balashevich.oopstyle.exception.ProjectInvalidDataException;
import com.balashevich.oopstyle.service.TimeService;
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
        int actual = timeService.determineDaysInMonth(2, 2020);
        int expected = 29;
        assertEquals(actual, expected, "error in test on Positive result");
    }

    @Test
    public void testDetermineDaysInMonthNegative() {
        int actual = timeService.determineDaysInMonth(2, 2019);
        int expected = 29;
        assertNotEquals(actual, expected, "error in test on Negative result");
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void testDetermineDaysInMonthException() {
        timeService.determineDaysInMonth(16, 2020);
    }

    @Test
    public void testIsLeapYearPositive() {
        boolean actual = timeService.isLeapYear(2020);
        assertTrue(actual, "error in test on Positive result");
    }

    @Test
    public void testIsLeapYearNegative() {
        boolean actual = timeService.isLeapYear(2019);
        assertNotEquals(actual, true, "error in test on Negative result");
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void testIsLeapYearException() {
        timeService.isLeapYear(500);
    }

    @Test
    public void testCalculateDayClockPositive() {
        LocalTime actual = timeService.calculateDayClock(85530);
        LocalTime expected = LocalTime.of(23, 45, 30);
        assertEquals(actual, expected, "error in Test on Positive result");
    }

    @Test
    public void testCalculateDayClockNegative() {
        LocalTime actual = timeService.calculateDayClock(85530);
        LocalTime expected = LocalTime.of(23, 10, 30);
        assertNotEquals(actual, expected, "error in Test on Negative result");
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void testCalculateDayClockException() {
        timeService.calculateDayClock(-100);
    }
}