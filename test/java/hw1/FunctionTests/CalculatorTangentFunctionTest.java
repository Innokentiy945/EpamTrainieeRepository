package hw1.FunctionTests;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTangentFunctionTest extends CalculatorSetUp {


    @Test(dataProvider = "testTgData", groups = "functions")
    public void TangentFunction(double a, double expected) {
        double actual = calculator.tg(a);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] testTgData() {
        return new Object[][] {
                {0.30, 1.0},
                {1.5, 1.0},
                {-2.5, 1.0}
        };
    }
}
