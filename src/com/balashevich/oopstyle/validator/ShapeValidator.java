package com.balashevich.oopstyle.validator;

import com.balashevich.oopstyle.entity.Point;
import com.balashevich.oopstyle.parser.EntityParser;

public class ShapeValidator {
    private ArithmeticValidator arithmeticValidator = new ArithmeticValidator();
    private EntityParser entityParser = new EntityParser();

    public boolean validateArea(String areaValue) {
        return arithmeticValidator.validateDouble(areaValue, 0, 200);
    }

    public boolean validatePoint(String pointData) {
        try {
            Point point = entityParser.parsePoint(pointData);
            if (!arithmeticValidator.validateInteger(point.getXCoordinate(), -20, 20) ||
                    !arithmeticValidator.validateInteger(point.getYCoordinate(), -20, 20)) {

                return false;
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public boolean validateRadius(String radiusValue) {
        return arithmeticValidator.validateDouble(radiusValue, 0, 140);
    }
}
