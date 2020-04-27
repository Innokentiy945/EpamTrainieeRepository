package hw6.Steps;

import hw6.Pages.HomePage;
import hw6.utils.WebDriverSingleton;
import io.cucumber.java.en.Given;

public class GivenSteps {

    private HomePage homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());


    @Given("I open JDI GitHub site")
    public void homePageIsOpen() {
        WebDriverSingleton.INSTANCE.getDriver().get("https://jdi-testing.github.io/jdi-light/index.html");
        homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());
    }

    @Given("I login as user {string} password: {string}")
    public void addingLogInData(String username, String password) {
        homePage.logInOperation(username, password);
    }

    @Given("I go to DifferentElement Page")
    public void goToDifferentElementPage() {
        homePage.goToDifferentPage();
    }

    @Given("I click on Service button in Header")
    public void clickOnServicesMenu() {
        homePage.clickOnMenu();
    }

    @Given("I click on User Table button in Service dropdown")
    public void goToUserTablr() {
        homePage.goToUserTablePage();
    }






}
