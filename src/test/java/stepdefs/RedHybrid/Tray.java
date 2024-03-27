package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.DashboardTray.RedHybrid_DashboardTray_Abstract;
import pages.RedHybrid.DashboardTray.RedHybrid_DashboardTray_Android;
import pages.RedHybrid.DashboardTray.RedHybrid_DashboardTray_PO;
import pages.RedHybrid.DashboardTray.RedHybrid_DashboardTray_iOS;

public class Tray {

    RedHybrid_DashboardTray_PO PO = new RedHybrid_DashboardTray_PO();
    RedHybrid_DashboardTray_Abstract RedHybridLogic;
    public Tray(Config config) {
        if (config.isAndroid()){
            RedHybridLogic = new RedHybrid_DashboardTray_Android();
        }
        if (config.isIos()) {
            RedHybridLogic = new RedHybrid_DashboardTray_iOS();
        }
    }

    @Then("Validate All Tray Components")
    public void validateAllTrayComponents() {
        RedHybridLogic.validateTrayItems();
    }

    @Then("Validate My Account")
    public void validateMyAccount() throws InterruptedException {
        RedHybridLogic.checkTargetOfMyAccount();
    }

    @Then("Validate Veryme")
    public void validateVeryme() throws InterruptedException {
        RedHybridLogic.checkTargetOfVeryMe();
    }

    @Then("I navigate to TOBi and validate it is opened then close it")
    public void validateTOBi() throws InterruptedException {
        RedHybridLogic.checkTargetOfTOBi();
    }
    @Then("I Close TOBi")
    public void closeTOBi() throws InterruptedException {
        RedHybridLogic.CloseTobi();
    }

    @Then("Validate Payment")
    public void validatePayment() throws InterruptedException {
        RedHybridLogic.checkTargetOfPayments();
    }

    @Then("Validate Settings in Tray")
    public void validateSettingsInTray() throws InterruptedException {
        RedHybridLogic.checkTargetOfSettings();
    }

    @When("User on Login and Skip login")
    public void userOnLoginAndSkipLogin() {
        RedHybridLogic.DismissSkipLoginScreen();
    }

    @When("I navigate to payment tray from Dashboard")
    public void clickOnPayment() throws InterruptedException {
        RedHybridLogic.clickOnPaymentTray();
    }


    @When("click on my account")
    public void clickOnMyAccount() throws InterruptedException {
        RedHybridLogic.clickOnMyAccount();
    }
    @When("I click on my account without login")
    public void clickOnMyAccountTray() throws InterruptedException {
        RedHybridLogic.clickOnMyAccountTray();
    }


    @When("click on Payments on dashboard tray")
    public void clickOnPaymentsOnDashboardTray() throws InterruptedException {
        RedHybridLogic.clickOnPayment();
    }

    @When("click on my Settings on dashboard tray")
    public void clickOnMySettingsOnDashboardTray() {
        RedHybridLogic.clickOnSettings();
    }

    @Then("Validate that the dashboard tray hidden under My account")
    public void validateThatTheDashboardTrayHiddenUnderTheDrawer() {
        RedHybridLogic.validateThatTheDashboardTrayHiddenUnderMyAccount();
    }

    @Then("Validate that the dashboard tray hidden under Payments")
    public void validateThatTheDashboardTrayHiddenUnderPayments() {
        RedHybridLogic.validateThatTheDashboardTrayHiddenUnderPayments();
    }

    @Then("Validate that the dashboard tray hidden under Settings")
    public void validateThatTheDashboardTrayHiddenUnderSettings() {
        RedHybridLogic.validateThatTheDashboardTrayHiddenUnderSettings();
    }

    @When("Open Tobi and Send {string} Message")
    public void openTobiAndSendAsAMessage(String Message) throws InterruptedException {
        RedHybridLogic.OpenTobiAndSendMessage(Message);
    }

    @Then("TOBi should respond With {string}")
    public void tobiShouldRespondWith(String Message ) {
        RedHybridLogic.CheckTobiResponse(Message);
    }

    @Then("I should navigate to My account overlay")
    public void iShouldNavigateToMyAccountOverlay() throws InterruptedException {
        RedHybridLogic.checkTargetOfMyAccount();
    }
}
