package runners;

import io.cucumber.java.*;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import utils.reporter.Reporter;
import utils.web.Driver;

@CucumberOptions(
        features = "src/test/java/tests/features",
        glue = {"tests.steps"})
public class TestRunner extends AbstractTestNGCucumberTests {
    /*
    @BeforeAll
    public void initialSetUp() {
        String url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
        Driver driver = new Driver();
        Reporter.info("Deleting cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info("Navigating to: " + url);
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
    }
    */
}