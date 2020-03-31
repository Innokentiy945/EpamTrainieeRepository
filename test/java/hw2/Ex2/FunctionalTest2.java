package hw2.Ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class FunctionalTest2 {

    private WebDriver driver;
    private String url = "https://jdi-testing.github.io/jdi-light/index.html ";


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void FunctionalTest2() {

        //1. Open test site by URL
        driver.get(url);
        System.out.println("Step passed: test site is opened");


        //2. Assert Browser title
        String currentTitle = driver.getTitle();
        assertEquals(currentTitle, "Home Page");
        System.out.println("Step passed: browser title equals \"Home Page\"");


        //3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
        boolean actualLogIn = driver.findElement(By.className("logout")).isDisplayed();
        assertTrue(actualLogIn);
        System.out.println("Step passed: user is logged");


        //4. Assert Username is loggined

        WebElement actualUserName = driver.findElement(By.id("user-name"));
        assertTrue(actualUserName.isDisplayed());
        System.out.println("Step passed: name is displayed and equals to expected result");




        //5.Open through the header menu Service -> Different Elements Page
        driver.findElement(By.linkText("Service")).click();
        driver.findElement(By.linkText("Different elements")).click();
        String actualPage = driver.getTitle();
        String expectedPage = "Different Elements";
        assertEquals(actualPage, expectedPage);
        System.out.println("Step passed: page is opened");


        //6.Select checkboxes
        driver.findElement(By.xpath("//label[normalize-space() = 'Wind']")).click();
        driver.findElement(By.xpath("//label[normalize-space() = 'Water']")).click();
        boolean actualCheckBox1 = driver.findElement(By.xpath("//label[normalize-space() = 'Wind']")).isSelected();
        boolean actualCheckBox2 = driver.findElement(By.xpath("//label[normalize-space() = 'Water']")).isSelected();
        assertFalse(actualCheckBox1);
        assertFalse(actualCheckBox2);
        System.out.println("Step passed: elements are checked");


        //7.Select radio
        driver.findElement(By.xpath("//label[normalize-space() = 'Selen']")).click();
        boolean actualRadioButton = driver.findElement(By.xpath("//label[normalize-space() = 'Selen']")).isSelected();
        assertFalse(actualRadioButton);
        System.out.println("Step passed: element is checked");


        //8.Select in dropdown
        driver.findElement(By.className("colors")).click();
        WebElement actualDropDown = driver.findElement(By.cssSelector(".colors select"));
        new Select(actualDropDown).selectByVisibleText("Yellow");
        assertTrue(actualDropDown.isDisplayed());
        System.out.println("Step passed: element is selected");


        //9.Assert that
        //for each checkbox,radiobutton, dropbox there are an individual log row and value is corresponded to the status of checkbox
        WebElement waterLog = driver.findElement(By.xpath("//li[contains(text(),'Water: condition changed to true')]"));
        assertTrue(waterLog.isDisplayed());

        WebElement windLog = driver.findElement(By.xpath("//li[contains(text(),'Wind: condition changed to true')]"));
        assertTrue(windLog.isDisplayed());

        WebElement selenLog = driver.findElement(By.xpath("//li[contains(text(),'metal: value changed to  Selen')]"));
        assertTrue(selenLog.isDisplayed());

        WebElement dropDownLog = driver.findElement(By.xpath("//li[contains(text(),'Colors: value changed to Yellow')]"));
        assertTrue(dropDownLog.isDisplayed());

        System.out.println("Step passed: log for all elements exist");
    }

    //10. Close browser
    @AfterClass
    public void tearDown() {
        if(driver!=null)
            driver.quit();
    }
}
