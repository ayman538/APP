package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.Then;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAbstract;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAndroid;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansIOS;
import utils.ConfirmedUpgradePlanUtils;

public class CurrentPlanCard {
    RecommendedPlansAbstract recommendedPlansPage;

    public CurrentPlanCard(Config config) {
        if (config.isAndroid())
            recommendedPlansPage = new RecommendedPlansAndroid();
        if (config.isIos())
            recommendedPlansPage = new RecommendedPlansIOS();
    }

    @Then("I should find the correct details in the current plan card")
    public void IShouldFindCorrectDetailsInCurrentPlanCard() {
        recommendedPlansPage.verifyTheCurrentPlanCardDetails();
    }
}
