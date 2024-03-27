package pages.RedHybrid.ProcessingPaymentCard;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class RedHybrid_ValidateCardAddingLogic extends RedHybrid_ValidateCardAddingPO {

    public RedHybrid_ValidateCardAddingLogic() {
        super();
    }


    public void ClickOnContinue() {
        waitForVisibility(RedHybrid_CardPayNowCTA);
        RedHybrid_CardPayNowCTA.click();
    }

    public void ClickOnCancel() {
        waitForVisibility(RedHybrid_CancelPaymentCTA);
        RedHybrid_CancelPaymentCTA.click();
    }

    public void ClickOnXicon() {
        waitForVisibility(RedHybrid_PaymentXIcon);
        RedHybrid_PaymentXIcon.click();
    }

    public void TapOnAndroidPhysicalBackOnSuccessScreen() {
        waitForVisibility(RedHybrid_SuccessBody);
        driver.navigate().back();
    }

    public void ClickOnTryAgain() {
        waitForVisibility(RedHybrid_FailedBody);
        RedHybrid_FailedCTA.click();
    }

    public void TapOnAndroidPhysicalBackOnProcessingScreen() {
        waitForVisibility(RedHybrid_ProcessingBody);
        driver.navigate().back();
    }

    public void ValidateVerifiedCardScreen() {
        waitForVisibility(RedHybrid_SuccessTik);
        AssertResult(RedHybrid_SuccessBody.getText(), "You added a new payment method to your account");
        AssertDisplayed(RedHybrid_SuccessCTA.isDisplayed());

    }

    public void ValidateFailedCardScreen() {
        waitForVisibility(RedHybrid_FailedTik);
        AssertResult(RedHybrid_FailedBody.getText(), "There was a problem adding your card");
        AssertResult(RedHybrid_FailedDetails.getText(), "Please try adding your card again or check back later");
        AssertDisplayed(RedHybrid_FailedCTA.isDisplayed());

    }

    public void ValidateProcessingScreen() {
        waitForVisibility(RedHybrid_ProcessingIcon);
        AssertResult(RedHybrid_ProcessingBody.getText(), "Processing ...");

    }

}
