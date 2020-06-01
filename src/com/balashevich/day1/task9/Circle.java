package com.balashevich.day1.task9;

/**
 * Describes a geometric shape a Circle
 * Extends of abstract class Shape
 * distinctive feature of a circle is that it have a area
 * so the area field was added. Uses methods of the
 * Math class to perform some actions
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 * @see Math
 */

public class Circle extends Shape {
    private double area;

    public Circle(double radius) {
        super(radius);
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    /**
     * mathematical formula for determining the area of a circle
     */
    public void calculateArea(){
        area = Math.pow(getRadius(), 2) * Math.PI;
    }
}
