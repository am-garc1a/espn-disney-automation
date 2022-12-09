package pom.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.mobile.BaseScreen;

/**
 * Object of the first screen that appears when we open the application.
 */
public class TutorialScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_primary_btn\")")
    private AndroidElement getStartedButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_primary_btn\")")
    private AndroidElement shareLocationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*android:id/button1\")")
    private AndroidElement allowLocationButton;

    @AndroidFindBy(uiAutomator =
            "new UiSelector().resourceIdMatches(\".*com.android.packageinstaller:id/permission_allow_button\")")
    private AndroidElement allowButton;

    /**
     * Constructor method for TutorialScreen.
     *
     * @param driver the driver
     */
    public TutorialScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Checks if Get Started Button is displayed in screen.
     *
     * @return : Boolean
     */
    public Boolean getStartedButtonIsDisplayed() {
        return isElementAvailable(getStartedButton, 10);
    }

    /**
     * Start permissions process.
     */
    public void startPermissionsProcess() {
        click(getStartedButton);
    }

    /**
     * Share Location permissions process,
     * and navigate to Dashboard screen from Tutorial screen.
     *
     * @return {@link pom.mobile.DashBoardScreen}
     */
    public DashBoardScreen shareLocationPermissions() {
        click(shareLocationButton);
        click(allowLocationButton);
        click(allowButton);
        return new DashBoardScreen(driver);
    }

    /*
    public DashBoardScreen skipPermissions() {
        * Navigate to Dashboard Screen from Tutorial Screen.
     *
     * @author am.garcia
        return new DashBoardScreen(driver);
    }*/
}