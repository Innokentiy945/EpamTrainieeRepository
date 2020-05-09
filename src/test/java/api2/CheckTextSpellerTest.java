package api2;


import api2.service.SpellerOperations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api2.dto.SpellerDto;
import api2.dto.EntityBuilder;



public class CheckTextSpellerTest {
    private SpellerOperations spellerOperations;

    @BeforeClass
    public void initData() {
        spellerOperations = new SpellerOperations();
    }


    @Test(dataProvider = "dataProviderEmptySpaceInWord", dataProviderClass = DataProviders.class)
    public void spellingEmptySpaceInWord(EntityBuilder testData) {
        assertResult(testData);
    }


    @Test(dataProvider = "dataProviderDigitsInWords", dataProviderClass = DataProviders.class)
    public void spellingDigitsInWord(EntityBuilder testData) {
        assertResult(testData);

    }

    @Test(dataProvider = "dataProviderErrorsInMultipleLangs", dataProviderClass = DataProviders.class)
    public void spellingErrorsInMultipleLangs(EntityBuilder testData) {
        assertResult(testData);
    }

    @Test(dataProvider = "dataProviderErrorsInMultipleTextsAndLangs", dataProviderClass = DataProviders.class)
    public void spellingErrorsInMultipleTextsAndLangs(EntityBuilder testData) {
        assertResult(testData);
    }

    @Test(dataProvider = "dataProviderUrls", dataProviderClass = DataProviders.class)
    public void ignoreUrls(EntityBuilder testData) {
        assertResult(testData);
    }

    @Test(dataProvider = "dataProviderIgnoreDotsInWords", dataProviderClass = DataProviders.class)
    public void spellingWordsWithDots(EntityBuilder testData) {
        assertResult(testData);
    }

    @Test(dataProvider = "dataProviderIgnoreDotsInWordsWithErrors", dataProviderClass = DataProviders.class)
    public void spellingWordsWithErrorsAndWithDots(EntityBuilder testData) {
        assertResult(testData);
    }

    @Test(dataProvider = "dataProviderFullText", dataProviderClass = DataProviders.class)
    public void spellingFullText(EntityBuilder testData) {
        assertResult(testData);
    }

    private void assertResult(EntityBuilder testData) {
        SpellerDto[] actualSpellerResult = spellerOperations.checkText(testData.getTextRequest());
        Assert.assertEquals(actualSpellerResult, testData.getDtos());
    }


}
