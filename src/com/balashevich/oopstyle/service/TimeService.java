package com.balashevich.oopstyle.service;

import com.balashevich.oopstyle.enumitem.Month;
import com.balashevich.oopstyle.exception.ProjectInvalidDataException;
import com.balashevich.oopstyle.validator.TimeValidator;

import java.time.LocalTime;

public class TimeService {
    private final int HOUR_SECONDS = 3600;
    private final int MINUTE_SECONDS = 60;
    private final int FORTH_CENTURY_MULTIPLE = 400;
    private final int CENTURY_MULTIPLE = 100;
    private final int FORTH_YEAR_MULTIPLE = 4;


    public int determineDaysInMonth(int monthNumber, int yearNumber) throws ProjectInvalidDataException {
        TimeValidator timeValidator = new TimeValidator();
        if (!timeValidator.validateMonthNumber(monthNumber) || !timeValidator.validateYearNumber(yearNumber)) {
            throw new ProjectInvalidDataException();
        }

        Month month = Month.values()[monthNumber - 1];

        return (month == Month.FEBRUARY && isLeapYear(yearNumber)) ? month.getTotalDays() + 1 : month.getTotalDays();
    }

    public boolean isLeapYear(int year) throws ProjectInvalidDataException {
        TimeValidator timeValidator = new TimeValidator();
        if (!timeValidator.validateYearNumber(year)) {
            throw new ProjectInvalidDataException();
        }

        return (year % FORTH_CENTURY_MULTIPLE == 0) || (year % FORTH_YEAR_MULTIPLE == 0 &&
                year % CENTURY_MULTIPLE != 0);
    }

    public LocalTime calculateDayClock(int secondsOfDay) throws ProjectInvalidDataException {
        TimeValidator validator = new TimeValidator();
        if (!validator.validateSecondsInDay(secondsOfDay)) {
            throw new ProjectInvalidDataException();
        }
        int balanceSeconds = secondsOfDay;

        int hours = balanceSeconds / HOUR_SECONDS;
        balanceSeconds = balanceSeconds % HOUR_SECONDS;
        int minutes = balanceSeconds / MINUTE_SECONDS;
        System.out.println(minutes);
        int seconds = balanceSeconds % MINUTE_SECONDS;

        return LocalTime.of(hours, minutes, seconds);
    }
}
