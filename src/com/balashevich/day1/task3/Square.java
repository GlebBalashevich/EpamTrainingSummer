package com.balashevich.day1.task3;

/**
 * Describes a geometric shape a Square
 * Extends of abstract class Shape
 * distinctive feature of a square is that all its sides are equal,
 * so the Side field was added
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 */

public class Square extends Shape {
    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    /**
     * defines the area of a square using a formula based on calculating the area diagonally
     * the mathematics square of the diagonal divided by two
     */
    public double calculateArea(double diagonal) {
        return (Math.pow(diagonal, 2) / 2);
    }

    /**
     * defines the side of a square using a formula based on calculating the side by square
     * square root of the area
     */
    public double calculateSideByArea() {
        return Math.sqrt(getArea());
    }

}
