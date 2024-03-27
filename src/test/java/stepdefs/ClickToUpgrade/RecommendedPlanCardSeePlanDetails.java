package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAbstract;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAndroid;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansIOS;

public class RecommendedPlanCardSeePlanDetails {
    RecommendedPlansAbstract recommendedPlanPage;
    public RecommendedPlanCardSeePlanDetails(Config config) {
        if (config.isAndroid())
            recommendedPlanPage = new RecommendedPlansAndroid();
        if (config.isIos())
            recommendedPlanPage = new RecommendedPlansIOS();
    }

    @And("I click on see plan details button")
    public void clickOnSeePlanDetailsButton() {
        recommendedPlanPage.clickOnSeePlanDetailsButton();
    }

    @Then("I should redirected to see plan details page")
    public void IShouldRedirectedToSeePlanDetailsPage() {
        recommendedPlanPage.verifyThatTheUserIsAtSeePlanDetailsWebview();
    }

}
