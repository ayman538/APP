package stepdefs.RedHybrid;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.AddExtrasConfirmPurchace_Cancelled_Failed.AddExtrasConfirmPurchace_Cancelled_FailedAbstract;
import pages.RedHybrid.AddExtrasConfirmPurchace_Cancelled_Failed.AddExtrasConfirmPurchace_Cancelled_FailedAndroid;
import pages.RedHybrid.AddExtrasConfirmPurchace_Cancelled_Failed.AddExtrasConfirmPurchace_Cancelled_Failed_IOS;

public class AddExtrasConfirmPurchace_Cancelled_Failed {

    private AddExtrasConfirmPurchace_Cancelled_FailedAbstract AddExtra;

    public AddExtrasConfirmPurchace_Cancelled_Failed(Config config) {
        if (config.isAndroid()) {
            AddExtra = new AddExtrasConfirmPurchace_Cancelled_FailedAndroid();
        }
        if (config.isIos()) {
            AddExtra = new AddExtrasConfirmPurchace_Cancelled_Failed_IOS();
        }
    }

    @When("I inserts {string} cvv number of the payment card")
    public void userInsertsNameAndCvv(String CVV) throws InterruptedException {

        AddExtra.paymentMethodScreenInsertCVV(CVV);
    }


    @And("Choose a Roaming Extra and click continue")
    public void chooseARoamingExtraAndClickContinue() {
        AddExtra.ClickOnContinueAddExtra();
    }

    @Given("User Navigated to Barcalys Screen")
    public void userNavigatedToBarcalysScreen() {
        AddExtra.AddExtraPaymentMethodOverlayAppears();
    }

    @Then("Payment error overlay for add extra journey should be visible and compatible with the response of the API")
    public void paymentErrorOverlayValidation() throws JsonProcessingException {
        AddExtra.paymentErrorOverlayFailedStatusValidation();
    }
}
