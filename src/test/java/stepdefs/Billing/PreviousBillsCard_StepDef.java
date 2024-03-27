package stepdefs.Billing;

import core.Config;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NewBilling.PreviousBillsCard.PreviousBillsCard_Abstract;
import pages.NewBilling.PreviousBillsCard.PreviousBillsCard_Logic_Android;
import pages.NewBilling.PreviousBillsCard.PreviousBillsCard_Logic_iOS;

public class PreviousBillsCard_StepDef {
    private PreviousBillsCard_Abstract previousBillsAbstract;

    public PreviousBillsCard_StepDef(Config config){
        if (config.isAndroid()){
            previousBillsAbstract = new PreviousBillsCard_Logic_Android();
        }
        if (config.isIos()){
            previousBillsAbstract = new PreviousBillsCard_Logic_iOS();
        }
    }



    @When("I Scroll Down To Previous Bill Card")
    public void iScrollDownToPreviousBillCard() {
        previousBillsAbstract.iScrollDownToPreviousBillCard();
    }

    @Then("I Should Validate Previous Bill Card Content")
    public void iShouldValidatePreviousBillCardContent() {
        previousBillsAbstract.iShouldValidatePreviousBillCardContent();
    }

    @When("I Check Load More CTA Functionality")
    public void iCheckLoadMoreCTAFunctionality() {
        previousBillsAbstract.iCheckLoadMoreCTAFunctionality();
    }

    @When("I Click On Arrow Icon")
    public void iClickOnArrowIcon() {
        previousBillsAbstract.iClickOnArrowIcon();
    }

    @Then("I Validate the Previous Bill Reinvent Journey is open")
    public void iValidateThePreviousBillReinventJourneyIsOpen() {
        previousBillsAbstract.iValidateThePreviousBillReinventJourneyIsOpen();
    }
}