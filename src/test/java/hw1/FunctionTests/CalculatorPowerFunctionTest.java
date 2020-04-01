package hw1.FunctionTests;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorPowerFunctionTest extends CalculatorSetUp {

    @Test(dataProvider = "testPowData", groups = "functions")
    public void PowerFunction(Double a, Double b, Double expected){
        Double actual = calculator.pow(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] testPowData() {
        return  new Object[][] {
                {4.0, 5.0, 1024.0},
                {-3.0, -7.0, -4.572473708276177E-4},
                {-8.0, 7.0, -2097152.0}

        };
    }
}
