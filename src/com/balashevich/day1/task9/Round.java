package com.balashevich.day1.task9;

/**
 * Describes a geometric shape a Round
 * Extends of abstract class Shape
 * distinctive feature of a round is that it have a circumference
 * and it's linked with Circle,
 * so the circle and circumference fields were added
 * Uses methods of the Math class to perform some actions
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 * @see Math
 */

public class Round extends Shape {
    private Circle circle;
    private double circumference;

    public Round(double radius) {
        super(radius);
        circle = new Circle(radius);
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public double getCircumference() {
        return circumference;
    }

    public void setCircumference(double circumference) {
        this.circumference = circumference;
    }

    /**
     * mathematical formula for determining the circumference of a round
     */
    public void calculateCircumference(){
        circumference = 2 * Math.PI * getRadius();
    }
}
