package stepdefs.RedHybrid;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.RedHybrid.PlanCard.RedHybrid_PlanCard;


public class RedHybrid_PlanCardTCs {

    RedHybrid_PlanCard RedHybrid_PlanCard;

    public RedHybrid_PlanCardTCs(Config config) {
        if (config.isAndroid()) {
            RedHybrid_PlanCard = new pages.RedHybrid.PlanCard.RedHybrid_PlanCardLogic_Android();
        }
        if (config.isIos()) {
            RedHybrid_PlanCard = new pages.RedHybrid.PlanCard.RedHybrid_PlanCardLogic_iOS();
        }

    }

    @Then("ValidatePlanCardForRedHybrid")
    public void validateplancardforredhybrid() {
        RedHybrid_PlanCard.ValidatePlanCardUI();
    }

    /*@Given("RedHybrid Dashboard Is Displayed")
    public void redhybridDashboardIsDisplayed() {
        RedHybrid_PlanCard.dashboardIsDisplayed();
    }*/

    @Given("RedHybrid Navigated to Plantab")
    public void redhybridnavigatedtoplanTab() throws InterruptedException {
        RedHybrid_PlanCard.navigateToPlan();
    }

    @Then("Validate Includes Displaying")
    public void validateIncludesDisplaying() {
        RedHybrid_PlanCard.ValidateIncludesDisplayingAfterClickingShowmore();
    }


    @And("add card hyberLink Displayed is {string}")
    public void addCardHyberLinkDisplayedIs(String displayed) {
        RedHybrid_PlanCard.addCardHyperLinkValidation(displayed);
    }

    @And("user closes the subsoverlay")
    public void userClosesTheSubsoverlay() {
        RedHybrid_PlanCard.userClosesSubsOverlay();
    }

    @Then("I Should see the mask over Manage your plan card")
    public void manageYourPlanMaskShouldAppear() throws JsonProcessingException {
        RedHybrid_PlanCard.validateMangeYourPlanMaskAfterChangingThePlan();

    }

    @Then("I should see the screen that notify the user that a request is being processed")
    public void iShouldSeeTheScreenThatNotifyTheUserThatARequestIsBeingProcessed() {
        RedHybrid_PlanCard.uiOfScreenThatNotifyTheUserThatARequestIsBeingProcessed();
    }

    @Then("I should able to see that reflected plan with message on the Plan Tile")
    public void iShouldAbleToSeeThatReflectedPlanWithMessageOnThePlanTileAndTheResponceShouldBeAsPlanAPIResponse() {
        RedHybrid_PlanCard.iShouldAbleToSeeThatReflectedPlanWithMessageOnThePlanTileAndTheResponceShouldBeAsPlanAPIResponse();}

    @Then("I am a redhybrid user who checks that teal card appeared successfully")
    public void CheckTealCard() {
        RedHybrid_PlanCard.checkContentOfTealCard();
    }

    @Then("I am a redhybrid user validates content of Plan Tab")
    public void validateContentOfPlanTab() {
        RedHybrid_PlanCard.validateContentOfPlanTab();
    }

    @And("I am a redhybrid user who turns off the auto renew toggle")
    public void iAmARedhybridUserWhoTurnsOffTheAutoRenewToggle() {
        RedHybrid_PlanCard.iAmARedhybridUserWhoTurnsOffTheAutoRenewToggle();
    }


}
