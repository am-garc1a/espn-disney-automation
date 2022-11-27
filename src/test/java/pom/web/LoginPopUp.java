package pom.web;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.web.BasePage;

/**
 * Login PopUp class.
 */
public class LoginPopUp extends BasePage {
    @FindBy(id = "logo")
    private WebElement espnLogoForm;

    @FindBy(id = "InputLoginValue")
    private WebElement emailInputForm;

    @FindBy(id = "InputPassword")
    private WebElement passwordInputForm;

    @FindBy(id = "BtnSubmit")
    private WebElement loginButtonSubmitForm;

    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButtonSubmitForm;

    @FindBy(id = "oneid-iframe")
    private WebElement signUpIframe;

    @FindBy(css = "#Title > span")
    private WebElement accountDeactivatedSpan;

    @FindBy(css = "#TextBlock > strong")
    private WebElement emailAccountDeactivated;

    /**
     * Constructor method for LoginPopUp.
     *
     * @param driver : WebDriver
     */
    public LoginPopUp(WebDriver driver) {
        super(driver);
    }

    /**
     * Check login form elements are displayed.
     *
     * @return true if login form elements are displayed, otherwise false
     */
    public boolean areLoginFormElementsDisplayed() {
        return isElementDisplayed(espnLogoForm, 3) &&
                isElementDisplayed(emailInputForm, 3) &&
                isElementDisplayed(passwordInputForm, 3) &&
                isElementDisplayed(loginButtonSubmitForm, 3) &&
                isElementDisplayed(signUpButtonSubmitForm, 3);
    }

    /**
     * Login confirmation action.
     *
     * @param email    : email
     * @param password : password
     */
    public void clickConfirmLoginButton(String email, String password) {
        typeOnInput(emailInputForm, email, 0);
        typeOnInput(passwordInputForm, password, 0);
        clickElement(loginButtonSubmitForm, 0);
    }

    /**
     * Navigate to signUp popup.
     *
     * @return SignUpPopUp
     */
    public SignUpPopUp clickSingUpButton() {
        clickElement(signUpButtonSubmitForm, 0);
        return new SignUpPopUp(getDriver());
    }

}
