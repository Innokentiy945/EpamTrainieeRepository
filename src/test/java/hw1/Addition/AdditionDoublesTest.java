package hw1.Addition;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class AdditionDoublesTest extends CalculatorSetUp {

    @Test(dataProvider = "dataProviderDoubleNumbers", groups = "sumsubtests")
    public void sumTwoDoubleNumbers(double a, double b, double expected){
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object [][] dataProviderDoubleNumbers(){
        return new Object[][] {
                {2.0, 1.0, 3.0},
                {5.0, 4.0, 9.0},
                {1.20, 0.40, 1.60}
        };
    }
}
