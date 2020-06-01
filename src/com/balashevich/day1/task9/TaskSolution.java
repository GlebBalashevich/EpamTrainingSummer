package com.balashevich.day1.task9;

/**
 * Main class for starting the Task9
 *
 * @author Gleb Balashevich
 * @version 1.00 31 May 2020
 */

public class TaskSolution {

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.writeMessage("Task 9:");

        Round round = new Round(consoleHelper.readDouble());
        round.calculateCircumference();
        round.getCircle().calculateArea();

        consoleHelper.writeMessage(String.format("Round circumference is: %.2f" +
                ", Circle area is: %.2f", round.getCircumference(),
                round.getCircle().getArea()));
        consoleHelper.close();
    }

}
