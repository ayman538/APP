package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.ReplacePaymentCard.RedHybrid_ReplacePaymentCard;


public class ReplacingCard {

    RedHybrid_ReplacePaymentCard redHybrid_ReplacePaymentCard;

    public ReplacingCard(Config config) {
        if (config.isAndroid())
            redHybrid_ReplacePaymentCard = new pages.RedHybrid.ReplacePaymentCard.RedHybrid_ReplacePaymentCardLogic_Android();
        if (config.isIos())
            redHybrid_ReplacePaymentCard = new pages.RedHybrid.ReplacePaymentCard.RedHybrid_ReplacePaymentCardLogic_IOS();
    }

    @When("I click on replace my card CTA")
    public void replaceCard() {
        redHybrid_ReplacePaymentCard.replaceCard();
    }

    @Then("I should be navigated to add another payment")
    public void checkAddPaymentAppearsAfterReplaceCard() {
        redHybrid_ReplacePaymentCard.checkAddPaymentAppearsAfterReplaceCard();
    }

    @When("Adding same card Details")
    public void addSameCardDetails() throws InterruptedException {
        redHybrid_ReplacePaymentCard.addPaymentCard();
        redHybrid_ReplacePaymentCard.addCardAddress();
        redHybrid_ReplacePaymentCard.addSameCardDetails();
        redHybrid_ReplacePaymentCard.processingCard();
    }

    @When("Adding different card Details")
    public void addDifferentCardDetails() throws InterruptedException {
        redHybrid_ReplacePaymentCard.addPaymentCard();
        redHybrid_ReplacePaymentCard.addCardAddress();
        redHybrid_ReplacePaymentCard.addDifferentCardDetails();
        redHybrid_ReplacePaymentCard.processingCard();
    }

    @Then("I should validate that the card is replaced successfully")
    public void checkAddDone() {
        redHybrid_ReplacePaymentCard.checkAddDone();
    }

    @When("I click on back button")
    public void pressPhysicalBack() {
        redHybrid_ReplacePaymentCard.pressPhysicalBack();
    }

    @Then("I should check replace card screen")
    public void checkReplaceCardScreen() {
        redHybrid_ReplacePaymentCard.checkReplaceCardScreen();
    }

    @And("I click on X button for Replace card")
    public void pressXBtnReplaceCard() {
        redHybrid_ReplacePaymentCard.pressXBtn();
    }

    @When("I agree on terms and conditions in add payment method")
    public void iAgreeOnTermsAndConditionsInAddPaymentMethod() {
        redHybrid_ReplacePaymentCard.agreeOnTermsAndConditions();
    }

    @And("I click on continue CTA")
    public void iClickOnContinueCTA() {
        redHybrid_ReplacePaymentCard.clickOnContinueCTA();
    }

    @And("I select the first address")
    public void iSelectTheFirstAddress() {
        redHybrid_ReplacePaymentCard.selectPostCodeFirstAddress();
    }

    @And("I scroll down to bottom of the billing address screen")
    public void iScrollDownToBottomOfTheBillingAddressScreen() {
        redHybrid_ReplacePaymentCard.scrollDownToBillingBottom();
    }

    @And("I search for post code {string}")
    public void iSearchForPostCode(String postCode) {
        redHybrid_ReplacePaymentCard.enterPostCodeAndSearch(postCode);
        System.setProperty("postCodeForApiCall",  postCode);
    }

    @And("I insert user's payment details {string} , {string} , {string} , {string} and {string}")
    public void iInsertUserSPaymentDetailsAnd(String name, String cardNumber, String expiryMonth, String expiryYear, String cvv) throws InterruptedException {
        redHybrid_ReplacePaymentCard.insertUserPaymentDerails(name, cardNumber, expiryMonth, expiryYear, cvv);
    }

    @Then("I should validate processing icon displayed successfully")
    public void iShouldValidateProcessingIconDisplayedSuccessfully() {
        redHybrid_ReplacePaymentCard.processingScreenValidation();
    }
}

