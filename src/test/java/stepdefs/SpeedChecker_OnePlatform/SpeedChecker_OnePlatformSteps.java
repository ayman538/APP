package stepdefs.SpeedChecker_OnePlatform;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Commons.CommonPo;
import pages.Dashboard.NetworkLinks.NetworksPO;
import pages.SpeedChecker_OnePlatform.SpeedChecker_OnePlatformAndroid;
import pages.SpeedChecker_OnePlatform.SpeedChecker_OnePlatform_Abstract;
import pages.SpeedChecker_OnePlatform.SpeedChecker_OnePlatformiOS;
import pages.Tray.Settings.PrivacySetting.PrivacySettingsAbstract;
import pages.Tray.Settings.PrivacySetting.PrivacySettingsPO;

public class SpeedChecker_OnePlatformSteps extends CommonPo {

    SpeedChecker_OnePlatform_Abstract speedCheckerOnePlatformAbstract;

    public SpeedChecker_OnePlatformSteps(Config config) {
        if (config.isAndroid()) {
            speedCheckerOnePlatformAbstract = new SpeedChecker_OnePlatformAndroid();
        }
        if (config.isIos()) {
            speedCheckerOnePlatformAbstract = new SpeedChecker_OnePlatformiOS();
        }
    }

    @And("Scroll until Check Data and Wi-Fi speed tab and click on it")
    public void scroll_toCheckDataAndWifiSpeedAndClick() {
        try {
            speedCheckerOnePlatformAbstract.scrollToCheckDataAndWifiSpeed();
            speedCheckerOnePlatformAbstract.clickOnCheckDataAndWifiSpeed();
        } catch (Exception e) {
            System.out.println("Check Data and Wi-Fi Speed Tab is not displayed");
        }
    }

    @Given("user is in speed test tab in speed checker screen")
    public void verifySpeedTestTab() {
        speedCheckerOnePlatformAbstract.validateSpeedTestTabIsDisplayed();
    }

    @Then("speedchecker screen title should be displayed")
    public void verify_SpeedCheckerScreen() {
        speedCheckerOnePlatformAbstract.validateSpeedCheckerScreenTitle();

    }

    @Then("In speedTest Tab Network or WIFI ,MSISDN ,why this network? and icon Should be displayed")
    public void validate_SpeedCheckerScreenInformationWhileUserInSpeedTestTab() {
        speedCheckerOnePlatformAbstract.validateSpeedCheckerScreenNetworkTypeText();
        speedCheckerOnePlatformAbstract.validateSpeedCheckerScreenMSISDN();
        speedCheckerOnePlatformAbstract.validateSpeedCheckerScreenWhyThisNetwork();


    }

    @And("user is in speed test history tab in speed checker screen")
    public void clickOnTestHistoryTab() {
        speedCheckerOnePlatformAbstract.clickOnSpeedHistoryTab();
    }

    @Then("In speedHistory Tab Network or WIFI ,MSISDN ,why this network? and icon Should be displayed")
    public void verifySpeedCheckerScreenInformationWhileUserInSpeedHistoryTab() {
        speedCheckerOnePlatformAbstract.validateSpeedCheckerScreenNetworkTypeText();
        speedCheckerOnePlatformAbstract.validateSpeedCheckerScreenMSISDN();
        speedCheckerOnePlatformAbstract.validateSpeedCheckerScreenWhyThisNetwork();
        speedCheckerOnePlatformAbstract.validateSpeedHistoryTabIsDisplayed();
    }

    @Given("user clicks on test network speed button")
    public void TestNetworkSpeedWhetherWifiOrMobileData() {
        speedCheckerOnePlatformAbstract.testNetworkSpeedWithWifiOrMobileDataNetwork();
    }

    @Then("validate that network speed test ends successfully")
    public void checkTestNetworkSpeedSuccess() {
        speedCheckerOnePlatformAbstract.validateTestNetworkSpeedSuccess();
    }

