package hw1.AdditionSubtractionTests;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractionTwoLongDigitsTest extends CalculatorSetUp {


    @Test(dataProvider = "testSubDataLong", groups = "sumsubtests")
    public void SubtractionTwoLongDigits(long a, long b, long expected){
        long actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] testSubDataLong(){
        return new Object[][]{
                {5L, 2L, 3L},
                {45L, 25L, 20L},
                {10L, 8L, 2L}
        };
    }
}
