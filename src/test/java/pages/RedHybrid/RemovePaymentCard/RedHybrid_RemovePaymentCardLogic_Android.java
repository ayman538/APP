package pages.RedHybrid.RemovePaymentCard;

import org.testng.Assert;
import pages.RedHybrid.CardDetailsBarclays.RedHybrid_CardDetails;

import static testdata.RedHybridTestData.GetValidPostCode;
import static testdata.VisaCardDetails.*;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_RemovePaymentCardLogic_Android extends RedHybrid_RemovePaymentCard {
    private RedHybrid_CardDetails redHybrid_cardDetails;

    public RedHybrid_RemovePaymentCardLogic_Android() {
        super();
        redHybrid_cardDetails = new pages.RedHybrid.CardDetailsBarclays.RedHybrid_CardDetailsLogic_Androiod();
    }

    @Override
    public void beforeRemovingCard() {
        waitForVisibility(DB_PaymentIcon);
        DB_PaymentIcon.click();
    }

    @Override
    public void initializePayment() throws InterruptedException {
        RedHybrid_PaymentAddCTA.click();
        addPaymentCard();
        addCardAddress();
        addCardDetails(GetCardName(), GetCardNumber(), GetCardMonthExpDate(), GetCardYearExpDate(), GetCVV());
        processingCard();
    }

    @Override
    public void processingCard() {
        waitForVisibility(RedHybrid_ProcessingIcon);
        waitForVisibility(RedHybrid_SuccessTik);
        waitForVisibility(RedHybrid_ProcessingIcon);
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
        scrollDownTo(RedHybrid_ContinuePaymentCTA);
        RedHybrid_ContinuePaymentCTA.click();
    }

    @Override
    public void addPaymentCard() {
        RedHybrid_PaymentConfirmationToggle1.click();
        RedHybrid_PaymentConfirmationToggle2.click();
        RedHybrid_ContinuePaymentCTA.click();
    }

    @Override
    public void checkAddedPaymentCardUI() {
        waitForVisibility(RedHybrid_currentCard);
        AssertDisplayed(RedHybrid_currentCard.isDisplayed());
        AssertResult(RedHybrid_editCancelCTAtxt.getText(), "Edit");
        AssertDisplayed(RedHybrid_PaymentXIcon.isDisplayed());
        AssertDisplayed(RedHybrid_replaceCardCTA.isDisplayed());
        AssertResult(RedHybrid_replaceCardCTAtxt.getText(), "Replace my card");
    }

    @Override
    public void clickEditCancelCTA() {
        waitForVisibility(RedHybrid_editCancelCTA);
        RedHybrid_editCancelCTA.click();
    }

    @Override
    public void clickCancelCTA() {
        waitForVisibility(RedHybrid_editCancelCTA);
        RedHybrid_editCancelCTA.click();
    }

    @Override
    public void checkUIAfterPressingEditCTA() {
        waitForVisibility(RedHybrid_currentCard);
        AssertDisplayed(RedHybrid_currentCard.isDisplayed());
        AssertResult(RedHybrid_editCancelCTAtxt.getText(), "Cancel");
        AssertDisplayed(RedHybrid_PaymentXIcon.isDisplayed());
        AssertDisplayed(RedHybrid_replaceCardCTA.isDisplayed());
        AssertResult(RedHybrid_replaceCardCTAtxt.getText(), "Replace my card");
        AssertDisplayed(RedHybrid_removeCurrentCardCTA.isDisplayed());
    }

    @Override
    public void clickRemoveCTA() {
        waitForVisibility(RedHybrid_RemoveCardCTA);
        RedHybrid_RemoveCardCTA.click();
    }

    @Override
    public void checkRemovePopUp() throws InterruptedException {
        Thread.sleep(1000);
        waitForVisibility(RedHybrid_removePopUpDescription);
        AssertDisplayed(RedHybrid_removePopUpTitle.isDisplayed());
        AssertResult(RedHybrid_removePopUpTitle.getText(), "Remove this card?");
        AssertDisplayed(RedHybrid_removePopUpDescription.isDisplayed());
        Assert.assertTrue(RedHybrid_removePopUpDescription.getText().equalsIgnoreCase("Removing this card will switch off auto renew. Are you sure you want to remove this payment card from your Plus account? "));
        Assert.assertTrue(RedHybrid_removePopUpDescription.getText().contains("Plus account"));
        AssertDisplayed(RedHybrid_removePopUpCancelRemoveCTA.isDisplayed());
        AssertResult(RedHybrid_removePopUpCancelRemoveCTA.getText(), "CANCEL");
        AssertDisplayed(RedHybrid_removePopUpProceedRemoveCTA.isDisplayed());
        AssertResult(RedHybrid_removePopUpProceedRemoveCTA.getText(), "REMOVE");
    }

    @Override
    public void clickRemoveInConfirmationPopUp() throws InterruptedException {
        waitForVisibility(RedHybrid_RemoveCTA);
        RedHybrid_RemoveCTA.click();
        waitForVisibility(RedHybrid_PaymentAddCTA);
    }

    @Override
    public void clickCancelInConfirmationPopUp() throws InterruptedException {
        Thread.sleep(1000);
        waitForVisibility(RedHybrid_removePopUpCancelRemoveCTA);
        RedHybrid_removePopUpCancelRemoveCTA.click();
    }

    @Override
    public void checkAddPaymentAppearAfterRemovingCard() {
        waitForVisibility(RedHybrid_PaymentAddCTA);
        AssertDisplayed(RedHybrid_PaymentAddCTA.isDisplayed());
    }

    @Override
    public void pressXBtn() {
        try {
            waitForVisibility(RedHybrid_PaymentXIcon);
            RedHybrid_PaymentXIcon.click();
        } catch (Exception e) {
            waitForVisibility(RedHybrid_removePopUpCancelRemoveCTA);
            RedHybrid_removePopUpCancelRemoveCTA.click();
            waitForVisibility(RedHybrid_PaymentXIcon);
            RedHybrid_PaymentXIcon.click();
        }
    }

    @Override
    public void checkDashboardAppears() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertDisplayed(DB_SettingDashboardTray_icon.isDisplayed());
    }

    @Override
    public void openDeepLinkForPlanTab() {
        driver.navigate().to("myvodafone://SUBS_OVERLAY_PLAN");
    }
}

