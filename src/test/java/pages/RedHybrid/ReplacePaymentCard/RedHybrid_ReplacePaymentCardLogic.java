//package pages.RedHybrid.ReplacePaymentCard;
//
//import core.Config;
//import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic;
//import pages.RedHybrid.CardDetailsBarclays.RedHybrid_CardDetails;
//import testdata.ReadResponse;
//
//import static testdata.RedHybridTestData.GetValidPostCode;
//import static testdata.VisaCardDetails.*;
//@Deprecated
//public class RedHybrid_ReplacePaymentCardLogic extends RedHybrid_ReplacePaymentCardPO {
//
//    private final String Card;
//    private final DX_IDM_FullLoginLogic loginObject;
//    private RedHybrid_CardDetails redHybrid_cardDetails;
//    private final Config config =new Config();
//
//
//    public RedHybrid_ReplacePaymentCardLogic() {
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
//    public void beforeReplacingCard() {
//        waitForVisibility(DB_PaymentIcon);
//        DB_PaymentIcon.click();
//    }
//
//    public void processingCard() {
//        waitForVisibility(RedHybrid_ProcessingIcon);
//        waitForVisibility(RedHybrid_SuccessTik);
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
//        waitForVisibility(RedHybrid_selectAddressDropdownFirstElement);
//        RedHybrid_selectAddressDropdownFirstElement.click();
//        scrollDownTo(RedHybrid_BillingAddressContinueCTA);
//        RedHybrid_BillingAddressContinueCTA.click();
//    }
//
//    public void addPaymentCard() {
//        waitForVisibility(RedHybrid_PaymentConfirmationToggle1);
//        RedHybrid_PaymentConfirmationToggle1.click();
//        RedHybrid_PaymentConfirmationToggle2.click();
//        RedHybrid_ContinuePaymentCTA.click();
//    }
//
//    public void replaceCard() {
//        waitForVisibility(RedHybrid_replaceCardCTA);
//        RedHybrid_replaceCardCTA.click();
//    }
//
//    public void checkAddPaymentAppearsAfterReplaceCard() {
//        waitForVisibility(RedHybrid_PaymentConfirmationToggle1);
//        AssertDisplayed(RedHybrid_PaymentConfirmationToggle1.isDisplayed());
//    }
//
//    public void pressPhysicalBack() {
//        driver.navigate().back();
//    }
//
//    public void checkDashboardAppears() {
//        waitForVisibility(DB_SettingDashboardTray_icon);
//        AssertDisplayed(DB_SettingDashboardTray_icon.isDisplayed());
//    }
//
//    public void addDifferentCardDetails() throws InterruptedException {
//        addCardDetails(GetCardName1(), GetCardNumber1(), GetCardMonthExpDate1(), GetCardYearExpDate1(), GetCVV1());
//    }
//
//    public void addSameCardDetails() throws InterruptedException {
//        addCardDetails(GetCardName(), GetCardNumber(), GetCardMonthExpDate(), GetCardYearExpDate(), GetCVV());
//    }
//
//    public void checkAddDone() {
//        waitForVisibility(RedHybrid_currentCard);
//        AssertDisplayed(RedHybrid_currentCard.isDisplayed());
//    }
//
//    public void checkReplaceCardScreen() {
//        waitForVisibility(RedHybrid_currentCard);
//        AssertDisplayed(RedHybrid_currentCard.isDisplayed());
//        AssertDisplayed(RedHybrid_replaceCardCTA.isDisplayed());
//    }
//
//    public void pressXBtn() {
//        waitForVisibility(RedHybrid_PaymentXIcon);
//        RedHybrid_PaymentXIcon.click();
//    }
//}
