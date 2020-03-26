package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SumSubTests {
    private Calculator calculator;

    @BeforeMethod
    public void setUp(){
        calculator = new Calculator();
    }


    @DataProvider
    public Object[][] testSumDataLong(){
        return new Object[][]{
                {1L, 2L, 3L},
                {4L, 5L, 9L},
                {7L, 8L, 15L}
        };
    }

    @DataProvider
    public Object[][] testSubDataLong(){
        return new Object[][]{
                {5L, 2L, 3L},
                {45L, 25L, 20L},
                {10L, 8L, 2L}
        };
    }
    @DataProvider
    public Object [][] testSumDataDouble(){
        return new Object[][] {
                {2.0, 1.0, 3.0},
                {5.0, 4.0, 9.0},
                {1.20, 0.40, 1.60}
        };
    }

    @DataProvider
    public Object [][] testSubDataDouble(){
        return new Object[][] {
                {0.8, 0.2, 0.6},
                {11.0, 7.0, 3.0},
                {0.45, 0.40, 0.5}
        };
    }


    @Test(dataProvider = "testSumDataLong", groups = "sumsubtests")
    public void LongSum(Long a, Long b, Long expected){
        System.out.println("Sum two long variables");
        long actual = calculator.sum(a, b);
        assertEquals(java.util.Optional.of(actual), java.util.Optional.ofNullable(expected));
        System.out.println(actual + " LongSum test passed: actual result is similar to expected result");

    }

    @Test(dataProvider = "testSubDataLong", groups = "sumsubtests")
    public void LongSub(Long a, Long b, Long expected){
        System.out.println("Sub two long digits");
        Long actual = calculator.sub(a, b);
        assertEquals(java.util.Optional.of(actual), java.util.Optional.ofNullable(expected));
        System.out.println(actual + " LongSub test passed: actual result is similar to expected result");
    }

    @Test(dataProvider = "testSumDataDouble", groups = "sumsubtests")
    public void DoubleSum(Double a, Double b, Double expected){
        System.out.println("Sum two double variables");
        double actual = calculator.sum(a, b);
        assertEquals(java.util.Optional.of(actual), java.util.Optional.ofNullable(expected));
        System.out.println(actual + " DoubleSub test passed: actual result is similar to expected result");
    }

    @Test(dataProvider = "testSubDataDouble", groups = "sumsubtests")
    public void DoubleSub(Double a, Double b, Double expected){
        System.out.println("Sub two double digits");
        double actual = calculator.sub(a, b);
        assertEquals(java.util.Optional.of(actual), java.util.Optional.ofNullable(expected));
        System.out.println(actual + " DoubleSub test not passed: test not passed: actual result is incorrect");
    }



    @AfterClass
    public void tearDownClass() {
        calculator = null;
        System.out.println("Test suit ends");
    }



}
