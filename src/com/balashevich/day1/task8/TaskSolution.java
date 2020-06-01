package com.balashevich.day1.task8;

/**
 * Main class for starting the Task8
 *
 * @author Gleb Balashevich
 * @version 1.00 31 May 2020
 */

public class TaskSolution {

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.writeMessage("Task 8:");

        FunctionCalculator functionCalculator =
                new FunctionCalculator(consoleHelper.readInt());
        consoleHelper.writeMessage(String.format("Result of calculation: %.3f",
                functionCalculator.calculateFunction()));
        consoleHelper.close();
    }

}
