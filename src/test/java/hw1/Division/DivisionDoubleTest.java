package hw1.Division;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivisionDoubleTest extends CalculatorSetUp {

    @Test(dataProvider = "dataProviderDoubleNumbers", groups = "divmultitests")
    public void divideTwoDoubleNumbers(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }


    @DataProvider
    public Object [][] dataProviderDoubleNumbers(){
        return new Object[][] {
                {0.10, 0.2, 0.5},
                {25.0, 5.0, 5.0},
                {0.128, 0.08, 1.6}
        };
    }
}
