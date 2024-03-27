package stepdefs.TC_Tray.TC_Settings;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Tray.Settings.AppSetting.AppSettingsAbstract;
import pages.Tray.Settings.AppSetting.AppSettingsAndroid;
import pages.Tray.Settings.AppSetting.AppSettingsIOS;

import java.io.IOException;


public class AppSettings {

    AppSettingsAbstract AS;
    static boolean run = false;
    static boolean navigatedToDashboard = false;

    public AppSettings(Config config){
        if (config.isAndroid()) AS = new AppSettingsAndroid();
        if (config.isIos()) AS = new AppSettingsIOS();
    }

//    @Given("Init App settings class")
//    public void beforeFeature() throws IOException {
//        if (!navigatedToDashboard) {
//            testAfterLastScenario();
//            navigatedToDashboard = true;
//        }
////        AS = new AppSettingsLogic();
//    }

    @Given("Init App settings for Acquisition")
    public void InitAppSettingForAcq() throws IOException {
//        AS = new AppSettingsLogic();
    }

    @And("I navigate to App settings screen")
    public void TC01_ValidateAppSettingsItemsForPrePayUser() {
        AS.navigateToAppSettingsScreen();
    }

    @Then("Assert on items displayed")
    public void assertOnItemsDisplayed() {
        AS.assertOnItemsDisplayed();
    }

    @Then("I validate app setting is opened and each items for acquisition")
    public void assertOnItemsDisplayedForAcq() {
        AS.assertOnItemsDisplayedForAcq();
    }

    @Then("Assert on Copied message of hardwareID")
    public void assertCopiedMsgForPrepayUser() {
        AS.assertCopiedMsg();
    }

    @Then("Assert on items displayed for PAYM user")
    public void TC02_ValidateAppSettingsItemsForPAYMUser() {
        AS.assertOnItemsDisplayed();
    }

    @When("User assert on Reset App screen Title")
    public void TC03_ValidateResetAppFunctionality() {
        AS.assertTitleOfResetAppScreen();
    }

    @When("User navigated to App Settings screen")
    public void TC13_TheUserNavigatedToAppSettingsScreen() {
        AS.UserNavigatedToAppSettingsScreen();
    }

    @Then("Reset app Journey")
    public void TC13_ValidateResetAppJourney() throws IOException {
        AS.assertResetAppJourney();
    }

    @Then("Assert on Reset app card CTA and description")
    public void ValidateResetAppFunctionality() {
        AS.assertOnResetCardCTAandDescription();
    }

    @Given("User opens device permissions screen")
    public void TC04_ValidateDevicePermissionsFunctionality() {
        AS.clickOnDevicePermissionElement();
    }

    @When("Device permission Title is displayed")
    public void assertDevicePermissionsTitle() {
        AS.assertDevicePermissionsTitle();
    }

    @Then("Assert on device permission content")
    public void assertDevicePermissionContent() {
        AS.assertDevicePermissionContent();
    }

//    @Then("Assert on elements for phone card")
//    public void assertElementsForPhoneCard() {
//        AS.assertElementsForPhoneCard();
//    }
//
//    @And("Assert on device location title")
//    public void assertDeviceLocationTitle() {
//        AS.assertDeviceLocationTitle();
//    }
//
//    @And("Assert on elements of location card")
//    public void assertElementsOfLocationCard() {
//        AS.assertElementsOfLocationCard();
//    }
//
//    @And("Assert on Media title")
//    public void assertMediaTitle() {
//        AS.assertMediaTitle();
//    }
//
//    @And("Assert on Media card elements")
//    public void assertElementsOfMediaCard() {
//        AS.assertElementsOfMediaCard();
//    }
//
//    @And("Assert on Usage text")
//    public void assertUsageText() {
//        AS.assertUsageText();
//    }
//
//    @And("Assert on elements of usage card")
//    public void assertElementsOfUsageCard() {
//        AS.assertElementsOfUsageCard();
//    }

    @Given("User clicks on T&C element")
    public void TC05_ValidateTAndCFunctionality() {
        AS.clickOnTandCElement();
    }

    @When("T&C title is displayed")
    public void assertTandCTitle() {
        AS.assertTandCTitle();
    }

    @Then("Assert on T&C Description and Version")
    public void assertTandCDescriptionAndVersion() {
        AS.assertTandCDescriptionAndVersion();
    }

    @Given("User clicks on Login Options element")
    public void TC06_ValidateLoginOptionsBeforeLoginFunctionality() {
        AS.clickOnLoginOptionsElement();
    }
    @Given("I choose PIN as my Login Options")
    public void choosePinLoginOption() {
        AS.choosePinLoginOption();
    }

    @Then("Assert on Login Options elements")
    public void assertOnLoginOptionsScreenElements() {
        AS.assertOnLoginOptionsScreenElements();
    }

    @Given("Click on Set Up your Pin CTA")
    public void clickOnSetUpYourPinCTA() {
        AS.clickOnSetUpYourPinCTA();
    }

    @Then("User completes login flow")
    public void TC07_ValidateLoginOptionsLoginFunctionality() throws InterruptedException, IOException {
        AS.validateLoginOptionsLoginFunctionality();
    }

    @Then("Assert on elements displayed in Login Options screen after login")
    public void TC08_ValidateLoginOptionsAfterLoginFunctionality() {
        AS.assertOnLoginOptionsScreenElementsAfterLogin();
    }

    @And("Click on Reset your Pin CTA")
    public void clickOnResetYourPinCTA() {
        AS.clickOnResetYourPinCTA();
    }


    @Given("Finger print Status is OFF")
    public void TC11_ValidateFingerPrintToggleFunctionality() {
        AS.assertFingerPrintStatus();
    }

    @Then("Turn Finger print status ON")
    public void assertFingerPrintToggleONStatus() {
        AS.assertFingerPrintToggleONStatus();
    }

    @Then("Enter pin to turn status OFF again")
    public void assertTextAfterPinLoginToTurnToggleOFF() {
        AS.assertTextAfterPinLoginToTurnToggleOFF();
    }

    @Given("User click on Reset your PIN CTA")
    public void TC12_ValidateOldPinIsNotWorking() {
        AS.clickOnResetYourPinCTA();
    }

    @When("User login with new PIN")
    public void loginWithNewPin() throws IOException, InterruptedException {
        AS.loginWithNewPin();
    }

    @And("Assert on invalid error message displayed")
    public void assertInvalidPinErrorMessageIsDisplayed() {
        AS.assertInvalidPinErrorMessageIsDisplayed();
    }

    @Then("Check swipe back functionality")
    public void TC13_ValidateSwipeBack() throws IOException {
        AS.ValidateSwipeBack();
    }
    @Then("I validate App settings is displayed")
    public void validateAppSettings() {
        AS.validateAppSettings();
    }
    @Then ("I navigate to App Settings deeplink")
    public void validateAppSettingsDeeplink() {
        AS.validateAppSettingsDeeplink();
    }
}