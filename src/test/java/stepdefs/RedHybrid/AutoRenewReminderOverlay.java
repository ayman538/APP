package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_scouse.An;
import pages.RedHybrid.AutoRenewReminder.AutoRenewReminderAndroid;
import pages.RedHybrid.AutoRenewReminder.AutoRenewReminderIOS;
import pages.RedHybrid.AutoRenewReminder.AutoRenewReminderOverlayAbstract;

public class AutoRenewReminderOverlay {
    private AutoRenewReminderOverlayAbstract AutoRenewReminder_abstract;

    public AutoRenewReminderOverlay(Config config) {
        if (config.isAndroid()) AutoRenewReminder_abstract= new AutoRenewReminderAndroid();
        if (config.isIos()) AutoRenewReminder_abstract = new AutoRenewReminderIOS();
    }

    @Then("check Auto renew Overlay UI")
    public void checkAutoRenewOverlayUI() throws InterruptedException {
        AutoRenewReminder_abstract.checkAutoRenewOverlayUI();
    }

    @And("click On Turn on CTA")
    public void clickOnTurnOnCTA(){
        AutoRenewReminder_abstract.clickOnTurnOnCTA();
    }

    @And("Plan tab Is Displayed")
    public void planTabIsDisplayed(){
        AutoRenewReminder_abstract.planTabIsDisplayed();
    }
}

