package hw3.Ex1;

import hw3.BaseTest.TestBase;
import hw3.Pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class FunctionalTestBase1 extends TestBase {



    @Test
    public void functionalTest() {

        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);


        StandartOperations();

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts

        List<String> actualTextOfHeaderMenuItems = homePage.getHeaderMenuElements();
        List<String> expectedTextOfHeaderMenuItems = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        int actualNumberOfHeaderItems = homePage.countHeaderMenuItems();
        assertEquals(actualNumberOfHeaderItems, expectedTextOfHeaderMenuItems.size());
        softAssert.assertEquals(actualTextOfHeaderMenuItems, expectedTextOfHeaderMenuItems);

        boolean actualItemsInHeader = homePage.isHeaderItemsDisplayed();
        softAssert.assertTrue(actualItemsInHeader);


        //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(homePage.countBenefitImages(), 4);
        boolean actualImages = homePage.isBenefitsDisplayed();
        softAssert.assertTrue(actualImages);


        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        int actualSizeTxtBenefits = homePage.countTxtBenefit();
        int expectedSizeTxtBenefits = 4;
        softAssert.assertEquals(actualSizeTxtBenefits, expectedSizeTxtBenefits);


        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(homePage.isFrameDisplayed());


        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.switchToFrame();
        softAssert.assertTrue(homePage.isFrameButtonDisplayed());


        //10. Switch to original window back
        homePage.switchToPreviousPage();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssert.assertTrue(homePage.leftCestionMenuisDisplayed());

        List<String>actualTextOfLeftMenu = homePage.leftSectionMenuText();
        List<String> expectedTextOfLeftMenu = Arrays.asList(
                "Home", "Contact form", "Service", "Metals & Colors", "Elements packs"
        );
        softAssert.assertEquals(actualTextOfLeftMenu, expectedTextOfLeftMenu);

        int actualCountOfLeftSideMenu = homePage.countHeaderMenuItems();
        assertEquals(actualCountOfLeftSideMenu, expectedTextOfLeftMenu.size());


    }

}
