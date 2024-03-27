package stepdefs.RedHybrid;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.RedHybrid.ConfirmChangePlanOverlay.ConfirmChangePlanOverlay_Abstract;
import pages.RedHybrid.ConfirmChangePlanOverlay.ConfirmChangePlanOverlay_AndroidLogic;
import pages.RedHybrid.ConfirmChangePlanOverlay.ConfirmChangePlanOverlay_iOSLogic;

public class ConfirmChangePlanOverlay {
    ConfirmChangePlanOverlay_Abstract confirmChangePlanOverlay_abstract;

    public ConfirmChangePlanOverlay(Config config) {
        if (config.isAndroid()) {
            confirmChangePlanOverlay_abstract = new ConfirmChangePlanOverlay_AndroidLogic();
        }
        if (config.isIos()) {
            confirmChangePlanOverlay_abstract = new ConfirmChangePlanOverlay_iOSLogic();
        }
    }


    @And("I clicks on Continue CTA")
    public void userClicksContinueCTA() {
        confirmChangePlanOverlay_abstract.clickContinueCTA();
    }

    @And("Change Plan Overlay should appear")
    public void changePlanOverlayShouldAppear() {
        confirmChangePlanOverlay_abstract.changePlanOverlayAppears();
    }

    @Then("Change Plan Overlay should comply with UI on Figma")
    public void changePlanOverlayShouldComplyWithUIOnFigma() throws JsonProcessingException, InterruptedException {
        confirmChangePlanOverlay_abstract.changePlanOverlayUiIsCorrect();
    }

    @And("I should be click on Turn on Auto-Renew Toggle")
    public void iShouldBeClickOnTurnOnAutoRenewToggle() {
        confirmChangePlanOverlay_abstract.clickOnTurnOnCTA();
    }
}
