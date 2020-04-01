package hw1.FunctionTests;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorCotangentFunctionTest extends CalculatorSetUp {

    @Test(dataProvider = "testCtgData", groups = "functions")
    public void CotangentFunction(Double a, Double expected) {
        Double actual = calculator.ctg(a);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] testCtgData() {
        return new Object[][] {
                {-0.45, -0.4218990052500079},
                {45.0, 1.0},
                {0.05, 0.04995837495787998}
        };
    }
}
