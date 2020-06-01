package com.balashevich.day1.task4;

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
    private ArrayList<Long> numbersList;

    public NumberCalculator(ArrayList<Long> numbersList) {
        this.numbersList = numbersList;
    }

    /**
     * counts the number of even numbers in numbersList and return result
     */
    public int calculateEvenNumbers() {
        int evenCount = 0;

        for (Long checkNumber : numbersList) {
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
}
