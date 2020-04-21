package hw4.Builder;

import hw4.Enums.*;
import java.util.Arrays;


public class DataGenerator {
    public static TestDataModel.Builder getDefaultTestDataBuilder() {
        return new TestDataModel.Builder()
                .setEven("2")
                .setOdd("1")
                .setColors(Colors.COLORS)
                .setVegetables(Arrays.asList(Vegetables.VEGETABLES))
                .setMetals(Metals.METALS)
                .setElements(Arrays.asList(Elements.DEFAULT));
    }
}


