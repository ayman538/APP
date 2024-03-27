package pages.DX_IDM.SoftLogin;

import pages.Commons.CommonPo;

public abstract class DX_IDM_SoftLoginLogic_Abstract extends CommonPo {

    public DX_IDM_SoftLoginLogic_Abstract() {
        super();
    }

    public abstract void navigateWelcomeScreen() ;

    public abstract void navigatePrivacyAndTermsScreen();

    public abstract void navigatePermissionScreen() ;

    public abstract void navigatePermissionScreenWithoutDismissingUsagePopup() ;
    public abstract void validateDashboardAfterSoftLogin() ;

    public abstract String validateSegmentTypeFromSegmentAPI();

}
