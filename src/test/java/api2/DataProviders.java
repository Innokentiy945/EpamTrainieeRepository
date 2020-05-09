package api2;

import api2.dto.EntityBuilder;
import org.testng.annotations.DataProvider;
import api2.utils.JsonParser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> dataProviderEmptySpaceInWord() {
        List<EntityBuilder> testData = JsonParser.readData("src/test/resources/TestData/EmptySpaceInWord.json");
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProviderDigitsInWords() {
        List<EntityBuilder> testData = JsonParser.readData("src/test/resources/TestData/DigitsInWords.json");
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProviderErrorsInMultipleLangs() {
        List<EntityBuilder> testData = JsonParser.readData("src/test/resources/TestData/ErrorsInMultipleLangs.json");
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProviderErrorsInMultipleTextsAndLangs() {
        List<EntityBuilder> testData = JsonParser.readData("src/test/resources/TestData/ErrorsInMultipleTextsAndLangs.json");
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }


    @DataProvider
    public Iterator<Object[]> dataProviderUrls() {
        List<EntityBuilder> testData = JsonParser.readData("src/test/resources/TestData/Urls.json");
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProviderIgnoreDotsInWords() {
        List<EntityBuilder> testData = JsonParser.readData("src/test/resources/TestData/DotsInWords.json");
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProviderIgnoreDotsInWordsWithErrors() {
        List<EntityBuilder> testData = JsonParser.readData("src/test/resources/TestData/DotsInWordWithError.json");
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProviderFullText() {
        List<EntityBuilder> testData = JsonParser.readData("src/test/resources/TestData/FullText.json");
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

















}
