package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.Then;
import pages.RedHybrid.RenewPlanEarly.RenewPlanEarly_Abstract;
import pages.RedHybrid.RenewPlanEarly.RenewPlanEarly_Android;
import pages.RedHybrid.RenewPlanEarly.RenewPlanEarly_iOS;

public class RenewPlanEarly {
    private RenewPlanEarly_Abstract renewPlanEarly_Op;

    public RenewPlanEarly(Config config) {
        if (config.isAndroid()) {
            renewPlanEarly_Op = new RenewPlanEarly_Android();
        }
        if (config.isIos()) {
            renewPlanEarly_Op = new RenewPlanEarly_iOS();
        }
    }

    @Then("I should be directed to Renew_plan_early_overlay")
    public void userShouldBeDirectedToRenew_plan_early_overlay() {
        renewPlanEarly_Op.renewEarlyOverlayAppears();

    }

    @Then("I Should Validate Renew plan early overlay UI")
    public void iShouldValidateRenewPlanEarlyOverlayUI() throws InterruptedException {
        renewPlanEarly_Op.RenewEarlyScreenUIValidation();
    }
}
