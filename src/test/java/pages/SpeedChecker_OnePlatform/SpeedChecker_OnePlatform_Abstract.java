package pages.SpeedChecker_OnePlatform;

public abstract class SpeedChecker_OnePlatform_Abstract extends SpeedChecker_OnePlatformPO {
    public SpeedChecker_OnePlatform_Abstract(){super();}

     protected String NetworkTypeExpectedValue =null;
     protected String SpeedCheckerResultExcpectedTitle =null;
     protected String SpeedCheckerResultUploadDescriptionExpected=null;
     protected String SpeedCheckerResultDownloadDescriptionExpected=null;
    protected String SpeedCheckerResultPingDescriptionExpected=null;

    public abstract void scrollToCheckDataAndWifiSpeed();
    public abstract void clickOnCheckDataAndWifiSpeed();
    public abstract void validateSpeedCheckerScreenTitle();
    public abstract void validateSpeedCheckerScreenNetworkTypeText();
    public abstract void validateSpeedCheckerScreenMSISDN();
    public abstract void validateSpeedCheckerScreenWhyThisNetwork();
    public abstract void validateSpeedTestTabIsDisplayed();
    public abstract void clickOnSpeedHistoryTab();
    public abstract void validateSpeedHistoryTabIsDisplayed();
    public abstract void testNetworkSpeedWithWifiOrMobileDataNetwork();
    public abstract void validateTestNetworkSpeedSuccess();
    public abstract void validateSpeedCheckerResultDescription();
    public abstract void validateCheckAgainCTAIsDisplayedInSpeedcheckerResultScreen();
    public abstract void scrollToCheckMoreOnDataAndWiFiLink();
    public abstract void CheckMoreDataAndWifiSpeedPage();
    public abstract void CloseMoreDataAndWifiSpeedPage();
    public abstract void clickOnOkPleaseProceedCTAFromNetworkOptimizationPermissionsScreen();
    public abstract boolean isDisplayedOkPleaseProceedCTA();
    public abstract void clickOnWhyThisNetworkLink();
    public abstract void validateWhyThisNetworkTray();

    public abstract void userOnPrivacySettingPage();
    public abstract void networkOptimizationToggleIsOFF();
    public abstract void networkOptimizationToggleIsON() throws InterruptedException;
    public abstract void ValidateSpeedcheckerDeeplink();
}
