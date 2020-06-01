package com.balashevich.day1.task6;

/**
 * Main class for starting the Task6
 *
 * @author Gleb Balashevich
 * @version 1.00 31 May 2020
 */

public class TaskSolution {

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.writeMessage("Task 6:");

        ClockCalculator clockCalculator = new ClockCalculator(consoleHelper.readInt());
        clockCalculator.calculateClock();
        consoleHelper.writeMessage(String.format("In the specified number of seconds:\n" +
                "Hours - %d, Minutes - %d, Seconds - %d.", clockCalculator.getDayFullHours(),
                clockCalculator.getDayFullMinutes(), clockCalculator.getDayFullSeconds()));
        consoleHelper.close();
    }

}
