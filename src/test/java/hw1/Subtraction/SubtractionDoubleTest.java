package hw1.Subtraction;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractionDoubleTest extends CalculatorSetUp {

    @Test(dataProvider = "dataProviderDoubleNumbers", groups = "sumsubtests")
    public void subtractTwoDoubleNumbers(double a, double b, double expected){
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object [][] dataProviderDoubleNumbers(){
        return new Object[][] {
                {0.8, 0.2, 0.6},
                {11.0, 7.0, 3.0},
                {0.45, 0.40, 0.5}
        };
    }
}
