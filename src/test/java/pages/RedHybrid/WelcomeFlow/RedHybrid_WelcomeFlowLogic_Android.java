package pages.RedHybrid.WelcomeFlow;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_WelcomeFlowLogic_Android extends RedHybrid_WelcomeFlowLogic_Abstract{


    public RedHybrid_WelcomeFlowLogic_Android(){
        super();
    }

    @Override
    public void redHybridWelcomeFlow(){
        waitForVisibility(RedHybrid_WelcomeTitle);
        validateWelcomeScreenContent();
        RedHybrid_WelcomeContinueCTA.click();

        waitForVisibility(RedHybrid_PrivacyScreenTitle);
        waitForVisibility(RedHybrid_PrivacyAndTermsToggle);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        validatePrivacyScreenContent();
        validatePrivacyScreenFunctionality();
        RedHybrid_PrivacyAndTermsToggle.click();
        RedHybrid_PrivacyScreenContinueCTA.click();

        waitForVisibility(RedHybrid_PermissionScreenTitle);
        validatePermissionsScreenContent();
        RedHybrid_PermissionScreenContinueCTA.click();

        waitForVisibility(NoThanksPermission);
        NoThanksPermission.click();
        waitForVisibility(DX_IDM_LoginCTA);
    }

    @Override
    public void validateWelcomeScreenContent() {
        AssertResult(RedHybrid_WelcomeTitle.getText(), "Welcome to My Vodafone");
        RedHybrid_WelcomeContinueCTA.isDisplayed();
    }

    @Override
    public void validatePrivacyScreenContent() {
        AssertResult(RedHybrid_PrivacyScreenTitle.getText(), "Before we get\nyou started...");
        AssertResult(RedHybrid_PrivacyScreenSubTitle.getText(), "Please agree to our App Privacy Supplement\nand Terms & Conditions before continuing.");
        AssertResult(RedHybrid_TermsText.getText(), "I agree to the App Privacy\nSupplement and Terms & Conditions");
        AssertDisplayed(RedHybrid_PrivacyAndTermsToggle.isDisplayed());
        AssertResult(RedHybrid_PrivacyScreenContinueCTA.getText(), "Continue");
    }

    @Override
    public void validatePrivacyScreenFunctionality() {
        RedHybrid_PrivacyScreenContinueCTA.click();
        AssertResult(RedHybrid_PrivacyAndTermsToggleMessage.getText(), "Please agree to the Terms and\nConditions before continuing");
    }

    @Override
    public void validatePermissionsScreenContent() {
        AssertResult(RedHybrid_PermissionScreenTitle.getText(), "One last thing");
        AssertResult(RedHybrid_PermissionScreenSubTitle.getText(), "To get the most from the My Vodafone App,\nwe'd like to ask for some permissions");
        AssertResult(RedHybrid_PermissionScreenContinueCTA.getText(), "Continue");
    }

}