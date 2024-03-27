package pages.SubsctionOverlay.NewPlanDesign;

import org.testng.Assert;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.CheckElementNotExist;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
public class UnlimitedDataBoosterIOS extends UnlimitedDataBoosterAbstract {

    NewPlanDesignLogic yourPlans;

    public UnlimitedDataBoosterIOS() {
        super();
    }

    public void navigateToYourPlans() {
        yourPlans = new NewPlanDesignLogic();
        yourPlans.navigateToPlan();
    }

    public void clickUnlimitedDataBooster() {
        scrollDownTo(unlimitedDataBoosterButton);
        waitForVisibility(unlimitedDataBoosterButton);
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
    public void assertActivateByTextDisplayed() {

        ActivateByTextCTA.isDisplayed();
    }

    public void assertChatNowCTADisplayed(){
        waitForVisibility(ChatNowCTA);
        ChatNowCTA.isDisplayed();

    }
    public void clickChatNowCTA() {
        waitForVisibility(ChatNowCTA);
        ChatNowCTA.click();


    }
}
