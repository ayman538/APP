package stepdefs.RedHybrid;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.StayOnMyPlanFlow.StayOnMyPlan_Abstract;
import pages.RedHybrid.StayOnMyPlanFlow.StayOnMyPlan_Android;
import pages.RedHybrid.StayOnMyPlanFlow.StayOnMyPlan_iOS;

public class StayOnMyPlan_stepDefs {

    StayOnMyPlan_Abstract stayOnMyPlanPageObj;

    public StayOnMyPlan_stepDefs(Config config)
    {
        if(config.isAndroid()){ stayOnMyPlanPageObj = new StayOnMyPlan_Android();
        }
        if (config.isIos()){  stayOnMyPlanPageObj= new StayOnMyPlan_iOS();
        }

    }
    @And("I should click on Stay on my plan CTA in the teal card")
    public void clickOnTealCardCTA()
    {
        stayOnMyPlanPageObj.clickOnStayOnMyPlanCTAFromTealCard();
    }
    @And("I should navigate to Stay on my plan overlay")
    public void checkStayOnMyPlanOrNotTray()
    {
        stayOnMyPlanPageObj.validateStayOnMyPlanOrNotTrayContent();
    }

    @When("I should click on Stay on my plan CTA in the Overlay")
    public void clickOnStayOnCurrentPlanCTA() throws JsonProcessingException {
        stayOnMyPlanPageObj.chooseToStayOnTheCurrentPlan();
    }


    @Then("I should navigate to Stay on current plan confirmation overlay")
    public void cancellingChangeNextPlanConfirmationTrayIsDisplayed() throws JsonProcessingException {
        stayOnMyPlanPageObj.ValidateStayOnCurrentPlanConfirmationTray();

    }

    @When("I should click on No thanks CTA")
    public void clickOnNoThanks() {
        stayOnMyPlanPageObj.clickOnNoThanks();
    }
}
