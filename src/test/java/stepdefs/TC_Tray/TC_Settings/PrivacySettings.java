package stepdefs.TC_Tray.TC_Settings;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAbstract;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAndroid;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogic_IOS;
import pages.Tray.Settings.PrivacySetting.PrivacySettingsAbstract;
import pages.Tray.Settings.PrivacySetting.PrivacySettingsAndroid;
import pages.Tray.Settings.PrivacySetting.PrivacySettingsIOS;

import java.io.IOException;


public class PrivacySettings {
    PrivacySettingsAbstract PS;
    DX_IDM_WelcomeFlowLogicAbstract WF;

    public PrivacySettings(Config config) throws IOException {
        if (config.isAndroid()){
            PS = new PrivacySettingsAndroid();
            WF = new DX_IDM_WelcomeFlowLogicAndroid();
        }
        if (config.isIos()){
            PS = new PrivacySettingsIOS();
            WF = new DX_IDM_WelcomeFlowLogic_IOS();
        }
    }

    @Given("I navigate to Privacy Settings")
    public void BeforeClass(){
        PS.navigateToPrivacyScreen();
    }

    @Given("Initialize Privacy Settings for Acquisition")
    public void InitializePrivacySettingsForAcquisition() {
        PS.navigateToPrivacyScreen();
    }

    @Then("Validate Privacy Settings Items")
    public void TC01_ValidatePrivacySettingsItems() {
        PS.validatePrivacySettingsItems();
    }

    @Then("I validate privacy setting is opened and each items")
    public void TC01_ValidatePrivacySettingsItemsForAcquisition() {
        PS.validatePrivacySettingsItems();
    }

    @Then("Validate App Privacy Supplement Chevrons")
    public void TC02_ValidateAppPrivacySupplementChevrons() {
        PS.validateAppPrivacySupplementChevrons();
    }

    @Then("Validate App Privacy Tailored")
    public void TC03_ValidateAppPrivacyTailored() {
        PS.validateAppPrivacyTailored();
    }

    @Then("Validate App Privacy Network")
    public void TC03_ValidateAppPrivacyNetwork() {
        PS.validateAppPrivacyNetwork();
    }

    @Then("Validate App Privacy Chevron")
    public void TC03_ValidateAppPrivacyChevron() {
        PS.validateAppPrivacyChevron();
    }

    @Then("Validate App Privacy UsageCard")
    public void TC03_ValidateAppPrivacyUsageCard() {
        PS.validateAppPrivacyUsageCard();
    }

    @Then("Validate Marketing Preferences Functionality")
    public void TC04_ValidateMarketingPreferencesFunctionality() {
        PS.validateMarketingPreferencesFunctionality();
    }

    @Then("Validate Vodafone Privacy Portal Functionality")
    public void TC05_ValidateVodafonePrivacyPortalFunctionality() {
        PS.validateVodafonePrivacyPortalFunctionality();
    }

    @Then("I navigate to Marketing preferences")
    public void navigateToMarketingPreferences() {
        PS.clickOnMarketingPermissionsOption();
    }

    @Then("Validate New UI Of Privacy Settings")
    public void validateNewUIOfPrivacySettings() {PS.ChekNewUIOfPrivacySettings();}

    @When("I click on Privacy Settings")
    public void iClickOnPrivacySettings() {PS.OpenPrivacySettings();}

    @And("I click on Cookie Permissions")
    public void iClickOnCookiePermissions() {PS.OpenCookiePermissions();}

    @And("I Validate Value Of {string} Cookie Is {string}")
    public void iValidateValueOfCookieIs(String arg0, String arg1) {
        WF.ValidateValueOfCookie(arg0,arg1);
    }

    @Then("I redirected to Privacy Settings")
    public void iRedirectedToPrivacySettings() {
        PS.CheckNavigationtoPrivacySettings();
    }

    @Then("I redirected to 'Get The Best Experience' Screen")
    public void iRedirectedToGetTheBestExperiecneScreen() {WF.validateNavigationToGetTheBestExperience();}

    @And("I click on Network And Service")
    public void iClickOnNetworkAndService() {PS.ClickOnNetworkAndService();}

    @And("I Validate Network Improvements {string} from settings")
    public void iValidateNetworkImprovementsToggleStateFromSettings(String state) {PS.ValidateNetworkImprovementsToggleStateFromSettings(state);}

    @When("I Toggle Network Improvements {string} from settings")
    public void iToggleNetworkImprovementsFromSettings(String state) {PS.ToggleNetworkImprovementsFromSettings(state);}

    @Then("I Validate 'Network And Service' screen from settings without link")
    public void iValidateNetworkAndServiceScreenFromSettingsWithoutLink() {PS.ValidateNetworkAndServiceScreenFromSettingsWithoutLink();}

    @Then("I Validate 'Network And Service' screen from settings with link")
    public void iValidateNetworkAndServiceScreenFromSettingsWithLink() {PS.ValidateNetworkAndServiceScreenFromSettingsWithLink();
    }

    @When("I click on 'Enable Performance Cookies' link in 'network and service' screen from settings")
    public void iClickOnEnablePerformanceCookiesLinkInNetworkAndServiceScreenFromSettings() {PS.clickOnEnablePerformanceCookiesLinkFromSettings();
    }

    @When("I click on Vodafone Privacy Information entry point")
    public void iClickOnVodafonePrivacyInformationEntryPoint() {
        PS.PrivacyInformationEntryPoint();
    }

    @Then("I navigate to Vodafone Privacy Portal screen")
    public void iNavigateToVodafonePrivacyPortalScreen() {
        PS.NavigateToVodafonePrivacyPortalScreen();
    }

    @When("I click on the back icon for settings screens")
    public void iClickOnTheBackIconForSettingsScreens() {
        PS.ClickOnTheBackIconForSettingsScreens();
    }

    @When("I click on App Privacy Supplement CTA")
    public void iClickOnAppPrivacySupplementCTA() {
        PS.ClickOnAppPrivacySupplementCTA();
    }

    @When("I click on Cookie policy CTA")
    public void iClickOnCookiePolicyCTA() {
        PS.ClickOnCookiePolicyCTA();
    }

    @When("I click on Privacy portal CTA")
    public void iClickOnPrivacyPortalCTA() {
        PS.ClickOnPrivacyPortalCTA();
    }

    @Then("I navigate to privacy portal webview")
    public void iNavigateToPrivacyPortalWebview() {PS.ValidateNavigationToPrivacyPortalWebview();}

    @When("I click on Device Permissions entry point")
    public void iClickOnDevicePermissionsEntryPoint() {
        PS.ClickOnDevicePermissionsCTA();
    }

    @Then("I navigate to Device permissions screen with enabling targeting cookies link")
    public void iNavigateToDevicePermissionsScreenWithEnablingTargetingCookiesLink() {
        PS.ValidateDevicePermissionsWithEnableTargetingCookies();
    }
    @Then("I navigate to Device permissions screen without enabling targeting cookies link")
    public void iNavigateToDevicePermissionsScreenWithoutEnablingTargetingCookiesLink() {
        PS.ValidateDevicePermissionsWithoutEnableTargetingCookies();
    }
    @When("I click on 'Enable Targeting Cookies' link in 'Device Permissions' screen from settings")
    public void iClickOnEnableTargetingCookiesLinkInNetworkAndServiceScreenFromSettings() {
        PS.clickOnEnableTargetingCookiesLinkFromSettings();
    }
    @Then("All device permissions are enabled")
    public void allDevicePermissionsAreEnabled(){
        PS.validateAllDevicePermissionsAreEnabled();
    }

}
