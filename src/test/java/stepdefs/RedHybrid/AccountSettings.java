package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.AccountSettings.RedHybrid_AccountSettings_Abstract;
import pages.RedHybrid.AccountSettings.RedHybrid_AccountSettings_Android;
import pages.RedHybrid.AccountSettings.RedHybrid_AccountSettings_iOS;


public class AccountSettings {

     RedHybrid_AccountSettings_Abstract accountSettingsAbstract;

    public AccountSettings(Config config) {
        if (config.isAndroid()) accountSettingsAbstract = new RedHybrid_AccountSettings_Android();
        if (config.isIos()) accountSettingsAbstract = new RedHybrid_AccountSettings_iOS();

    }


    @And("click on account setting")
    public void clickOnAccountSetting() {
        accountSettingsAbstract.clickOnAccount();
    }

    @Then("I should validate Account Settings Items")
    public void validateAccountSettingsItemsTextAndArrangement() {
        accountSettingsAbstract.validateAccountSettingsTitlesAndArrangement();

    }

    @And("close my account sheet")
    public void closeMyAccountSheet() {
        accountSettingsAbstract.closeMyAccountSheet();
    }


    @When("I click on {string}")
    public void iClickOnLink(String linkName) {
        accountSettingsAbstract.iClickOnLink(linkName);
    }

    @Then("I navigate to the {string} Page")
    public void iNavigateToThePage(String PageTitle) throws InterruptedException {
        accountSettingsAbstract.iNavigateToThePage(PageTitle);
    }


    @Then("Validate Data Notifications item not appears in Account settings")
    public void validateDataNotificationsItemNotAppearsInAccountSettings() {
        accountSettingsAbstract.validateDataNotificationsNotAppearInAccountSettings();
    }

    @Then("Validate Accessibility item appear in Account settings")
    public void validateAccessibilityItemAppearInAccountSettings() {
        accountSettingsAbstract.validateAccessibilityAppearInAccountSettings();
    }
}

