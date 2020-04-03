package hw2.Ex1;

import hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;


public class FunctionalTest1 extends BaseTest {

    @Test
    public void exercise1Test(){
        SoftAssert softAssert = new SoftAssert();

        //1. Open test site by URL
        openTestUrl();
        System.out.println("Step passed: url opens");

        //2. Assert Browser title
        String currentTitle = driver.getTitle();
        softAssert.assertEquals(currentTitle, "Home Page");
        System.out.println("Step passed: browser title equals \"Home Page\"");


        //3. Perform login
        login("Roman", "Jdi1234");
        System.out.println("Step passed: login operation have been passed");


        //4. Assert Username is loggined
        softAssert.assertTrue(isUsernameDisplayed());
        softAssert.assertEquals(getUsername(), "ROMAN IOVLEV");
        System.out.println("Test passed: name is displayed and equals to expected result");


        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> actualElements = driver.findElements(By.cssSelector(".m-l8 > li"));
        List<String> expectedElements = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softAssert.assertEquals(actualElements,expectedElements);
        System.out.println("Step passed: menu buttons are displayed and have proper texts");



        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> actualImages = driver.findElements(By.className("benefit-icon"));
        actualImages.forEach(i -> softAssert.assertTrue(i.isDisplayed()));
        softAssert.assertEquals(actualImages.size(), 4);
        System.out.println("Step passed: images are displayed");


        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertEquals(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("benefit-txt")))
                .size(),4);
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("benefits"))).getText();
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
        softAssert.assertTrue(!driver.findElement(By.id("button-frame")).isDisplayed());
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

}

