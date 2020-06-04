package com.balashevich.oopstyle.validator;

import com.balashevich.oopstyle.parser.VariableParser;

public class ArithmeticValidator {
    private VariableParser variableParser = new VariableParser();

    public boolean validateInteger(String integerValue, int minValue, int maxValue) {
        try {
            int number = variableParser.parseInt(integerValue);
            if (number < minValue || number > maxValue) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean validateInteger(int number, int minValue, int maxValue) {
        return !(number < minValue || number > maxValue);
    }

    public boolean validateIntegerArray(String integerValues, int minValue, int maxValue) {
        try {
            int[] numbers = variableParser.parseIntArray(integerValues);

            for (int checkingNumber : numbers) {
                if (checkingNumber < minValue || checkingNumber > maxValue) {
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean validateLong(String longValue, long minValue, long maxValue) {
        try {
            long longNumber = variableParser.parseLong(longValue);
            if (longNumber < minValue || longNumber > maxValue) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean validateDouble(String doubleValue, double notEqualValue) {
        try {
            double realNumber = variableParser.parseDouble(doubleValue);
            if (realNumber == notEqualValue) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean validateDouble(String doubleValue, double minValue, double maxValue) {
        try {
            double realNumber = variableParser.parseDouble(doubleValue);
            if (realNumber < minValue || realNumber > maxValue) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean validateLineFunction(String firstPointValue, String secondPointValue, String stepValue) {
        try {
            double firstPoint = variableParser.parseDouble(firstPointValue);
            double secondPoint = variableParser.parseDouble(secondPointValue);
            double step = variableParser.parseDouble(stepValue);
            if (firstPoint > secondPoint) {
                return false;
            }
            if (secondPoint - firstPoint < step) {
                return false;
            }
            if (step < 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
