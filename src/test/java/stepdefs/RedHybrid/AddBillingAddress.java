package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.response.paymentCardResponseModel;
import pages.RedHybrid.PaymentMethod.RedHybrid_AddCardAddress;
import pages.RedHybrid.PaymentMethod.RedHybrid_AddCardAddress_Android;
import pages.RedHybrid.PaymentMethod.RedHybrid_AddCardAddress_IOS;
import pages.RedHybrid.RemovePaymentCard.RedHybrid_RemovePaymentCard;
import pages.RedHybrid.RemovePaymentCard.RedHybrid_RemovePaymentCardLogic_Android;
import pages.RedHybrid.RemovePaymentCard.RedHybrid_RemovePaymentCardLogic_IOS;
import testdata.RedHybridTestData;
import utils.paymentCardUtils;

public class AddBillingAddress {

    RedHybrid_AddCardAddress redHybrid_AddCardAddress;
    RedHybrid_RemovePaymentCard redHybrid_RemovePaymentCard;
    private static paymentCardResponseModel responseModel;

    public AddBillingAddress(Config config) {
        responseModel = paymentCardUtils.paymentCard();
        if (config.isAndroid()){
            redHybrid_AddCardAddress = new RedHybrid_AddCardAddress_Android();
            redHybrid_RemovePaymentCard = new RedHybrid_RemovePaymentCardLogic_Android();
        }
        if (config.isIos()) {
            redHybrid_AddCardAddress = new RedHybrid_AddCardAddress_IOS();
            redHybrid_RemovePaymentCard = new RedHybrid_RemovePaymentCardLogic_IOS();
        }
    }

    @Given("Enter Valid UK Postcode")
    public void enterValidUKPostcode() {
        redHybrid_AddCardAddress.enterUKPostcode(RedHybridTestData.GetValidPostCode());
    }

    @When("Click Search CTA")
    public void searchAddress() {
        redHybrid_AddCardAddress.searchAddress();
    }

    @Then("I should see dropdown list with addresses")
    public void checkFilledDropdownList() {
        redHybrid_AddCardAddress.checkDropdownList();
    }

    @Given("Enter Invalid UK Postcode")
    public void enterInvalidUKPostcode() {
        redHybrid_AddCardAddress.enterUKPostcode(RedHybridTestData.GetInvalidPostCode());
    }

    @Then("I should see empty dropdown list")
    public void checkEmptyDropdownList() {
        redHybrid_AddCardAddress.checkDropdownListEmpty();
    }

    @When("Select address")
    public void selectAddress() {
        redHybrid_AddCardAddress.selectFirstElementFromDropDown();
    }

    @Then("Check Address details appeared")
    public void checkAddressElementAfterSearchAddress() {
        redHybrid_AddCardAddress.checkAddressDetails();
    }

    @Given("Enter address manually")
    public void enterAddressManually() {
        redHybrid_AddCardAddress.enterAddressManually();
    }

    @Then("Check any address field -like house no- is Empty")
    public void checkHouseNotxtIsEmpty() {
        redHybrid_AddCardAddress.checkHouseNotxtIsEmpty();
    }

    @Then("Check Continue button is dimmed when info are incomplete")
    public void checkContinueBtnDimmed() {
        redHybrid_AddCardAddress.checkContinueBtnDimmed();
    }

    @Then("Validate Add Billing Screen")
    public void validateAddBillingScreen() {
        redHybrid_AddCardAddress.validateBillingScreen();
    }

    @And("I remove the added payment card if exist")
    public void iRemoveTheAddedPaymentCardIfExist() throws InterruptedException {
        if(responseModel.buttons.get(0).text.equalsIgnoreCase("replace my card")) {
            redHybrid_RemovePaymentCard.checkAddedPaymentCardUI();
            redHybrid_RemovePaymentCard.clickEditCancelCTA();
            redHybrid_RemovePaymentCard.clickRemoveCTA();
            redHybrid_RemovePaymentCard.clickRemoveInConfirmationPopUp();
            redHybrid_RemovePaymentCard.checkAddPaymentAppearAfterRemovingCard();
            System.out.println("User has removed the Payment method");
        }else {
            System.out.println("User has no Payment method to be removed");
        }
    }
}
