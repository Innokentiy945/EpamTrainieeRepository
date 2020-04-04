package hw3.Ex2;

import hw3.BaseTest.CompositeBaseTest;
import hw3.Pages.HomePage;
import hw3.Pages.DifferentElementPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CompositeFunctionalTest2 extends CompositeBaseTest {

    @Test
    public void FunctionalTest2(){
        HomePage homePage = new HomePage(driver);
        DifferentElementPage differentElementPage = new DifferentElementPage(driver);
        BaseTest();

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
        assertTrue(differentElementPage.isCheckboxLogDisplayed(checkBoxOne, "true"));
        assertTrue(differentElementPage.isCheckboxLogDisplayed(checkBoxTwo, "true"));

        assertTrue(differentElementPage.isRadioLogDisplayed(radio));

        assertTrue(differentElementPage.isDropdownLogDisplayed(color));
    }
}

