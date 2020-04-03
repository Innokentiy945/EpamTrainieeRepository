package hw1.Subtraction;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractionLongTest extends CalculatorSetUp {


    @Test(dataProvider = "dataProviderLongNumbers", groups = "sumsubtests")
    public void subtractTwoLongNumbers(long a, long b, long expected){
        long actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] dataProviderLongNumbers(){
        return new Object[][]{
                {5L, 2L, 3L},
                {45L, 25L, 20L},
                {10L, 8L, 2L}
        };
    }
}
