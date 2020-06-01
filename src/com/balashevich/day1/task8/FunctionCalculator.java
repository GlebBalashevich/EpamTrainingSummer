package com.balashevich.day1.task8;

/**
 * Used for performing arithmetic calculations
 * with numbers. Uses methods of the Math class
 * to perform some actions
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 * @see Math
 */

public class FunctionCalculator {
    private int x;

    public FunctionCalculator(int x) {
        this.x = x;
    }

    /**
     * Calculates a specific function value set by the task condition
     * The order of calculation depends on the value of the variable X
     */
    public double calculateFunction() {
        double result = 0;

        if (x >= 3) {
            result = Math.pow(x, 2) * -1 + 3 * x + 9;
        } else {
            result = 1 / (Math.pow(x, 3) - 6);
        }

        return result;
    }
}
