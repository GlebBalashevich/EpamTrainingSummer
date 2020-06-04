package com.balashevich.oopstyle.entity;

public class Point {
    private String name;
    private int xCoordinate;
    private int yCoordinate;

    public Point(String name, int xCoordinate, int yCoordinate) {
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public boolean equals(Point point) {
        if (this == point) return true;
        if (point == null) return false;
        return xCoordinate == point.xCoordinate &&
                yCoordinate == point.yCoordinate &&
                name.equals(point.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result += 37 * xCoordinate;
        result += 23 * yCoordinate;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s(%d,%d)", name, xCoordinate, yCoordinate);
    }
}
