package pom.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import utils.mobile.BaseScreen;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

/**
 * DashBoard screen.
 */
public class DashBoardScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*android:id/button2\")")
    private AndroidElement dismissPreferenceUpdateButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*dismiss-icon\")")
    private AndroidElement dismissWelcome;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator =
            "new UiSelector().className(\"android.widget.ImageView\").descriptionContains(\"Map\")")
    @AndroidFindBy(uiAutomator =
            "new UiSelector().descriptionContains(\"Map\")")
    private AndroidElement mapButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator =
            "new UiSelector().className(\"android.widget.ImageView\").descriptionContains(\"Reserve\")")
    @AndroidFindBy(uiAutomator =
            "new UiSelector().descriptionContains(\"Reserve\")")
    private AndroidElement addPlansButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator =
            "new UiSelector().className(\"android.widget.ImageView\").descriptionContains(\"More\")")
    @AndroidFindBy(uiAutomator =
            "new UiSelector().descriptionContains(\"More\")")
    private AndroidElement moreOptionsButton;

    /**
     * Constructor method DashBoardScreen.
     *
     * @param driver : AndroidDriver
     */
    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Dismiss PopUps to have clean dashboard.
     */
    public void dismissPopUps() {
        if (isElementAvailable(dismissWelcome, 10)) {
            click(dismissWelcome);
        }
        if (isElementAvailable(dismissPreferenceUpdateButton, 10)) {
            click(dismissPreferenceUpdateButton);
        }
    }

    /**
     * Navigate to Map Screen from DashBoard Screen.
     *
     * @return {@link pom.mobile.MapScreen}
     */
    public MapScreen goToMapScreen() {
        click(mapButton);
        return new MapScreen(driver);
    }

    /**
     * Navigate to Add Plans Screen from DashBoard Screen.
     *
     * @return {@link pom.mobile.AddPlansScreen}
     */
    public AddPlansScreen goToAddPlansScreen() {
        click(addPlansButton);
        return new AddPlansScreen(driver);
    }

    /**
     * Navigate to More Options Screen from DashBoard Screen.
     *
     * @return {@link pom.mobile.MoreOptionsScreen}
     */
    public MoreOptionsScreen goToMoreOptionsScreen() {
        click(moreOptionsButton);
        return new MoreOptionsScreen(driver);
    }

}
