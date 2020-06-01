package com.balashevich.day1.task2;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class to solve the task, according to the description
 * Using the number of month and number of the year
 * method realized in class detecting year is leap or no
 * and return the number of the days in month.
 * Using class Calendar to operate with date
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 * @see Calendar
 */

public class CustomDate {
    private Calendar calendar;

    public CustomDate(int year, int month) {
        calendar = new GregorianCalendar(year, month, 1);
    }

    /**
     * Detecting what number of days have month in asking date.
     * It's consider year in date is Leap or no (for February)
     */
    public int getDaysInMonth() {
        int daysInMonth = 0;
        switch (calendar.get(Calendar.MONTH)) {
            case Calendar.JANUARY:
            case Calendar.MARCH:
            case Calendar.MAY:
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.OCTOBER:
            case Calendar.DECEMBER:
                daysInMonth = 31;
                break;
            case Calendar.FEBRUARY:
                daysInMonth = isLeapYear() ? 29 : 28;
                break;
            case Calendar.APRIL:
            case Calendar.JUNE:
            case Calendar.SEPTEMBER:
            case Calendar.NOVEMBER:
                daysInMonth = 30;
                break;
            default:
                break;
        }

        return daysInMonth;
    }

    /**
     * Detecting year is leap or no. Every 4-th year is Leap (if it's not
     * multiply start of the new century or if it's start of 4-th century)
     */
    public boolean isLeapYear() {
        int centuryMultiple = 100;
        int forthYearMultiple = 4;
        int forthCenturyMultiple = 400;
        int checkingYear = calendar.get(Calendar.YEAR);
        boolean isLeap = false;

        if (checkingYear % forthCenturyMultiple == 0) {
            isLeap = true;
        } else if (checkingYear % forthYearMultiple == 0 &&
                checkingYear % centuryMultiple != 0) {
            isLeap = true;
        }

        return isLeap;
    }
}
