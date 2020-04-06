package hw1.Trigonometry;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SinusTest extends CalculatorSetUp {


    @Test(dataProvider = "dataProviderDoubleNumbers", groups = "trigonometry")
    public void sinNumbers(double a, double expected) {
        double actual = calculator.sin(a);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] dataProviderDoubleNumbers() {
        return new Object[][] {
                {55.0, -0.9997551733586199},
                {-105, 0.9705352835374847},
                {8.3, 0.9021718337562933}
        };
    }
}
