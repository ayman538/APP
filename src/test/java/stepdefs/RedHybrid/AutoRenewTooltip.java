package stepdefs.RedHybrid;

import core.Config;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.AutoRenewTooltip.AutoRenewTooltipAbstract;
import pages.RedHybrid.AutoRenewTooltip.AutoRenewTooltipAndroid;
import pages.RedHybrid.AutoRenewTooltip.AutoRenewTooltipIOS;


public class AutoRenewTooltip {

    private AutoRenewTooltipAbstract Tooltip;

    public AutoRenewTooltip(Config config) {
        if (config.isAndroid()) Tooltip= new AutoRenewTooltipAndroid();
        if (config.isIos()) Tooltip = new AutoRenewTooltipIOS();
    }



    @And("Validate and Click on i ICon")
    public void validateAndClickOnIICon() {
        Tooltip.SubmitiIcon();

    }

    @Then("AutoRenew Tip will displayed successfully")
    public void autorenewTipWillDisplayedSuccessfully() {
        Tooltip.ValidateAutoRenewTip();
    }

    @When("Navigate to redhybrid plan")
    public void navigateToRedhybridPlan() throws InterruptedException {
        Tooltip.navigateToPlan();

    }
}
