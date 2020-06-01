package com.balashevich.day1.task7;

import java.util.ArrayList;

/**
 * A graph object that stores a set of
 * points related to this graph. It is
 * possible to determine the nearest reference
 * point using the method
 * uses the class ArrayList to store points
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 * @see ArrayList
 */

public class Graph {
    private ArrayList<Point> points;

    public Graph() {
        points = new ArrayList<>();
    }

    public void addPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    /**
     * Defines the point closest to the reference point using the
     * sumCoordinates() method of the Point class. The nearest point is determined
     * by the smallest sum of the absolute values of the point's coordinates
     */
    public Point searchNearestToStart() {
        Point nearestPoint = null;

        for (Point checkingPoint : points) {
            if (nearestPoint == null) {
                nearestPoint = checkingPoint;
            }

            if (nearestPoint.sumCoordinates() > checkingPoint.sumCoordinates()) {
                nearestPoint = checkingPoint;
            }
        }

        return nearestPoint;
    }
}
