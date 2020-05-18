package api2;


import api2.service.SpellerAssert;
import api2.service.SpellerOperations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api2.dto.EntityBuilder;

public class CheckTextSpellerTest extends SpellerAssert {
    private SpellerOperations spellerOperations;
    private SpellerAssert spellerAssert;

    @BeforeClass
    public void initData() {
        spellerOperations = new SpellerOperations();
        spellerAssert = new SpellerAssert();
    }

    @Test(dataProvider = "dataProviderMultipleWords", dataProviderClass = DataProviders.class)
    public void spellerMultipleWords(EntityBuilder testData) {
        assertResultText(testData);
    }

    @Test(dataProvider = "dataProviderSingleWord", dataProviderClass = DataProviders.class)
    public void spellerSingleWord(EntityBuilder testData) {
        assertResultText(testData);
    }
}
