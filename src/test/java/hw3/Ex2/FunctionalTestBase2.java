package hw3.Ex2;

import hw3.BaseTest.TestBase;
import hw3.Pages.HomePage;
import hw3.Pages.DifferentElementPage;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

public class FunctionalTestBase2 extends TestBase {

    @Test
    public void FunctionalTest2(){
        HomePage homePage = new HomePage(driver);
        DifferentElementPage differentElementPage = new DifferentElementPage(driver);
        StandartOperations();

        //5.Open through the header menu Service -> Different Elements Page
        homePage.goToDifferentPage();

        //6. Select checkboxes "Water", "Wind"
        String checkBoxOne = "Water";
        String checkBoxTwo = "Wind";

        differentElementPage.defineCheckBox(checkBoxOne);
        differentElementPage.defineCheckBox(checkBoxTwo);

        //7. Select radio "Selen"
        String radio = "Selen";
        differentElementPage.defineRadio(radio);

        //8.Select in dropdown "Yellow"
        String color = "Yellow";
        differentElementPage.defineColorDropDown(color);


        //9. Assert individual log
        //9.1 Assert checkbox log
        assertTrue(differentElementPage.isElementIsDisplayedInLog(checkBoxOne, "true"));
        assertTrue(differentElementPage.isElementIsDisplayedInLog(checkBoxTwo, "true"));

        //9.2 Assert radio button and color log
        assertTrue(differentElementPage.isRadioAndColorLogDisplayed(radio, color));

    }
}

