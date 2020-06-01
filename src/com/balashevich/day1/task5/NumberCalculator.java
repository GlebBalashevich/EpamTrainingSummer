package com.balashevich.day1.task5;

import java.util.ArrayList;

/**
 * Designed for performing arithmetic operations with numbers
 * It's working with ArrayList
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 * @see ArrayList
 */

public class NumberCalculator {
    private ArrayList<Integer> numbersList;
    private long numberForOperations;

    public NumberCalculator(ArrayList<Integer> numbersList) {
        this.numbersList = numbersList;
    }

    public NumberCalculator(long numberForOperations) {
        this.numberForOperations = numberForOperations;
    }

    /**
     * counts the number of even numbers in numbersList and return result
     */
    public int calculateEvenNumbers() {
        int evenCount = 0;

        for (Integer checkNumber : numbersList) {
            if (isEvenNumber(checkNumber)) {
                evenCount++;
            }
        }

        return evenCount;
    }

    /**
     * detecting number is even or no
     */
    public boolean isEvenNumber(long checkNumber) {
        return checkNumber % 2 == 0;
    }


    /**
     * determines whether the number is perfect. A perfect number is
     * a number whose sum of divisors is equal to the number itself
     */
    public boolean isPerfectNumber() {
        long dividersSumm = 0;

        if (!isEvenNumber(numberForOperations)) {
            return false;
        }

        /* in the loop, we divided the checked number by two because
        when dividing a number by a number that is more than half,
        there will always be a remainder from the division*/
        for (long i = 1; i <= numberForOperations / 2; i++) {
            if (numberForOperations % i == 0) {
                dividersSumm += i;
            }
        }
        return dividersSumm == numberForOperations;
    }
}
