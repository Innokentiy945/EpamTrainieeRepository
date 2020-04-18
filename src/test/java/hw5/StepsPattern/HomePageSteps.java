package hw5.StepsPattern;

import hw5.Pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

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


    @Step("Home page opening")
    public void openUrl() {
        driver.get(url);
    }

    @Step("Verify home page title")
    public void checkTitle(String homePageTitle) {
       driver.getTitle();
    }

    @Step("Log in to site with username: 'Roman' and password: 'Jdi1234' ")
    public void logInOperation(String user, String password) {
        homePage.logInOperation(user, password);
        homePage.getNameOfUser();

    }

    @Step("Verifying logged in user name")
    public void assertUserName(String expectedUserName) {
        String actualUserName = homePage.getNameOfUser();
        assertEquals(actualUserName, expectedUserName);
    }


    @Step("Verifying home page`s header menu text")
    public void verifyingHeaderMenuText(List<String> expectedHeaderMenuText) {
        List<String> actualTextOfHeaderMenuItems = homePage.getHeaderMenuElements();
        assertEquals(actualTextOfHeaderMenuItems, expectedHeaderMenuText);
    }



    @Step("Verifying number of items in header menu on Home Page")
    public void verifyingNumberOfItems(List<String> expectedHeaderMenuItems) {
        int actualNumberOfHeaderItems = homePage.countHeaderMenuItems();
        assertEquals(actualNumberOfHeaderItems, expectedHeaderMenuItems.size());
    }



    @Step("Verifying that header menu on Home Page is displayed")
    public void headerMenuIsDisplaeyd() {
        assertTrue(homePage.isHeaderItemsDisplayed());
    }

    @Step("Verifying the iframe with 'FrameButton' is exist")
    public void verifyingIframeExist() {
        assertTrue(homePage.isFrameDisplayed());
    }

    @Step("Verifying that there is 'FrameButton' in the iframe")
    public void verifyingIframeButton() {
        homePage.switchToFrame();
        assertTrue(homePage.isFrameDisplayed());
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
    public void veryfyingNamesOfItems(List<String> expectedNamesOfItemsInLeftMenu) {
        List<String>actualTextOfLeftMenu = homePage.leftSectionMenuText();
        assertEquals(actualTextOfLeftMenu, expectedNamesOfItemsInLeftMenu);
    }

    @Step("Verifying numbers of items in left menu")
    public void verifyingNumbersOfItems(List<String> expectedNumberOfItemsInLeftMenu) {
        int actualeNumberOfItemsInLeftMenu = homePage.counItemsInLefSectionMenu();
        assertEquals(actualeNumberOfItemsInLeftMenu, expectedNumberOfItemsInLeftMenu.size());
    }


    @Step("Incorrect number of items in left menu for failed test")
    public void incorrectNumberOfItems(List<String> incorrectNumberOfItemsForFailedTest) {
        int incorrectNumberOfItemsInLeftMenu = homePage.counItemsInLefSectionMenu();
        assertEquals(incorrectNumberOfItemsInLeftMenu, incorrectNumberOfItemsForFailedTest.size());
    }




}
