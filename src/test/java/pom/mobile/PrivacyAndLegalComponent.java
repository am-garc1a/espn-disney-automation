package pom.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.mobile.BaseScreen;

import java.util.List;

/**
 * Privacy & Legal Component.
 */
public class PrivacyAndLegalComponent extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Privacy & Legal\")")
    private AndroidElement privacyLegalTitle;

    @AndroidFindBy(uiAutomator =
            "new UiSelector().resourceIdMatches(\".*privacy_and_legal_elements\").resourceIdMatches(\".*txt_element\")")
    private List<AndroidElement> privacyLegalList;

    /**
     * Constructor method for PrivacyAndLegalComponent.
     *
     * @param driver : AndroidDriver
     */
    public PrivacyAndLegalComponent(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Checks if Privacy & Legal Title is displayed in screen.
     *
     * @return : Boolean
     */
    public Boolean privacyLegalTitleTitleIsDisplayed() {
        return isElementAvailable(privacyLegalTitle, 5);
    }

    /**
     * Checks if Privacy & Legal Elements are displayed in screen.
     *
     * @return : Boolean
     */
    public Boolean privacyLegalElementsAreDisplayed() {
        return areListElementsDisplayed(privacyLegalList, 10);
    }

}
