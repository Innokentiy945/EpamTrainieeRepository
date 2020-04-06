package hw1.Division;

import hw1.CalculatorSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivisionLongTest extends CalculatorSetUp {

    @Test(dataProvider = "dataProviderLongNumbers", groups = "divmultitests")
    public void divisionTwoLongNumbers(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] dataProviderLongNumbers() {
        return new Object[][]{
                {10L, 2L, 5L},
                {45L, 5L, 9L},
                {35L, 7L, 5L}
        };
    }
}
