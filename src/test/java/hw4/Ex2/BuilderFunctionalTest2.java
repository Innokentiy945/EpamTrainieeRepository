package hw4.Ex2;

import hw4.BaseTest.TestBase;
import hw4.Builder.*;
import hw4.Enums.Colors;
import hw4.Enums.Elements;
import hw4.Enums.Metals;
import hw4.Enums.Vegetables;
import hw4.utils.Summary;
import hw4.Pages.*;
import hw4.utils.DataOpener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BuilderFunctionalTest2 extends TestBase {

    private HomePage homePage;
    private MetalsColorsPage metalsColorsPage;
    private User user;

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {DataGenerator.getDefaultTestDataBuilder().setElements(Arrays.asList(Elements.EARTH)).setColors(Colors.YELLOW).setMetals(Metals.GOLD).build()},
                {DataGenerator.getDefaultTestDataBuilder().setOdd("3").setEven("8").setVegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO)).build()},
                {DataGenerator.getDefaultTestDataBuilder().setOdd("3").setEven("2").setElements(Arrays.asList(Elements.WATER, Elements.WIND, Elements.FIRE)).setMetals(Metals.BRONZE).setVegetables(Arrays.asList(Vegetables.ONION)).build()},
                {DataGenerator.getDefaultTestDataBuilder().setOdd("5").setEven("6").setElements(Arrays.asList(Elements.WATER)).setColors(Colors.GREEN).setMetals(Metals.SELEN).setVegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO, Vegetables.VEGETABLES, Vegetables.ONION)).build()},
                {DataGenerator.getDefaultTestDataBuilder().setElements(Arrays.asList(Elements.FIRE)).setColors(Colors.BLUE).setVegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO, Vegetables.VEGETABLES)).build()}
        };
    }

    @BeforeMethod
    public void initData() {
        homePage = new HomePage(driver);
        metalsColorsPage = new MetalsColorsPage(driver);
        user = User
                .builder()
                .setPassword(DataOpener.read("password"))
                .setUsername(DataOpener.read("user"))
                .build();
    }

    @Test(dataProvider = "dataProvider")
    public void metalsColorsPageFuncTest(TestDataModel builder) {

        baseTest();

        //4. Add data on the page
        homePage.goToMetalColorPage();
        metalsColorsPage.addingData(builder);
        metalsColorsPage.submitForm();

        //5. Check Results block output on the right-side
        if (!builder.getColors().equalsIgnoreCase(Colors.COLORS.toString())) {
            assertThat(metalsColorsPage.getColorResult()).isEqualToIgnoringCase(builder.getColors());
        }
        else if (!builder.getMetals().equalsIgnoreCase(Metals.METALS.toString())) {
            assertThat(metalsColorsPage.getMetalResult()).isEqualToIgnoringCase(builder.getMetals());
        }
        else if (!builder.getElementsAsString().equalsIgnoreCase(Elements.DEFAULT.toString())) {
            assertThat(metalsColorsPage.getElementsResult()).isEqualToIgnoringCase(builder.getElementsAsString());
        }
        else if (!builder.getVegetablesAsString().equalsIgnoreCase(Vegetables.VEGETABLES.toString())) {
            assertThat(metalsColorsPage.getVegetableResult()).isEqualToIgnoringCase(builder.getVegetablesAsString());
        }
        else if (!builder.getEven().equals("2") | !builder.getOdd().equals("1")) {
            String expectedSum = Summary.summ(builder.getEven(), builder.getOdd());
            assertThat(metalsColorsPage.getSumResult()).isEqualTo(expectedSum);
        }


    }
}