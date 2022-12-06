package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/tests/features",
        glue = {"tests.steps"},
        tags = "@EspnNavigation")
public class WebTestRunner extends AbstractTestNGCucumberTests {
}