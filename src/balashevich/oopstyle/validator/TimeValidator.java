package balashevich.oopstyle.validator;

public class TimeValidator {
    private final int START_LEAP_CALCULATE = 1582;
    private final int TOTAL_DAY_SECONDS = 86400;

    public boolean validateMonthNumber(int monthNumber) {
        return (1 <= monthNumber && monthNumber <= 12);
    }

    public boolean validateYearNumber(int yearNumber) {
        return yearNumber >= START_LEAP_CALCULATE;
    }

    public boolean validateSecondsInDay(int seconds) {
        return (0 <= seconds && seconds < TOTAL_DAY_SECONDS);
    }
}
