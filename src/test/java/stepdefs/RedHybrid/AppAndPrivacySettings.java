package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.AppAndPrivacySettings.AppAndPrivacySettingsAbstract;
import pages.RedHybrid.AppAndPrivacySettings.AppAndPrivacySettingsAndroid;
import pages.RedHybrid.AppAndPrivacySettings.AppAndPrivacySettingsIOS;
import pages.Tray.Settings.PrivacySetting.PrivacySettingsAbstract;
import pages.Tray.Settings.PrivacySetting.PrivacySettingsAndroid;
import pages.Tray.Settings.PrivacySetting.PrivacySettingsIOS;

import java.io.IOException;

public class AppAndPrivacySettings {

    AppAndPrivacySettingsAbstract appAndPrivacySettingsAbstract;
    PrivacySettingsAbstract privacySettingsLogic;

    public AppAndPrivacySettings(Config config) throws IOException {
        if(config.isAndroid()){
            appAndPrivacySettingsAbstract = new AppAndPrivacySettingsAndroid();
            privacySettingsLogic = new PrivacySettingsAndroid();
        }
        if(config.isIos()){
            appAndPrivacySettingsAbstract = new AppAndPrivacySettingsIOS();
            privacySettingsLogic = new PrivacySettingsIOS();
        }
    }


    @When("user clicks on Settings in Dashboard tray")
    public void clickOnSettingsInTray(){
        appAndPrivacySettingsAbstract.clickOnSettingIcon();
    }
    @And("Settings drawer appeared successfully")
    public void settingsDrawerIsOpened(){
        appAndPrivacySettingsAbstract.settingsDrawer();
    }

    @When ("user clicks on App in settings drawer")
    public void clickOnAppSettings(){
        appAndPrivacySettingsAbstract.clickOnAppSettingIcon();
    }
    @Then("App Settings for Red Hybrid user appeared successfully")
    public void checkUiOfAppSettings(){
        appAndPrivacySettingsAbstract.checkUIOfAppSettings();
    }

    @And ("user clicks on reset the app link")
    public void clickOnResetAppLink(){
        appAndPrivacySettingsAbstract.clickOnResetAppLink();
    }
    @Then ("reset the app screen appeared successfully")
    public void checkResetAppScreen(){
        appAndPrivacySettingsAbstract.checkResetAppScreen();
    }

    @When ("user clicks on Login options link")
    public void clickOnLoginOptionsLink(){
        appAndPrivacySettingsAbstract.clickOnLoginOptionsLink();
    }
    @Then ("Login options screen appeared successfully")
    public void checkLoginOptionsScreen(){
        appAndPrivacySettingsAbstract.checkLoginOptionsScreen();
    }

    @When ("user clicks on Device permissions link")
    public void clickOnDevicePermissionsLink(){
        appAndPrivacySettingsAbstract.clickOnDevicePermissionsLink();
    }
    @Then ("Device permissions screen appeared successfully")
    public void checkDevicePermissionsScreen(){
        appAndPrivacySettingsAbstract.checkDevicePermissionsScreen();
    }

    @When ("user clicks on Terms and Conditions link")
    public void clickOnTermsAndConditionsLink(){
        appAndPrivacySettingsAbstract.clickOnTermsAndConditionsLink();
    }
    @Then ("Terms and Conditions screen appeared successfully")
    public void checkTermsAndConditionsScreen(){
        appAndPrivacySettingsAbstract.checkTermsAndConditionsScreen();
    }

    @When ("user clicks on Privacy in settings drawer")
    public void clickOnPrivacyIcon(){
        appAndPrivacySettingsAbstract.clickOnPrivacySettingIcon();
    }
    @And ("Privacy Settings for Red Hybrid user appeared successfully")
    public void checkPrivacySettingsScreen(){
        appAndPrivacySettingsAbstract.checkPrivacySettingsScreen();
    }

    @Then ("click on app privacy and validate screen the screen content")
    public void checkAppPrivacyScreen(){
        privacySettingsLogic.validateAppPrivacyTailored();
    }


    @Then("check App Privacy Supplement screen content appeared successfully")
    public void appPrivacySupplementScreenAppearedSuccessfully() {
        appAndPrivacySettingsAbstract.checkAppPrivacySupplementScreen();
    }

    @And("user clicks on Vodafone Privacy Portal link")
    public void userClicksOnVodafonePrivacyPortalLink() {
        appAndPrivacySettingsAbstract.clickOnVodafonePrivacyPortalLink();
    }

    @Then("Vodafone Privacy Portal screen appeared successfully")
    public void vodafonePrivacyPortalScreenAppearedSuccessfully() {
        appAndPrivacySettingsAbstract.checkVodafonePrivacyPortalScreen();
    }

    @And("user clicks on Marketing preferences link")
    public void userClicksOnMarketingPreferencesLink() {
        appAndPrivacySettingsAbstract.clickOnMarketingPreferencesLink();
    }

    @Then("check Marketing preferences screen content appeared successfully")
    public void checkMarketingPreferencesScreenContentAppearedSuccessfully() {
        appAndPrivacySettingsAbstract.checkOnMarketingPreferencesScreen();
    }
}
