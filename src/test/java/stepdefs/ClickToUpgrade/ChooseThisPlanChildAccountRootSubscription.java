package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.Then;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAbstract;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAndroid;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansIOS;

public class ChooseThisPlanChildAccountRootSubscription {
    RecommendedPlansAbstract recommendedPlanPage;

    public ChooseThisPlanChildAccountRootSubscription(Config config) {
        if (config.isAndroid()) {
            recommendedPlanPage = new RecommendedPlansAndroid();
        }
        if (config.isIos()) {
            recommendedPlanPage = new RecommendedPlansIOS();
        }
    }

    @Then("the user gets a full screen error")
    public void theUserGetsFullScreenError() {
        recommendedPlanPage.verifyThatTheChildUserGetsFullScreenError();
    }
}
