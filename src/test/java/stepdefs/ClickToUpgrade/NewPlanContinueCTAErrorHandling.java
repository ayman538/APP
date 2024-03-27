package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.Then;
import pages.ClickToUpgrade.NewPlan.NewPlanAbstract;
import pages.ClickToUpgrade.NewPlan.NewPlanAndroid;
import pages.ClickToUpgrade.NewPlan.NewPlanIOS;

public class NewPlanContinueCTAErrorHandling {
    NewPlanAbstract newPlanPage;

    public NewPlanContinueCTAErrorHandling(Config config) {
        if (config.isAndroid())
            newPlanPage = new NewPlanAndroid();
        if (config.isIos())
            newPlanPage = new NewPlanIOS();
    }

    @Then("the user gets an error screen due to API failure")
    public void theUserGetsErrorScreenDueToApiFailure() {
        newPlanPage.verifyThatApiFailureErrorScreenIsDisplayed();
    }
}
