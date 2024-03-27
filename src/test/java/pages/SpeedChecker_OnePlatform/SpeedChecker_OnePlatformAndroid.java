package pages.SpeedChecker_OnePlatform;


import models.response.DashboardV4ResponseModel;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pages.Tray.Settings.PrivacySetting.PrivacySettingsPO;
import utils.DashboardUtils;

import static utils.element_helpers.GenericHelpers.navigateToURL;
import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;


public class SpeedChecker_OnePlatformAndroid extends SpeedChecker_OnePlatform_Abstract {

    PrivacySettingsPO PrivacySettingsPOObj;

    public SpeedChecker_OnePlatformAndroid() {
        super();
    }

    @Override
    public void scrollToCheckDataAndWifiSpeed() {

        scrollDownTo(checkDataAndWifiSpeed);
    }

    @Override
    public void clickOnCheckDataAndWifiSpeed() {
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
        DashboardV4ResponseModel DashboardWholeResponse = DashboardUtils.GetDashboard();
        String DashboardSubscriptionID = DashboardWholeResponse.subscriptionHeader.subscriptionId;
        waitForVisibility(speedCheckerMSISDN);
        AssertDisplayed(speedCheckerMSISDN.isDisplayed());
        Assertions.assertEquals(speedCheckerMSISDN.getText()
                , DashboardSubscriptionID.replaceFirst("0", "44"));
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
        AssertResult(speedCheckerScreenTitle.getText(), "Speed checker");
    }

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
        try {
            Thread.sleep(150000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForVisibility(speedChecker_ResultScreenStatus);
        AssertDisplayed(speedChecker_ResultScreenStatus.isDisplayed());
    }

    @Override
    public void validateSpeedCheckerResultDescription() {
        try {
            Thread.sleep(150000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForVisibility(speedChecker_ResultScreenStatus);
        if (speedChecker_ResultScreenStatus.getText().equalsIgnoreCase("Great")) {
            Assertions.assertTrue(speedChecker_ResultDescription.getText().contains("you can quickly and easily"));
            Assertions.assertTrue(speedChecker_ResultDescription.getText().contains("is ideal"));
            Assertions.assertTrue(speedChecker_ResultDescription.getText().contains("you can use your NOW TV Entertainment Pass or watch Sky Sports"));
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
        scrollDownTo(speedChecker_CheckAgainCTA);
        waitForVisibility(speedChecker_CheckAgainCTA);
        Assertions.assertTrue(speedChecker_CheckAgainCTA.isDisplayed());
    }

    @Override
    public void scrollToCheckMoreOnDataAndWiFiLink() {
        waitForVisibility(speedChecker_ResultScreenStatus);
        scrollDownTo(MoreOnDataAndWifiLink);
        MoreOnDataAndWifiLink.click();
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

        //Check Upload Question and answer
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
        scrollDownTo(MoreOnDataAndWifiLink);
        waitForVisibility(MoreOnDataAndWifiLink);
    }

    @Override
    public void clickOnOkPleaseProceedCTAFromNetworkOptimizationPermissionsScreen() {
        waitForVisibility(NetworkOptimizationPermissionsScreen_OKPleaseProceedCTA);
        NetworkOptimizationPermissionsScreen_OKPleaseProceedCTA.click();
    }

    @Override
    public boolean isDisplayedOkPleaseProceedCTA() {
        boolean okPleaseProceedCtaIsDisplayed = false;

        if (NetworkOptimizationPermissionsScreen_OKPleaseProceedCTA.isDisplayed()) {
            okPleaseProceedCtaIsDisplayed = true;
        }
        return okPleaseProceedCtaIsDisplayed;
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
        AssertResult(speedChecker_WhyThisNetwork_Tray_Header.getText(), "Wi-Fi connection");
        AssertDisplayed(speedChecker_WhyThisNetwork_Tray_description.isDisplayed());
        AssertResult(speedChecker_WhyThisNetwork_Tray_description.getText(), "You are currently connected to the internet via Wi-Fi. If you would like to test your cellular data speed, please go to settings and turn off Wi-Fi.");
        AssertDisplayed(speedChecker_WhyThisNetwork_Tray_FCTA.isDisplayed());
        AssertResult(speedChecker_WhyThisNetwork_Tray_FCTA.getText(), "Go to settings");
        AssertDisplayed(speedChecker_WhyThisNetwork_Tray_SCTA.isDisplayed());


    }

    @Override
    public void userOnPrivacySettingPage() {
        try {
            waitForVisibility(DB_SettingDashboardTray_icon);
            DB_SettingDashboardTray_icon.click();
            By privacy = By.xpath(GetXpath("Privacy"));
            SwipeToElement(DB_PrivacySetting, "Right");
            SwipeToElement(privacy, "Right");
            waitForVisibility(DB_PrivacySetting);
            DB_PrivacySetting.click();
        }catch (Exception e){
            navigateToURL("myvodafone://PRIVACY_SETTINGS");
        }
    }

    @Override
    public void networkOptimizationToggleIsOFF() {
        waitForVisibility(PS_AppPrivacyOption);
        PS_AppPrivacyOption.click();
        scrollDownTo(PS_NetworkOptimisationTitle);
        waitForVisibility(PS_NetworkOptimisationTitle);
        AssertResult(PS_NetworkOptimisationTitle.getText(), "Network optimisation");

        if (PS_AppPrivacyNetworkOptimisationToggle.getAttribute("checked").equals("true")) {
            PS_AppPrivacyNetworkOptimisationToggle.click();
            PS_AppPrivacyNetworkOptimisationConfirmOFFBtn.click();
        }
        AssertResult(PS_AppPrivacyNetworkOptimisationToggle.getAttribute("checked"), "false");
        GeneralBackIcon.click();
        SO_Xicon.click();
    }

    @Override
    public void networkOptimizationToggleIsON() throws InterruptedException {
        waitForVisibility(PS_AppPrivacyOption);
        PS_AppPrivacyOption.click();
        scrollDownTo(PS_NetworkOptimisationTitle);
        waitForVisibility(PS_NetworkOptimisationTitle);
        AssertResult(PS_NetworkOptimisationTitle.getText(), "Network optimisation");

        AssertResult(PS_AppPrivacyNetworkOptimisationToggle.getAttribute("checked"), "true");
        System.out.println("Status is: "+PS_AppPrivacyNetworkOptimisationToggle.getAttribute("checked"));
        GeneralBackIcon.click();
        SO_Xicon.click();
    }
    @Override
    public void ValidateSpeedcheckerDeeplink(){
        navigateToURL("myvodafone://NET_PERFORM");
        waitForVisibility(speedChecker_TestNetworkSpeedCTA);
    }

}
