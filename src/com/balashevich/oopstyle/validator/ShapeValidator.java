package com.balashevich.oopstyle.validator;

import com.balashevich.oopstyle.entity.Point;

public class ShapeValidator {

    public boolean validatePoint(Point point){
        boolean result = true;
        if (point == null){
            result = false;
        } else if (point.getXCoordinate() < 0 || point.getYCoordinate() < 0){
            result = false;
        }
        return result;
    }

}
