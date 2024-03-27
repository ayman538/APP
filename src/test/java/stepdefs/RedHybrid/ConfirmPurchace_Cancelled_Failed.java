package stepdefs.RedHybrid;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.response.BeginCardPaymentResponseModel;
import models.response.HybridBundelsResponseModel;
import models.response.ProcessCardPaymentResponseModel;
import pages.RedHybrid.confirmPurchace_Cancelled_Failed.ConfirmPurchace_Cancelled_Failed_Abstract;
import pages.RedHybrid.confirmPurchace_Cancelled_Failed.ConfirmPurchace_Cancelled_Failed_Android;
import pages.RedHybrid.confirmPurchace_Cancelled_Failed.ConfirmPurchace_Cancelled_Failed_Ios;

public class ConfirmPurchace_Cancelled_Failed {
    ConfirmPurchace_Cancelled_Failed_Abstract confirmYourPurchaseCancelled_failedStatus_abstract;
    HybridBundelsResponseModel hybridBundlesResponse;
    BeginCardPaymentResponseModel beginCardResponse;
    ProcessCardPaymentResponseModel processCardResponse;

    public ConfirmPurchace_Cancelled_Failed(Config config) {
        if (config.isAndroid()) {
            confirmYourPurchaseCancelled_failedStatus_abstract = new ConfirmPurchace_Cancelled_Failed_Android();
        }
        if (config.isIos()) {
            confirmYourPurchaseCancelled_failedStatus_abstract = new ConfirmPurchace_Cancelled_Failed_Ios();
        }
    }

    @When("user inserts {string} name and {string} cvv")
    public void userInsertsNameAndCvv(String arg0, String arg1) throws InterruptedException {

        confirmYourPurchaseCancelled_failedStatus_abstract.paymentMethodScreenInsertNameAndCVV(arg0, arg1);
    }

    @And("I clicks on Continue CTA in Payment Method screen")
    public void userClicksOnPayNowCTA() {
        confirmYourPurchaseCancelled_failedStatus_abstract.clickOnPayNow();
    }

    @And("I inserts {string} password of the card")
    public void userInsertsInvalidPasswordOfTheCard(String arg0) {
        try {
            confirmYourPurchaseCancelled_failedStatus_abstract.paymentMethodInsertPassword(arg0);
        }
        catch (Exception e ){
            System.out.println("payment method requires no pwd");
        }

    }

    @And("I clicks on submit CTA in Payment Card PWD screen")
    public void userClicksOnSubmit() {
        try {
            confirmYourPurchaseCancelled_failedStatus_abstract.clickSubmitPassword();
        }
        catch (Exception e ){
            System.out.println("payment method requires no pwd");
        }
    }

    @And("invalid password text appears")
    public void invalidPasswordTextAppears() {

        confirmYourPurchaseCancelled_failedStatus_abstract.validateIncorrectPwd();
    }

    @And("User clicks on Try Again CTA")
    public void userClicksOnTryAgainCTA() {

        confirmYourPurchaseCancelled_failedStatus_abstract.paymentErrorTryAgainCTAClick();
    }

    @And("User clicks on dismissal button")
    public void userClicksOnDismissalButton() {

        confirmYourPurchaseCancelled_failedStatus_abstract.paymentErrorDismissButtonClick();
    }

    @When("User clicks on Cancel CTA")
    public void userClicksOnCancelCTA() throws InterruptedException {

        confirmYourPurchaseCancelled_failedStatus_abstract.paymentScreenCancelCTAClick();
    }

    @Then("Payment error overlay should appear to the user with try again CTA")
    public void payment_errorScreenShouldAppearToTheUser() throws InterruptedException {

        confirmYourPurchaseCancelled_failedStatus_abstract.paymentErrorScreenIsVisible();
    }

    @Then("Payment error overlay should be visible and compatible with the response of the API")
    public void paymentErrorOverlayShouldBeVisibleAndCompataibleWithTheResponseOfTheAPI() throws JsonProcessingException {

        confirmYourPurchaseCancelled_failedStatus_abstract.paymentErrorScreenUIValidationFailedStatus(hybridBundlesResponse, beginCardResponse, processCardResponse);
    }


    @Then("Payment error for cancelled status should be retrieved")
    public void paymentErrorForCancelledStatusShouldBeRetrieved() throws JsonProcessingException {

        confirmYourPurchaseCancelled_failedStatus_abstract.paymentErrorCancelledStatus(hybridBundlesResponse, beginCardResponse, processCardResponse);
    }

    @And("I should be navigated to Payment Card PWD screen")
    public void passwordScreenAppears() {
        try {
            confirmYourPurchaseCancelled_failedStatus_abstract.pwdScreenIsVisible();
        }
        catch (Exception e ){
            System.out.println("payment method requires no pwd");
        }
    }

    @Given("User in Payment method overlay")
    public void userInPaymentMethodOverlay() {

        confirmYourPurchaseCancelled_failedStatus_abstract.paymentMethodOverlayAppears();
    }
}