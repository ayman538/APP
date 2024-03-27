/*package pages.Tray.Settings.PrivacySetting;

import org.openqa.selenium.WebElement;
import pages.Tray.Settings.AccountSetting.SettingsDrawerAndAccountSettingsLogic;
import testdata.ReadResponse;

import java.io.IOException;

import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class PrivacySettingsLogic extends PrivacySettingsPO {

    private final SettingsDrawerAndAccountSettingsLogic accountSettings;


    public PrivacySettingsLogic() throws IOException {
        super();
        accountSettings = new SettingsDrawerAndAccountSettingsLogic();
    }

    public void navigateToPrivacyScreen() {
        clickOnSettingsInTray();
        SwipeToElement(DB_PrivacySetting, "Right");
        clickOnPrivacySettings();
    }

    public void validatePrivacySettingsItems() {
        PrivacyCommanItems();
        if (ReadResponse.GetSegment().equalsIgnoreCase("PREPAY")) {
            AssertDisplayed(!IsElementDisplayed(PS_MarketingPermissionsOption));
        } else {
            AssertResult(PS_MarketingPermissionsOption.getText(), "Marketing preferences");
        }
    }

    public void validatePrivacySettingsItemsForAcq() {
        PrivacyCommanItems();
        PS_DismissButton.click();
    }

    private void PrivacyCommanItems() {
        waitForVisibility(PS_AppPrivacyOption);
        AssertResult(PS_AppPrivacyOption.getText(), "App privacy");
        AssertResult(PS_AppPrivacySupplementOption.getText(), "App Privacy Supplement");
        AssertResult(PS_VodafonePrivacyPortalOption.getText(), "Vodafone Privacy Portal");
    }

    public void clickOnPrivacySettings() {
        waitForVisibility(DB_PrivacySetting);
        DB_PrivacySetting.click();
    }

    public void clickOnSettingsInTray() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        DB_SettingDashboardTray_icon.click();
    }

    public void validateAppPrivacySupplementChevrons() {
        clickOnAppPrivacySupplement();
        AssertDisplayed(PS_SupplementTitle.isDisplayed());

        ChevronChecks(PS_SupplementCardInfoWeCollect, "Information we collect", PS_SupplementCardInfoWeCollectDescription);

        assertSupplementCardExpansion();
        assertSupplementCardCollapse();


        waitForVisibility(PS_SupplementCardWhatInfoNotCollected);
        ChevronChecks(PS_SupplementCardWhatInfoNotCollected, "What information we don't collect", PS_SupplementCardUsageOfVodafoneDescription);

        scrollDown();
        waitForVisibility(PS_SupplementCardHowToUseInfo);
        ChevronChecks(PS_SupplementCardHowToUseInfo, "How we use this information", PS_SupplementCardUsageOfVodafoneDescription);

        waitForVisibility(PS_SupplementCardWhatChoices);
        ChevronChecks(PS_SupplementCardWhatChoices, "What choices do you have?", PS_SupplementCardUsageOfVodafoneDescription);

        scrollDown();
        assertSupplementCardProtectDataExpansion();
        assertSupplementCardInfoWeCollectCollapse();


        assertSupplementCardKeepDataExpansion();
        assertSupplementCardKeepDataCollapse();


        clickOnSupplementCardVodafonePrivacy();
        assertExternalBrowserDisplayed();

        PS_BackButton.click();
    }

    public void assertExternalBrowserDisplayed() {
        waitForVisibility(DoneCtaInExternalbrowser);
        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
        DoneCtaInExternalbrowser.click();
    }

    public void clickOnSupplementCardVodafonePrivacy() {
        waitForVisibility(PS_SupplementCardVodafonePrivacy);
        PS_SupplementCardVodafonePrivacy.click();
    }

    public void assertSupplementCardKeepDataCollapse() {
        PS_SupplementCardKeepData.click();
        AssertDisplayed(!IsElementDisplayed(PS_SupplementCardInfoWeCollectDescription));
    }

    public void assertSupplementCardKeepDataExpansion() {
        waitForVisibility(PS_SupplementCardKeepData);
        PS_SupplementCardKeepData.click();
        AssertDisplayed(PS_SupplementCardUsageOfVodafoneDescription.isDisplayed());
    }

    public void assertSupplementCardInfoWeCollectCollapse() {
        PS_SupplementCardProtectData.click();
        AssertDisplayed(!IsElementDisplayed(PS_SupplementCardInfoWeCollectDescription));
    }

    public void assertSupplementCardProtectDataExpansion() {
        waitForVisibility(PS_SupplementCardProtectData);
        PS_SupplementCardProtectData.click();
        AssertDisplayed(PS_SupplementCardUsageOfVodafoneDescription.isDisplayed());
    }

    public void assertSupplementCardCollapse() {
        PS_SupplementCardUsageOfVodafone.click();
        AssertDisplayed(!IsElementDisplayed(PS_SupplementCardInfoWeCollectDescription));
    }

    public void assertSupplementCardExpansion() {
        PS_SupplementCardUsageOfVodafone.click();
        AssertDisplayed(PS_SupplementCardUsageOfVodafoneDescription.isDisplayed());
    }

    public void clickOnAppPrivacySupplement() {
        waitForVisibility(PS_AppPrivacySupplementOption);
        PS_AppPrivacySupplementOption.click();
    }

    public void ChevronChecks(WebElement ps_supplementCardInfoWeCollect, String s, WebElement ps_supplementCardInfoWeCollectDescription) {
        AssertResult(ps_supplementCardInfoWeCollect.getText(), s);
        ps_supplementCardInfoWeCollect.click();
        AssertDisplayed(ps_supplementCardInfoWeCollectDescription.isDisplayed());
        ps_supplementCardInfoWeCollect.click();
        AssertDisplayed(!IsElementDisplayed(PS_SupplementCardInfoWeCollectDescription));
    }

    public void validateAppPrivacyTailored() {
        waitForVisibility(PS_AppPrivacyOption);
        PS_AppPrivacyOption.click();
        AssertResult(PS_AppPrivacyTailoredServiceTitle.getText(), "Tailored service and recommendations");
        AssertDisplayed(PS_AppPrivacyTailoredServiceDescription.isDisplayed());
        scrollDownTo(PS_AppPrivacyNetworkOptimisationDescription);
    }

    public void validateAppPrivacyNetwork() {
        AssertResult(PS_NetworkOptimisationTitle.getText(), "Network optimisation");
        AssertDisplayed(PS_AppPrivacyChevron.isDisplayed());
    }

    public void validateAppPrivacyChevron() {
        PS_AppPrivacyChevron.click();
        scrollDownTo(PS_AppPrivacyChevronExpandContent);
        AssertDisplayed(PS_AppPrivacyChevronExpandContent.isDisplayed());
        PS_AppPrivacyChevron.click();
    }

    public void validateAppPrivacyUsageCard() {
        scrollDownTo(PS_AppPrivacyDataUsageCard);
        scrollDown();
//        AssertDisplayed(PS_AppPrivacyDataUsage.isDisplayed());
        System.out.println(PS_AppPrivacyDataUsage.getText());
        AssertDisplayed(PS_AppPrivacyDataUsage.getText().contains("App data usage:"));
        PS_BackButton.click();
    }

    public void validateMarketingPreferencesFunctionality() {
        if (ReadResponse.GetSegment().equalsIgnoreCase("PREPAY")) {
            AssertDisplayed(!IsElementDisplayed(PS_MarketingPermissionsOption));
        } else {
            clickOnMarketingPermissionsOption();
            accountSettings.checkLoginStatus();
        }
    }

    public void clickOnMarketingPermissionsOption() {
        waitForVisibility(PS_MarketingPermissionsOption);
        PS_MarketingPermissionsOption.click();
    }

    public void validateVodafonePrivacyPortalFunctionality() {
        clickOnVodafonePrivacyPortalOption();
        assertExternalBrowserDisplayed();
    }

    public void clickOnVodafonePrivacyPortalOption() {
        waitForVisibility(PS_VodafonePrivacyPortalOption);
        PS_VodafonePrivacyPortalOption.click();
    }
}

 */






