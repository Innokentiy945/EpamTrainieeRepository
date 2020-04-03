package hw1.Multiplication;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplicationDoubleTest extends CalculatorSetUp {

    @Test(dataProvider = "dataProviderDoubleNumbers", groups = "divmultitests")
    public void multiplyTwoDoubleNumbers(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object [][] dataProviderDoubleNumbers() {
        return new Object[][] {
                {2.0, 1.0, 2.0},
                {5.0, 4.0, 20.0},
                {1.20, 0.40, 0.48}
        };
    }
}
