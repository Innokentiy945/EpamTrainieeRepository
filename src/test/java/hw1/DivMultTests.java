package hw1;




import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivMultTests {
    private Calculator calculator;

    @BeforeMethod
    public void setUp(){
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] testMultiDataLong() {
        return new Object[][]{
                {1L, 2L, 2L},
                {4L, 5L, 20L},
                {7L, 8L, 56L}
        };
    }

    @DataProvider
    public Object[][] testDivDataLong() {
        return new Object[][]{
                {10L, 2L, 5L},
                {45L, 5L, 9L},
                {35L, 7L, 5L}
        };
    }
    @DataProvider
    public Object [][] testMultiDataDouble() {
        return new Object[][] {
                {2.0, 1.0, 2.0},
                {5.0, 4.0, 20.0},
                {1.20, 0.40, 0.48}
        };
    }

    @DataProvider
    public Object [][] testDivDataDouble(){
        return new Object[][] {
                {0.10, 0.2, 0.5},
                {25.0, 5.0, 5.0},
                {0.128, 0.08, 1.6}
        };
    }

    @Test(dataProvider = "testMultiDataLong", groups = "divmultitests")
    public void LongMulti(Long a, Long b, Long expected) {
        System.out.println("Multiply two long digits ");
        long actual = calculator.mult(a, b);
        assertEquals(java.util.Optional.of(actual), java.util.Optional.ofNullable(expected));
        System.out.println(actual + " LongMulti test passed: actual result is similar to expected result");
    }

    @Test(dataProvider = "testDivDataLong", groups = "divmultitests")
    public void LongDiv(Long a, Long b, Long expected) {
        System.out.println("Divide two long digits");
        long actual = calculator.div(a, b);
        assertEquals(java.util.Optional.of(actual), java.util.Optional.ofNullable(expected));
        System.out.println(actual + " LongDiv test passed: actual result is similar to expected result");
    }
    @Test(dataProvider = "testMultiDataDouble", groups = "divmultitests")
    public void DoubleMulti(Double a, Double b, Double expected) {
        System.out.println("Multiply two double digits ");
        Double actual = calculator.mult(a, b);
        assertEquals(java.util.Optional.of(actual), java.util.Optional.ofNullable(expected));
        System.out.println(actual + " DoubleMulti test not passed: actual result is incorrect");
    }

    @DataProvider
    public Object[][] testPowData() {
        return  new Object[][] {
                {4.0, 5.0, 1024.0},
                {-3.0, -7.0, -4.572473708276177E-4},
                {-8.0, 7.0, -2097152.0}

        };
    }

    @Test(dataProvider = "testPowData", groups = "divmultitests")
    public void powTest(double a, double b, double expected){
        System.out.println("Pow two digits");
        Double actual = calculator.pow(a, b);
        assertEquals(java.util.Optional.of(actual), java.util.Optional.of(expected));
        System.out.println(actual + " powTest passed: actual result is similar to expected result");
    }

    @DataProvider
    public Object[][] testSqrtData() {
            return new Object[][] {
                    {4.0, 2.0},
                    {-0.7, 0.8366600265340756},
                    {5.7, 2.3874672772626644}
            };
    }

    @Test(dataProvider = "testSqrtData", groups = "divmultitests")
    public void sqrtTest(double a, double expected){
        System.out.println("Sqrt digit");
        double actual = calculator.sqrt(a);
        assertEquals(actual, expected);
        System.out.println(actual + " sqrtTest passed: actual result is similar to expected result");
    }

    @DataProvider
    public Object[][] testTgData() {
        return new Object[][] {
                {0.30, 1.0},
                {1.5, 1.0},
                {-2.5, 1.0}
        };
    }
    @Test(dataProvider = "testTgData", groups = "divmultitests")
    public void tgTest(double a, double expected) {
        System.out.println("Tg of the digit");
        double actual = calculator.tg(a);
        assertEquals(actual, expected);
        System.out.println(actual + " tgTest passed: actual result is similar to expected result");
    }

    @DataProvider
    public Object[][] testCtgData() {
        return new Object[][] {
                {-0.45, -0.4218990052500079},
                {45.0, 1.0},
                {0.05, 0.04995837495787998}
        };
    }

    @Test(dataProvider = "testCtgData", groups = "divmultitests")
    public void ctgTest(double a, double expected) {
        System.out.println("Ctg of the digit");
        double actual = calculator.ctg(a);
        assertEquals(actual, expected);
        System.out.println(actual + " ctgTest passed: actual result is similar to expected result");
    }


    @DataProvider
    public Object[][] testCosData() {
        return new Object[][] {
                {55.0, -0.9997551733586199},
                {-105, 0.9705352835374847},
                {8.3, 0.9021718337562933}
        };
    }

    @Test(dataProvider = "testCosData", groups = "divmultitests")
    public void cosTest(double a, double expected) {
        System.out.println("Cos of the digit");
        double actual = calculator.cos(a);
        assertEquals(actual, expected);
        System.out.println(actual + " cosTest test not passed: actual result is incorrect. In cosinus method used sinus method");
    }

    @DataProvider
    public Object[][] testSinData() {
        return new Object[][] {
                {55.0, -0.9997551733586199},
                {-105, 0.9705352835374847},
                {8.3, 0.9021718337562933}
        };
    }

    @Test(dataProvider = "testSinData", groups = "divmultitests")
    public void sinTest(double a, double expected) {
        System.out.println("Sin of the digit");
        double actual = calculator.sin(a);
        assertEquals(actual, expected);
        System.out.println(actual + " sinTest test passed: actual result is similar to expected result");
    }


    @AfterClass
    public void tearDownClass() {
        calculator = null;
        System.out.println("Test suit ends");
    }

}
