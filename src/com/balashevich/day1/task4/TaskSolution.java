package com.balashevich.day1.task4;

import java.util.ArrayList;

/**
 * Main class for starting the Task4
 *
 * @author Gleb Balashevich
 * @version 1.00 31 May 2020
 */

public class TaskSolution {

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.writeMessage("Task 4:");

        ArrayList<Long> numbersList = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            numbersList.add(consoleHelper.readLong());
        }

        NumberCalculator numberCalculator = new NumberCalculator(numbersList);
        consoleHelper.writeMessage(String.format("Have two or more even numbers? " +
                "- %b", numberCalculator.calculateEvenNumbers() >= 2));
        consoleHelper.close();
    }

}
