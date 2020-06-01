package com.balashevich.day1.task1;

/**
 * Main class for starting the Task1
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 */

public class TaskSolution {

    public static void main(String[] args) {
        DigitCalculator taskSolution = new DigitCalculator();

        System.out.println("Task 1:");
        System.out.println("The last digit of the number square is: " +
                taskSolution.searchDigit());
    }

}
