package tests.steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import utils.reporter.Reporter;
import pom.web.*;

public class EspnSteps {
    private MainNavBar mainNavBar;
    private UserOptions userOptions;
    private LoginPopUp loginPopUp;
    private SignUpPopUp signUpPopUp;
    private WatchPage watchPage;
    private static String EMAIL = "test-email-0-@gmail.com";

    public void setNewEmail() {
        int randomValue = (int) (Math.random() * 2000);
        EMAIL = "test-email-" + randomValue + "-@gmail.com";
    }

    @Given("Browser is open on ESPN page")
    public void browserIsOpenOnESPNPage() {
        this.mainNavBar = new MainNavBar(WebHooks.getDriver());
    }

    @When("User is successful signed up and is logged in {string} {string} {string}")
    public void userIsSuccessfulSignedUpAndIsLoggedIn(String name, String lastname, String password) {
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

    @Then("User goes to watch page and its elements must be displayed")
    public void userGoesToWatchPageAndItsElementsMustBeDisplayed() {
        Reporter.info("Navigating to: watch page");
        watchPage = mainNavBar.goToWatchPage();

        Reporter.info("Validate watch page components are displayed");
        Assert.assertTrue(watchPage.areWatchPageElementsDisplayed(), "Watch page is not displayed");

        Reporter.info("Validate title is present in each carousel card");
        Assert.assertTrue(watchPage.isCarouselCardsTitleDisplayed(), "Title cards are not displayed");

        watchPage.clickCarouselCard(1);
        Reporter.info("Validate choose supplier frame is present");
        Assert.assertTrue(watchPage.isExitFromChooseSupplierBtnDisplayed(), "Choose supplier frame is not displayed");
        watchPage.clickExitFromChooseSupplier();
    }

    @And("User should be able to return to home page {string}")
    public void userShouldBeAbleToReturnToHomePage(String name) {
        Reporter.info("Navigating to: home page");
        watchPage.goToPreviousPage();

        userOptions = mainNavBar.goToUserOptions();
        Reporter.info("Validate user still connected");
        Assert.assertEquals(userOptions.getUsernameLogged(), (name + "!"), "User is not connected");
    }

    @And("User can logout from ESPN session")
    public void userCanLogoutFromESPNSession() {
        Reporter.info("Logout action");
        userOptions.clickLogoutButton();
        userOptions.reloadPage();

        userOptions = mainNavBar.goToUserOptions();
        Reporter.info("Validate user is disconnected");
        Assert.assertTrue(userOptions.isUserDisconnected(), "User still connected");
    }
}
