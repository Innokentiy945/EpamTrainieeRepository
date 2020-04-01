package hw1.AdditionSubtractionTests;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class CalculatorAdditionTwoDoubleDigitsTest extends CalculatorSetUp {

    @Test(dataProvider = "testSumDataDouble", groups = "sumsubtests")
    public void AdditionTwoDoubleDigits(Double a, Double b, Double expected){
        double actual = calculator.sum(a, b);
        assertEquals((Double) actual, expected);
    }

    @DataProvider
    public Object [][] testSumDataDouble(){
        return new Object[][] {
                {2.0, 1.0, 3.0},
                {5.0, 4.0, 9.0},
                {1.20, 0.40, 1.60}
        };
    }
}
