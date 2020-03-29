package hw1.FunctionTests;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSquareRootFunctionTest extends CalculatorSetUp {

    @Test(dataProvider = "testSqrtData", groups = "functions")
    public void SquareRootFunction(double a, double expected){
        double actual = calculator.sqrt(a);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] testSqrtData() {
        return new Object[][] {
                {4.0, 2.0},
                {-0.7, 0.8366600265340756},
                {5.7, 2.3874672772626644}
        };
    }


}
