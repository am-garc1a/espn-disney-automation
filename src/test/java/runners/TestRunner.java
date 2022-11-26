package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/tests/features",
        glue = {"src/test/java/tests/steps"})
public class TestRunner extends AbstractTestNGCucumberTests {

}