//package pages.RedHybrid.RemovePaymentCard;
//
//import core.Config;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic;
//import pages.RedHybrid.CardDetailsBarclays.RedHybrid_CardDetails;
//import testdata.ReadResponse;
//
//import static testdata.RedHybridTestData.GetValidPostCode;
//import static testdata.VisaCardDetails.*;
//@Deprecated
//public class RedHybrid_RemovePaymentCardLogic extends RedHybrid_RemovePaymentCardPO {
//    private static WebElement DB_SettingDashboardTray_icon;
//    private final String Card;
//    private final DX_IDM_FullLoginLogic loginObject;
//    private RedHybrid_CardDetails redHybrid_cardDetails ;
//    private final Config config =new Config();
//
//
//    public RedHybrid_RemovePaymentCardLogic() {
//        super();
//        Card = ReadResponse.GetPaymentCardList();
//        loginObject = new DX_IDM_FullLoginLogic();
//        if (config.isAndroid())
//            redHybrid_cardDetails = new pages.RedHybrid.CardDetailsBarclays.RedHybrid_CardDetailsLogic_Androiod();
//        if (config.isIos())
//            redHybrid_cardDetails = new pages.RedHybrid.CardDetailsBarclays.RedHybrid_CardDetailsLogic_IOS();
//
//    }
//
//    public void beforeRemovingCard() {
//        waitForVisibility(DB_PaymentIcon);
//        DB_PaymentIcon.click();
//    }
//
//    public void initializePayment() throws InterruptedException {
//        RedHybrid_PaymentAddCTA.click();
//        addPaymentCard();
//        addCardAddress();
//        addCardDetails(GetCardName(), GetCardNumber(), GetCardMonthExpDate(), GetCardYearExpDate(), GetCVV());
//        processingCard();
//    }
//
//    public void processingCard() {
//        waitForVisibility(RedHybrid_ProcessingIcon);
//        waitForVisibility(RedHybrid_SuccessTik);
//        waitForVisibility(RedHybrid_ProcessingIcon);
//        RedHybrid_SuccessCTA.click();
//    }
//
//    public void addCardDetails(String cardName, String cardNo, String cardExpiryMonth, String cardExpiryYear, String cardCVV) throws InterruptedException {
//        scrollDownTo(RedHybrid_CardNameField);
//        RedHybrid_CardNameField.sendKeys(cardName);
//        RedHybrid_CardNumberField.sendKeys(cardNo);
//        redHybrid_cardDetails.selectExpiryDate(cardExpiryMonth, cardExpiryYear);
//        RedHybrid_CardSecurityCodeField.sendKeys(cardCVV);
//        RedHybrid_CardPayNowCTA.click();
//    }
//
//    public void addCardAddress() {
//        waitForVisibility(RedHybrid_UKPostcodeText);
//        RedHybrid_UKPostcodeText.sendKeys(GetValidPostCode());
//        RedHybrid_searchAddressCTA.click();
//        scrollDownTo(RedHybrid_BillingAddressContinueCTA);
//        RedHybrid_BillingAddressContinueCTA.click();
//    }
//
//    public void addPaymentCard() {
//        RedHybrid_PaymentConfirmationToggle1.click();
//        RedHybrid_PaymentConfirmationToggle2.click();
//        RedHybrid_ContinuePaymentCTA.click();
//    }
//
//    public void checkAddedPaymentCardUI() {
//        waitForVisibility(RedHybrid_currentCard);
//        AssertDisplayed(RedHybrid_currentCard.isDisplayed());
//        AssertResult(RedHybrid_editCancelCTAtxt.getText(), "Edit");
//        AssertDisplayed(RedHybrid_PaymentXIcon.isDisplayed());
//        AssertDisplayed(RedHybrid_replaceCardCTA.isDisplayed());
//        AssertResult(RedHybrid_replaceCardCTAtxt.getText(), "Replace my card");
//    }
//
//    public void clickEditCTA() {
//        waitForVisibility(RedHybrid_editCancelCTA);
//        RedHybrid_editCancelCTA.click();
//    }
//
//    public void clickCancelCTA() {
//        waitForVisibility(RedHybrid_editCancelCTA);
//        RedHybrid_editCancelCTA.click();
//    }
//
//    public void checkUIAfterPressingEditCTA() {
//        waitForVisibility(RedHybrid_currentCard);
//        AssertDisplayed(RedHybrid_currentCard.isDisplayed());
//        AssertResult(RedHybrid_editCancelCTAtxt.getText(), "Cancel");
//        AssertDisplayed(RedHybrid_PaymentXIcon.isDisplayed());
//        AssertDisplayed(RedHybrid_replaceCardCTA.isDisplayed());
//        AssertResult(RedHybrid_replaceCardCTAtxt.getText(), "Replace my card");
//        AssertDisplayed(RedHybrid_removeCurrentCardCTA.isDisplayed());
//    }
//
//    public void clickRemoveCTA() {
//        waitForVisibility(RedHybrid_removeCurrentCardCTA);
//        RedHybrid_removeCurrentCardCTA.click();
//    }
//
//    public void checkRemovePopUp() throws InterruptedException {
//        Thread.sleep(1000);
//        waitForVisibility(RedHybrid_removePopUpDescription);
//        AssertDisplayed(RedHybrid_removePopUpTitle.isDisplayed());
//        AssertResult(RedHybrid_removePopUpTitle.getText(), "Remove this card?");
//        AssertDisplayed(RedHybrid_removePopUpDescription.isDisplayed());
//        Assert.assertTrue(RedHybrid_removePopUpDescription.getText().contains("Are you sure you want to remove this"));
//        AssertDisplayed(RedHybrid_removePopUpCancelRemoveCTA.isDisplayed());
//        AssertResult(RedHybrid_removePopUpCancelRemoveCTA.getText(), "CANCEL");
//        AssertDisplayed(RedHybrid_removePopUpProceedRemoveCTA.isDisplayed());
//        AssertResult(RedHybrid_removePopUpProceedRemoveCTA.getText(), "REMOVE");
//    }
//
//    public void clickRemoveInConfirmationPopUp() throws InterruptedException {
//        Thread.sleep(1000);
//        waitForVisibility(RedHybrid_removePopUpProceedRemoveCTA);
//        RedHybrid_removePopUpProceedRemoveCTA.click();
//    }
//
//    public void clickCancelInConfirmationPopUp() throws InterruptedException {
//        Thread.sleep(1000);
//        waitForVisibility(RedHybrid_removePopUpCancelRemoveCTA);
//        RedHybrid_removePopUpCancelRemoveCTA.click();
//    }
//
//    public void checkAddPaymentAppearAfterRemovingCard() {
//        waitForVisibility(RedHybrid_PaymentAddCTA);
//        AssertDisplayed(RedHybrid_PaymentAddCTA.isDisplayed());
//    }
//
//    public void pressXBtn() {
//        try {
//            waitForVisibility(RedHybrid_PaymentXIcon);
//            RedHybrid_PaymentXIcon.click();
//        } catch (Exception e) {
//            waitForVisibility(RedHybrid_removePopUpCancelRemoveCTA);
//            RedHybrid_removePopUpCancelRemoveCTA.click();
//            waitForVisibility(RedHybrid_PaymentXIcon);
//            RedHybrid_PaymentXIcon.click();
//        }
//    }
//
//    public void checkDashboardAppears() {
//        waitForVisibility(DB_SettingDashboardTray_icon);
//        AssertDisplayed(DB_SettingDashboardTray_icon.isDisplayed());
//    }
//}
