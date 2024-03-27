package stepdefs.DX_IDM;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAbstract;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAndroid;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogic_IOS;
import pages.Tray.DashboardTray.DashboardTrayAbstract;
import pages.Tray.DashboardTray.DashboardTrayAndroid;
import pages.Tray.DashboardTray.DashboardTrayIOS;


public class Welcome {
    DX_IDM_WelcomeFlowLogicAbstract DX_IDM;
    DX_IDM_WelcomeFlowLogicAndroid  dX_IDM_WelcomeFlowLogicAndroid;
    DashboardTrayAbstract DashboardTrayObject;

    public Welcome(Config config){
        if (config.isAndroid()) {
            DX_IDM = new DX_IDM_WelcomeFlowLogicAndroid();
            dX_IDM_WelcomeFlowLogicAndroid = new DX_IDM_WelcomeFlowLogicAndroid();
            DashboardTrayObject = new DashboardTrayAndroid();
        }
        if (config.isIos()) {
            DX_IDM = new DX_IDM_WelcomeFlowLogic_IOS();
            DashboardTrayObject = new DashboardTrayIOS();
        }
    }

    @Given("Welcome to My vodafone screen is displayed")
    public void beforeWelcome() {
        DX_IDM.beforeWelcomeScreen();
    }

    @Then("Validate Welcome screen content")
    public void TC01_validateWelcomeScreenContent() {
        DX_IDM.validateWelcomeScreenContent();
    }

    @Given("Privacy screen is displayed")
    public void beforePrivacyScreen() {
        DX_IDM.beforePrivacyScreen();
    }

    @Then("Validate Privacy screen content")
    public void TC02_validatePrivacyScreenContent() {
        DX_IDM.validatePrivacyScreenContent();
    }

    @Then("Validate Privacy screen Func")
    public void TC02_validatePrivacyScreenFunc() {
        DX_IDM.validatePrivacyScreenFunc();
    }

    @Given("Permission screen is displayed")
    public void beforePermissionScreen() {
        DX_IDM.beforePermissionScreen();
    }

    @Then("Validate Permission screen content")
    public void TC03_validatePermissionScreenContent() {
        DX_IDM.validatePermissionScreenContent();
    }

    @When("Usage access popup is displayed")
    public void beforeUsageAccessPopup(){ DX_IDM.beforeUsageAccessPopup(); }

    @Then("Validate Usage access popup content")
    public void validateUsageAccessPopupContent(){ DX_IDM.validateUsageAccessPopupContent(); }

    @Given("Login screen is displayed")
    public void beforeLoginScreen() {
        DX_IDM.beforeLoginScreen();
    }

    @Then("Validate Login screen content")
    public void TC04_validateLoginScreenContent() {
        DX_IDM.validateLoginScreenContent();
    }

    @When("wait for one second and half")
    public void waitForOneSecondAndHalf() throws InterruptedException {
        Thread.sleep(2500);
    }

    @Then("Validate Hello friend overlay content")
    public void validateHelloFriendOverlayContent() {
        DX_IDM.dxIdmVOXIScreenContent();
    }

    @Then("Validate Hello friend overlay content For SME users")
    public void validateHelloFriendOverlayContentForSME() {
        DX_IDM.dxIdmSMEScreenContent();
    }

    @Then("Tap on X icon in Hello friend screen")
    public void TapOnXIconInHelloFriendScreen() {
        DX_IDM.TapOnXIconInHelloFriendScreen();
    }

    @Then("Validate Tobi on Acquisition dashboard")
    public void TC05_ValidateTobiDashboardTray() {
        DashboardTrayObject.checkTobi();
    }

    @Then("Validate Close Tobi CTA on Acquisition dashboard")
    public void TC06_ValidateCloseTobiDashboardTray() {
        DashboardTrayObject.checkCloseTobi();
    }

    @Given("Hello friend overlay is displayed")
    public void helloFriendOverlayIsDisplayed() {
        DX_IDM.dxIdmVOXIScreenContent();
    }

    @When("I click on Return to my vodafone CTA")
    public void clickOnReturnToMyVodafoneCTA() throws InterruptedException {
        DX_IDM.clickOnReturnToMyVodafoneCTA();
    }

    @When("Click on x icon")
    public void clickOnXIcon() {
        DX_IDM.clickOnXIcon();
    }

    @When("Click on Tobi Icon")
    public void clickOnTobiIcon() {
        DX_IDM.clickOnTobiIcon();
    }

    @Then("Tobi chat should be displayed")
    public void tobiChatShouldBeDisplayed() {
        DX_IDM.validateTobiContentScreen();
    }

    @When("I navigate to settings from dashboard tray")
    public void clickOnSettingsIcon() {
        DX_IDM.clickOnSettingsDrawer();
    }

    @Then("I validate app and privacy settings are opened from acquisition")
    public void settingsDrawerShouldBeDisplayedWithAppAndPrivacySettings() {
        DX_IDM.validateAppAndPrivacySettingsDisplayed();
    }

    @And("I navigate to my account from dashboard tray")
    public void clickOnMyAccountIcon() {
        DX_IDM.clickOnVOXIMyAccountDrawer();
    }

    @Then("User should land on Login to my vodafone-Username screen for the UFL mode")
    public void userShouldLandOnLoginToMyVodafoneUsernameScreenForTheUFLMode() {
        DX_IDM.validateLoginToMyVodafoneUsername();
    }

    @Then("Validate Hello Friend Screen Content With Unknown User")
    public void ValidateHelloFriendScreenContentWithUnknownUser() {
        DX_IDM.ValidateHelloFriendScreenContentWithUnknownUser();
    }

    @When("I click on Return to my vodafone CTA With Unknown User")
    public void ClickOnReturnToVodafoneCTAWithUnknownUser() {
        DX_IDM.ClickOnReturnToVodafoneCTAWithUnknownUser();
    }

    @When("App HardClose In Hello Friend Screen Then Relaunch")
    public void AppHardCloseInHelloFriendScreenThenRelaunch() {
        DX_IDM.AppHardCloseInHelloFriendScreenThenRelaunch();
    }

    @When("Click On Login CTA With Unknown User")
    public void ClickOnLoginCTAWithUnknownUser() {
        DX_IDM.ClickOnLoginCTAWithUnknownUser();
    }
    @And("Accept Cookies")
    public void acceptCookies() {
        try {
            DX_IDM.acceptCookies();
        }catch (Exception e){
            System.out.println("Cookies're not displayed");
        }

    }
    @Then("UFL Journey Is Triggered Till Reach Dashboard")
    public void UFLJourneyIsTriggeredTillReachDashboard() throws InterruptedException, ParseException {
        DX_IDM.UFLJourneyIsTriggeredTillReachDashboard();
    }

    @When("Acquisition Screen Is Displayed")
    public void AcquisitionScreenIsDisplayed() {
        DX_IDM.AcquisitionScreenIsDisplayed();
    }


}
