package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class  BaseTest {

    protected WebDriver driver;

    protected final static String url = "https://jdi-testing.github.io/jdi-light/index.html";

    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
    }

    public boolean isUsernameDisplayed(){
        return getUsernameWebElement().isDisplayed();
    }

    public String getUsername(){
        return getUsernameWebElement().getText();
    }

    private WebElement getUsernameWebElement(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
    }


    public void openTestUrl(){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void login(String user, String pass){
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
