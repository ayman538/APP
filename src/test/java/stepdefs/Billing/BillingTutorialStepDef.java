package stepdefs.Billing;

import core.Config;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NewBilling.Billing_Abstract;
import pages.NewBilling.Billing_Logic_Android;
import pages.NewBilling.Billing_Logic_iOS;


public class BillingTutorialStepDef {

    Billing_Abstract billing_abstract;

    public BillingTutorialStepDef (Config config){
        if (config.isAndroid()) billing_abstract = new Billing_Logic_Android();
        if (config.isIos()) billing_abstract = new Billing_Logic_iOS();


    }
    @Then("I should see billing tutorial Title")
    public void validateBillingTutorialTitleExistence (){
        billing_abstract.validateBillingTutorialTitleExistence();

    }

    @Then("I should see billing tutorial description")
    public void validateBillingTutorialDescriptionExistence(){
        billing_abstract.validateBillingTutorialDescriptionExistence();
    }

    @Then("I should see billing Tutorial Continue Cta")
    public void validateTutorialContinueCTAExistence(){
        billing_abstract.validateTutorialContinueCTAExistence();
    }
   @When("I click on billing Tutorial Continue Cta")
    public void clickOnTutorialContinueCTA(){
       billing_abstract.clickOnTutorialContinueCTA();
   }

}

