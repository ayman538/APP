package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.And;
import pages.ClickToUpgrade.NewPlan.NewPlanAbstract;
import pages.ClickToUpgrade.NewPlan.NewPlanAndroid;
import pages.ClickToUpgrade.NewPlan.NewPlanIOS;

public class NewPlanCard {
    NewPlanAbstract newPlanPage;

    public NewPlanCard(Config config) {
        if (config.isAndroid()) {
            newPlanPage = new NewPlanAndroid();
        }

        if (config.isIos()) {
            newPlanPage = new NewPlanIOS();
        }
    }

    @And("the new plan card contains the correct details and features")
    public void theNewPlanCardContainsTheCorrectDetailsAndFeatures() {
        newPlanPage.verifyThatNewPlanCardContainsCorrectDetails();
    }

    @And("I click on see plans button")
    public void iClickOnSeePlansButton() {
       newPlanPage.clickOnSeeAllPlansCTA();
    }
}
