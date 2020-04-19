package hw5.StepsPattern;

import hw5.Pages.DifferentElementPage;
import hw5.Pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;


public class DifferentElementPageSteps{


    protected WebDriver driver;
    protected HomePage homePage;
    protected DifferentElementPage differentElementPage;



    public DifferentElementPageSteps(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        differentElementPage = new DifferentElementPage(driver);
    }


    @Step("Opening Different Elements Page")
    public void goToDifferentElementPage() {
        homePage.goToDifferentPage();
    }


    @Step("Selecting checkboxes")
    public void selectingCheckbox(String checkboxName) {
        differentElementPage.setCheckBox(checkboxName);
    }

    @Step("Selecting radiobutton")
    public void selectingRadio(String radioName) {
        differentElementPage.setRadio(radioName);
    }

    @Step("Selecting in dropdown Yellow")
    public void selectingColorDropdownTo(String color) {
        differentElementPage.setColorDropDown(color);
    }


    @Step("Verify that log for checkboxes displayed after press checkboxes")
    public void individualLogRowForCheckboxIsDisplayed(String checkBox, String status) {
        assertTrue(differentElementPage.isCheckboxLogDisplayed(checkBox, status));
    }

    @Step("Verify that log for radio button displayed after press radio buttons")
    public void individualLogRowForRadioButtonIsDisplayed(String radio) {
        assertTrue(differentElementPage.isRadioLogDisplayed(radio));
    }

    @Step("Verify that log for dropdown menu displayed after press dropdown menu")
    public void individualLogRowForDropdownIsDisplayed(String dropdownValue) {
        assertTrue(differentElementPage.isDropdownLogDisplayed(dropdownValue));
    }


}
