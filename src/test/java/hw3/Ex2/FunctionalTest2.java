package hw3.Ex2;

import hw3.BaseTest.TestBase;
import hw3.Pages.HomePage;
import hw3.Pages.DifferentElementPage;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;


public class FunctionalTest2 extends TestBase {

    @Test
    public void FunctionalTest2(){
        HomePage homePage = new HomePage(driver);
        DifferentElementPage differentElementPage = new DifferentElementPage(driver);
        standartOperations();

        //5.Open through the header menu Service -> Different Elements Page
        homePage.goToDifferentPage();

        //6. Select checkboxes "Water", "Wind" + 7. Select radio "Selen"
        List<String> checkboxes = Arrays.asList("Water", "Wind", "Selen");
        differentElementPage.defineButtonElements(checkboxes);


        //8.Select in dropdown "Yellow"
        String color = "Yellow";
        differentElementPage.defineColorDropDown(color);


        //9. Assert individual log
        List<String> logs = Arrays.asList("Wind", "Water", "Selen", "Yellow");
        differentElementPage.isElementInLogDisplayed(logs);

    }
}

