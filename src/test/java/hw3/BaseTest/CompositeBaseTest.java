package hw3.BaseTest;

import hw3.Pages.HomePage;
import hw3.TestData.PropertiesOpener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class CompositeBaseTest{

    protected WebDriver driver;
    protected String url = "https://jdi-testing.github.io/jdi-light/index.html";


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



    public void BaseTest() {
        HomePage homePage = new HomePage(driver);

        //1. Open url
        driver.get(url);

        //2. Check title
        driver.getTitle();

        //3.Login
        homePage.logInOperation(PropertiesOpener.read("user"), PropertiesOpener.read("password"));
        homePage.getNameOfUser();

        //4.Assert login
        homePage.isUserNameDisplayed();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
