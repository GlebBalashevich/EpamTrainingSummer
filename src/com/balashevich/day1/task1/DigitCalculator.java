package com.balashevich.day1.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class to solve the task according to the description
 * Methods of that class get number from user and with last digit of user number
 * searching the last digit of user square number
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 */

public class DigitCalculator {

    /**
     * General class method what executed by external call
     * method using other class methods to get number from user,
     * using the last digit of the number determines the last digit
     * of the square of the number and returns the resulting value
     */
    public int searchDigit() {
        int lastDigit = getNumberLastDigit(getUserNumber());
        lastDigit *= lastDigit;
        return getNumberLastDigit(lastDigit);
    }

    /**
     * Method using BufferedReader read number from console.
     * If entered number not a number or it's Zero is incorrect
     * user get message and repeat enter until input became correct
     *
     * @see BufferedReader
     */
    private int getUserNumber() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int enteredNumber = 0;

        System.out.println("Enter a number to search the last digit of " +
                "the number square");

        while (true) {
            try {
                enteredNumber = Integer.parseInt(reader.readLine());
                if (enteredNumber == 0) {
                    System.out.println("You entered Zero, please enter another number");
                } else {
                    reader.close();
                    break;
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("An error occurred while trying to enter number. Try again.");
            }
        }

        return enteredNumber;
    }

    private int getNumberLastDigit(int number) {
        return number % 10;
    }
}
