package pom.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.web.BasePage;

/**
 * SignUp PopUp class.
 */
public class SignUpPopUp extends BasePage {
    @FindBy(id = "InputFirstName")
    private WebElement nameInputSingUpForm;

    @FindBy(id = "InputLastName")
    private WebElement lastNameInputSingUpForm;

    @FindBy(id = "InputEmail")
    private WebElement emailInputSingUpForm;

    @FindBy(id = "password-new")
    private WebElement passwordInputSingUpForm;

    @FindBy(id = "BtnSubmit")
    private WebElement singUpButtonSubmitForm;

    /**
     * Constructor method for SignUpPopUp.
     *
     * @param driver : WebDriver
     */
    public SignUpPopUp(WebDriver driver) {
        super(driver);
    }

    /**
     * Check if singup form elements are displayed.
     *
     * @return true if singup form elements are displayed, otherwise false
     */
    public boolean areSingUpFormElementsDisplayed() {
        return isElementDisplayed(nameInputSingUpForm, 3) &&
                isElementDisplayed(lastNameInputSingUpForm, 3) &&
                isElementDisplayed(emailInputSingUpForm, 3) &&
                isElementDisplayed(passwordInputSingUpForm, 3);
    }

    /**
     * Fills singUp inputs.
     *
     * @param name     : name
     * @param lastName : last name
     * @param email    : email
     * @param password : password
     */
    public void fillSingUpInputs(String name, String lastName, String email, String password) {
        typeOnInput(nameInputSingUpForm, name, 0);
        typeOnInput(lastNameInputSingUpForm, lastName, 0);
        typeOnInput(emailInputSingUpForm, email, 0);
        typeOnInput(passwordInputSingUpForm, password, 0);
    }

    public void clickConfirmSingUpButton() {
        isElementDisplayed(singUpButtonSubmitForm, 3);
        clickElement(singUpButtonSubmitForm, 1);
    }
}
