package pages.NativeControlsAndLimits.ThankYouTurnOffControls;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ThankYouTurnOffControlsLogicIOS extends ThankYouTurnOffControlsAbstract {


    @Override
    public void validateThankYouTurnOffControlsTray() {
        waitForVisibility(RedHybrid_PaymentAddCTA);
        AssertResult(traySuccessNotification.getText(),"Your control is now turned off");
        AssertDisplayed(RedHybrid_SuccessTik.isDisplayed());
        AssertResult(traySuccessSubNotification.getText(),"It may take up to 6 hours for your control to update in the My Vodafone app.");
        AssertDisplayed(RedHybrid_PaymentAddCTA.isDisplayed());
        AssertDisplayed(thankYouCloseIcon.isDisplayed());
    }

    @Override
    public void clickOnThankYouTurnOffControlXCTA() {
        thankYouCloseIcon.click();
    }
}
