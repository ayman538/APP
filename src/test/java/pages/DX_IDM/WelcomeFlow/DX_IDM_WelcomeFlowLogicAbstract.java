package pages.DX_IDM.WelcomeFlow;

import org.json.simple.parser.ParseException;


public abstract class DX_IDM_WelcomeFlowLogicAbstract extends DX_IDM_WelcomeFlowPO{


    public DX_IDM_WelcomeFlowLogicAbstract() {
        super();
    }

    public abstract void beforeWelcomeScreen();

    public abstract void validateWelcomeScreenContent() ;

    public abstract void beforePrivacyScreen();

    public abstract void validatePrivacyScreenContent() ;

    public abstract void validatePrivacyScreenFunc() ;
    public abstract void beforePermissionScreen() ;

    public abstract void validatePermissionScreenContent() ;

    public abstract void beforeUsageAccessPopup();
    public abstract void validateUsageAccessPopupContent();

    public abstract void acceptAlert() ;

    public abstract void beforeLoginScreen();
    public abstract void validateLoginScreenContent() ;

    public abstract void dxIDMWelcomeFlow();

    public abstract void dxIdmVOXIScreenContent() ;

    public abstract void clickOnReturnToMyVodafoneCTA() throws InterruptedException;

    public abstract void clickOnXIcon();

    public abstract void clickOnTobiIcon();

    public abstract void validateTobiContentScreen() ;
    public abstract void clickOnSettingsDrawer() ;

    public abstract void validateAppAndPrivacySettingsDisplayed();

    public abstract void clickOnVOXIMyAccountDrawer() ;
    public abstract void validateLoginToMyVodafoneUsername() ;

    public abstract void dxIdmSMEScreenContent() ;

    public abstract void TapOnXIconInHelloFriendScreen() ;

    public abstract void ValidateHelloFriendScreenContentWithUnknownUser() ;

    public abstract void ClickOnReturnToVodafoneCTAWithUnknownUser();

    public abstract void AppHardCloseInHelloFriendScreenThenRelaunch() ;

    public abstract void ClickOnLoginCTAWithUnknownUser() ;

    public abstract void UFLJourneyIsTriggeredTillReachDashboard() throws ParseException, InterruptedException ;

    public abstract void AcquisitionScreenIsDisplayed();

    public abstract void acceptCookies();

    public abstract void ValidateWelcomeScreenOpened();
    public abstract void clickOnContinueCTAWelcomeScreens();
    public abstract void validateBeforeYouGetStartedScreen();
    public abstract void validateBeforeYouGetStartedScreenOpened();
    public abstract void validateTermsandConditionsPopup();
    public abstract void toggleOnTermsandConditions();
    public abstract void clickOnBackCTA();

    public abstract void weValueYourPrivacyScreen();

    public abstract void TermsAndConditionsLink();

    public abstract void TermsAndConditionsScreen();

    public abstract void clickOkCtaTermsAndConditionsScreen();
    public abstract void validateNavigationToCookiePermissions();
    public abstract void validateCookiePermissionsScreen(String entery);
    public abstract void OpenCookiePermissions();
    public abstract void ClickOnBackInCookiePerms();
    public abstract void ToggleOnOffAllCookies();
    public abstract void expandAndCollapseAllCookies();
    public abstract void ClickOnAppPrivacySupplementLink();
    public abstract void ValidateAppPrivacySupplementScreen();
    public abstract void Toggle_Cookie(String cookie,String state);
    public abstract void ValidateValueOfCookie(String cookie, String value);
    public abstract void clickonAcceptAllCookiesinWeValueYourPrivacy();
    public abstract void redirectNetworkandService();
    public abstract void validateOurNetworkandServiceWithLink();
    public abstract void validateOurNetworkandServiceWithoutLink();
    public abstract void validateOurNetworkImprovementsToggle();
    public abstract void clickonAcceptAllfromCookiePermissions();
    public abstract void clickonRejectAllfromCookiePermissions();
    public abstract void clickOnEnablePerformanceCookiesLink();
    public abstract void clickOnEnableTargetingCookiesLink();
    public abstract void validateGettheBestExperienceWithoutLink();
    public abstract void validateNavigationToGetTheBestExperience();
    public abstract void validateGettheBestExperienceWithLink();
    public abstract void clickOnEnableAllCTA();
    public abstract void clickOnCookiePolicyLink();
    public abstract void validateCookiePolicyScreen();
    public abstract void clickOnFirstTwoPolicies();
    public abstract void clickOnLastTwoPolicies();
    public abstract void ToggleNetworkImprovementsFromWelcomeFlow();
}
