package pom.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.mobile.BaseScreen;

import java.util.List;

/**
 * Add PlansS screen.
 */
public class AddPlansScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator =
            "new UiSelector().resourceIdMatches(\".*actionSheetListView\").resourceIdMatches(\".*actionSheetItemText\")")
    private List<AndroidElement> plansList;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*filter_clear\")")
    private AndroidElement partySizeLabel;

    /**
     * Constructor method for AddPlansScreen.
     *
     * @param driver : AndroidDriver
     */
    public AddPlansScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Checks if specific plan is present in plan list.
     *
     * @param planToFind : plan to find
     * @return : Boolean
     */
    public Boolean planIsPresent(String planToFind) {
        return elementIsPresentInList(plansList, planToFind);
    }

    /**
     * Click the plan by index.
     *
     * @param planIndex : index of plan in plans list
     */
    public void clickPlan(int planIndex) {
        click(plansList.get(planIndex));
    }

    /**
     * Checks if Party Size label is displayed in screen.
     *
     * @return : Boolean
     */
    public Boolean diningAvailabilityComponentDisplayed() {
        return isElementAvailable(partySizeLabel, 5);
    }

}
