package hw5.Tests.Ex1;


import hw5.Pages.HomePage;
import hw5.StepsPattern.HomePageSteps;
import hw5.Tests.TestBase.TestBase;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FunctionalTest1 extends TestBase {

    protected WebDriver driver;
    protected HomePageSteps homePageSteps;

    @Story("Log in to site and checking web elements")


    @Test
    public void functionalTest() throws InterruptedException {

        standartOperations();
        homePageSteps.verifyingHeaderMenuText();
        homePageSteps.verifyingNumberOfItems();
        homePageSteps.headerMenuIsDisplaeyd();
        homePageSteps.verifyingIframeExist();
        homePageSteps.verifyingIframeButton();
        homePageSteps.verifyingSwitchiToPrevousPage();
        homePageSteps.verifyingItemsInLeftMenu();
        homePageSteps.veryfyingNamesOfItems();
        homePageSteps.verifyingNumbersOfItems();

    }
}
