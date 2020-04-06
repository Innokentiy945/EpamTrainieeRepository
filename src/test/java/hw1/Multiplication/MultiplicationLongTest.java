package hw1.Multiplication;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplicationLongTest extends CalculatorSetUp {

    @Test(dataProvider = "dataProviderLongNumbers", groups = "divmultitests")
    public void multiplyTwoLongNumbers(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }


    @DataProvider
    public Object[][] dataProviderLongNumbers() {
        return new Object[][]{
                {1L, 2L, 2L},
                {4L, 5L, 20L},
                {7L, 8L, 56L}
        };
    }
}
