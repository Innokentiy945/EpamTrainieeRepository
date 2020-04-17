package hw6;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        strict = true,
        features = "src/test/resources/Features",
        glue = "hw6"
)
public class RunTest extends AbstractTestNGCucumberTests {

}
