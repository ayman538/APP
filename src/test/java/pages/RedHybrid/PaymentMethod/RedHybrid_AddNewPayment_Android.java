package pages.RedHybrid.PaymentMethod;

import models.response.paymentCardResponseModel;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import testdata.ReadResponse;
import utils.paymentCardUtils;

import java.time.Duration;
import java.util.Properties;

import static helpers.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.DriverHelps.runAppInBackground;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_AddNewPayment_Android extends RedHybrid_AddNewPayment {
    //private final String Card;
    private final String Card;
    private final DX_IDM_FullLoginLogic_Abstract loginObject;
    private static paymentCardResponseModel response;
    private final Properties envProp;


    public RedHybrid_AddNewPayment_Android() {
        super();
        Card = ReadResponse.GetPaymentCardList();
        response = paymentCardUtils.paymentCard();
        loginObject = new DX_IDM_FullLoginLogic_Android();
        envProp = readPropertyFile("config/platform.properties");
    }

    @Override
    public void TapOnPayment() {
        waitForVisibility(DB_PaymentIcon);
        DB_PaymentIcon.click();
    }

    @Override
    public void TapOnVerifyCTA() {
        // Tap on continue CTA, check with Yara the naming of this element
    }

    @Override
    public void PaymentDrawerIsOpened() {
        waitForVisibility(RedHybrid_PaymentTitle);
        AssertDisplayed(RedHybrid_PaymentTitle.isDisplayed());
        System.out.println(RedHybrid_PaymentTitle.getText());
    }

    @Override
    public void ValidateLoginScreenIsDisplayed() {

        waitForVisibility(loginObject.DX_IDM_Username);
        AssertDisplayed(loginObject.DX_IDM_Username.isDisplayed());
    }

    @Override
    public void ValidateAddNewPaymentMethod() {
        waitForVisibility(RedHybrid_PaymentTitle);
        AssertResult(RedHybrid_PaymentTitle.getText(), response.title);
        System.out.println(RedHybrid_PaymentTitle.getText());
        System.out.println(response.title);
        AssertResult(RedHybrid_PaymentHeader.getText(), response.subContent.subtitle);
        System.out.println(RedHybrid_PaymentHeader.getText());
        System.out.println(response.subContent.subtitle);
        AssertResult(RedHybrid_PaymentDesc.getText(), response.subContent.text);
        System.out.println(RedHybrid_PaymentDesc.getText());
        System.out.println(response.subContent.text);
        AssertResult(RedHybrid_PaymentAddCTA.getText(), response.buttons.get(0).text);
        System.out.println(RedHybrid_PaymentAddCTA.getText());
        System.out.println(response.buttons.get(0).text);
        AssertDisplayed(RedHybrid_PaymentXIcon.isDisplayed());
    }

    @Override
    public void TapOnAddNewCard() {
        waitForVisibility(RedHybrid_PaymentAddCTA);
        RedHybrid_PaymentAddCTA.click();
    }

    @Override
    public void ValidateAddPaymentMethodScreen() {
        waitForVisibility(RedHybrid_ContinuePaymentCTA);
        AssertDisplayed(RedHybrid_ContinuePaymentCTA.isDisplayed());
    }

    @Override
    public void ValidateAddPaymentMethodScreenContent() {
        waitForVisibility(RedHybrid_ContinuePaymentCTA);
        AssertResult(RedHybrid_PaymentTitle.getText(), "Payments");
        AssertResult(RedHybrid_AddPaymentHeader.getText(), "Add a payment method");
        AssertResult(RedHybrid_AddPaymentDesc.getText(), "This will be the payment method you will use for your monthly plan and any additional Extras.");
        //AssertResult(RedHybrid_PaymentConfirmationText1.getText(),"I consent to Vodafone storing my card details for future recurring and one-off payments and understand my personal data will be processed in accordance with Vodafone Limited's Privacy Policy.");
        //AssertResult(RedHybrid_PaymentConfirmationText2.getText(),"I confirm I have read and agree to Vodafone Limited’s Terms and conditions.");
        AssertDisplayed(RedHybrid_PaymentConfirmationToggle1.isDisplayed());
        AssertDisplayed(RedHybrid_PaymentConfirmationToggle2.isDisplayed());
        AssertResult(RedHybrid_ContinuePaymentCTA.getText(), "Continue");
        AssertDisplayed(RedHybrid_PaymentXIcon.isDisplayed());
        AssertDisplayed(RedHybrid_PaymentBackIcon.isDisplayed());
        // indicate Continue is not clickable
        RedHybrid_ContinuePaymentCTA.click();
        AssertResult(RedHybrid_AddPaymentHeader.getText(), "Add a payment method");
    }

    @Override
    public void TurnOnTheToggles() {
        waitForVisibility(RedHybrid_PaymentConfirmationToggle1);
        RedHybrid_PaymentConfirmationToggle1.click();
        RedHybrid_PaymentConfirmationToggle2.click();
    }

    @Override
    public void ValidateContinueCTAIsClickable() {
        waitForVisibility(RedHybrid_ContinuePaymentCTA);
        RedHybrid_ContinuePaymentCTA.click();
        waitForVisibility(RedHybrid_BillingAddressHeader);
        AssertDisplayed(RedHybrid_BillingAddressHeader.isDisplayed());
    }

    @Override
    public void TapOnXIcon() {
        waitForVisibility(RedHybrid_PaymentXIcon);
        RedHybrid_PaymentXIcon.click();
    }

    @Override
    public void ValidateDashboardIsDisplayed() {
        waitForVisibility(DB_PaymentIcon);
        AssertDisplayed(DB_PaymentIcon.isDisplayed());
    }

    @Override
    public void TapOnAndroidPhysicalBack() {
        waitForVisibility(RedHybrid_PaymentXIcon);
        driver.navigate().back();
    }

    @Override
    public void ValidatePaymentCardIsAdded() {
        waitForVisibility(RedHybrid_PaymentTitle);
        AssertResult(RedHybrid_PaymentTitle.getText(), "Payments");
        AssertResult(RedHybrid_PaymentHeader.getText(), "Payment method");
        AssertResult(RedHybrid_PaymentDesc.getText(), "You can only have one active card linked with your Plus account.");
        AssertResult(RedHybrid_PaymentAddCTA.getText(), "Replace my card");
        AssertDisplayed(RedHybrid_PaymentXIcon.isDisplayed());
        AssertDisplayed(RedHybrid_AddedPaymentCardView.isDisplayed());
        AssertDisplayed(RedHybrid_AddedPaymentCardType.isDisplayed());
        AssertDisplayed(RedHybrid_AddedPaymentCardNumber.isDisplayed());
        AssertDisplayed(RedHybrid_AddedPaymentCardExpiryDate.isDisplayed());
        AssertDisplayed(RedHybrid_EditPaymentCardIcon.isDisplayed());
        AssertResult(RedHybrid_EditPaymentCardLabel.getText(), "Edit");
    }

    @Override
    public void ValidateXIconCloseTheFlow() {
        RedHybrid_PaymentXIcon.click();
        waitForVisibility(DB_PaymentIcon);
        AssertDisplayed(DB_PaymentIcon.isDisplayed());
    }

    @Override
    public void ValidateSoftCloseTheApp() {
        runAppInBackground();
        waitForVisibility(RedHybrid_PaymentTitle);
        AssertDisplayed(RedHybrid_PaymentTitle.isDisplayed());
    }

    @Override
    public void ClickOnBackIcon() {
        waitForVisibility(RedHybrid_PaymentBackIcon);
        RedHybrid_PaymentBackIcon.click();
    }

    @Override
    public void XiconIsNotDisplayed() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HardAssertNotDisplayed("X icon is displayed ",elementIsPresent(RedHybrid_PaymentXIcon));
    }


}