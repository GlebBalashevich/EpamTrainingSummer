package com.balashevich.day1.task3;

/**
 * Abstract class what describes the main parameters of a geometric shape
 * Almost all geometric shapes have general parameters like Area and Diagonal
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 */

public abstract class Shape {
    private double diagonal;
    private double area;

    public Shape() {
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

}
