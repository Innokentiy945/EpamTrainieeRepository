package api2;

import api2.dto.EntityBuilder;
import org.testng.annotations.DataProvider;
import api2.utils.JsonParser;
import org.testng.collections.Lists;

import java.util.*;

public class DataProviders {


    public Object[][] EmptySpaceInWord() {
        List<EntityBuilder> testData = JsonParser.readData("src/test/resources/TestData/EmptySpaceInWord.json");
        Collection<Object[]> data = new ArrayList<>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.toArray(new Object[0][]);
    }

    public Object[][] Urls() {
        List<EntityBuilder> testData = JsonParser.readData("src/test/resources/TestData/Urls.json");
        Collection<Object[]> data = new ArrayList<>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.toArray(new Object[0][]);
    }

    public Object[][] DigitsInWords() {
        List<EntityBuilder> testData = JsonParser.readData("src/test/resources/TestData/DigitsInWords");
        Collection<Object[]> data = new ArrayList<>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.toArray(new Object[0][]);
    }

    public Object[][] IgnoreDotsInWords() {
        List<EntityBuilder> testData = JsonParser.readData("src/test/resources/TestData/DotsInWords.json");
        Collection<Object[]> data = new ArrayList<>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.toArray(new Object[0][]);
    }

    public Object[][] IgnoreDotsInWordsWithErrors() {
        List<EntityBuilder> testData = JsonParser.readData("src/test/resources/TestData/DotsInWordWithError.json");
        Collection<Object[]> data = new ArrayList<>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.toArray(new Object[0][]);
    }

    public Object[][] ErrorsInMultipleLangs() {
        List<EntityBuilder> testData = JsonParser.readData("src/test/resources/TestData/ErrorsInMultipleLangs.json");
        Collection<Object[]> data = new ArrayList<>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.toArray(new Object[0][]);
    }

    public Object[][] FullText() {
        List<EntityBuilder> testData = JsonParser.readData("src/test/resources/TestData/FullText.json");
        Collection<Object[]> data = new ArrayList<>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.toArray(new Object[0][]);
    }

    @DataProvider
    public Object[][] dataProviderSingleWord() {
        List<Object[]> result = Lists.newArrayList();
        result.addAll(Arrays.asList(EmptySpaceInWord()));
        result.addAll(Arrays.asList(DigitsInWords()));
        result.addAll(Arrays.asList(Urls()));
        result.addAll(Arrays.asList(IgnoreDotsInWords()));
        result.addAll(Arrays.asList(IgnoreDotsInWordsWithErrors()));

        return result.toArray(new Object[result.size()][]);
    }

    @DataProvider
    public Object[][] dataProviderMultipleWords() {
        List<Object[]> result = Lists.newArrayList();
        result.addAll(Arrays.asList(ErrorsInMultipleLangs()));
        result.addAll(Arrays.asList(FullText()));

        return result.toArray(new Object[result.size()][]);
    }


}
