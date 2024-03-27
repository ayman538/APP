package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.Change_Next_Plan_Change_Next_Plan_overlay.Change_Next_Plan_Change_Next_Plan_overlay_Abstract;
import pages.RedHybrid.Change_Next_Plan_Change_Next_Plan_overlay.Change_Next_Plan_Change_Next_Plan_overlay_Logic_Android;
import pages.RedHybrid.Change_Next_Plan_Change_Next_Plan_overlay.Change_Next_Plan_Change_Next_Plan_overlay_Logic_IOS;

public class Change_Next_Plan_Change_Next_Plan_overlay {

    Change_Next_Plan_Change_Next_Plan_overlay_Abstract change_next_plan_change_next_plan_overlay_abstract;

    public Change_Next_Plan_Change_Next_Plan_overlay(Config config) {
        if (config.isAndroid()) {
            change_next_plan_change_next_plan_overlay_abstract = new Change_Next_Plan_Change_Next_Plan_overlay_Logic_Android();
        }
        if (config.isIos()) {
            change_next_plan_change_next_plan_overlay_abstract = new Change_Next_Plan_Change_Next_Plan_overlay_Logic_IOS();
        }
    }


    @And("user clicks on Change Plan CTA")
    public void userClicksChangePlanCTA() {
        change_next_plan_change_next_plan_overlay_abstract.changePlanCTAClick();
    }

    @Then("user should be directed to Change_Next_Plan_overlay")
    public void userShouldBeInChange_Next_Plan_Overlay() {
        change_next_plan_change_next_plan_overlay_abstract.changeNextPlanOverlayAppears();
    }

    @And("user selects a plan")
    public void userSelectsAPlan() {
        change_next_plan_change_next_plan_overlay_abstract.planItemSelection();
    }


    @Then("Continue button should not be dimmed")
    public void continueCTAStatus() {
        change_next_plan_change_next_plan_overlay_abstract.continueCTAIsDimmed();
    }

    @Then("Change_Next_Plan_overlay UI should be respected")
    public void changeNextPlanOverlayUIValidation() throws InterruptedException {
        change_next_plan_change_next_plan_overlay_abstract.screenUIValidation();
    }

    @And("I should validate the UI of overlay if plans have promotion or not")
    public void iShouldValidateTheUIOfOverlayIfPlansHavePromotionOrNot() {
        change_next_plan_change_next_plan_overlay_abstract.checkUIWithPromoOrNoPromo();
    }
    @Then("I should click on Promos terms apply link")
    public void iShouldClickOnPromosTermsApplyLink() {
        change_next_plan_change_next_plan_overlay_abstract.clickOnPromosTermsApplyHyperLink();
    }

    @And("I should navigate to Change plan overlay")
    public void iNavigateToChangePlanOverlay() {
        change_next_plan_change_next_plan_overlay_abstract.ChangePlanOverlayDisplayed();
    }

    @Then("I Should Validate Change plan overlay UI")
    public void changePlanOverlayUIShouldBeRespected() {
        change_next_plan_change_next_plan_overlay_abstract.ChangePlanOverlayUIValidation();
    }

    @And("I Select Change plan for next month Card and click continue CTA")
    public void iChoseChangePlanForNextMonthCardAndClickContinueCTA() {
        change_next_plan_change_next_plan_overlay_abstract.ChoseChangePlanForNextMonthCardAndClickContinueCTA();
    }

    @And("I Select Renew plan early Card and click continue CTA")
    public void iChoseRenewPlanEarlyCardAndClickContinueCTA() {
        change_next_plan_change_next_plan_overlay_abstract.ChoseRenewPlanEarlyCardAndClickContinueCTA();
    }


//    @When("user clicks on change_next_plan CTA")
//    public void userClicksOnChange_next_planCTA() {
//        change_next_plan_change_next_plan_overlay_abstract.clickChangeNextPlanCTA();
//    }



}
