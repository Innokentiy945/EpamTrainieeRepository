package hw2.Ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

public class FunctionalTest2 {

    private WebDriver driver;
    private String url = "https://jdi-testing.github.io/jdi-light/index.html ";


    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @BeforeTest
    public void profileSetup() {
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void appSetup() {
        driver.get(url);
    }

    @Test
    public void FunctionalTest2() {
        SoftAssert softAssert = new SoftAssert();

        //1. Open test site by URL
        String currentUrl = driver.getCurrentUrl();
        softAssert.assertEquals(currentUrl, url);
        System.out.println("Step passed: test site is opened");


        //2. Assert Browser title
        String currentTitle = driver.getTitle();
        softAssert.assertEquals(currentTitle, "Home Page");
        System.out.println("Step passed: browser title equals \"Home Page\"");


        //3. Perform login
        driver.findElement(By.xpath("/html/body/header/div/nav/ul[2]")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        boolean actualLogIn = driver.findElement(By.xpath("/html/body/header/div/nav/ul[2]/li/div/div/button")).isEnabled();
        softAssert.assertTrue(actualLogIn);
        System.out.println("Step passed: user is logged");


        //4. Assert Username is loggined
        WebElement actualUserName = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        String expectedUserName = "Roman Iovlev";
        softAssert.assertEquals(actualUserName,expectedUserName);
        System.out.println("Step passed: name is displayed and equals to expected result");


        //5.Open through the header menu Service -> Different Elements Page
        driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[3]/ul/li[8]/a/span")).click();
        String actualPage = driver.getTitle();
        String expectedPage = "https://jdi-testing.github.io/jdi-light/different-elements.html";
        softAssert.assertEquals(actualPage,expectedPage);
        System.out.println("Step passed: page is opened");


        //6.Select checkboxes
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[3]/input")).click();
        boolean actualCheckBox1 = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[1]/input")).isSelected();
        boolean actualCheckBox2 = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[3]/input")).isSelected();
        softAssert.assertTrue(actualCheckBox1);
        softAssert.assertTrue(actualCheckBox2);
        System.out.println("Step passed: elements are checked");


        //7.Select radio
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[3]/label[1]/input")).click();
        boolean actualRadioButton = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[3]/label[1]/input")).isSelected();
        softAssert.assertTrue(actualRadioButton);
        System.out.println("Step passed: element is checked");


        //8.Select in dropdown
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select")).click();
        boolean actualDropDown = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select")).isSelected();
        softAssert.assertTrue(actualDropDown);
        System.out.println("Step passed: element is selected");


        //9.Assert individual logging after selecting items
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[3]/label[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]")).click();

        boolean actualLogging = driver.findElement(By.xpath("//*[@id=\"mCSB_2_container\"]/section[1]/div[2]")).isDisplayed();
        softAssert.assertTrue(actualLogging);
        System.out.println("Step passed: log for all elements exist");
    }

    //10. Close browser
    @AfterClass
    public void tearDown() {
        if(driver!=null)
            driver.quit();
    }
}
