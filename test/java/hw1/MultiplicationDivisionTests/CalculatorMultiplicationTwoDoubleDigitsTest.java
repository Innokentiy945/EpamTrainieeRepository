package hw1.MultiplicationDivisionTests;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultiplicationTwoDoubleDigitsTest extends CalculatorSetUp {

    @Test(dataProvider = "testMultiDataDouble", groups = "divmultitests")
    public void DoubleMulti(Double a, Double b, Double expected) {
        Double actual = calculator.mult(a, b);
        assertEquals((Double)actual, expected);
    }

    @DataProvider
    public Object [][] testMultiDataDouble() {
        return new Object[][] {
                {2.0, 1.0, 2.0},
                {5.0, 4.0, 20.0},
                {1.20, 0.40, 0.48}
        };
    }
}
