package hw6.Steps;

import hw6.Pages.DifferentElementPage;
import hw6.Pages.HomePage;
import hw6.Pages.UserTablePage;
import hw6.utils.WebDriverSingleton;
import io.cucumber.java.en.When;

import java.util.List;

public class WhenSteps {

    private DifferentElementPage differentElementPage = new DifferentElementPage(WebDriverSingleton.INSTANCE.getDriver());
    private UserTablePage userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
    private HomePage homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());


    @When("Select checkboxes")
    public void selectingCheckboxes(List<String> checkboxes) {
        differentElementPage.defineButtonElements(checkboxes);
    }

    @When("Select radiobutton {string}")
    public void selectingRadioButton(String radio) {
        differentElementPage.defineRadioElements(radio);
    }

    @When("Select dropdown {string}")
    public void selectingDropDowncolor(String color) {
        differentElementPage = new DifferentElementPage(WebDriverSingleton.INSTANCE.getDriver());
        differentElementPage.defineColorDropDown(color);
    }

    @When("I click on 'Service' button in Header")
    public void clickOnServicesMenu() {
        homePage.clickOnMenu();
    }

    @When("I click on 'User Table' button in Service dropdown")
    public void goToUserTable() {
        homePage.goToUserTablePage();
    }


    @When("I select vip checkbox for Sergey Ivan")
    public void selectCheckBoxSergeyIvanov() {
        userTablePage.clickOnVipCheckbox();
    }



}
