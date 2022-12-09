package pom.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import utils.mobile.BaseScreen;


import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

/**
 * Map screen.
 */
public class MapScreen extends BaseScreen {

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*filterTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Filter\")")
    private AndroidElement filterButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categoryTitle\")")
    private AndroidElement categoriesButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*toggleTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Show List\")")
    private AndroidElement showListButton;

    /**
     * Constructor method for MapScreen.
     *
     * @param driver the driver
     */
    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Checks if Filter Button is displayed in screen.
     *
     * @return : Boolean
     */
    public Boolean filterIsDisplayed() {
        return isElementAvailable(filterButton);
    }

    /**
     * Checks if Categories Button is displayed in screen.
     *
     * @return : Boolean
     */
    public Boolean categoriesIsDisplayed() {
        return isElementAvailable(categoriesButton);
    }

    /**
     * Checks if Show List Button is displayed in screen.
     *
     * @return : Boolean
     */
    public Boolean showListIsDisplayed() {
        return isElementAvailable(showListButton);
    }

    /**
     * Shows Categories List Component.
     *
     * @return {@link pom.mobile.CategoryListComponent}
     */
    public CategoryListComponent clickCategoryListComponent() {
        click(categoriesButton);
        return new CategoryListComponent(driver);
    }

}