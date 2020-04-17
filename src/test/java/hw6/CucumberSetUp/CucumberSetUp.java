package hw6.CucumberSetUp;

import hw6.utils.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CucumberSetUp {


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverSingleton.INSTANCE.setDriver("chrome");
        WebDriverSingleton.INSTANCE.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.INSTANCE.getDriver().quit();
    }

}
