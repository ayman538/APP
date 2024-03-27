package pages.Tray.Settings.PrivacySetting;

import org.openqa.selenium.WebElement;

import java.io.IOException;

public abstract class PrivacySettingsAbstract extends PrivacySettingsPO {

    public PrivacySettingsAbstract() throws IOException {
        super();
    }

    public abstract void navigateToPrivacyScreen();

    public abstract void validatePrivacySettingsItems();

    public abstract void validatePrivacySettingsItemsForAcq();

    public abstract void PrivacyCommanItems();

    public abstract void clickOnPrivacySettings();

    public abstract void clickOnSettingsInTray();

    public abstract void validateAppPrivacySupplementChevrons();

    public abstract void assertExternalBrowserDisplayed();

    public abstract void clickOnSupplementCardVodafonePrivacy();

    public abstract void assertSupplementCardKeepDataCollapse();

    public abstract void assertSupplementCardKeepDataExpansion();

    public abstract void assertSupplementCardInfoWeCollectCollapse();

    public abstract void assertSupplementCardProtectDataExpansion();

    public abstract void assertSupplementCardCollapse();

    public abstract void assertSupplementCardExpansion();

    public abstract void clickOnAppPrivacySupplement();

    public abstract void ChevronChecks(WebElement ps_supplementCardInfoWeCollect, String s, WebElement ps_supplementCardInfoWeCollectDescription);

    public abstract void validateAppPrivacyTailored();

    public abstract void validateAppPrivacyNetwork();

    public abstract void validateAppPrivacyChevron();

    public abstract void validateAppPrivacyUsageCard();

    public abstract void validateMarketingPreferencesFunctionality();

    public abstract void clickOnMarketingPermissionsOption();

    public abstract void validateVodafonePrivacyPortalFunctionality();

    public abstract void clickOnVodafonePrivacyPortalOption();
    public abstract void ChekNewUIOfPrivacySettings();
    public abstract void CheckNavigationtoPrivacySettings();
    public abstract void OpenPrivacySettings();
    public abstract void OpenCookiePermissions();
    public abstract void ClickOnNetworkAndService();
    public abstract void ValidateNetworkImprovementsToggleStateFromSettings(String state);
    public abstract void ToggleNetworkImprovementsFromSettings(String state);
    public abstract void ValidateNetworkAndServiceScreenFromSettingsWithoutLink();
    public abstract void ValidateNetworkAndServiceScreenFromSettingsWithLink();
    public abstract void clickOnEnablePerformanceCookiesLinkFromSettings();

    public abstract void PrivacyInformationEntryPoint();

    public abstract void NavigateToVodafonePrivacyPortalScreen();

    public abstract void ClickOnTheBackIconForSettingsScreens();

    public abstract void ClickOnAppPrivacySupplementCTA();

    public abstract void ClickOnCookiePolicyCTA();

    public abstract void ClickOnPrivacyPortalCTA();
    public abstract void ValidateNavigationToPrivacyPortalWebview();

    public abstract void ClickOnDevicePermissionsCTA();

    public abstract void ValidateDevicePermissionsWithEnableTargetingCookies();

    public abstract void ValidateDevicePermissionsWithoutEnableTargetingCookies();

    public abstract void clickOnEnableTargetingCookiesLinkFromSettings();

    public abstract void validateAllDevicePermissionsAreEnabled();

}







