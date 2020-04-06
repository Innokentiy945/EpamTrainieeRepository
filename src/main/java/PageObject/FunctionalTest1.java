package PageObject;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FunctionalTest1 extends BaseTest {

    @Test
    public String checkUserName() {
        SoftAssert softAssert = new SoftAssert();
        EntryPage ep = PageFactory
                .initElements(driver, EntryPage.class);

        ep.checkingUserName("Roman");
        softAssert.assertEquals("Roman", ep.checkingUserName("Roman"));
        return checkUserName();
    }
}
