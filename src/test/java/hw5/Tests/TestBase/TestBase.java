package hw5.Tests.TestBase;

import hw5.StepsPattern.HomePageSteps;
import hw5.TestData.PropertiesOpener;
import hw5.utils.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverSingleton.INSTANCE.createdDriver("chrome");
        driver = WebDriverSingleton.INSTANCE.getDriver();
        driver.manage().window().maximize();
    }


    public void standartOperations() throws InterruptedException {

        HomePageSteps homePageSteps = new HomePageSteps(driver);

        homePageSteps.openUrl();
        homePageSteps.checkTitle("HOME PAGE");
        homePageSteps.logInOperation(PropertiesOpener.read("user"), PropertiesOpener.read("password"));
        homePageSteps.assertUserName("ROMAN IOVLEV");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
