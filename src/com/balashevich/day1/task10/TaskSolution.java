package com.balashevich.day1.task10;

/**
 * Main class for starting the Task10
 *
 * @author Gleb Balashevich
 * @version 1.00 31 May 2020
 */

public class TaskSolution {

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        LineSegment lineSegment = null;
        consoleHelper.writeMessage("Task 10:");

        while (true) {
            consoleHelper.writeMessage("Enter First segment point value");
            double firstSegmentPoint = consoleHelper.readDouble();
            consoleHelper.writeMessage("Enter Second segment point value");
            double secondSegmentPoint = consoleHelper.readDouble();
            consoleHelper.writeMessage("Enter function Step value");
            double functionStep = consoleHelper.readDouble();
            if (firstSegmentPoint < secondSegmentPoint) {
                lineSegment = new LineSegment(firstSegmentPoint, secondSegmentPoint, functionStep);
                break;
            } else {
                consoleHelper.writeMessage("Entered invalid points values. Try again");
            }
        }

        consoleHelper.writeMap(lineSegment.getFunctionCalculator().calculateFunction());
        consoleHelper.close();
    }

}
