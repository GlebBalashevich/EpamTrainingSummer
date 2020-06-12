package com.balashevich.oopstyle.console;

import com.balashevich.oopstyle.entity.Point;

public class ShapeConsole {

    public void printSquaresProportion(double proportion) {
        System.out.printf("Outer square more than Inner square in %.2f times.%n", proportion);
    }

    public void printPointNearestOrigin(Point nearestPoint) {
        System.out.println("The nearest point to the origin is: " + nearestPoint);
    }

    public void printAreaAndCircumference(double area, double circumference) {
        System.out.printf("The area of circle is: %.2f,%nThe circumference of round is: %.2f.%n",
                area, circumference);
    }
}
