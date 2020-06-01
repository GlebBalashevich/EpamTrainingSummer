package com.balashevich.day1.task3;

/**
 * Main class for starting the Task3
 *
 * @author Gleb Balashevich
 * @version 1.00 31 May 2020
 */

public class TaskSolution {

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.writeMessage("Task 3:");

        Square outerSquare = new Square();
        outerSquare.setArea(consoleHelper.readSquareArea());

        Circle circle = new Circle();
        circle.setDiagonal(outerSquare.calculateSideByArea());

        Square innerSquare = new Square();
        innerSquare.setArea(innerSquare.calculateArea(circle.getDiagonal()));

        consoleHelper.writeMessage(String.format("Area of inner Square is: %.2f", innerSquare.getArea()));
        consoleHelper.writeMessage(String.format("Area of outer Square more than area of " +
                "inner Square in: %.2f times", outerSquare.getArea() / innerSquare.getArea()));
        consoleHelper.close();
    }

}
