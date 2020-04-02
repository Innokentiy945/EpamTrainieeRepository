package hw1.Trigonometry;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CotangentTest extends CalculatorSetUp {

    @Test(dataProvider = "dataProviderDoubleNumbers", groups = "trigonometry")
    public void cotNumbers(double a, double expected) {
        double actual = calculator.ctg(a);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] dataProviderDoubleNumbers() {
        return new Object[][] {
                {-0.45, -0.4218990052500079},
                {45.0, 1.0},
                {0.05, 0.04995837495787998}
        };
    }
}
