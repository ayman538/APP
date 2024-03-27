package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Tray.Settings.AccountSetting.SettingsDrawerAndAccountSettingsAbstract;
import pages.Tray.Settings.AccountSetting.SettingsDrawerAndAccountSettingsAndroid;
import pages.Tray.Settings.AccountSetting.SettingsDrawerAndAccountSettingsIOS;

import java.io.IOException;

public class AccountSettingsList {
    SettingsDrawerAndAccountSettingsAbstract settingsDrawerAndAccountSettingsAbstract;

    public AccountSettingsList(Config config) throws IOException {
        if(config.isAndroid()) settingsDrawerAndAccountSettingsAbstract = new SettingsDrawerAndAccountSettingsAndroid();
        if(config.isIos()) settingsDrawerAndAccountSettingsAbstract = new SettingsDrawerAndAccountSettingsIOS();
    }
    @Then("Check Account setting ordering and texts")
    public void CheckAccountSettingOrderingAndTexts(){
        settingsDrawerAndAccountSettingsAbstract.CheckAccountSettingOrderingAndTexts();
    }

    @And("Click on Spend Manager CTA")
    public void clickOnSpendManagerCTA() {

        settingsDrawerAndAccountSettingsAbstract.SpendManagerCTA();
    }

    @Then("I should be directed to Spend Manager Webview")
    public void iShouldBeDirectedToSpendManagerWebview() {

        settingsDrawerAndAccountSettingsAbstract.SpendManagerWebView();
    }

    @And("Click on Cards & Payments CTA")
    public void clickOnCardsPaymentsCTA() {
        settingsDrawerAndAccountSettingsAbstract.CardsAndPaymentsCTA();
    }


    @Then("I should be directed to Manage Cards & Payments Webview")
    public void iShouldBeDirectedToManageCardsPayemntsWebview() {
        settingsDrawerAndAccountSettingsAbstract.ManageCardsAndPaymentsWebview();
    }

    @And("Click on Profile & Address CTA")
    public void clickOnProfileAddressCTA() {
        settingsDrawerAndAccountSettingsAbstract.ClickOnProfileAndAddressCTA();
    }

    @Then("I should be directed to Profile & Address Webview")
    public void iShouldBeDirectedToProfileAddressWebview() {
        settingsDrawerAndAccountSettingsAbstract.ValidateProfileAndAddressWebviewIsDisplayed();
    }

    @And("Click on Data Notifications CTA")
    public void clickOnDataNotificationsCTA() {
        settingsDrawerAndAccountSettingsAbstract.ClickOnDataNotificationsCTA();
    }

    @Then("I should be directed to Data Notifications")
    public void iShouldBeDirectedToDataNotifications() {
        settingsDrawerAndAccountSettingsAbstract.ValidateDataNotificationsWebviewIsDisplayed();
    }

    @And("I click on Activate SIM CTA")
    public void iClickOnActivateSIMCTA() {
        settingsDrawerAndAccountSettingsAbstract.ActivateSimCTA();
    }

    @Then("I should be directed to Activate SIM Webview")
    public void iShouldBeDirectedToActivateSIMWebview() {
        settingsDrawerAndAccountSettingsAbstract.ValidateActivateSimWebviewIsDisplayed();
    }

    @And("I click on SIM Swap CTA")
    public void iClickOnSIMSwapCTA() {
        settingsDrawerAndAccountSettingsAbstract.SimSwapCTA();

    }

    @Then("I should be directed to SIM Swap Webview")
    public void iShouldBeDirectedToSIMSwapWebview() {
        settingsDrawerAndAccountSettingsAbstract.ValidateSimSwapWebviewIsDisplayed();
    }

    @Then("Check Account settings for SMB user")
    public void checkAccountSettingsForSMBUser() {
        settingsDrawerAndAccountSettingsAbstract.validateAccountSettingsForSMB();
    }

    @Then("Check Account settings for PAYG+ user")
    public void checkAccountSettingsForPAYGUser() {
        settingsDrawerAndAccountSettingsAbstract.validateAccountSettingsForPAYGPLUS();
    }

    @And("Validate Logout CTA in Account settings list")
    public void validateLogoutCTAInAccountSettingsList() {
        settingsDrawerAndAccountSettingsAbstract.validateLogoutCTA();
    }

    @And("I click on Logout CTA")
    public void iClickOnLogoutCTA() {
        settingsDrawerAndAccountSettingsAbstract.clickOnLogoutCTA();
    }

    @Then("Logout Popup message appears")
    public void logoutPopupMessageAppears() {
        settingsDrawerAndAccountSettingsAbstract.validateLogoutPopupMessage();
    }

    @And("I tap on each option in manage my SIM screen and validate webpage")
    public void iTapOnEachOptionInManageMySIMScreenAndValidateWebpage() throws InterruptedException {
        settingsDrawerAndAccountSettingsAbstract.checkWebviewsOfManageMySIMList();
    }

    @And("I validate each manage my SIM screen items list")
    public void iValidateEachManageMySIMScreenItemsList() {
        settingsDrawerAndAccountSettingsAbstract.validateManageMySIMList();
    }
}



