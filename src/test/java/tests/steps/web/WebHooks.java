package tests.steps.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.reporter.Reporter;
import utils.web.Driver;

/**
 * WebHooks class
 */
public class WebHooks {
    private static Driver driver;

    /**
     * Before Hook for make initial set up
     */
    @Before
    public void initialSetUp() {
        String url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
        driver = new Driver();
        Reporter.info("Deleting cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info("Navigating to: " + url);
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
    }

    /**
     * After Hook for tear down web-driver.
     */
    @After
    public void tearDown() {
        Reporter.info("Quitting driver");
        driver.getDriver().quit();
    }

    /**
     * Gets the current driver.
     *
     * @return : WebDriver instance
     */
    public static WebDriver getDriver() {
        return driver.getDriver();
    }
}
