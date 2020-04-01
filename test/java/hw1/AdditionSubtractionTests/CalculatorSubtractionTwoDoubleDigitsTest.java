package hw1.AdditionSubtractionTests;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractionTwoDoubleDigitsTest extends CalculatorSetUp {

    @Test(dataProvider = "testSubDataDouble", groups = "sumsubtests")
    public void SubtractionTwoDoubleDigits(Double a, Double b, Double expected){
        Double actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object [][] testSubDataDouble(){
        return new Object[][] {
                {0.8, 0.2, 0.6},
                {11.0, 7.0, 3.0},
                {0.45, 0.40, 0.5}
        };
    }
}
