package hw5.StepsPattern;

import hw5.Pages.HomePage;
import hw5.TestData.PropertiesOpener;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSteps {

    protected String url = "https://jdi-testing.github.io/jdi-light/index.html";
    protected WebDriver driver;
    protected HomePage homePage;


    public HomePageSteps(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        homePage = new HomePage(driver);
    }


    @Step("Test site opening")
    public void openUrl() {
        driver.get(url);
    }

    @Step("Verify site`s title")
    public void checkTitle() {
       String actualTitle = driver.getTitle();
       String expectedTitle = "Home Page";
       assertEquals(actualTitle, expectedTitle);
    }

    @Step("User login on site")
    public void logInOperation() {
        homePage.logInOperation(PropertiesOpener.read("user"), PropertiesOpener.read("password"));
        homePage.getNameOfUser();

    }

    @Step("Verifying user name")
    public void assertUserName() {
        homePage.isUserNameDisplayed();
    }

    @Step("Verifying header menu text")
    public void verifyingHeaderMenuText() {
        List<String> actualTextOfHeaderMenuItems = homePage.getHeaderMenuElements();
        List<String> expectedTextOfHeaderMenuItems = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        assertEquals(actualTextOfHeaderMenuItems, expectedTextOfHeaderMenuItems);
    }

    @Step("Verifying number of items in header menu")
    public void verifyingNumberOfItems() {
        int actualNumberOfHeaderItems = homePage.countHeaderMenuItems();
        List<String> expectedTextOfHeaderMenuItems = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        assertEquals(actualNumberOfHeaderItems, expectedTextOfHeaderMenuItems.size());
    }

    @Step("Verifying that header menu is displayed")
    public void headerMenuIsDisplaeyd() {
        assertTrue(homePage.isHeaderItemsDisplayed());
    }

    @Step("Verifying the iframe with “Frame Button” exist")
    public void verifyingIframeExist() {
        assertTrue(homePage.isFrameDisplayed());
    }

    @Step("Verifying that there is “Frame Button” in the iframe")
    public void verifyingIframeButton() {
        homePage.switchToFrame();
        assertTrue(homePage.isFrameButtonDisplayed());
    }

    @Step("Verifying that switching to previous page is possible")
    public void verifyingSwitchiToPrevousPage() {
        homePage.switchToPreviousPage();
    }

    @Step("Verifying that 5 items in the Left Section are displayed")
    public void verifyingItemsInLeftMenu() {
        assertTrue(homePage.leftCestionMenuisDisplayed());
    }

    @Step("Verifying names of items in left menu")
    public void veryfyingNamesOfItems() {
        List<String>actualTextOfLeftMenu = homePage.leftSectionMenuText();
        List<String> expectedTextOfLeftMenu = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        assertEquals(actualTextOfLeftMenu, expectedTextOfLeftMenu);
    }

    @Step("Verifying numbers of items in left menu")
    public void verifyingNumbersOfItems() {
        int actualCountOfLeftSideMenu = 5;
        List<String> expectedTextOfLeftMenu = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        assertEquals(actualCountOfLeftSideMenu, expectedTextOfLeftMenu.size());
    }






}
