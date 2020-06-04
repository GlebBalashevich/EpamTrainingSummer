package com.balashevich.oopstyle.console;

import java.util.Map;
import java.util.SortedMap;

public class ArithmeticConsole {

    public void printSquareLastDigit(int lastDigit) {
        System.out.printf("Last digit of number square is %d.%n", lastDigit);
    }

    public void printTwoEvenNumbers(boolean result) {
        System.out.printf("Among the passed numbers have%s two even numbers.%n", result ? "" : " NO");
    }

    public void printPerfectNumber(boolean result) {
        System.out.printf("Passed number is%s perfect number.%n", result ? "" : " NOT");
    }

    public void printDoubleFunction(double result) {
        System.out.printf("result of calculating the function: %.2f.%n", result);
    }

    public void printTangentFunction(SortedMap<Double, Double> result) {
        System.out.println("_____ ______");
        System.out.println("| X | |tg(x)|");
        for (Map.Entry<Double, Double> pair : result.entrySet()) {
            System.out.printf("|%.1f| | %.1f|%n", pair.getKey(), pair.getValue());
        }

    }

}
