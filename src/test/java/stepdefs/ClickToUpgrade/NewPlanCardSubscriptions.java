package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.Then;
import pages.ClickToUpgrade.NewPlan.NewPlanAbstract;
import pages.ClickToUpgrade.NewPlan.NewPlanAndroid;
import pages.ClickToUpgrade.NewPlan.NewPlanIOS;

public class NewPlanCardSubscriptions {
    NewPlanAbstract newPlanPage;
    public NewPlanCardSubscriptions(Config config) {
        if (config.isAndroid())
            newPlanPage = new NewPlanAndroid();
        if (config.isIos())
            newPlanPage = new NewPlanIOS();
    }

    @Then("the user can see the free subscriptions in the new plan card")
    public void theUserCanSeeTheFreeSubscriptionsInTheNewPlanCard() {
        newPlanPage.verifyThatNewPlanCardSubscriptionsDisplayed();
    }
}
