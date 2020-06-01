package com.balashevich.day1.task7;

/**
 * A point on the graph whose location is determined
 * by the values of X and Y coordinates
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 */

public class Point {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Summarize and return absolute values of X and Y coordinates
     */
    public int sumCoordinates() {
        return Math.abs(x) + Math.abs(y);
    }

    @Override
    public String toString() {
        return String.format("Point (x: %d, y: %d)", x, y);
    }
}
