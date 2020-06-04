package com.balashevich.oopstyle.main;

import com.balashevich.oopstyle.console.ShapeConsole;
import com.balashevich.oopstyle.service.ShapeService;

public class ShapeTasksMain {

    public static void main(String[] args) {
        ShapeService shapeService = new ShapeService();
        ShapeConsole shapeConsole = new ShapeConsole();

        shapeConsole.printSquaresProportion(shapeService.calculateSquaresProportion("80"));
        shapeConsole.printSquaresProportion(shapeService.calculateSquaresProportion("-5"));
        shapeConsole.printSquaresProportion(shapeService.calculateSquaresProportion("g"));

        shapeConsole.printPointNearestOrigin(shapeService.searchPointNearestOrigin("A(5,8)", "B(14,2)"));
        shapeConsole.printPointNearestOrigin(shapeService.searchPointNearestOrigin("A(25,8)", "B(14,2"));
        shapeConsole.printPointNearestOrigin(shapeService.searchPointNearestOrigin("A(j,d)", "B(14,2"));

        shapeConsole.printAreaAndCircumference(shapeService.calculateCircleArea("15"),
                shapeService.calculateRoundСircumference("15"));
        shapeConsole.printAreaAndCircumference(shapeService.calculateCircleArea("-15"),
                shapeService.calculateRoundСircumference("-15"));
        shapeConsole.printAreaAndCircumference(shapeService.calculateCircleArea("g"),
                shapeService.calculateRoundСircumference("g"));
    }

}
