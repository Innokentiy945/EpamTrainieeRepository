package PageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BaseTest {

    protected WebDriver driver;
    protected String url = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.get(url);
    }

    @Test
    public void loginTest() {
        EntryPage ep = PageFactory
                .initElements(driver, EntryPage.class);
        ep.logInOperation("Roman", "Jdi1234");
        assertTrue(ep.LogInAssertation());
    }





    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
