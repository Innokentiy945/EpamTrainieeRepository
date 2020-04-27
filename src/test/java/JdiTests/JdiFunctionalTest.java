package JdiTests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.init.PageFactory;
import jdi.JdiSite;
import jdi.entity.MetalsColorsDataSet;
import jdi.entity.User;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;
import jdi.utils.JsonParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;

public class JdiFunctionalTest {




    @DataProvider
    public Iterator<Object[]> dataProvider() {
        try {
            List<MetalsColorsDataSet> testingdata = JsonParser.readData();
            Collection<Object[]> data = new ArrayList<>();
            if (testingdata != null) {
                testingdata.forEach(item -> data.add(new Object[]{item}));
            }
            return data.iterator();
        } catch (Exception e) {
            e.printStackTrace();
        }



        return null;
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initElements(JdiSite.class);
    }


    @Test(dataProvider = "dataProvider")
    public void jdiFuncTest(MetalsColorsDataSet data) {
        JdiSite.open();

        JdiSite.homePage.login(User.ROMAN);
        JdiSite.homePage.getUserName();

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
