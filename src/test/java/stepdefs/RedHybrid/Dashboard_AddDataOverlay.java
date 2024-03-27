package stepdefs.RedHybrid;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.response.BeginCardPaymentResponseModel;
import models.response.ProcessCardPaymentResponseModel;
import models.response.paymentCardResponseModel;
import pages.RedHybrid.Dashboard_AddDataOverlay.Dashboard_AddDataOverlay_Abstract;
import pages.RedHybrid.Dashboard_AddDataOverlay.Dashboard_AddDataOverlay_Android;
import pages.RedHybrid.Dashboard_AddDataOverlay.Dashboard_AddDataOverlay_IOS;
import utils.BeginCardPaymentUtils;
import utils.ProcessAddCardUtils;
import utils.beginAddCardUtils;
import utils.paymentCardUtils;

import static utils.element_helpers.VerifyHelpers.AssertSoftResult;

public class Dashboard_AddDataOverlay {
    private Dashboard_AddDataOverlay_Abstract dashboard_AddDataOverlay;

    paymentCardResponseModel PaymentCardResp;
    BeginCardPaymentResponseModel BeginAddCardRes;
    ProcessCardPaymentResponseModel ProcessCardRes;
    String billingProfileId;
    String TransRef;
    private static boolean PaymentState = false;
    public Dashboard_AddDataOverlay(Config config) {
        if (config.isAndroid()) dashboard_AddDataOverlay = new Dashboard_AddDataOverlay_Android();
        if (config.isIos()) dashboard_AddDataOverlay = new Dashboard_AddDataOverlay_IOS();
    }

    @When("Click on add data tile from dashboard")
    public void clickOnAddDataTileFromDashboard() throws InterruptedException {
        dashboard_AddDataOverlay.clickOnAddDataTileFromDashboard();
    }

    @Then("Assert that Add Data overlay should be displayed")
    public void assertThatAddDataOverlayShouldBeDisplayed() {
        dashboard_AddDataOverlay.assertThatAddDataOverlayShouldBeDisplayed();
    }

    @Then("Assert that Add Data overlay UI should be displayed correctly")
    public void assertThatAddDataOverlayUIShouldBeDisplayedCorrectly() {
        dashboard_AddDataOverlay.assertThatAddDataOverlayUIShouldBeDisplayedCorrectly();
    }

    @And("I add a valid payment method to RH User With address details {string} {string} {string} {string} {string} {string} {string} {string} and payment details {string} {string} {string} {string} {string}")
    public void iAddAValidPaymentMethodToRHUser(String addressShortDescription, String city, String country, String flatNumber, String houseName,
                                                String houseNumber, String postCode, String streetName,
                                                String HolderName ,String CardNumber , String ExpMonth , String ExpYear ,String CVV) throws JsonProcessingException {
        if (!PaymentState) {
            try {
                PaymentCardResp = paymentCardUtils.paymentCard();
                System.out.println(PaymentCardResp.buttons.get(0).text);
                if (PaymentCardResp.buttons.get(0).text.equalsIgnoreCase("Add a new card")) {
                    billingProfileId = PaymentCardResp.billingProfileId;

                    BeginAddCardRes = beginAddCardUtils.BeginAddingCard(addressShortDescription, city, country, flatNumber, houseName, houseNumber, postCode, streetName);
                    TransRef = BeginAddCardRes.transactionReference;
                    String RedURL = BeginAddCardRes.redirectUrl;

                    BeginCardPaymentUtils.SubmitCardDetails(RedURL, HolderName, CardNumber, ExpMonth, ExpYear, CVV);

                    ProcessCardRes = ProcessAddCardUtils.ProcessAddCard(billingProfileId, addressShortDescription, city, country, flatNumber, houseName, houseNumber, postCode, streetName, TransRef);
                    System.out.println(ProcessCardRes.processStatus);
                    AssertSoftResult(ProcessCardRes.processStatus, "ADDED");
                    PaymentState = true;
                } else if (PaymentCardResp.buttons.get(0).text.equalsIgnoreCase("Replace my card")) {
                    System.out.println("Payment method already added");
                    PaymentState = true;

                }
            } catch (Exception e) {
                System.out.println("Could Not Add Payment Method");

            }
        }
    }
}

