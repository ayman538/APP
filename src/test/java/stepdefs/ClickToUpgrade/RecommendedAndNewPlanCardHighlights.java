package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.Then;
import pages.ClickToUpgrade.NewPlan.NewPlanAbstract;
import pages.ClickToUpgrade.NewPlan.NewPlanAndroid;
import pages.ClickToUpgrade.NewPlan.NewPlanIOS;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAbstract;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAndroid;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansIOS;

public class RecommendedAndNewPlanCardHighlights {
    RecommendedPlansAbstract recommendedPlansPage;
    NewPlanAbstract newPlanPage;
    public RecommendedAndNewPlanCardHighlights(Config config) {
        if (config.isAndroid()) {
            recommendedPlansPage = new RecommendedPlansAndroid();
            newPlanPage = new NewPlanAndroid();
        }
        if (config.isIos()) {
            recommendedPlansPage = new RecommendedPlansIOS();
            newPlanPage = new NewPlanIOS();
        }
    }

    @Then("I should find the recommended plan card highlights displayed")
    public void IShouldFindTheRecommendedPlanCardHighlightsDisplayed() {
        recommendedPlansPage.verifyThatTheRecommendedPlanHighlightsDisplayed();
    }

    @Then("I should find the new plan card highlights displayed")
    public void IShouldFindTheNewPlanCardHighlightsDisplayed() {
        newPlanPage.verifyThatNewPlanCardHighlightsDisplayed();
    }
}
