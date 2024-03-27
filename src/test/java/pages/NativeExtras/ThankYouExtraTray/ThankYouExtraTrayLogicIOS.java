package pages.NativeExtras.ThankYouExtraTray;

import org.testng.Assert;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ThankYouExtraTrayLogicIOS extends ThankYouExtraTrayAbstract {


    @Override
    public void validateThankYouBottomSheetContent() {
        waitForVisibility(traySuccessNotification);
        Assert.assertEquals("Thanks for adding an Extra", traySuccessNotification.getText());
        Assert.assertEquals("We'll text or email you when the changes have been made. It can take up to 6 hours for the extra to appear as active.  This charge will be added to your next bill.", traySuccessSubNotification.getText());
        AssertDisplayed(thankYouCloseIcon.isDisplayed());
        AssertDisplayed(ContinueCTA.isDisplayed());
        AssertDisplayed(thankYouTickIcon.isDisplayed());
    }
    @Override
    public void validateThankYouReOptingInTrayContent() {
        waitForVisibility(traySuccessNotification);
        Assert.assertEquals("Your Recurring Extra will be added", traySuccessNotification.getText());
        Assert.assertEquals("We'll text or email you when the changes have been made. It can take up to 6 hours for the extra to appear as active.  This charge will be added to your next bill.", traySuccessSubNotification.getText());
        AssertDisplayed(thankYouCloseIcon.isDisplayed());
        AssertDisplayed(ContinueCTA.isDisplayed());
        AssertDisplayed(thankYouTickIcon.isDisplayed());
    }


    @Override
    public void validateThankYouOptingOutExtraTrayContent() {
        waitForVisibility(traySuccessNotification);
        Assert.assertEquals("Your Recurring Extra will be removed", traySuccessNotification.getText());
        Assert.assertEquals("We'll text or email you when the changes have been made. It can take up to 6 hours for an extra to be removed.", traySuccessSubNotification.getText());
        AssertDisplayed(thankYouCloseIcon.isDisplayed());
        AssertDisplayed(ContinueCTA.isDisplayed());
        AssertDisplayed(thankYouTickIcon.isDisplayed());
    }


    @Override
    public void clickOnThankYouExtraTrayXCTA() {
        thankYouCloseIcon.click();
    }
}
