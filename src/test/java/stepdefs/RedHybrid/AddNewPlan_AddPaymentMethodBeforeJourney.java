package stepdefs.RedHybrid;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.AddNewPlan_AddPaymentMethodBeforeJourney.AddNewPlanAddPaymentMethodBeforeJourneyLogic_Android;
import pages.RedHybrid.AddNewPlan_AddPaymentMethodBeforeJourney.AddNewPlanAddPaymentMethodBeforeJourneyLogic_IOS;
import pages.RedHybrid.AddNewPlan_AddPaymentMethodBeforeJourney.AddNewPlan_AddPaymentMethodBeforeJourney_Abstract;
import pages.RedHybrid.PaymentMethod.*;
import pages.RedHybrid.ProcessingPaymentCard.RedHybrid_ValidateCardAdding;
import pages.RedHybrid.ProcessingPaymentCard.RedHybrid_ValidateCardAddingLogic_Android;
import pages.RedHybrid.ProcessingPaymentCard.RedHybrid_ValidateCardAddingLogic_IOS;

public class AddNewPlan_AddPaymentMethodBeforeJourney {

    private AddNewPlan_AddPaymentMethodBeforeJourney_Abstract abstractLogic;
    private RedHybrid_AddNewPayment redHybrid_AddNewPayment;
    RedHybrid_ValidateCardAdding redHybrid_ValidateCardAdding;

    public AddNewPlan_AddPaymentMethodBeforeJourney(Config config){
        if(config.isAndroid()){
            abstractLogic = new AddNewPlanAddPaymentMethodBeforeJourneyLogic_Android();
            redHybrid_AddNewPayment = new RedHybrid_AddNewPayment_Android();
            redHybrid_ValidateCardAdding = new RedHybrid_ValidateCardAddingLogic_Android();
        }
        if(config.isIos()){
            abstractLogic = new AddNewPlanAddPaymentMethodBeforeJourneyLogic_IOS();
            redHybrid_AddNewPayment = new RedHybrid_AddNewPayment_IOS();
            redHybrid_ValidateCardAdding = new RedHybrid_ValidateCardAddingLogic_IOS();

        }
    }

    @Then("I should be navigated to an overlay to {string} while trying to {string}")
    public void ValidateContentOfOverlay(String processType, String requestedActionValue) throws JsonProcessingException{
        abstractLogic.ValidateContentOfOverlay(processType, requestedActionValue);
    }

    @And("Clicked on a add new card CTA")
    public void Click_on_add_new_card_CTA(){
        abstractLogic.ClickOnAddNewCardCTA();
    }

    @Then("user should redirected to Payment full flow")
    public void redirected_to_Payment_full_flow() {
        redHybrid_AddNewPayment.ValidateAddNewPaymentMethod();
    }


    @Then("User should be directed to Add Flexi plan screen")
    public void directed_to_Add_Flexi_plan_screen(){
        abstractLogic.CheckFlexiPlansScreen();
    }

    @When("User clicked on X CTA")
    public void ClickOnXCTA(){
        abstractLogic.ClickOnXCTA();
    }
}
