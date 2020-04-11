package hw5.Tests.Ex2;


import hw5.StepsPattern.HomePageSteps;
import hw5.Tests.TestBase.TestBase;
import hw5.utils.AllureScreenshotListener;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(AllureScreenshotListener.class)
public class FunctionalTest1Failed extends TestBase {

    protected HomePageSteps homePageSteps;

    @Story("Log in to site and checking web elements")

    @BeforeMethod
    public void init() throws InterruptedException {
        homePageSteps = new HomePageSteps(driver);
    }


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
        homePageSteps.incorrectNumberOfItems();

    }
}
