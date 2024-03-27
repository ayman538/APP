package stepdefs.RedHybrid;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.ChangeNextPlan_ChangeProcessing.ChangeNextPlaneChangeProcessing_Abstract;
import pages.RedHybrid.ChangeNextPlan_ChangeProcessing.ChangeNextPlaneChangeProcessing_Android;
import pages.RedHybrid.ChangeNextPlan_ChangeProcessing.ChangeNextPlaneChangeProcessing_iOS;

public class ChangeNextPlanChangeProcessing {

    private ChangeNextPlaneChangeProcessing_Abstract changeProcessing;

    public ChangeNextPlanChangeProcessing(Config config) {
        if (config.isAndroid()) changeProcessing = new ChangeNextPlaneChangeProcessing_Android();
        if (config.isIos()) changeProcessing = new ChangeNextPlaneChangeProcessing_iOS();
    }

    @And("user clicks on Change plan for next month from quick links")
    public void userClicksOnChangePlanForNextMonth() {
        changeProcessing.clickOnChangePlanForNextMonth();

    }

    @When("I Click on Confirm next plan CTA")
    public void clickOnConfirmNextPlanCTA() {
        changeProcessing.clickOnConfirmNextPlanCTA();
    }

    @Then("I should be able to see Processing screen")
    public void changePlanProcessingShouldAppear() {
        changeProcessing.validateChangePlaneProcessingScreenUI();
    }

    @Then("I should able to see Change plan Notification screen")
    public void changePlanNotificationScreenShouldAppear() {
        changeProcessing.validateChangePlanNotificationScreenUI();
    }

    @Then("I should see Plan tab")
    public void planTabShouldAppear() {
        changeProcessing.validatePlanTabIsDisplayed();
    }

    @When("I Click on X CTA for redHybrid")
    public void clickOnXCTAForRedHybrid() {
        changeProcessing.redHybridDismissIconClick();
    }

    @Then("I should validate the UI of confirmation screen of {string}")
    public void validateTheUIOfConfirmationScreenOfChangePlan(String JourneyType) throws JsonProcessingException {
        changeProcessing.validate_UI_of_confirmation_screen_in_changePlan(JourneyType);
    }

    @Then("I should able to see quick links")
    public void iShouldAbleToSeeQuickLinks() {
        changeProcessing.iShouldAbleToSeeQuickLinks();
    }
}
