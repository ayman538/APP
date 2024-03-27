package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.Then;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_Abstract;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_Android;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_IOS;
import pages.RedHybrid.ViewPlanTile.RedHybrid_ViewPlanTile_Abstract;
import pages.RedHybrid.ViewPlanTile.RedHybrid_ViewPlanTile_Android;
import pages.RedHybrid.ViewPlanTile.RedHybrid_ViewPlanTile_IOS;


public class ViewPlanTile {
    RedHybrid_ViewPlanTile_Abstract AbstractObject;
    private RedHybrid_PaymentReminderOverlay_Abstract redHybrid_paymentReminderOverlay_abstract;

    public ViewPlanTile(Config config) {
        if (config.isAndroid()) {
            redHybrid_paymentReminderOverlay_abstract = new RedHybrid_PaymentReminderOverlay_Android();
            AbstractObject = new RedHybrid_ViewPlanTile_Android();
        }

        if (config.isIos()) {
            redHybrid_paymentReminderOverlay_abstract = new RedHybrid_PaymentReminderOverlay_IOS();
            AbstractObject = new RedHybrid_ViewPlanTile_IOS();
        }
    }

    @Then("Validate the plan card")
    public void validateThePlanCard() {
        try {
            redHybrid_paymentReminderOverlay_abstract.clickOnBackToVodafoneCTA();
        } catch (Exception exception) {
            System.out.println("No overlay appeared");
        }
        AbstractObject.ValidatePlanTile();
    }


}
