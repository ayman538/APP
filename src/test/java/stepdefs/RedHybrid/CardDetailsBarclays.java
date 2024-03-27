package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.CardDetailsBarclays.RedHybrid_CardDetails;


public class CardDetailsBarclays {
    RedHybrid_CardDetails redHybrid_cardDetails;

    @Given("Initialize Barclays card details")
    public void beforeFeature(Config config) {
        if (config.isAndroid())
            redHybrid_cardDetails = new pages.RedHybrid.CardDetailsBarclays.RedHybrid_CardDetailsLogic_Androiod();
        if (config.isIos())
            redHybrid_cardDetails = new pages.RedHybrid.CardDetailsBarclays.RedHybrid_CardDetailsLogic_IOS();
    }


    @When("Barclays card details screen is displayed")
    public void BarclaysDrawerIsDisplayed() {
        redHybrid_cardDetails.BarclaysDrawerIsDisplayed();
    }

    @Then("Validate card fields are displayed successfully")
    public void validateCardFields() {
        redHybrid_cardDetails.validateCardFields();
    }

    @Then("Validate card name field can enter name")
    public void validateCardNameField() {
        redHybrid_cardDetails.validateCardNameField();
    }

    @Then("Validate card number field can enter name")
    public void validateCardNumberField() {
        redHybrid_cardDetails.validateCardNumberField();
    }

    @Then("Validate expiration date field can enter name")
    public void validateExpirationDateField() {
        redHybrid_cardDetails.validateExpirationDateField();
    }

    @Then("Validate when entering invalid CVV")
    public void validateWhenEnteringInvalidCVV() throws InterruptedException {
        redHybrid_cardDetails.validateWhenEnteringInvalidCVV();
    }

    @Then("Validate when entering invalid Card Name")
    public void validateWhenEnteringInvalidCardName() throws InterruptedException {
        redHybrid_cardDetails.validateWhenEnteringInvalidCardName();
    }

    @Then("Validate when entering invalid Card Number")
    public void validateWhenEnteringInvalidCardNumber() throws InterruptedException {
        redHybrid_cardDetails.validateWhenEnteringInvalidCardNumber();
    }

    @Then("Validate when entering invalid Card Expiration date")
    public void validateWhenEnteringInvalidCardExpiryDate() throws InterruptedException {
        redHybrid_cardDetails.validateWhenEnteringInvalidCardExpiryDate();
    }

    @Then("Validate when entering Valid card data and Auth equal true")
    public void validateWhenEnteringValidCardDetailsAuthTrue() throws InterruptedException {
        redHybrid_cardDetails.validateWhenEnteringValidCardDetailsAuthTrue();
    }

    @Then("Validate when entering Valid card data and Auth equal false")
    public void validateWhenEnteringValidCardDetailsAuthFalse() throws InterruptedException {
        redHybrid_cardDetails.validateWhenEnteringValidCardDetailsAuthFalse();
    }


}
