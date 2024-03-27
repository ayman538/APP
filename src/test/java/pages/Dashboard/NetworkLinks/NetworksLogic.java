package pages.Dashboard.NetworkLinks;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class NetworksLogic extends NetworksPO {

    public NetworksLogic() {
        super();
    }


    public void checkFirstCard() {
        assertNetworkCheckerLinkText();
    }

    public void assertNetworkCheckerLinkText() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        scrollDownTo(DB_NetworkCheckerLink);
        AssertResult(DB_NetworkCheckerLink.getText(), "Network Status Checker");
    }

    public void checkSecondCard() {
        assertDataSpeedLinkText();
    }

    public void assertDataSpeedLinkText() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        scrollDownTo(DB_CheckDataSpeedLink);
        AssertResult(DB_CheckDataSpeedLink.getText(), "Check Data and Wi-Fi Speed");
    }

    public void checkNetworkStatusJourney() {
        networkCheckerLinkCTA();
        assertNetworkStatusTitleText();
        NetworkScreenXIcon.click();
    }

    public void assertNetworkStatusTitleText() {
        waitForVisibility(DB_NetworkStatus_title);
        AssertResult(DB_NetworkStatus_title.getText(), "Network Status Checker");
    }

    public void networkCheckerLinkCTA() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        scrollDownTo(DB_NetworkCheckerLink);
        DB_NetworkCheckerLink.click();
    }

    public void checkDataWIFIJourney() {
        SpeedLinkCTA();
        assertSpeedCheckerTitleText();
    }

    public void assertSpeedCheckerTitleText() {
        waitForVisibility(DB_speedChecker_title);
        AssertResult(DB_speedChecker_title.getText(), "Speed Checker");
    }

    public void SpeedLinkCTA() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        scrollDownTo(DB_CheckDataSpeedLink);
        DB_CheckDataSpeedLink.click();
    }

    public void checkSpeedTest() {
        waitForVisibility(DB_StartSpeedTestCTA);
        DB_StartSpeedTestCTA.click();
        waitForVisibility(DB_StartSpeedRetestCTA);
        AssertDisplayed(DB_StartSpeedRetestCTA.isDisplayed());
    }

}
