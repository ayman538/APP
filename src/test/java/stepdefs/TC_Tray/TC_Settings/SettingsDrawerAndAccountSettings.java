package stepdefs.TC_Tray.TC_Settings;

import core.Config;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import pages.Tray.Settings.AccountSetting.SettingsDrawerAndAccountSettingsAbstract;
import pages.Tray.Settings.AccountSetting.SettingsDrawerAndAccountSettingsAndroid;
import pages.Tray.Settings.AccountSetting.SettingsDrawerAndAccountSettingsIOS;

import java.io.IOException;


public class SettingsDrawerAndAccountSettings {

    SettingsDrawerAndAccountSettingsAbstract SD;
    SettingsDrawerAndAccountSettingsAndroid SD_Android;

    public SettingsDrawerAndAccountSettings(Config config) throws IOException {
        if (config.isAndroid()) SD = new SettingsDrawerAndAccountSettingsAndroid();
        if (config.isAndroid()) SD_Android = new SettingsDrawerAndAccountSettingsAndroid();
        if (config.isIos()) SD = new SettingsDrawerAndAccountSettingsIOS();
    }

    @Then("Validate Setting Drawer Items")
    public void ValidateSettingsDrawerItems() {
        SD.ValidateSettingsDrawerItems();
    }

    @Then("Validate Account Settings Items")
    public void ValidateAccountSettingsItems() {
        SD.ValidateAccountSettingsItems();
    }

    @Then("Validate Account Settings Items for MBB")
    public void ValidateAccountSettingsItemsMBB() throws ParseException, InterruptedException, IOException {
        SD.ValidateSettingsDrawerForSubscription("MBB");
    }

    @Then("Validate Account Settings Items for FLN")
    public void ValidateSettingsDrawerForFLNUsers() throws ParseException, InterruptedException, IOException {
        SD.ValidateAccountSettingsNotDisplayedInDrawer();
    }

    @Then("Validate Account Settings Items for BB")
    public void ValidateSettingsDrawerForHBBUsers() throws ParseException, InterruptedException, IOException {
        SD.ValidateAccountSettingsNotDisplayedInDrawer();
    }

    @When("I click on settings from dashboard Tray")
    public void clickOnSettings(){
        SD.clickOnSettings();
    }
   @Then("I validate the 'X' CTA in Settings Drawer")
   public void validateXCTAinSettings(){
       SD.validateXCTAinSettings();
   }
    @Then("Validate New Settings Drawer Items")
    public void validateSettings(){
        SD.validateSettings();
    }
    @Then("Validate changes of SettingsItems in Dashboard api for App Settings for PaymUser")
    public void validateSettingsItemsinDashboardApiforAppSettings(){
        SD_Android.validateSettingsItemsinDashboardApiforAppSettings();
    }
    @Then("Validate changes of SettingsItems in Dashboard api for Privacy Settings for PaymUser")
    public void validateSettingsItemsinDashboardApiforPrivacySetings(){
        SD_Android.validateSettingsItemsinDashboardApiforPrivacySettings();
    }
}
