package hw1.MultiplicationDivisionTests;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivisionTwoDoubleDigitsTest extends CalculatorSetUp {

    @Test(dataProvider = "testDivDataDouble", groups = "divmultitests")
    public void DivisionTwoLongDigits(Double a, Double b, Double expected) {
        double actual = calculator.div(a, b);
        assertEquals((Double) actual, expected);
    }


    @DataProvider
    public Object [][] testDivDataDouble(){
        return new Object[][] {
                {0.10, 0.2, 0.5},
                {25.0, 5.0, 5.0},
                {0.128, 0.08, 1.6}
        };
    }
}
