package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.UsageCard.RedHybrid_UsageCardLogic_Android;
import pages.RedHybrid.UsageCard.RedHybrid_UsageCardLogic_IOS;
import pages.RedHybrid.UsageCard.RedHybrid_UsageCard_Abstract;

public class RedHybrid_UsageCard {
    RedHybrid_UsageCard_Abstract redHybrid_usageCard;

    public RedHybrid_UsageCard(Config config) {
        if (config.isAndroid())
            redHybrid_usageCard = new RedHybrid_UsageCardLogic_Android();
        if (config.isIos()) {
            redHybrid_usageCard = new RedHybrid_UsageCardLogic_IOS();

        }
    }

    @When("user dismiss the add payment method overlay")
    public void userDismissTheAddPaymentMethodOverlay() {
        redHybrid_usageCard.addPaymentMethodOverlayDismiss();
    }

    @Given("I navigate to subscriptions overlay")
    public void userNavigatesToSubscriptionsOverlay()  {
        redHybrid_usageCard.navigateToSubsOverLay();
    }

    @When("I navigate to usage tab from subscriptions overlay")
    public void userTabsOnUsageTab()  {
        redHybrid_usageCard.navigateToUsage();
    }

    @Then("usage tab should be displayed")
    public void usageTabShouldBeDisplayed() {
        redHybrid_usageCard.validateRHUsageCardUI();
    }


    @Then("data is mapped correctly between usage API response and UI")
    public void dataIsMappedCorrectlyBetweenUsageAPIResponseAndUI() {
        redHybrid_usageCard.usageAPIDataMappingValidation();
    }


// For Active Extras Card Assertion

    @Then("Validate content of Active Extras Card for user that has active Extras")
    public void ValidateContentOfActiveExtrasCard(){
        redHybrid_usageCard.ValidateContentOfActiveExtrasCard();
        redHybrid_usageCard.CheckQuantitySuffixWord();
    }


    @Then("Validate that Add Extras CTA is removed")
    public void ValidateThatAddExtrasCTAIsRemoved(){
        redHybrid_usageCard.ValidateThatAddExtrasCTAIsRemoved();
    }


}