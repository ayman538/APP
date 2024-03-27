package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ClickToUpgrade.NewPlan.NewPlanAbstract;
import pages.ClickToUpgrade.NewPlan.NewPlanAndroid;
import pages.ClickToUpgrade.NewPlan.NewPlanIOS;

public class NewPlanContinueCTA {
    NewPlanAbstract newPlanPage;

    public NewPlanContinueCTA(Config config) {
        if (config.isAndroid()) {
            newPlanPage = new NewPlanAndroid();
        }

        if (config.isIos()) {
            newPlanPage = new NewPlanIOS();
        }
    }

    @When("the user toggles terms and conditions confirmation")
    public void theUserToggleTermsAndConditionsConfirmation() {
        newPlanPage.toggleTermsAndConditionsConfirmation();
    }
    @And("the user clicks on Continue CTA")
    public void theUserClicksOnContinueCTA() {
        newPlanPage.clickOnContinueCTA();
    }

    @Then("the user redirected to Checkout modal")
    public void theUserRedirectedToCheckoutModal() {
        newPlanPage.verifyThatCheckoutModalIsDisplayed();
    }

}
