package utils.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Driver class.
 */
public class Driver {

    private final WebDriver driver;

    /**
     * Constructor method for driver.
     */
    public Driver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    /**
     * Get driver.
     *
     * @return : WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }
}