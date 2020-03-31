package hw2.Ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FunctionalTest1 {
    private WebDriver driver;
    private String url = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void exercise1Test(){
        SoftAssert softAssert = new SoftAssert();

        //1. Open test site by URL
        driver.get(url);
        System.out.println("Step passed: test site is opened");


        //2. Assert Browser title
        String currentTitle = driver.getTitle();
        softAssert.assertEquals(currentTitle, "Home Page");
        System.out.println("Step passed: browser title equals \"Home Page\"");


        //3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
        boolean actualLogIn = driver.findElement(By.className("logout")).isDisplayed();
        softAssert.assertTrue(actualLogIn);
        System.out.println("Step passed: user is logged");


        //4. Assert Username is loggined
        WebElement actualUserName = driver.findElement(By.id("user-name"));
        String expectedUserName = "Roman Iovlev";
        softAssert.assertEquals(actualUserName,expectedUserName);
        System.out.println("Test passed: name is displayed and equals to expected result");


        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> actualElements = driver.findElements(By.cssSelector(".m-l8 > li"));
        List<String> expectedElements = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softAssert.assertEquals(actualElements,expectedElements);
        System.out.println("Step passed: menu buttons are displayed and have proper texts");


        //6. Assert that there are 4 images on the Index Page and they are displayed
        WebElement actualImage = driver.findElement(By.className("benefit-icon"));
        boolean expectedImage = actualImage.isDisplayed();
        softAssert.assertEquals(actualImage,expectedImage);
        System.out.println("Step passed: images are displayed");


        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> actualText = driver.findElements(By.className("benefit-txt"));
        List<String> expectedText = Arrays.asList(
                "To include good practices and ideas from successful EPAM project",
                "To be flexible and customizable",
                "To be multiplatform",
                "Already have good base (about 20 internal and some external projects), wish to get more…"
        );
        softAssert.assertEquals(actualText,expectedText);
        System.out.println("Step passed: texts are displayed and equal to expected");


        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(driver.findElement(By.id("frame")).isDisplayed());
        System.out.println("Step passed: the iframe exists");


        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        softAssert.assertTrue(driver.findElement(By.id("button-frame")).isDisplayed());
        System.out.println("Step passed: the “Frame Button” exists");


        //10. Switch to original window back
        driver.switchTo().defaultContent();
        System.out.println("Step passed: driver has focus on the original page");


        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> actualItems = driver.findElements(By.className("sidebar-menu"));
        List<String> expectedItems = Arrays.asList(
                "Home", "Contact form", "Service", "Metals & Colors", "Elements packs"
        );
        softAssert.assertEquals(actualItems,expectedItems);
        System.out.println("Step passed: left section menu items are displayed and have proper text");

    }

    //12. Close browser
    @AfterClass
    public void tearDown() {
        if(driver!=null)
            driver.quit();
    }
}
