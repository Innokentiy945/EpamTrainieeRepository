package hw1.MultiplicationDivisionTests;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultiplicationTwoLongDigitsTest extends CalculatorSetUp {

    @Test(dataProvider = "testMultiDataLong", groups = "divmultitests")
    public void MultiplicationTwoLongDigits(Long a, Long b, Long expected) {
        Long actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }


    @DataProvider
    public Object[][] testMultiDataLong() {
        return new Object[][]{
                {1L, 2L, 2L},
                {4L, 5L, 20L},
                {7L, 8L, 56L}
        };
    }
}
