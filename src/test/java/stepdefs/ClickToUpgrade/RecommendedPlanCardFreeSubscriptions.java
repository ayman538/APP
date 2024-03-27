package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.Then;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAbstract;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAndroid;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansIOS;

public class RecommendedPlanCardFreeSubscriptions {
    RecommendedPlansAbstract recommendedPlansPage;
    public RecommendedPlanCardFreeSubscriptions(Config config) {
        if (config.isAndroid())
            recommendedPlansPage = new RecommendedPlansAndroid();
        if (config.isIos())
            recommendedPlansPage = new RecommendedPlansIOS();
    }

    @Then("the user can see the free subscriptions")
    public void theUserCanSeeTheFreeSubscriptions() {
        recommendedPlansPage.verifyThatFreeSubscriptionsDisplayed();
    }

}
