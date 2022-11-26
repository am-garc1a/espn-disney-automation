package tests.steps.web;

import io.cucumber.java.en.*;

import utils.reporter.Reporter;

public class LoginSteps {
    @Given("navigation to login page")
    public void navigationToLoginPage() {
        Reporter.info("one");
    }

    @When("enter valid credentials {string} {string}")
    public void enterValidCredentials(String email, String password) {
        Reporter.info("two");
    }

    @Then("should be taken to main page")
    public void shouldBeTakenToMainPage() {
        Reporter.info("three");
    }

}
