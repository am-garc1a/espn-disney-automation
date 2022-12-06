package tests.steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import org.testng.Assert;
import pom.web.LoginPopUp;
import pom.web.MainNavBar;
import pom.web.SignUpPopUp;
import pom.web.UserOptions;
import utils.reporter.Reporter;

public class EspnSteps {
    private MainNavBar mainNavBar;
    private UserOptions userOptions;
    private LoginPopUp loginPopUp;
    private SignUpPopUp signUpPopUp;
    private static String EMAIL = "test-email-0-@gmail.com";

    public void setNewEmail() {
        int randomValue = (int) (Math.random() * 2000);
        EMAIL = "test-email-" + randomValue + "-@gmail.com";
    }

    @Given("Browser has home ESPN page open")
    public void browserHasHomeESPNPageOpen() {
        this.mainNavBar = new MainNavBar(WebHooks.getDriver());
    }

    @Given("User is successful sign up and is logged in {string} {string} {string}")
    public void userIsSuccessfulSignUpAndIsLoggedIn(String name, String lastname, String password) {
        userOptions = mainNavBar.goToUserOptions();
        loginPopUp = userOptions.clickLoginButton();

        Reporter.info("Validate login components are displayed");
        Assert.assertTrue(loginPopUp.areLoginFormElementsDisplayed(), "Login component is not displayed");

        signUpPopUp = loginPopUp.clickSingUpButton();
        Reporter.info("Validate sign up components are displayed");
        Assert.assertTrue(signUpPopUp.areSignUpFormElementsDisplayed(), "SignUp component is not displayed");

        setNewEmail();
        signUpPopUp.fillSingUpInputs(name, lastname, EMAIL, password);
        signUpPopUp.clickConfirmSingUpButton();
        Reporter.info("Email of new user: " + EMAIL);
    }

    @When("User goes to the watch page")
    public void userGoesToTheWatchPage() {
        System.out.println("userGoesToTheWatchPage");
    }

    @Then("The watch page elements should be displayed")
    public void theWatchPageElementsShouldBeDisplayed() {
        System.out.println("theWatchPageElementsShouldBeDisplayed");
    }

    @And("User should be able to return to home page")
    public void userShouldBeAbleToReturnToHomePage() {
        System.out.println("userShouldBeAbleToReturnToHomePage");
    }

    @And("User can logout from ESPN session")
    public void userCanLogoutFromESPNSession() {
        System.out.println("userCanLogoutFromESPNSession");
    }
}
