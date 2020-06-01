package com.balashevich.day1.task7;

/**
 * Main class for starting the Task7
 *
 * @author Gleb Balashevich
 * @version 1.00 31 May 2020
 */

public class TaskSolution {

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.writeMessage("Task 7:");

        Graph graph = new Graph();
        for (int i = 0; i < 2; i++) {
            consoleHelper.writeMessage("Create Point number" + (i + 1));
            graph.addPoint(consoleHelper.readInt(), consoleHelper.readInt());
        }

        consoleHelper.writeMessage("Nearest point to the origin is: "
                + graph.searchNearestToStart());
        consoleHelper.close();
    }

}
