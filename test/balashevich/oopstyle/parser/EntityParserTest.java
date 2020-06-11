package balashevich.oopstyle.parser;

import balashevich.oopstyle.entity.Point;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EntityParserTest {
    EntityParser entityParser;

    @BeforeTest
    public void setUp() {
        entityParser = new EntityParser();
    }

    @DataProvider(name = "pointPositiveData")
    public Object[][] createPointPositiveData() {
        return new Object[][]{
                {"A(5,10)", new Point("A", 5, 10)},
                {"B(15,8)", new Point("B", 15, 8)},
                {"C(6,14)", new Point("C", 6, 14)},
        };
    }

    @Test(dataProvider = "pointPositiveData")
    public void testParsePointPositive(String pointData, Point expected) {
        Point actual = entityParser.parsePoint(pointData);
        assertTrue(actual.equals(expected));
    }

    @DataProvider(name = "pointExceptionData")
    public Object[][] createPointExceptionData() {
        return new Object[][]{
                {"A5,10)"},
                {"B(g5,8)"},
                {"C(6,g)"},
        };
    }

    @Test(dataProvider = "pointExceptionData", expectedExceptions = IllegalArgumentException.class)
    public void testParsePointIllegalArgumentException(String pointData) {
        entityParser.parsePoint(pointData);
    }

    @Test(expectedExceptions = StringIndexOutOfBoundsException.class)
    public void testParsePointStringOutOfBoundsException() {
        entityParser.parsePoint("B(g58)");
    }
}