package stepdefs.TC_SubscriptionOverlay.TC_NewPlanTab;

import core.Config;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SubsctionOverlay.NewPlanDesign.HBBUpgrades.HBBUpgradesAbstract;
import pages.SubsctionOverlay.NewPlanDesign.HBBUpgrades.HBBUpgradesAndroid;
import pages.SubsctionOverlay.NewPlanDesign.NewPlanPAYGCardsAbstract;
import pages.SubsctionOverlay.NewPlanDesign.NewPlanPAYGCardsAndroid;
import pages.SubsctionOverlay.NewPlanDesign.NewPlanPAYGCardsIOS;

public class HBBUpgrades {

    HBBUpgradesAbstract HBBUpgradesLogic;

    public HBBUpgrades(Config config) {
        if (config.isAndroid())
            HBBUpgradesLogic = new pages.SubsctionOverlay.NewPlanDesign.HBBUpgrades.HBBUpgradesAndroid();
        if (config.isIos()) HBBUpgradesLogic = new pages.SubsctionOverlay.NewPlanDesign.HBBUpgrades.HBBUpgradesIOS();
    }

    @Then("Validate HBB Upgrade Eligibility Card")
    public void ValidateUpgradeEligibilityCardForHBB() {
        HBBUpgradesLogic.ValidateUpgradeEligibilityCardForHBB();
    }

    @Then("I Click on Check Upgrade Eligibility CTA")
    public void assertCheckUpgradeEligibilityCTA() {
        HBBUpgradesLogic.ClickOnHBBEligibilityCTA();
    }

    @When("user clicks on Your Plan control tile")
    public void userClicksOnYourPlanControlTile() {
        HBBUpgradesLogic.ClickOnYourPlanHBB();
    }

    @Then("I should be directed to the Upgrade Eligibility Check journey")
    public void TC02_ValidateNewPlanPageOffersCardCTAForBVB() {
        HBBUpgradesLogic.ValidateCheckEligibilityCTAJourney();
    }

}
