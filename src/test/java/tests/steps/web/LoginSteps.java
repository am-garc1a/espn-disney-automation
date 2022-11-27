package tests.steps.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.testng.Assert;
import pom.web.LoginPopUp;
import pom.web.MainNavBar;
import pom.web.UserOptions;
import utils.reporter.Reporter;
import utils.web.Driver;

public class LoginSteps {
    private Driver driver;
    private MainNavBar mainNavBar;
    private UserOptions userOptions;
    private LoginPopUp loginPopUp;

    @Before
    public void initialSetUp() {
        String url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
        this.driver = new Driver();
        Reporter.info("Deleting cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info("Navigating to: " + url);
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
        this.mainNavBar = new MainNavBar(driver.getDriver());
    }

    @Given("navigation to login page")
    public void navigationToLoginPage() {
        Reporter.info("Click on user button");
        this.userOptions = mainNavBar.goToUserOptions();

        Reporter.info("Validate user is disconnected");
        Assert.assertTrue(userOptions.isUserDisconnected(), "User is not disconnected");

        Reporter.info("Click on login button");
        this.loginPopUp = userOptions.clickLoginButton();

        Reporter.info("Validate Login form is displayed");
        Assert.assertTrue(loginPopUp.areLoginFormElementsDisplayed(), "Login form is not displayed");
    }

    @When("enter valid credentials {string} {string}")
    public void enterValidCredentials(String email, String password) {
        Reporter.info("Enter credentials and click on confirm login button");
        loginPopUp.clickConfirmLoginButton(email, password);
    }

    @Then("should be taken to main page")
    public void shouldBeTakenToMainPage() {
        userOptions = mainNavBar.goToUserOptions();
        Reporter.info("Validate user is successfully connected");
        Assert.assertEquals(userOptions.getUsernameLogged(), "Ana!", "Login failed");
    }

    @After
    public void tearDown() {
        Reporter.info("Quitting driver");
        //driver.getDriver().quit();
    }

}
