package hw5.Tests.Ex1;


import hw5.StepsPattern.HomePageSteps;
import hw5.Tests.TestBase.TestBase;
import hw5.utils.AllureScreenshotListener;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;

@Listeners(AllureScreenshotListener.class)
public class FunctionalTest1 extends TestBase {

    protected HomePageSteps homePageSteps;

    @Story("Log in to site and checking web elements")

    @BeforeMethod
    public void init() {
        homePageSteps = new HomePageSteps(driver);
    }

    @Test
    public void functionalTest() throws InterruptedException {

        standartOperations();

        homePageSteps.verifyingHeaderMenuText(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
        homePageSteps.verifyingNumberOfItems(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
        homePageSteps.headerMenuIsDisplaeyd();
        homePageSteps.verifyingIframeExist();
        homePageSteps.verifyingIframeButton();
        homePageSteps.verifyingSwitchiToPrevousPage();
        homePageSteps.verifyingItemsInLeftMenu();
        homePageSteps.veryfyingNamesOfItems(Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs"));
        homePageSteps.verifyingNumbersOfItems(Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs"));
    }
}
