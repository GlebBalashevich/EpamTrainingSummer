package com.balashevich.oopstyle.parser;

import com.balashevich.oopstyle.entity.Point;

public class EntityParser {
    private VariableParser variableParser = new VariableParser();

    public Point parsePoint(String pointData) {
        String name = pointData.split("\\(")[0];

        String pointValue = pointData.substring(pointData.indexOf('(') + 1, pointData.lastIndexOf(','));
        int xCoordinate = variableParser.parseInt(pointValue);

        pointValue = pointData.substring(pointData.indexOf(',') + 1, pointData.lastIndexOf(')'));
        int yCoordinate = variableParser.parseInt(pointValue);

        return new Point(name, xCoordinate, yCoordinate);
    }

}
