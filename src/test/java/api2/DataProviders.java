package api2;

import api2.dto.EntityBuilder;
import org.testng.annotations.DataProvider;
import api2.utils.JsonParser;
import org.testng.collections.Lists;

import java.util.*;

public class DataProviders {

    public Object[][] pathsForData() {
        List<EntityBuilder> list = new ArrayList<>();
        list.addAll(JsonParser.readData("src/test/resources/TestData/EmptySpaceInWord.json"));
        list.addAll(JsonParser.readData("src/test/resources/TestData/Urls.json"));
        list.addAll(JsonParser.readData("src/test/resources/TestData/DigitsInWords"));
        list.addAll(JsonParser.readData("src/test/resources/TestData/DotsInWords.json"));
        list.addAll(JsonParser.readData("src/test/resources/TestData/DotsInWordWithError.json"));
        list.addAll(JsonParser.readData("src/test/resources/TestData/ErrorsInMultipleLangs.json"));
        list.addAll(JsonParser.readData("src/test/resources/TestData/FullText.json"));

        Collection<Object[]> data = new ArrayList<>();
        list.forEach(item -> data.add(new Object[]{item}));
        return data.toArray(new Object[0][]);
    }


    @DataProvider
    public Object[][] dataProviderSingleWord() {
        List<Object[]> result = Lists.newArrayList();
        result.addAll(Arrays.asList(pathsForData()));
        return result.toArray(new Object[result.size()][]);
    }

    @DataProvider
    public Object[][] dataProviderMultipleWords() {
        List<Object[]> result = Lists.newArrayList();
        result.addAll(Arrays.asList(pathsForData()));
        return result.toArray(new Object[result.size()][]);
    }
}
