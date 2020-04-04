package hw1.Trigonometry;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SquareRootTest extends CalculatorSetUp {

    @Test(dataProvider = "dataProviderDoubleNumbers", groups = "trigonometry")
    public void squareRootNumbers(double a, double expected){
        double actual = calculator.sqrt(a);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] dataProviderDoubleNumbers() {
        return new Object[][] {
                {4.0, 2.0},
                {-0.7, 0.8366600265340756},
                {5.7, 2.3874672772626644}
        };
    }


}