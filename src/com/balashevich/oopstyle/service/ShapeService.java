package com.balashevich.oopstyle.service;

import com.balashevich.oopstyle.entity.Point;
import com.balashevich.oopstyle.exception.InvalidInputValueException;
import com.balashevich.oopstyle.parser.VariableParser;
import com.balashevich.oopstyle.parser.EntityParser;
import com.balashevich.oopstyle.validator.ShapeValidator;

public class ShapeService {
    VariableParser variableParser = new VariableParser();
    EntityParser entityParser = new EntityParser();
    ShapeValidator shapeValidator = new ShapeValidator();

    public double calculateSquareArea(double diagonal) {
        return (Math.pow(diagonal, 2) / 2);
    }

    public double calculateSquareSide(double area) {
        return Math.sqrt(area);
    }

    public double calculateSquaresProportion(String outerSquareAreaValue) {
        if (!shapeValidator.validateArea(outerSquareAreaValue)) {
            throw new InvalidInputValueException();
        }

        double outerSquareArea = variableParser.parseDouble(outerSquareAreaValue);
        double outerSquareSide = calculateSquareSide(outerSquareArea);
        double innerSquareArea = calculateSquareArea(outerSquareSide);
        return outerSquareArea / innerSquareArea;
    }

    public Point searchPointNearestOrigin(String firstPointData, String secondPointData) {
        if (!shapeValidator.validatePoint(firstPointData) || !shapeValidator.validatePoint(secondPointData)) {
            throw new InvalidInputValueException();
        }

        Point firstPoint = entityParser.parsePoint(firstPointData);
        Point secondPoint = entityParser.parsePoint(secondPointData);

        return (Math.hypot(firstPoint.getXCoordinate(), firstPoint.getYCoordinate()) <=
                Math.hypot(secondPoint.getXCoordinate(), secondPoint.getYCoordinate())) ?
                firstPoint : secondPoint;
    }

    public double calculateRoundСircumference(String radiusValue) {
        if (!shapeValidator.validateRadius(radiusValue)) {
            throw new InvalidInputValueException();
        }

        double radius = variableParser.parseDouble(radiusValue);

        return 2 * Math.PI * radius;
    }

    public double calculateCircleArea(String radiusValue) {
        if (!shapeValidator.validateRadius(radiusValue)) {
            throw new InvalidInputValueException();
        }

        double radius = variableParser.parseDouble(radiusValue);

        return Math.pow(radius, 2) * Math.PI;
    }
}
