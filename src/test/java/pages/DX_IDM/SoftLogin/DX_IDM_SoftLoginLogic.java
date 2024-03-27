//package pages.DX_IDM.SoftLogin;
//
//import pages.Commons.CommonPo;
//import testdata.ReadResponse;
//
//public class DX_IDM_SoftLoginLogic extends CommonPo {
//
//    private final String dx_idm_user_segment = validateSegmentTypeFromSegmentAPI();
//
//
//    public DX_IDM_SoftLoginLogic() {
//        super();
//    }
//
//
//    public void navigateWelcomeScreen() {
//        waitForVisibility(DX_IDM_WelcomeContinueCTA);
//        DX_IDM_WelcomeContinueCTA.click();
//    }
//
//    public void navigatePrivacyAndTermsScreen() {
//        waitForVisibility(DX_IDM_PrivacyAndTermsToggle);
//        DX_IDM_PrivacyAndTermsToggle.click();
//        DX_IDM_PrivacyScreenContinueCTA.click();
//    }
//
//    public void navigatePermissionScreen() {
//        waitForVisibility(DX_IDM_PermissionScreenContinueCTA);
//        DX_IDM_PermissionScreenContinueCTA.click();
//        DX_IDM_NoThanksPermission.click();
//    }
//
//    public void validateDashboardAfterSoftLogin() {
//        //check on segment that is returned in segment API
//        if (!dx_idm_user_segment.equalsIgnoreCase("PREPAY")) {
//            waitForVisibility(DX_IDM_SkipLoginCTA);
//            DX_IDM_SkipLoginCTA.click();
//            waitForVisibility(DB_AllowanceTileHeader);
//            AssertDisplayed(DB_AllowanceTileHeader.isDisplayed());
//        } else {
//            waitForVisibility(DB_SubscriptionIconText);
//            AssertResult(DB_SubscriptionIconText.getText(), "Pay as you go");
//        }
//    }
//
//    public String validateSegmentTypeFromSegmentAPI() {
//        String userSegment = ReadResponse.GetSegment();
//        return userSegment;
//    }
//
//}
