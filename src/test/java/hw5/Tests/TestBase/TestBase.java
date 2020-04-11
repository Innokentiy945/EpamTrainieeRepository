package hw5.Tests.TestBase;

import hw5.StepsPattern.HomePageSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    public void standartOperations() throws InterruptedException {

        HomePageSteps homePageSteps = new HomePageSteps(driver);

        homePageSteps.openUrl();
        homePageSteps.checkTitle();
        homePageSteps.logInOperation();
        homePageSteps.assertUserName();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
