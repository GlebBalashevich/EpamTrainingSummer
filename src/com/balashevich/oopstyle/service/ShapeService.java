package com.balashevich.oopstyle.service;

import com.balashevich.oopstyle.entity.Point;
import com.balashevich.oopstyle.exception.ProjectInvalidDataException;
import com.balashevich.oopstyle.validator.ShapeValidator;

public class ShapeService {

    public double calculateSquaresProportion (double outerSquareArea) {
        if (outerSquareArea < 0){
            throw new ProjectInvalidDataException();
        }

        double outerSquareSide = Math.sqrt(outerSquareArea);
        double innerSquareArea = Math.pow(outerSquareSide, 2) / 2;

        return outerSquareArea / innerSquareArea;
    }

    public Point searchPointNearestOrigin(Point firstPoint, Point secondPoint) {
        ShapeValidator shapeValidator = new ShapeValidator();
        if (!shapeValidator.validatePoint(firstPoint) || !shapeValidator.validatePoint(secondPoint)){
            throw new ProjectInvalidDataException();
        }

        double firstPointHypotenuse = Math.hypot(firstPoint.getXCoordinate(), firstPoint.getYCoordinate());
        double secondPointHypotenuse = Math.hypot(secondPoint.getXCoordinate(), secondPoint.getYCoordinate());

        return firstPointHypotenuse < secondPointHypotenuse ? firstPoint : secondPoint;
    }

    public double calculateRoundCircumference(double radius) {
        if (radius < 0){
            throw new ProjectInvalidDataException();
        }

        return 2 * Math.PI * radius;
    }

    public double calculateCircleArea(double radius) {
        if (radius < 0){
            throw new ProjectInvalidDataException();
        }

        return Math.pow(radius, 2) * Math.PI;
    }
}
