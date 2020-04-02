package hw1.Trigonometry;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TangentTest extends CalculatorSetUp {


    @Test(dataProvider = "dataProviderDoubleNumbers", groups = "trigonometry")
    public void tangNumbers(double a, double expected) {
        double actual = calculator.tg(a);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] dataProviderDoubleNumbers() {
        return new Object[][] {
                {0.30, 1.0},
                {1.5, 1.0},
                {-2.5, 1.0}
        };
    }
}
