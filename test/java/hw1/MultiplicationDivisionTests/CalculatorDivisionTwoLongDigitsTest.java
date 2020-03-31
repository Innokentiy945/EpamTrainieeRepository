package hw1.MultiplicationDivisionTests;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivisionTwoLongDigitsTest extends CalculatorSetUp {

    @Test(dataProvider = "testDivDataLong", groups = "divmultitests")
    public void DivisionTwoLongDigits(Long a, Long b, Long expected) {
        long actual = calculator.div(a, b);
        assertEquals((Long)actual, expected);
    }

    @DataProvider
    public Object[][] testDivDataLong() {
        return new Object[][]{
                {10L, 2L, 5L},
                {45L, 5L, 9L},
                {35L, 7L, 5L}
        };
    }
}
