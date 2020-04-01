package hw1.FunctionTests;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorCosineFunctionTest extends CalculatorSetUp {



    @Test(dataProvider = "testCosData", groups = "functions")
    public void CosineFunction(Double a, Double expected) {
        Double actual = calculator.cos(a);
        assertEquals(actual, expected);
    }


    @DataProvider
    public Object[][] testCosData() {
        return new Object[][] {
                {55.0, -0.9997551733586199},
                {-105, 0.9705352835374847},
                {8.3, 0.9021718337562933}
        };
    }
}
