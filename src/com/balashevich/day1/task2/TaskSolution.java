package com.balashevich.day1.task2;

/**
 * Main class for starting the Task2
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 */

public class TaskSolution {

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.writeMessage("Task 2:");

        CustomDate customDate = new CustomDate(consoleHelper.readYear(), consoleHelper.readMonth());
        consoleHelper.writeMessage("In month " + customDate.getDaysInMonth() + " days");
        String isLeap = customDate.isLeapYear() ? "" : "not ";
        consoleHelper.writeMessage("The year is " + isLeap + "leap.");
        consoleHelper.close();
    }

}
