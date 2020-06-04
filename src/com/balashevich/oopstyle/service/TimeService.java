package com.balashevich.oopstyle.service;

import com.balashevich.oopstyle.enumitem.Month;
import com.balashevich.oopstyle.exception.InvalidInputValueException;
import com.balashevich.oopstyle.parser.VariableParser;
import com.balashevich.oopstyle.validator.TimeValidator;

import java.util.HashMap;
import java.util.Map;

public class TimeService {
    private final int HOUR_SECONDS = 3600;
    private final int MINUTE_SECONDS = 60;
    private final int FORTH_CENTURY_MULTIPLE = 400;
    private final int CENTURY_MULTIPLE = 100;
    private final int FORTH_YEAR_MULTIPLE = 4;
    private TimeValidator timeValidator = new TimeValidator();
    private VariableParser variableParser = new VariableParser();


    public int determineDaysInMonth(String monthNumberValue, String yearValue) {
        if (!timeValidator.validateMonthNumber(monthNumberValue) || !timeValidator.validateYearNumber(yearValue)) {
            throw new InvalidInputValueException();
        }

        int monthNumber = variableParser.parseInt(monthNumberValue);
        int yearNumber = variableParser.parseInt(yearValue);

        Month month = Month.values()[monthNumber - 1];
        return (month == Month.FEBRUARY && isLeapYear(yearNumber)) ? month.getTotalDays() + 1 : month.getTotalDays();
    }

    public boolean isLeapYear(int year) {
        return (year % FORTH_CENTURY_MULTIPLE == 0) || (year % FORTH_YEAR_MULTIPLE == 0 &&
                year % CENTURY_MULTIPLE != 0);
    }

    public Map<String, Integer> calculateDayClock(String secondsOfDayValue) {
        if (!timeValidator.validateSecondsInDay(secondsOfDayValue)) {
            throw new InvalidInputValueException();
        }

        int secondsOfDay = variableParser.parseInt(secondsOfDayValue);
        Map<String, Integer> clock = new HashMap<>();
        int balanceSeconds = secondsOfDay;

        clock.put("hours", balanceSeconds / HOUR_SECONDS);
        balanceSeconds = balanceSeconds % HOUR_SECONDS;
        clock.put("minutes", balanceSeconds / MINUTE_SECONDS);
        clock.put("seconds", balanceSeconds % MINUTE_SECONDS);

        return clock;
    }
}
