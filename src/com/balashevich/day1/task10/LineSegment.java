package com.balashevich.day1.task10;

import java.util.TreeMap;

/**
 * a segment consisting of two points.
 * the class includes a nested class that
 * is used for calculations related to points
 * located on a segment
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 */

public class LineSegment {
    private double firstPoint;
    private double secondPoint;
    private FunctionCalculator functionCalculator;

    public LineSegment(double firstPoint, double secondPoint, double functionStep) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        functionCalculator = new FunctionCalculator(functionStep);
    }

    public double getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(double firstPoint) {
        this.firstPoint = firstPoint;
    }

    public double getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(double secondPoint) {
        this.secondPoint = secondPoint;
    }

    public FunctionCalculator getFunctionCalculator() {
        return functionCalculator;
    }

    /**
     * using data from the outer class calculates the
     * value of a function of the form F(x) = tg(x)
     */
    public class FunctionCalculator {
        private double functionStep;

        public FunctionCalculator(double functionStep) {
            this.functionStep = functionStep;
        }

        public double getFunctionStep() {
            return functionStep;
        }

        public void setFunctionStep(double functionStep) {
        }

        /**
         * Calculating function values, put its in TreeMap and return result
         */
        public TreeMap<Double, Double> calculateFunction() {
            double functionArgument = firstPoint;
            TreeMap<Double, Double> functionResult = new TreeMap<>();

            while (functionArgument <= secondPoint) {
                System.out.println(functionStep + " " + functionArgument);
                functionResult.put(functionArgument, Math.tan(functionArgument));
                functionArgument += functionStep;
            }

            return functionResult;
        }
    }
}
