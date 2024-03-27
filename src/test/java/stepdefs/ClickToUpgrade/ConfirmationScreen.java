package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ClickToUpgrade.NewPlan.NewPlanAbstract;
import pages.ClickToUpgrade.NewPlan.NewPlanAndroid;
import pages.ClickToUpgrade.NewPlan.NewPlanIOS;

public class ConfirmationScreen {
    NewPlanAbstract newPlanPage;

    public ConfirmationScreen(Config config) {
        if (config.isAndroid()) {
            newPlanPage = new NewPlanAndroid();
        }
        if (config.isIos()) {
            newPlanPage = new NewPlanIOS();
        }
    }

    @When("the user clicks on confirm CTA")
    public void theUserClicksOnConfirmCTA() {
        newPlanPage.clickOnConfirmThisChangeCTA();
    }

    @Then("the confirmation screen appears")
    public void theConfirmationScreenAppears() {
        newPlanPage.verifyThatTheConfirmationScreenAppears();
    }
}
