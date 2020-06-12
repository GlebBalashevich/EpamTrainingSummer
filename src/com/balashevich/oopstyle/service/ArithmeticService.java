package com.balashevich.oopstyle.service;

import com.balashevich.oopstyle.validator.ArithmeticValidator;
import com.balashevich.oopstyle.exception.ProjectInvalidDataException;

import java.util.SortedMap;
import java.util.TreeMap;

public class ArithmeticService {
    private final int FIRST_PERFECT_NUMBER = 6;
    private final int DECIMAL_DIVISOR = 10;
    private final int EVEN_DIVIDER = 2;


    public int calculateSquareLastDigit(int number) {
        number = Math.abs(number);
        return (int) (Math.pow(number % DECIMAL_DIVISOR, 2) % DECIMAL_DIVISOR);
    }

    public boolean isTwoEvenNumbers(int... numbers) throws ProjectInvalidDataException {
        ArithmeticValidator arithmeticValidator = new ArithmeticValidator();
        if (!arithmeticValidator.validateNumbersSequence(numbers)) {
            throw new ProjectInvalidDataException();
        }

        int evenCount = 0;

        for (int checkNumber : numbers) {
            if (checkNumber % EVEN_DIVIDER == 0) {
                evenCount++;
            }
        }

        return evenCount >= EVEN_DIVIDER;
    }

    public boolean isNumberPerfect(long number) throws ProjectInvalidDataException {
        if (number < 0) {
            throw new ProjectInvalidDataException();
        }

        long sumCubes = 0;
        long loopIndex = 1;
        boolean result = false;

        /* not even numbers can't be perfect */
        if (number % 2 != 0) {
            return false;
        }
        /* this number is not calculated using the formula
        below, i.e. it is special */
        if (number == FIRST_PERFECT_NUMBER) {
            return true;
        }

        while (sumCubes < number) {
            sumCubes += Math.pow(loopIndex, 3);
            loopIndex += 2;
        }
        return sumCubes == number;
    }

    public double calculateArithmeticFunction(double argument) throws ProjectInvalidDataException {
        ArithmeticValidator arithmeticValidator = new ArithmeticValidator();
        if (!arithmeticValidator.validateFunctionArgument(argument)) {
            throw new ProjectInvalidDataException();
        }
        double result = 0;

        if (argument >= 3) {
            result = Math.pow(argument, 2) * -1 + 3 * argument + 9;
        } else {
            result = 1 / (Math.pow(argument, 3) - 6);
        }

        return result;
    }

    public SortedMap<Double, Double> calculateTrigonometricFunction(double firstPoint, double secondPoint, double functionStep) throws ProjectInvalidDataException {
        ArithmeticValidator arithmeticValidator = new ArithmeticValidator();
        if (!arithmeticValidator.validateLineSegment(firstPoint, secondPoint, functionStep)) {
            throw new ProjectInvalidDataException();
        }

        double functionArgument = firstPoint;
        SortedMap<Double, Double> functionResult = new TreeMap<>();

        while (functionArgument <= secondPoint) {
            double tan = Math.tan(functionArgument);
            double scale = Math.pow(10, 3);
            tan = Math.ceil(tan * scale) / scale;

            functionResult.put(functionArgument, tan);
            functionArgument += functionStep;
        }

        return functionResult;
    }

}
