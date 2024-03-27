package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.response.paymentCardResponseModel;
import pages.RedHybrid.PaymentMethod.RedHybrid_AddNewPayment;
import pages.RedHybrid.PaymentMethod.RedHybrid_AddNewPayment_Android;
import pages.RedHybrid.PaymentMethod.RedHybrid_AddNewPayment_IOS;
import pages.RedHybrid.ReplacePaymentCard.RedHybrid_ReplacePaymentCard;
import pages.RedHybrid.ReplacePaymentCard.RedHybrid_ReplacePaymentCardLogic_Android;
import pages.RedHybrid.ReplacePaymentCard.RedHybrid_ReplacePaymentCardLogic_IOS;
import utils.paymentCardUtils;


public class RetrievingPaymentCard {
    RedHybrid_AddNewPayment redHybrid_AddNewPayment;
    RedHybrid_ReplacePaymentCard redHybrid_ReplacePaymentCard;
    private static paymentCardResponseModel responseModel;
    public static String postCode = "BT41 1AZ", cardName ="test",
            cardNumber="4125000000000150", expMonth="07", expYear="25", cvv="258";

    public RetrievingPaymentCard(Config config){
        responseModel = paymentCardUtils.paymentCard();
        if (config.isAndroid()){
            redHybrid_AddNewPayment = new RedHybrid_AddNewPayment_Android();
            redHybrid_ReplacePaymentCard = new RedHybrid_ReplacePaymentCardLogic_Android();
        }

        if (config.isIos()){
            redHybrid_AddNewPayment = new RedHybrid_AddNewPayment_IOS();
            redHybrid_ReplacePaymentCard = new RedHybrid_ReplacePaymentCardLogic_IOS();
        }
    }

//    @Given("Initialize Retrieving Payment Card")
//    public void RetrievingPaymentCard(Config config) {
//        if (config.isAndroid())
//            redHybrid_AddNewPayment = new RedHybrid_AddNewPayment_Android();
//        if (config.isIos()) redHybrid_AddNewPayment = new RedHybrid_AddNewPayment_IOS();
//    }
    /*
    @Given("Initialize Retrieving Payment Card")
    public void beforeFeature() throws IOException {
        RedHybrid_AddPayment = new RedHybrid_AddNewPaymentLogic();
    }

     */

    @When("Tap on Continue Cta in verified screen")
    public void TapOnVerifyCTA() {
        redHybrid_AddNewPayment.TapOnVerifyCTA();
        redHybrid_AddNewPayment.PaymentDrawerIsOpened();
    }

    @Then("Validate card is added successfully")
    public void ValidateLoginScreenIsDisplayed() {
        redHybrid_AddNewPayment.ValidatePaymentCardIsAdded();
    }

    @When("I should Validate Payment card drawer is displayed")
    public void PaymentDrawerIsOpened() {
        redHybrid_AddNewPayment.PaymentDrawerIsOpened();
    }

    @Then("Validate X Icon close the flow")
    public void ValidateXIconCloseTheFlow() {
        redHybrid_AddNewPayment.ValidateXIconCloseTheFlow();
    }

    @Then("Validate The app soft close")
    public void ValidateSoftCloseTheApp() {
        redHybrid_AddNewPayment.ValidateSoftCloseTheApp();
    }

    @Then("I add new payment if no payment method exists")
    public void iAddNewPaymentIfNoPaymentMethodExists() throws InterruptedException {
        System.out.println(responseModel.buttons.get(0).text);
      if (responseModel.buttons.get(0).text.equalsIgnoreCase("Add a new card")){
            redHybrid_AddNewPayment.TapOnAddNewCard();
            redHybrid_ReplacePaymentCard.agreeOnTermsAndConditions();
            redHybrid_ReplacePaymentCard.clickOnContinueCTA();
            redHybrid_ReplacePaymentCard.enterPostCodeAndSearch(postCode);
            System.setProperty("postCodeForApiCall", postCode);
            redHybrid_ReplacePaymentCard.selectPostCodeFirstAddress();
            redHybrid_ReplacePaymentCard.scrollDownToBillingBottom();
            redHybrid_ReplacePaymentCard.clickOnContinueCTA();
            redHybrid_ReplacePaymentCard.insertUserPaymentDerails(cardName, cardNumber, expMonth, expYear, cvv);
            redHybrid_ReplacePaymentCard.processingScreenValidation();
            redHybrid_ReplacePaymentCard.clickOnContinueCTA();
            System.out.println("User has added a new payment method");
        }else {
          System.out.println("User has a payment method already added");
      }
    }
}
