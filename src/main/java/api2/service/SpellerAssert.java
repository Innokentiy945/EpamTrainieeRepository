package api2.service;

import api2.dto.EntityBuilder;
import api2.dto.SpellerDto;
import org.testng.Assert;

public class SpellerAssert {

    private SpellerOperations spellerOperations = new SpellerOperations();

    public void assertResultText(EntityBuilder testData) {
        SpellerDto[] actualSpellerResult = spellerOperations.checkText(testData.getTextRequest());
        Assert.assertEquals(actualSpellerResult, testData.getDtos());
    }

    public void assertResultTexts(EntityBuilder testData) {
        SpellerDto[] actualSpellerResult = spellerOperations.checkText(testData.getTextRequest());
        Assert.assertEquals(actualSpellerResult, testData.getDtos());
    }
}
