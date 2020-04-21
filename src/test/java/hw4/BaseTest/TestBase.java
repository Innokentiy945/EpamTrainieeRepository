package hw4.BaseTest;


import hw4.Pages.HomePage;
import hw4.utils.DataOpener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected String url = "https://jdi-testing.github.io/jdi-light/index.html";


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



    public void baseTest() {
        HomePage homePage = new HomePage(driver);

        //1. Open url
        driver.get(url);

        //2. Check title
        driver.getTitle();

        //3.Login
        homePage.logInOperation(DataOpener.read("user"), DataOpener.read("password"));
        homePage.getNameOfUser();

        //4.Assert login
        homePage.isUserNameDisplayed();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