    @Then("validate network speedchecker test results value")
    public void checkNetworkspeedReslutDescriptionText() {
        speedCheckerOnePlatformAbstract.validateSpeedCheckerResultDescription();
    }

    @And("validate check again CTA is displayed")
    public void checkThatCheckAgainbuttonISDisplayedInResultsScreen() {
        speedCheckerOnePlatformAbstract.validateCheckAgainCTAIsDisplayedInSpeedcheckerResultScreen();
    }

    @When("Scroll to More on data and wifi Link")
    public void ScrollToMoreOnDataAndWifiLink() {
        speedCheckerOnePlatformAbstract.scrollToCheckMoreOnDataAndWiFiLink();
    }

    @And("Validate More Data And Wifi Speed Page")
    public void ValidateMoreDataAndWifiSpeedPage() {
        speedCheckerOnePlatformAbstract.CheckMoreDataAndWifiSpeedPage();
    }

    @Then("Close More Data And Wifi Speed Page")
    public void CloseMoreDataAndWifiSpeedPage() {
        speedCheckerOnePlatformAbstract.CloseMoreDataAndWifiSpeedPage();
    }

    @And("Network optimization grant permission screen is displayed")
    public void networkOptimizationGrantPermissionScreenIsDisplayed() {
        try {
            if (speedCheckerOnePlatformAbstract.isDisplayedOkPleaseProceedCTA())
                speedCheckerOnePlatformAbstract.clickOnOkPleaseProceedCTAFromNetworkOptimizationPermissionsScreen();
        } catch (Exception e) {
            System.out.println("Network Optimization Grant Permission Screen is not displayed");
        }
    }

    @And("user should see why this network button")
    public void userShouldSeeWhyThisNetworkButton() {
        speedCheckerOnePlatformAbstract.validateSpeedCheckerScreenWhyThisNetwork();
    }

    @When("user should click on why this network button")
    public void userShouldClickOnWhyThisNetworkButton() {
        speedCheckerOnePlatformAbstract.clickOnWhyThisNetworkLink();
    }

    @Then("Validate network button tray")
    public void validateNetworkButtonTray() {
        speedCheckerOnePlatformAbstract.validateWhyThisNetworkTray();

    }

    @Given("user is on privacy setting")
    public void userIsOnPrivacySetting() {
        speedCheckerOnePlatformAbstract.userOnPrivacySettingPage();
    }

    @And("Network Optimization toggle is OFF")
    public void networkOptimizationToggleIsOFF() {
        speedCheckerOnePlatformAbstract.networkOptimizationToggleIsOFF();
    }

    @When("user navigate to speed checker and click on OK Proceed")
    public void userNavigateToSpeedCheckerAndClickOnOKProceed() {
        speedCheckerOnePlatformAbstract.scrollToCheckDataAndWifiSpeed();
        speedCheckerOnePlatformAbstract.clickOnCheckDataAndWifiSpeed();
        speedCheckerOnePlatformAbstract.clickOnOkPleaseProceedCTAFromNetworkOptimizationPermissionsScreen();
    }

    @Then("Network Optimization toggle is ON")
    public void networkOptimizationToggleIsON() throws InterruptedException {
        speedCheckerOnePlatformAbstract.networkOptimizationToggleIsON();
    }

    @Then("click on test network speed button")
    public void clickOnTestNetworkSpeedButton() {
        speedCheckerOnePlatformAbstract.scrollToCheckDataAndWifiSpeed();
        speedCheckerOnePlatformAbstract.clickOnCheckDataAndWifiSpeed();
        speedCheckerOnePlatformAbstract.testNetworkSpeedWithWifiOrMobileDataNetwork();
    }

    @Then("I should tap on speed checker Deeplink")
    public void iShouldTapOnSpeedCheckerDeeplink() {
        speedCheckerOnePlatformAbstract.ValidateSpeedcheckerDeeplink();
    }
}
