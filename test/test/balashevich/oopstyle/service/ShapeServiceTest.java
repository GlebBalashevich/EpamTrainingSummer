package test.balashevich.oopstyle.service;

import com.balashevich.oopstyle.entity.Point;
import com.balashevich.oopstyle.exception.ProjectInvalidDataException;
import com.balashevich.oopstyle.service.ShapeService;
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
    public void testCalculateSquaresProportionPositive() {
        double actual = shapeService.calculateSquaresProportion(16);
        double expected = 2;
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testCalculateSquaresProportionNegative() {
        double actual = shapeService.calculateSquaresProportion(16);
        double expected = 8;
        assertNotEquals(actual, expected, 0.001);
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void testCalculateSquaresProportionException() {
        shapeService.calculateSquaresProportion(-5);
    }

    @Test
    public void testSearchPointNearestOriginPositive() {
        Point firstPoint = new Point("A", 5, 10);
        Point secondPoint = new Point("B", 10, 8);
        Point actual = shapeService.searchPointNearestOrigin(firstPoint, secondPoint);
        assertEquals(actual, firstPoint);
    }

    @Test
    public void testSearchPointNearestOriginNegative() {
        Point firstPoint = new Point("A", 12, 10);
        Point secondPoint = new Point("B", 10, 8);
        Point actual = shapeService.searchPointNearestOrigin(firstPoint, secondPoint);
        assertNotEquals(actual, firstPoint);
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void testSearchPointNearestOriginException() {
        Point firstPoint = new Point("A", -12, 10);
        Point secondPoint = new Point("B", 10, 8);
        shapeService.searchPointNearestOrigin(firstPoint, secondPoint);
    }

    @Test
    public void testCalculateRoundCircumferencePositive() {
        double actual = shapeService.calculateRoundCircumference(17);
        double expected = 106.814;
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testCalculateRoundCircumferenceNegative() {
        double actual = shapeService.calculateRoundCircumference(17);
        double expected = 96.814;
        assertNotEquals(actual, expected, 0.001);
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void testCalculateRoundCircumferenceException() {
        shapeService.calculateRoundCircumference(-17);
    }

    @Test
    public void testCalculateCircleAreaPositive() {
        double actual = shapeService.calculateCircleArea(17);
        double expected = 907.92;
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testCalculateCircleAreaNegative() {
        double actual = shapeService.calculateCircleArea(17);
        double expected = 107.92;
        assertNotEquals(actual, expected, 0.001);
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class)
    public void testCalculateCircleAreaException() {
        shapeService.calculateCircleArea(-17);
    }
}