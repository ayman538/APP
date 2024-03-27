package pages.SubsctionOverlay.NewPlanDesign;

import org.testng.Assert;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.CheckElementNotExist;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
@Deprecated
public class UnlimitedDataBoosterLogic extends UnlimitedDataBoosterPO {
    NewPlanDesignLogic yourPlans;

    public UnlimitedDataBoosterLogic() {
        super();
    }

    public void navigateToYourPlans() {
        yourPlans = new NewPlanDesignLogic();
        yourPlans.navigateToPlan();
    }

    public void clickUnlimitedDataBooster() {
        waitForVisibility(unlimitedDataBoosterButton);
        scrollDownTo(unlimitedDataBoosterButton);
        unlimitedDataBoosterButton.click();
    }

    public void clickChangeYourAirtimePlan() {
        Assert.assertEquals(Plan_changeYourAirtimePlanButton.getText(), "Change your Airtime Plan");
        Plan_changeYourAirtimePlanButton.click();
    }

    public void assertLoginScreenIsOpened() {
        AssertDisplayed(Login_username.isDisplayed());
    }

    public void assertCountersAreDisplayed() {
        Plan_availableCounter.isDisplayed();
        Assert.assertEquals(Plan_availableCounter.getText(), "Available");
        Plan_usedCounter.isDisplayed();
        Assert.assertEquals(Plan_usedCounter.getText(), "Used");
    }

    public void assertActiveCounterNotDisplayed() {
        CheckElementNotExist(Plan_activeCounter);
    }
}