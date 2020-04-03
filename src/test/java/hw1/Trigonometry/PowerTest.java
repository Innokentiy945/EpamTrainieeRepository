package hw1.Trigonometry;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PowerTest extends CalculatorSetUp {

    @Test(dataProvider = "dataProviderDoubleNumbers", groups = "trigonometry")
    public void powerNumbers(double a, double b, double expected){
        double actual = calculator.pow(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] dataProviderDoubleNumbers() {
        return  new Object[][] {
                {4.0, 5.0, 1024.0},
                {-3.0, -7.0, -4.572473708276177E-4},
                {-8.0, 7.0, -2097152.0}

        };
    }
}
