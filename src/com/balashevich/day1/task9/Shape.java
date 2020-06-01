package com.balashevich.day1.task9;

/**
 * Abstract class what describes the main parameters of a geometric shape
 * A lot of geometric shapes have general parameter radius
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 */

public abstract class Shape {
    private double radius;

    public Shape(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
