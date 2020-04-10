package hw5.StepsPattern;

import hw5.Pages.DifferentElementPage;
import hw5.Pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;



public class DifferentElementPageSteps extends HomePageSteps{

    protected WebDriver driver;

    HomePage homePage = new HomePage(driver);
    DifferentElementPage differentElementPage = new DifferentElementPage(driver);



    public DifferentElementPageSteps(WebDriver driver) throws InterruptedException {
        super(driver);
    }



    @Step("Opening Different Elements Page")
    public void goToDifferentElementPAge() {
        homePage.goToDifferentPage();
    }


    @Step("Selecting checkboxes")
    public void selectingCheckboxes() {
        List<String> checkboxes = Arrays.asList("Water", "Wind", "Selen");
        differentElementPage.defineButtonElements(checkboxes);
    }


    @Step("Selecting in dropdown Yellow")
    public void selectingItemInDropdown() {
        String color = "Yellow";
        differentElementPage.defineColorDropDown(color);
    }


    @Step("Verifiy that log is displayed after selecting")
    public void verifyingIndividualLog() {
        List<String> logs = Arrays.asList("Wind", "Water", "Selen", "Yellow");
        differentElementPage.isElementInLogDisplayed(logs);
    }

}
