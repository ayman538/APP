package pages.SpeedChecker_OnePlatform;


import org.junit.jupiter.api.Assertions;
import pages.Tray.Settings.PrivacySetting.PrivacySettingsAbstract;
import pages.Tray.Settings.PrivacySetting.PrivacySettingsIOS;
import pages.Tray.Settings.PrivacySetting.PrivacySettingsPO;

import java.io.IOException;
import java.util.Locale;

import static utils.element_helpers.GenericHelpers.openDeepLinkForiOS;
import static utils.element_helpers.ScrollHelpers.scrollDownElementOverCenterScreen;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;


public class SpeedChecker_OnePlatformiOS extends SpeedChecker_OnePlatform_Abstract {
    PrivacySettingsAbstract PS;
    PrivacySettingsPO PrivacySettingsPOObj;

    public SpeedChecker_OnePlatformiOS() {
        super();


        try {
            PS= new PrivacySettingsIOS();
            PrivacySettingsPOObj = new PrivacySettingsPO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void scrollToCheckDataAndWifiSpeed() {

        scrollDownElementOverCenterScreen(checkDataAndWifiSpeed);
    }

    @Override
    public void clickOnCheckDataAndWifiSpeed() {
        waitForVisibility(checkDataAndWifiSpeed);
        checkDataAndWifiSpeed.click();
    }

    @Override
    public void validateSpeedCheckerScreenTitle() {
        waitForVisibility(speedCheckerScreenTitle);
        AssertDisplayed(speedCheckerScreenTitle.isDisplayed());
        AssertResult(speedCheckerScreenTitle.getText(), "Speed checker");
    }

    @Override
    public void validateSpeedCheckerScreenNetworkTypeText() {
        waitForVisibility(speedCheckerNetworkType);
        AssertDisplayed(speedCheckerNetworkType.isDisplayed());
        if (speedCheckerNetworkType.getText().equalsIgnoreCase("Wi-Fi")) {
            AssertResult(speedCheckerNetworkType.getText(), "Wi-Fi");
        } else if (speedCheckerNetworkType.getText().equalsIgnoreCase("Network")) {
            AssertResult(speedCheckerNetworkType.getText(), "Network");
        }
    }

    @Override
    public void validateSpeedCheckerScreenMSISDN() {
        waitForVisibility(speedCheckerMSISDN);
        AssertDisplayed(speedCheckerMSISDN.isDisplayed());
    }

    @Override
    public void validateSpeedCheckerScreenWhyThisNetwork() {
        waitForVisibility(speedChecker_WhyThisNetwork_Text);
        AssertDisplayed(speedChecker_WhyThisNetwork_Text.isDisplayed());
        AssertResult(speedChecker_WhyThisNetwork_Text.getText(), "Why this network?");
        waitForVisibility(speedChecker_WhyThisNetworkIcon);
        Assertions.assertTrue(speedChecker_WhyThisNetworkIcon.isDisplayed());

    }

    @Override
    public void validateSpeedTestTabIsDisplayed() {
        waitForVisibility(speedChecker_SpeedTestTab);
        AssertDisplayed(speedChecker_SpeedTestTab.isDisplayed());
        AssertDisplayed(speedCheckerScreenTitle.isDisplayed());
        AssertResult(speedCheckerScreenTitle.getText(), "Speed checker");}

    @Override
    public void clickOnSpeedHistoryTab() {
        AssertDisplayed(speedChecker_SpeedHistoryTab.isDisplayed());
        speedChecker_SpeedHistoryTab.click();
    }

    @Override
    public void validateSpeedHistoryTabIsDisplayed() {
        waitForVisibility(speedChecker_SpeedHistoryTab);
        AssertDisplayed(speedChecker_SpeedHistoryTab.isDisplayed());

    }

    @Override
    public void testNetworkSpeedWithWifiOrMobileDataNetwork() {
        if (speedCheckerNetworkType.getText().contains("Wi-Fi") ||
                speedCheckerNetworkType.getText().contains("Network"))
            speedChecker_TestNetworkSpeedCTA.click();
    }

    @Override
    public void validateTestNetworkSpeedSuccess() {
        waitForVisibility(speedChecker_ResultScreenStatus);
        AssertDisplayed(speedChecker_ResultScreenStatus.isDisplayed());
    }

    @Override
    public void validateSpeedCheckerResultDescription() {
        waitForVisibility(speedChecker_ResultScreenStatus);
        if (speedChecker_ResultScreenStatus.getText().equalsIgnoreCase("Great")) {
            Assertions.assertTrue(speedChecker_ResultDescription.getText().contains("you can quickly and easily"));
            Assertions.assertTrue(speedChecker_ResultDescription.getText().contains("is ideal"));
            Assertions.assertTrue(speedChecker_ResultDescription.getText().contains("you can watch Amazon Prime on your device"));
        } else if (speedChecker_ResultScreenStatus.getText().equalsIgnoreCase("Average")) {
            Assertions.assertTrue(speedChecker_ResultDescription.getText().contains("you can upload content to social media and send emails"));
            Assertions.assertTrue(speedChecker_ResultDescription.getText().contains("is suitable"));
            Assertions.assertTrue(speedChecker_ResultDescription.getText().contains("you can stream Spotify Premium"));

        } else if (speedChecker_ResultScreenStatus.getText().equalsIgnoreCase("Slow")) {
            Assertions.assertTrue(speedChecker_ResultDescription.getText().contains("it may take a while"));
            Assertions.assertTrue(speedChecker_ResultDescription.getText().contains("is not great"));
            Assertions.assertTrue(speedChecker_ResultDescription.getText().contains("browse social media or your favourite websites"));
        }
    }

    @Override
    public void validateCheckAgainCTAIsDisplayedInSpeedcheckerResultScreen() {
        try {
            waitForVisibility(speedChecker_CheckAgainCTA);
            Assertions.assertTrue(speedChecker_CheckAgainCTA.isDisplayed());
            speedChecker_CheckAgainCTA.click();
        } catch (Exception e) {
            scrollDownElementOverCenterScreen(speedChecker_CheckAgainCTA);
            speedChecker_CheckAgainCTA.click();
        }
    }


    @Override
    public void scrollToCheckMoreOnDataAndWiFiLink() {
        try {
            waitForVisibility(speedChecker_ResultScreenStatus);
            Assertions.assertTrue(MoreOnDataAndWifiLink.isDisplayed());
            MoreOnDataAndWifiLink.click();
        } catch (Exception e) {
            scrollDownElementOverCenterScreen(MoreOnDataAndWifiLink);
        }
    }

    @Override
    public void CheckMoreDataAndWifiSpeedPage() {

        waitForVisibility(MoreDataAndWifiSpeedPageTitle);
        AssertDisplayed(MoreDataAndWifiSpeedPageTitle.isDisplayed());
        AssertResult(MoreDataAndWifiSpeedPageTitle.getText(), "More on data and Wi-Fi speed");
        //Check Download Question and answer
        AssertDisplayed(DownloadSpeedTitle.isDisplayed());
        AssertResult(DownloadSpeedTitle.getText(), "What is download speed?");
        AssertDisplayed(DownloadSpeedDescription.isDisplayed());
        AssertResult(DownloadSpeedDescription.getText(), "This is the ability to receive information from the internet. The higher the speed, the more information you can receive per second, which means webpages load faster and content loading on apps are smoother. Network speed is measured by Megabits per second, written as MB/s.");
        //Check Uplaod Question and answer
        AssertDisplayed(UploadSpeedTitle.isDisplayed());
        AssertResult(UploadSpeedTitle.getText(), "What is upload speed?");
        AssertDisplayed(UploadSpeedDescription.isDisplayed());
        AssertResult(UploadSpeedDescription.getText(), "This is the ability to send information from your device to the internet. Normally the default setting of upload speed is lower than download, as people tend to download and consume information more.");
        //Check Ping Question and answer
        AssertDisplayed(PingSpeedTitle.isDisplayed());
        AssertResult(PingSpeedTitle.getText(), "What is ping?");
        AssertDisplayed(PingSpeedDescription.isDisplayed());
        AssertResult(PingSpeedDescription.getText(), "Ping is a measure of network latency, a key factor in how fast your online experience feels. The lower the latency, the more responsive the network is when streaming video, playing games, sending messages, or browsing the internet.");
        //Check Close button
        AssertDisplayed(MoreDataAndWifiSpeedCloseCTA.isDisplayed());

    }

    @Override
    public void CloseMoreDataAndWifiSpeedPage() {
        MoreDataAndWifiSpeedCloseCTA.click();
    }

    @Override
    public void clickOnOkPleaseProceedCTAFromNetworkOptimizationPermissionsScreen() {
        waitForVisibility(NetworkOptimizationPermissionsScreen_OKPleaseProceedCTA);
        NetworkOptimizationPermissionsScreen_OKPleaseProceedCTA.click();
    }

    @Override
    public boolean isDisplayedOkPleaseProceedCTA() {
        boolean OkPleaseProceedCtaIsDisplayed = false;

        if (NetworkOptimizationPermissionsScreen_OKPleaseProceedCTA.isDisplayed()) {
            OkPleaseProceedCtaIsDisplayed = true;
        }
        return OkPleaseProceedCtaIsDisplayed;
    }

    @Override
    public void clickOnWhyThisNetworkLink() {
        waitForVisibility(speedChecker_WhyThisNetwork_Text);
        AssertDisplayed(speedChecker_WhyThisNetwork_Text.isDisplayed());
        speedChecker_WhyThisNetwork_Text.click();
    }

    @Override
    public void validateWhyThisNetworkTray() {
        waitForVisibility(speedChecker_WhyThisNetwork_Tray_title);
        AssertDisplayed(speedChecker_WhyThisNetwork_Tray_title.isDisplayed());
        AssertDisplayed(speedChecker_WhyThisNetwork_Tray_title.isDisplayed());
        AssertResult(speedChecker_WhyThisNetwork_Tray_title.getText(), "Why this network?");
        AssertDisplayed(speedChecker_WhyThisNetwork_Tray_Icon.isDisplayed());
        AssertDisplayed(speedChecker_WhyThisNetwork_Tray_Header.isDisplayed());
        AssertResult(speedChecker_WhyThisNetwork_Tray_Header.getText().toLowerCase(Locale.ROOT), "WI-FI connection".toLowerCase(Locale.ROOT));
        AssertDisplayed(speedChecker_WhyThisNetwork_Tray_description.isDisplayed());
        Assertions.assertEquals(speedChecker_WhyThisNetwork_Tray_description.getText().contains("You are currently connected to the internet via Wi-Fi."), true);
        AssertDisplayed(speedChecker_WhyThisNetwork_Tray_SCTA.isDisplayed());
        AssertResult(speedChecker_WhyThisNetwork_Tray_SCTA.getText(), "OK, thanks");
    }

    @Override
    public void userOnPrivacySettingPage() {
        PS.navigateToPrivacyScreen();
    }

    @Override
    public void networkOptimizationToggleIsOFF() {
        waitForVisibility(PrivacySettingsPOObj.PS_AppPrivacyOption);
        PrivacySettingsPOObj.PS_AppPrivacyOption.click();
        AssertResult(PrivacySettingsPOObj.PS_NetworkOptimisationTitle.getText(), "Network Optimization");
        AssertDisplayed(PrivacySettingsPOObj.PS_AppPrivacyChevron.isDisplayed());

            PrivacySettingsPOObj.PS_AppPrivacyNetworkOptimisationToggle.click();
            PrivacySettingsPOObj.PS_AppPrivacyNetworkOptimisationConfirmOFFBtn.click();

    }

    @Override
    public void networkOptimizationToggleIsON() {
        waitForVisibility(PrivacySettingsPOObj.PS_AppPrivacyOption);
        PrivacySettingsPOObj.PS_AppPrivacyOption.click();
        AssertResult(PrivacySettingsPOObj.PS_NetworkOptimisationTitle.getText(), "Network Optimization");
        AssertDisplayed(PrivacySettingsPOObj.PS_AppPrivacyChevron.isDisplayed());
            PrivacySettingsPOObj.PS_AppPrivacyNetworkOptimisationToggle.click();
            PrivacySettingsPOObj.PS_AppPrivacyNetworkOptimisationConfirmOFFBtn.click();

    }


    @Override
    public void ValidateSpeedcheckerDeeplink(){
        openDeepLinkForiOS("myvodafone://NET_PERFORM");
        waitForVisibility(speedChecker_TestNetworkSpeedCTA);
    }
}
