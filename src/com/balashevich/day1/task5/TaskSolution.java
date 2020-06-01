package com.balashevich.day1.task5;

/**
 * Main class for starting the Task5
 *
 * @author Gleb Balashevich
 * @version 1.00 31 May 2020
 */

public class TaskSolution {

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.writeMessage("Task 5:");

        NumberCalculator numberCalculator = new NumberCalculator(consoleHelper.readLong());
        consoleHelper.writeMessage(String.format("Is it perfect number? " +
                "- %b", numberCalculator.isPerfectNumber()));
        consoleHelper.close();
    }

}
