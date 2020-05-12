package api2;


import api2.service.SpellerOperations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api2.dto.SpellerDto;
import api2.dto.EntityBuilder;

import java.util.stream.Stream;


public class CheckTextSpellerTest {
    private SpellerOperations spellerOperations;

    @BeforeClass
    public void initData() {
        spellerOperations = new SpellerOperations();
    }


    @Test(dataProvider = "dataProviderMultipleWords", dataProviderClass = DataProviders.class)
    public void spellerMultipleWords(EntityBuilder testData) {
        assertResultTexts(testData);
        System.out.println("Text reques is: ");
        Stream.of(testData.textRequest).findFirst().ifPresent(System.out::println);
    }

    @Test(dataProvider = "dataProviderSingleWord", dataProviderClass = DataProviders.class)
    public void spellerSingleWord(EntityBuilder testData) {
        assertResultText(testData);
        Stream.of(testData.textRequest).findFirst().ifPresent(System.out::println);
    }

    private void assertResultText(EntityBuilder testData) {
        SpellerDto[] actualSpellerResult = spellerOperations.checkText(testData.getTextRequest());
        Assert.assertEquals(actualSpellerResult, testData.getDtos());
    }

    private void assertResultTexts(EntityBuilder testData) {
        SpellerDto[] actualSpellerResult = spellerOperations.checkText(testData.getTextRequest());
        Assert.assertEquals(actualSpellerResult, testData.getDtos());
    }

}
