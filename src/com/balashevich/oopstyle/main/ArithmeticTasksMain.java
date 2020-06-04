package com.balashevich.oopstyle.main;

import com.balashevich.oopstyle.console.ArithmeticConsole;
import com.balashevich.oopstyle.service.ArithmeticService;

public class ArithmeticTasksMain {

    public static void main(String[] args) {
        ArithmeticConsole arithmeticConsole = new ArithmeticConsole();
        ArithmeticService arithmeticService = new ArithmeticService();

        arithmeticConsole.printSquareLastDigit(arithmeticService.calculateSquareLastDigit("53"));
        arithmeticConsole.printSquareLastDigit(arithmeticService.calculateSquareLastDigit("105"));
        arithmeticConsole.printSquareLastDigit(arithmeticService.calculateSquareLastDigit("hello exception"));

        arithmeticConsole.printTwoEvenNumbers(arithmeticService.isTwoEvenNumbers("2, 3, 5, 8"));
        arithmeticConsole.printTwoEvenNumbers(arithmeticService.isTwoEvenNumbers("2, 3, 5, 5"));
        arithmeticConsole.printTwoEvenNumbers(arithmeticService.isTwoEvenNumbers("2, 3, 5, 105"));
        arithmeticConsole.printTwoEvenNumbers(arithmeticService.isTwoEvenNumbers("2, b, 5, 8"));

        arithmeticConsole.printPerfectNumber(arithmeticService.isNumberPerfect("33550336"));
        arithmeticConsole.printPerfectNumber(arithmeticService.isNumberPerfect("2305843008139952130"));
        arithmeticConsole.printPerfectNumber(arithmeticService.isNumberPerfect("33550337"));

        arithmeticConsole.printDoubleFunction(arithmeticService.calculateDoubleFunction("3"));
        arithmeticConsole.printDoubleFunction(arithmeticService.calculateDoubleFunction("1"));
        arithmeticConsole.printDoubleFunction(arithmeticService.calculateDoubleFunction("1.8171205928321"));

        arithmeticConsole.printTangentFunction(
                arithmeticService.calculateLineFunction("1", "10", "0.5"));
        arithmeticConsole.printTangentFunction(
                arithmeticService.calculateLineFunction("1", "10", "20"));
        arithmeticConsole.printTangentFunction(
                arithmeticService.calculateLineFunction("20", "10", "0.5"));
    }
}
