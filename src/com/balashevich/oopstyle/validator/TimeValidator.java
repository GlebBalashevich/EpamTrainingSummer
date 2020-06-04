package com.balashevich.oopstyle.validator;

import com.balashevich.oopstyle.parser.VariableParser;

public class TimeValidator {
    VariableParser variableParser = new VariableParser();

    public boolean validateMonthNumber(String monthNumberValue) {
        try {
            int monthNumber = variableParser.parseInt(monthNumberValue);
            if (monthNumber < 1 || monthNumber > 12) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean validateYearNumber(String yearNumberValue) {
        try {
            int year = variableParser.parseInt(yearNumberValue);
            if (year < 0 || year > 4000) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean validateSecondsInDay(String secondsValue) {
        try {
            int totalDaySeconds = 86400;
            int seconds = variableParser.parseInt(secondsValue);
            if (seconds < 0 || seconds > totalDaySeconds) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
