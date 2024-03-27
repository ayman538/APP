package stepdefs.TC_SubscriptionOverlay.TC_NewPlanTab;

import core.Config;
import io.cucumber.java.en.Then;
import pages.SubsctionOverlay.NewPlanDesign.*;

public class PlanCardsForPAYGUsersTCs {

    NewPlanPAYGCardsAbstract newPlanDesignLogic;

    public PlanCardsForPAYGUsersTCs(Config config) {
        if (config.isAndroid()) {
            newPlanDesignLogic = new NewPlanPAYGCardsAndroid();
        }
        if (config.isIos()) {
            newPlanDesignLogic = new NewPlanPAYGCardsIOS();
        }
    }

    @Then("Validate Plan Offers Card for BVB users")
    public void TC01_ValidateNewPlanPageOffersCardForBVB() {
        newPlanDesignLogic.ValidateNewPlanPageOffersCardForBVB();
    }

    @Then("Validate Plan Offers Card CTA for BVB users")
    public void TC02_ValidateNewPlanPageOffersCardCTAForBVB() {
        newPlanDesignLogic.ValidateNewPlanPageOffersCardCTAForBVB();
    }

    @Then("Validate Plan Tab for PAYG simply or PAYG1 users")
    public void TC03_ValidateNewPlanPageForPAYG() {
        newPlanDesignLogic.ValidateNewPlanPageForPAYG();
    }

    @Then("Validate Plan Tab CTA for PAYG simply or PAYG1 users")
    public void TC04_ValidateNewPlanPageForPAYGCTA() {
        newPlanDesignLogic.ValidateNewPlanPageForPAYGCTA();
    }

    @Then("Validate Plan Tab for PAYG1 users")
    public void TC04_ValidateNewPlanPageForPAYG1() {
        newPlanDesignLogic.ValidateNewPlanPageForPAYG1Content();
        newPlanDesignLogic.ValidateNewPlanPageForPAYG1CTAs();
    }
}
