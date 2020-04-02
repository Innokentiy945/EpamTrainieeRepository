package hw1.Addition;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AdditionLongTest extends CalculatorSetUp {
    @Test(dataProvider = "dataProviderLongNumbers", groups = "sumsubtests")
    public void sumTwoLongNumbers(long a, long b, long expected){
        long actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] dataProviderLongNumbers(){
        return new Object[][]{
                {1L, 2L, 3L},
                {4L, 5L, 9L},
                {7L, 8L, 15L}
        };
    }
}
