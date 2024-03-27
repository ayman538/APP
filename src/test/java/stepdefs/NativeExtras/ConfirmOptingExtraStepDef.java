package stepdefs.NativeExtras;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.NativeExtras.ConfirmOptingExtra.ConfirmOptingExtraAbstract;
import pages.NativeExtras.ConfirmOptingExtra.ConfirmOptingExtraLogicAndroid;
import pages.NativeExtras.ConfirmOptingExtra.ConfirmOptingExtraLogicIOS;

public class ConfirmOptingExtraStepDef {
    ConfirmOptingExtraAbstract confirmOptingOutExtraAbstract;

    public ConfirmOptingExtraStepDef(Config config) {
        if (config.isAndroid()) {
            confirmOptingOutExtraAbstract = new ConfirmOptingExtraLogicAndroid();
        }
        if (config.isIos()) {
            confirmOptingOutExtraAbstract = new ConfirmOptingExtraLogicIOS();
        }
    }


    @And("I click on X CTA for Opting Confirmation Tray")
    public void iClickOnXCTAForOptingConfirmationTray() {
        confirmOptingOutExtraAbstract.clickOnXCTAOnRemoveConfirmationTray();
    }

    @And("I click on Opt CTA on the Opting Confirmation Tray")
    public void iClickOnOptCTAOnTheOptingConfirmationTray() {
        confirmOptingOutExtraAbstract.clickOnOptCTAOnOptingConfirmationTray();
    }

    @Then("I should be navigated to {string} Confirmation Tray")
    public void iShouldBeNavigatedToConfirmationTray(String buttonName) {
        confirmOptingOutExtraAbstract.validateConfirmOptOutExtraTrayIsOpened(buttonName);

    }
}
