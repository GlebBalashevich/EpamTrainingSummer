package com.balashevich.oopstyle.validator;

public class ArithmeticValidator {
    private final int FUNCTION_ZERO_DIVIDER = 6;

    public boolean validateNumbersSequence(int... numbers) {
        boolean result = true;

        if (numbers == null) {
            result = false;
        } else if (numbers.length < 2) {
            result = false;
        }

        return result;
    }

    public boolean validateFunctionArgument(double argument) {
        return (Math.pow(argument, 3) != FUNCTION_ZERO_DIVIDER);
    }

    public boolean validateLineSegment(double firstPoint, double secondPoint, double functionStep) {
        boolean result = true;

        if (firstPoint > secondPoint && functionStep > 0) {
            result = false;
        } else if (firstPoint < secondPoint && functionStep < 0) {
            result = false;
        } else if (Math.abs(firstPoint - secondPoint) < functionStep) {
            result = false;
        }

        return result;
    }
}
