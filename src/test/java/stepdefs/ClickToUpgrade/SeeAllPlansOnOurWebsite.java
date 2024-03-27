package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAbstract;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAndroid;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansIOS;

public class SeeAllPlansOnOurWebsite {
    RecommendedPlansAbstract recommendedPlansPage;

    public SeeAllPlansOnOurWebsite(Config config) {
        if (config.isAndroid()) {
            recommendedPlansPage = new RecommendedPlansAndroid();
        }

        if (config.isIos()) {
            recommendedPlansPage = new RecommendedPlansIOS();
        }
    }

    @And("the user clicks on see all plans on our website CTA")
    public void theUserClicksOnSeeAllPlansOnOurWebsiteCTA(){
        recommendedPlansPage.clickOnSeeAllPlansOnOurWebsite();
    }

    @Then("the user redirected to the webview with all plans")
    public void theUserRedirectedToTheWebViewWithAllPlans() {
        recommendedPlansPage.verifyThatTheUserIsAtAllPlansWebsite();
    }
}
