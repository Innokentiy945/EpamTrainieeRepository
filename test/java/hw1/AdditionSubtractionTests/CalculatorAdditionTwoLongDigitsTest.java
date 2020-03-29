package hw1.AdditionSubtractionTests;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorAdditionTwoLongDigitsTest extends CalculatorSetUp {
    @Test(dataProvider = "testSumDataLong", groups = "sumsubtests")
    public void AdditionTwoLongDigits(Long a, Long b, Long expected){
        long actual = calculator.sum(a, b);
        assertEquals(java.util.Optional.of(actual), java.util.Optional.ofNullable(expected));
    }

    @DataProvider
    public Object[][] testSumDataLong(){
        return new Object[][]{
                {1L, 2L, 3L},
                {4L, 5L, 9L},
                {7L, 8L, 15L}
        };
    }
}
