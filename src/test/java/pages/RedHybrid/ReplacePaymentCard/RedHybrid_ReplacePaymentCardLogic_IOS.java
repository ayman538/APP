package pages.RedHybrid.ReplacePaymentCard;

import models.response.AddressResponseModel;
import org.openqa.selenium.Keys;
import pages.RedHybrid.CardDetailsBarclays.RedHybrid_CardDetails;
import utils.AddressUtils;

import static testdata.RedHybridTestData.GetValidPostCode;
import static testdata.VisaCardDetails.*;
import static utils.element_helpers.ActionsHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.*;
import static utils.element_helpers.GenericHelpers.*;

public class RedHybrid_ReplacePaymentCardLogic_IOS extends RedHybrid_ReplacePaymentCard {

    private RedHybrid_CardDetails redHybrid_cardDetails;
    private AddressResponseModel responseModel;


    public RedHybrid_ReplacePaymentCardLogic_IOS() {
        super();
        redHybrid_cardDetails = new pages.RedHybrid.CardDetailsBarclays.RedHybrid_CardDetailsLogic_IOS();

    }

    @Override
    public void beforeReplacingCard() {
        waitForVisibility(DB_PaymentIcon);
        DB_PaymentIcon.click();
    }

    @Override
    public void processingCard() {
        waitForVisibility(RedHybrid_ProcessingIcon);
        waitForVisibility(RedHybrid_SuccessTik);
        RedHybrid_SuccessCTA.click();
    }

    @Override
    public void addCardDetails(String cardName, String cardNo, String cardExpiryMonth, String cardExpiryYear, String cardCVV) throws InterruptedException {
        scrollDownTo(RedHybrid_CardNameField);
        RedHybrid_CardNameField.sendKeys(cardName);
        RedHybrid_CardNumberField.sendKeys(cardNo);
        redHybrid_cardDetails.selectExpiryDate(cardExpiryMonth, cardExpiryYear);
        RedHybrid_CardSecurityCodeField.sendKeys(cardCVV);
        RedHybrid_CardPayNowCTA.click();
    }

    @Override
    public void addCardAddress() {
        waitForVisibility(RedHybrid_UKPostcodeText);
        RedHybrid_UKPostcodeText.sendKeys(GetValidPostCode());
        RedHybrid_searchAddressCTA.click();
        waitForVisibility(RedHybrid_selectAddressDropdownFirstElement);
        RedHybrid_selectAddressDropdownFirstElement.click();
        scrollDownTo(RedHybrid_ContinuePaymentCTA);
        RedHybrid_ContinuePaymentCTA.click();
    }

    @Override
    public void addPaymentCard() {
        waitForVisibility(RedHybrid_PaymentConfirmationToggle1);
        RedHybrid_PaymentConfirmationToggle1.click();
        RedHybrid_PaymentConfirmationToggle2.click();
        RedHybrid_ContinuePaymentCTA.click();
    }

    @Override
    public void replaceCard() {
        waitForVisibility(RedHybrid_replaceCardCTA);
        RedHybrid_replaceCardCTA.click();
    }

    @Override
    public void checkAddPaymentAppearsAfterReplaceCard() {
        waitForVisibility(RedHybrid_PaymentConfirmationToggle1);
        AssertDisplayed(RedHybrid_PaymentConfirmationToggle1.isDisplayed());
    }

    @Override
    public void pressPhysicalBack() {
        driver.navigate().back();
    }

    @Override
    public void checkDashboardAppears() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertDisplayed(DB_SettingDashboardTray_icon.isDisplayed());
    }

    @Override
    public void addDifferentCardDetails() throws InterruptedException {
        addCardDetails(GetCardName1(), GetCardNumber1(), GetCardMonthExpDate1(), GetCardYearExpDate1(), GetCVV1());
    }

    @Override
    public void addSameCardDetails() throws InterruptedException {
        addCardDetails(GetCardName(), GetCardNumber(), GetCardMonthExpDate(), GetCardYearExpDate(), GetCVV());
    }

    @Override
    public void checkAddDone() {
        waitForVisibility(RedHybrid_currentCard);
        AssertDisplayed(RedHybrid_currentCard.isDisplayed());
    }

    @Override
    public void checkReplaceCardScreen() {
        waitForVisibility(RedHybrid_currentCard);
        AssertDisplayed(RedHybrid_currentCard.isDisplayed());
        AssertDisplayed(RedHybrid_replaceCardCTA.isDisplayed());
    }

    @Override
    public void pressXBtn() {
        waitForVisibility(RedHybrid_PaymentXIcon);
        RedHybrid_PaymentXIcon.click();
    }

    // New Refactoring functions
    @Override
    public void agreeOnTermsAndConditions() {
        waitForVisibility(RedHybrid_PaymentConfirmationToggle1);
        RedHybrid_PaymentConfirmationToggle1.click();
        RedHybrid_PaymentConfirmationToggle2.click();

    }

    @Override
    public void clickOnContinueCTA() {
        RedHybrid_ContinuePaymentCTA.click();
    }

    @Override
    public void enterPostCodeAndSearch(String postCode) {
        waitForVisibility(RedHybrid_UKPostcodeText);
        RedHybrid_UKPostcodeText.sendKeys(postCode);
        RedHybrid_searchAddressCTA.click();
        responseModel = AddressUtils.getAddress(postCode);
    }

    @Override
    public void selectPostCodeFirstAddress() {
        waitForVisibility(RedHybrid_selectAddressDropdownFirstElement);
        System.out.println(responseModel.addresses.get(0).addressShortDescription+ "    Address");
        RedHybrid_selectAddressDropdownFirstElement.sendKeys(responseModel.addresses.get(0).addressShortDescription);
        IOSDoneCTAKeyBoard.click();
    }

    @Override
    public void scrollDownToBillingBottom() {
        scrollDownTo(RedHybrid_ContinuePaymentCTA);
    }

    @Override
    public void insertUserPaymentDerails(String name, String cardNumber, String expiryMonth, String expiryYear, String cvv) throws InterruptedException {
        waitForVisibility(RedHybrid_CardNameField);
        scrollDownTo(RedHybrid_CardNameField);
        RedHybrid_CardNameField.sendKeys(name);
        RedHybrid_CardNumberField.sendKeys(cardNumber);
        IOSDoneCTAKeyBoard.click();
        redHybrid_cardDetails.selectExpiryDate(expiryMonth, expiryYear);
        RedHybrid_CardSecurityCodeField.sendKeys(cvv);
        IOSDoneCTAKeyBoard.click();
        scrollDownTo(RedHybrid_CardPayNowCTA);
        RedHybrid_CardPayNowCTA.click();
    }

    @Override
    public void processingScreenValidation() {
        try {
            waitForVisibility(RedHybrid_ProcessingIcon);
        }catch (Exception e){
            System.out.println("processing screen disappears quickly");
        }
        waitForVisibility(RedHybrid_SuccessCTA);
        AssertDisplayed(RedHybrid_SuccessTik.isDisplayed());
    }
}


