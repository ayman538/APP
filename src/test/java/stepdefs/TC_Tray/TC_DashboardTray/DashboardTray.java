package stepdefs.TC_Tray.TC_DashboardTray;

import core.Config;
import io.cucumber.java.en.Then;
import pages.Tray.DashboardTray.DashboardTrayAbstract;
import pages.Tray.DashboardTray.DashboardTrayAndroid;
import pages.Tray.DashboardTray.DashboardTrayIOS;

public class DashboardTray {

    DashboardTrayAbstract DashboardTrayObject;

    public DashboardTray(Config config) {
        if (config.isAndroid()) DashboardTrayObject = new DashboardTrayAndroid();
        if (config.isIos()) DashboardTrayObject = new DashboardTrayIOS();
    }

    @Then("Validate MyAccount item in dashboard tray")
    public void TC01_ValidateMyAccountDashboardTray() {
        DashboardTrayObject.ValidateMyAccount();
    }

    @Then("Validate Rewards and very me item in dashboard tray")
    public void TC02_ValidateRewardstDashboardTray() {
        DashboardTrayObject.ValidateVeyMeOrRewards();
    }

    @Then("Validate Billing and top up item in dashboard tray")
    public void TC03_ValidateBillingstDashboardTray() {
        DashboardTrayObject.ValidateBillingOrTopUp();
    }


    @Then("Validate Settings item in dashboard tray")
    public void TC04_ValidateSettingstDashboardTray() {
        DashboardTrayObject.ValidateSettings();
    }

    @Then("Validate Close Tobi CTA")
    public void TC06_ValidateCloseTobiDashboardTray() {
        DashboardTrayObject.checkCloseTobi();
    }

    @Then("Validate Tobi is clickable")
    public void TC07_Validate() {
        DashboardTrayObject.checkCloseTobi();
    }

    @Then("I should see the TOBI prompt when I click on Tobi using returning user with Biometrics preference")
    public void TC08_ValidateTobiPromptDisplayed() {
        DashboardTrayObject.clickTobiUsingReturningUserWithBioPref();
    }
    @Then("I click on Skip Login CTA on Tobi Prompt")
    public void TC09_clickSkipLoginForTobiPrompt() {
        DashboardTrayObject.clickSkipLoginForTobiPrompt();
    }

    @Then("I click on X icon for the tobi prompt")
    public void clickOnXIconForThePrompt() {
        DashboardTrayObject.clickOnXIconForThePrompt();
    }

    @Then("I should see the tobi chat")
    public void iShouldSeeTheTobiChat() {
        DashboardTrayObject.validateTobiChatisOpen();
    }

    @Then("I navigate to TOBI")
    public void navigateToTobi(){
        DashboardTrayObject.navigateToTobi();
    }
}

