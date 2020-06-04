package com.balashevich.oopstyle.service;

import com.balashevich.oopstyle.exception.InvalidInputValueException;
import com.balashevich.oopstyle.parser.VariableParser;
import com.balashevich.oopstyle.validator.ArithmeticValidator;

import java.util.SortedMap;
import java.util.TreeMap;

public class ArithmeticService {
    private ArithmeticValidator arithmeticValidator = new ArithmeticValidator();
    private VariableParser variableParser = new VariableParser();

    public int calculateSquareLastDigit(String numberValue) {
        if (!arithmeticValidator.validateInteger(numberValue, -100, 100)) {
            throw new InvalidInputValueException();
        }

        int number = variableParser.parseInt(numberValue);

        return (int) (Math.pow(number % 10, 2) % 10);
    }

    public boolean isTwoEvenNumbers(String numbersValues) {
        if (!arithmeticValidator.validateIntegerArray(numbersValues, -100, 100)) {
            throw new InvalidInputValueException();
        }

        int[] numbers = variableParser.parseIntArray(numbersValues);
        int evenCount = 0;

        for (int checkNumber : numbers) {
            if (checkNumber % 2 == 0) {
                evenCount++;
            }
        }

        return evenCount >= 2;
    }

    public boolean isNumberPerfect(String numberValue) {
        if (!arithmeticValidator.validateLong(numberValue, 0, 2305843008139952128L)) {
            throw new InvalidInputValueException();
        }

        long number = variableParser.parseLong(numberValue);
        long sumDivisors = 0;

        /* not even numbers can't be perfect */
        if (number % 2 != 0) {
            return false;
        }

        /* in the loop, we divided the checked number by two because
        when dividing a number by a number that is more than half,
        there will always be a remainder from the division*/
        for (long i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sumDivisors += i;
            }
        }
        return sumDivisors == number;
    }

    public double calculateDoubleFunction(String argumentValue) {
        if (!arithmeticValidator.validateDouble(argumentValue, 1.8171205928321)) {
            throw new InvalidInputValueException();
        }

        double argument = variableParser.parseDouble(argumentValue);
        double result = 0;

        if (argument >= 3) {
            result = Math.pow(argument, 2) * -1 + 3 * argument + 9;
        } else {
            result = 1 / (Math.pow(argument, 3) - 6);
        }

        return result;
    }

    public SortedMap<Double, Double> calculateLineFunction(
            String firstPointValue, String secondPointValue, String functionStepValue) {
        if (!arithmeticValidator.validateLineFunction(firstPointValue, secondPointValue, functionStepValue)) {
            throw new InvalidInputValueException();
        }

        double firstPoint = variableParser.parseDouble(firstPointValue);
        double secondPoint = variableParser.parseDouble(secondPointValue);
        double functionStep = variableParser.parseDouble(functionStepValue);
        double functionArgument = firstPoint;
        SortedMap<Double, Double> functionResult = new TreeMap<>();

        while (functionArgument <= secondPoint) {
            functionResult.put(functionArgument, Math.tan(functionArgument));
            functionArgument += functionStep;
        }

        return functionResult;
    }

}
