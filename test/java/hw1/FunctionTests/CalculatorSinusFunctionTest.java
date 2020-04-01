package hw1.FunctionTests;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSinusFunctionTest extends CalculatorSetUp {


    @Test(dataProvider = "testSinData", groups = "functions")
    public void SinusFunction(double a, double expected) {
        double actual = calculator.sin(a);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] testSinData() {
        return new Object[][] {
                {55.0, -0.9997551733586199},
                {-105, 0.9705352835374847},
                {8.3, 0.9021718337562933}
        };
    }
}