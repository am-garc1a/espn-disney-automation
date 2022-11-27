package pom.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.web.BasePage;

/**
 * MainNavBar component class.
 */
public class MainNavBar extends BasePage {
    @FindBy(css = ".container h1")
    private WebElement espnLogo;

    @FindBy(css = ".pillar.watch")
    private WebElement watchLink;

    @FindBy(id = "global-user-trigger")
    private WebElement userButton;

    /**
     * Constructor method for MainNavBar.
     *
     * @param driver : WebDriver
     */
    public MainNavBar(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigate to users options.
     *
     * @return : UserOptions
     */
    public UserOptions goToUserOptions() {
        isElementDisplayed(espnLogo, 3);
        isElementDisplayed(watchLink, 3);
        clickElement(userButton, 3);
        return new UserOptions(super.getDriver());
    }

}