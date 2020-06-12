package com.balashevich.oopstyle.service;

import com.balashevich.oopstyle.entity.Point;
import com.balashevich.oopstyle.exception.ProjectInvalidDataException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ShapeServiceTest {
    ShapeService shapeService;

    @BeforeTest
    public void setUp() {
        shapeService = new ShapeService();
    }

    @Test
    public void calculateSquaresProportionTestPositive() {
        try {
            double actual = shapeService.calculateSquaresProportion(16);
            double expected = 2;
            assertEquals(actual, expected, 0.001);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test
    public void calculateSquaresProportionTestNegative() {
        try {
            double actual = shapeService.calculateSquaresProportion(16);
            double expected = 8;
            assertNotEquals(actual, expected, 0.001);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void calculateSquaresProportionTestException() throws ProjectInvalidDataException {
        shapeService.calculateSquaresProportion(-5);
    }

    @Test
    public void searchPointNearestOriginTestPositive() {
        try {
            Point firstPoint = new Point("A", 5, 10);
            Point secondPoint = new Point("B", 10, 8);
            Point actual = shapeService.searchPointNearestOrigin(firstPoint, secondPoint);
            assertEquals(actual, firstPoint);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test
    public void searchPointNearestOriginTestNegative() {
        try {
            Point firstPoint = new Point("A", 12, 10);
            Point secondPoint = new Point("B", 10, 8);
            Point actual = shapeService.searchPointNearestOrigin(firstPoint, secondPoint);
            assertNotEquals(actual, firstPoint);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void searchPointNearestOriginTestException() throws ProjectInvalidDataException {
        Point firstPoint = new Point("A", -12, 10);
        Point secondPoint = new Point("B", 10, 8);
        shapeService.searchPointNearestOrigin(firstPoint, secondPoint);
    }

    @Test
    public void calculateRoundCircumferenceTestPositive() {
        try {
            double actual = shapeService.calculateRoundCircumference(17);
            double expected = 106.814;
            assertEquals(actual, expected, 0.001);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test
    public void calculateRoundCircumferenceTestNegative() {
        try {
            double actual = shapeService.calculateRoundCircumference(17);
            double expected = 96.814;
            assertNotEquals(actual, expected, 0.001);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void calculateRoundCircumferenceTestException() throws ProjectInvalidDataException {
        shapeService.calculateRoundCircumference(-17);
    }

    @Test
    public void calculateCircleAreaTestPositive() {
        try {
            double actual = shapeService.calculateCircleArea(17);
            double expected = 907.92;
            assertEquals(actual, expected, 0.001);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test
    public void calculateCircleAreaTestNegative() {
        try {
            double actual = shapeService.calculateCircleArea(17);
            double expected = 7.306;
            assertNotEquals(actual, expected, 0.001);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void calculateCircleAreaTestException() throws ProjectInvalidDataException {
        shapeService.calculateCircleArea(-17);
    }
}