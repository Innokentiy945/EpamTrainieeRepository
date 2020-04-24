package JdiTests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.init.PageFactory;
import jdi.JdiSite;
import jdi.entity.MetalsColorsDataSet;
import org.testng.annotations.*;
import jdi.utils.JsonParser;

import java.util.*;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static jdi.entity.User.ROMAN;
import static org.testng.Assert.assertEquals;

public class JdiFunctionalTest {



    @DataProvider
    public Iterator<Object[]> dataProvider() {
        List<MetalsColorsDataSet> testingdata = JsonParser.readData();
        Collection<Object[]> data = new ArrayList<>();
        if (testingdata != null) {
            testingdata.forEach(item -> data.add(new Object[]{item}));
        }
        return data.iterator();
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initElements(JdiSite.class);
    }


    @Test(dataProvider = "dataProvider")
    public void jdiFuncTest(MetalsColorsDataSet data) {
        JdiSite.open();

        JdiSite.homePage.login(ROMAN);
        String actualUserName = JdiSite.homePage.getUserName();
        assertEquals(actualUserName, "ROMAN IOVLEV");

        JdiSite.homePage.setGoToMetalsColorsPage();
        JdiSite.metalsColorsPage.form.submit(data);
        JdiSite.metalsColorsPage.results.has().text(data.getExpectedResult());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        WebDriverFactory.getDriver().quit();
    }

    @AfterSuite
    public void afterSuite() {
        killAllSeleniumDrivers();
    }



}
