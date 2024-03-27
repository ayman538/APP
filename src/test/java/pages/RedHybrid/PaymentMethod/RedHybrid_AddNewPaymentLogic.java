package pages.RedHybrid.PaymentMethod;


import core.Config;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_IOS;
import testdata.ReadResponse;

import java.time.Duration;

import static utils.element_helpers.DriverHelps.runAppInBackground;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForInVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class RedHybrid_AddNewPaymentLogic extends RedHybrid_AddNewPaymentPO {

    private final String Card;
    private final Config config= new Config();

    private DX_IDM_FullLoginLogic_Abstract loginObject;

    public RedHybrid_AddNewPaymentLogic() {
        super();
        Card = ReadResponse.GetPaymentCardList();
        if (config.isAndroid()) loginObject = new DX_IDM_FullLoginLogic_Android();
        if (config.isIos()) loginObject = new DX_IDM_FullLoginLogic_IOS();
    }

    public void TapOnPayment() {
        waitForVisibility(DB_PaymentIcon);
        DB_PaymentIcon.click();
    }

    public void TapOnVerifyCTA() {
        // Tap on continue CTA, check with Yara the naming of this element
    }

    public void PaymentDrawerIsOpened() {
        waitForVisibility(RedHybrid_PaymentTitle);
    }

    public void ValidateLoginScreenIsDisplayed() {
        waitForVisibility(loginObject.DX_IDM_Username);
        AssertDisplayed(loginObject.DX_IDM_Username.isDisplayed());
    }

    public void LoginFlow() throws InterruptedException {
        loginObject.fullLoginWithPIN();
    }

    public void ValidateAddNewPaymentMethod() {
        waitForVisibility(RedHybrid_PaymentTitle);
        AssertResult(RedHybrid_PaymentTitle.getText(), "Payments");
        AssertResult(RedHybrid_PaymentHeader.getText(), "Payment method");
        AssertResult(RedHybrid_PaymentDesc.getText(), "Add a payment method to your account below");
        AssertResult(RedHybrid_PaymentAddCTA.getText(), "Add a new card");
        AssertDisplayed(RedHybrid_PaymentXIcon.isDisplayed());
    }

    public void TapOnAddNewCard() {
        RedHybrid_PaymentAddCTA.click();
    }

    public void ValidateAddPaymentMethodScreen() {
        waitForVisibility(RedHybrid_ContinuePaymentCTA);
        AssertDisplayed(RedHybrid_ContinuePaymentCTA.isDisplayed());
    }

    public void ValidateAddPaymentMethodScreenContent() {
        waitForVisibility(RedHybrid_ContinuePaymentCTA);
        AssertResult(RedHybrid_PaymentTitle.getText(), "Payments");
        AssertResult(RedHybrid_AddPaymentHeader.getText(), "Add a payment method");
        AssertResult(RedHybrid_AddPaymentDesc.getText(), "This will be payment method you use for your monthly plan and any additional extras.");
        AssertDisplayed(RedHybrid_PaymentCardType1.isDisplayed());
        AssertDisplayed(RedHybrid_PaymentCardType2.isDisplayed());
        AssertDisplayed(RedHybrid_PaymentCardType3.isDisplayed());
        AssertDisplayed(RedHybrid_PaymentCardType4.isDisplayed());
        AssertDisplayed(RedHybrid_PaymentConfirmationText1.isDisplayed());
        AssertDisplayed(RedHybrid_PaymentConfirmationText2.isDisplayed());
        AssertDisplayed(RedHybrid_PaymentConfirmationToggle1.isDisplayed());
        AssertDisplayed(RedHybrid_PaymentConfirmationToggle2.isDisplayed());
        AssertResult(RedHybrid_ContinuePaymentCTA.getText(), "Continue");
        AssertDisplayed(RedHybrid_PaymentXIcon.isDisplayed());
        AssertDisplayed(RedHybrid_PaymentBackIcon.isDisplayed());

        // indicate Continue is not clickable
        RedHybrid_ContinuePaymentCTA.click();
        AssertResult(RedHybrid_AddPaymentHeader.getText(), "Add a payment method");

    }

    public void TurnOnTheToggles() {
        RedHybrid_PaymentConfirmationText1.click();
        RedHybrid_PaymentConfirmationText2.click();
    }

    public void TapOnXIcon() {
        waitForVisibility(RedHybrid_PaymentXIcon);
        RedHybrid_PaymentXIcon.click();
    }

    public void TapOnAndroidPhysicalBack() {
        waitForVisibility(RedHybrid_PaymentXIcon);
        driver.navigate().back();
    }

    public void ValidateDashboardIsDisplayed() {
        waitForVisibility(DB_PaymentIcon);
        AssertDisplayed(DB_PaymentIcon.isDisplayed());
    }

    public void ValidateContinueCTAIsClickable() {
        RedHybrid_ContinuePaymentCTA.click();
        waitForInVisibility(RedHybrid_AddPaymentHeader);
        AssertDisplayed(!RedHybrid_AddPaymentHeader.isDisplayed());
    }

    public void ValidatePaymentCardIsAdded() {
        waitForVisibility(RedHybrid_PaymentTitle);
        AssertResult(RedHybrid_PaymentTitle.getText(), "Payments");
        AssertResult(RedHybrid_PaymentHeader.getText(), "Payment method");
        AssertResult(RedHybrid_PaymentDesc.getText(), "You can only have one active card linked with your Flexi account. Tap below to replace your existing card.");
        AssertResult(RedHybrid_PaymentAddCTA.getText(), "Replace my card");
        AssertDisplayed(RedHybrid_PaymentXIcon.isDisplayed());

        AssertDisplayed(RedHybrid_AddedPaymentCardView.isDisplayed());
        AssertDisplayed(RedHybrid_AddedPaymentCardType.isDisplayed());
        AssertDisplayed(RedHybrid_AddedPaymentCardNumber.isDisplayed());
        AssertDisplayed(RedHybrid_AddedPaymentCardExpiryDate.isDisplayed());
        AssertDisplayed(RedHybrid_EditPaymentCardIcon.isDisplayed());
        AssertResult(RedHybrid_EditPaymentCardLabel.getText(), "Edit");
    }

    public void ValidateXIconCloseTheFlow() {
        RedHybrid_PaymentXIcon.click();
        waitForVisibility(DB_PaymentIcon);
        AssertDisplayed(DB_PaymentIcon.isDisplayed());
    }

    public void ValidateSoftCloseTheApp() {
        runAppInBackground();
        waitForVisibility(RedHybrid_PaymentTitle);
        AssertDisplayed(RedHybrid_PaymentTitle.isDisplayed());
    }


}
