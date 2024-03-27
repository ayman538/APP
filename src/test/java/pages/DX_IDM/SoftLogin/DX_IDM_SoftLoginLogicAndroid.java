package pages.DX_IDM.SoftLogin;

import testdata.ReadResponse;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class DX_IDM_SoftLoginLogicAndroid extends DX_IDM_SoftLoginLogic_Abstract {

    private final String dx_idm_user_segment = validateSegmentTypeFromSegmentAPI();


    public DX_IDM_SoftLoginLogicAndroid() {
        super();
    }

    @Override
    public void navigateWelcomeScreen() {
        waitForVisibility(DX_IDM_WelcomeContinueCTA);
        DX_IDM_WelcomeContinueCTA.click();
    }

    @Override
    public void navigatePrivacyAndTermsScreen() {
        waitForVisibility(DX_IDM_PrivacyAndTermsToggle);
        DX_IDM_PrivacyAndTermsToggle.click();
        DX_IDM_PrivacyScreenContinueCTA.click();
    }

    @Override
    public void navigatePermissionScreen() {
        waitForVisibility(DX_IDM_PermissionScreenContinueCTA);
        DX_IDM_PermissionScreenContinueCTA.click();
        DX_IDM_NoThanksPermission.click();
    }

    @Override
    public void navigatePermissionScreenWithoutDismissingUsagePopup() {
        waitForVisibility(DX_IDM_PermissionScreenContinueCTA);
        DX_IDM_PermissionScreenContinueCTA.click();
    }


    @Override
    public void validateDashboardAfterSoftLogin() {
        //check on segment that is returned in segment API
        if (!dx_idm_user_segment.equalsIgnoreCase("PREPAY")) {
            waitForVisibility(DX_IDM_SkipLoginCTA);
            DX_IDM_SkipLoginCTA.click();
            waitForVisibility(DB_AllowanceTileHeader);
            AssertDisplayed(DB_AllowanceTileHeader.isDisplayed());
        } else {
            waitForVisibility(DB_SubscriptionIconText);
            AssertResult(DB_SubscriptionIconText.getText(), "Pay as you go");
        }
    }

    @Override
    public String validateSegmentTypeFromSegmentAPI() {
        String userSegment = ReadResponse.GetSegment();
        return userSegment;
    }
}
