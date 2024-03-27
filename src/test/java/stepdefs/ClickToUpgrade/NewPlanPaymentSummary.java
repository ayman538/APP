package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.*;
import pages.ClickToUpgrade.NewPlan.NewPlanAbstract;
import pages.ClickToUpgrade.NewPlan.NewPlanAndroid;
import pages.ClickToUpgrade.NewPlan.NewPlanIOS;

public class NewPlanPaymentSummary {
    NewPlanAbstract newPlanPage;

    public NewPlanPaymentSummary(Config config) {
        if (config.isAndroid()) {
            newPlanPage = new NewPlanAndroid();
        }

        if (config.isIos()) {
            newPlanPage = new NewPlanIOS();
        }
    }

    @And("the payment summary section contains the correct details")
    public void thePaymentSummarySectionContainsTheCorrectDetails() {
        newPlanPage.verifyThatNewPlanPaymentSummaryContainsCorrectDetails();
    }

}
