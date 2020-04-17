package hw6.Steps;

import hw6.Pages.DifferentElementPage;
import hw6.Pages.HomePage;
import hw6.Pages.UserTablePage;
import hw6.utils.WebDriverSingleton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;

public class WhenSteps {

    private DifferentElementPage differentElementPage = new DifferentElementPage(WebDriverSingleton.INSTANCE.getDriver());
    private HomePage homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());
    private UserTablePage userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());


    @When("Select checkboxes 'Water', 'Wind'")
    public void selectingCheckboxes(List<String> checkboxes) {
        differentElementPage.defineButtonElements(checkboxes);
    }

    @When("Select dropdown 'Yellow'")
    public void selectingRadioButton(String color) {
        differentElementPage = new DifferentElementPage(WebDriverSingleton.INSTANCE.getDriver());
        differentElementPage.defineColorDropDown(color);
    }


    @Given("I click on 'Service' button in Header")
    public void clickOnServicesMenu() {
        homePage.clickOnMenu();
    }

    @Given("I click on 'User Table' button in Service dropdown")
    public void goToUserTablr() {
        homePage.goToUserTablePage();
    }



    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void selectCheckBoxSergeyIvanov() {
        userTablePage.clickOnVipCheckbox();
    }
}
