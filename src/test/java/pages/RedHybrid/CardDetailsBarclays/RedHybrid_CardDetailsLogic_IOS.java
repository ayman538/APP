package pages.RedHybrid.CardDetailsBarclays;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import testdata.VisaCardDetails;

import static testdata.VisaCardDetails.GetCardMonthExpDate;
import static testdata.VisaCardDetails.GetCardYearExpDate;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForInVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_CardDetailsLogic_IOS extends RedHybrid_CardDetails {

    public RedHybrid_CardDetailsLogic_IOS() {
        super();
    }

    @Override
    public void selectExpiryDate(String month, String year) throws InterruptedException {
        waitForVisibility(RedHybrid_CardExpiryDateMonthField);
        RedHybrid_CardExpiryDateMonthField.click();
        RedHybrid_CardExpiryDateMonthField.sendKeys(month);
        IOSDoneCTAKeyBoard.click();
        waitForVisibility(RedHybrid_CardExpiryDateYearField);
        RedHybrid_CardExpiryDateYearField.click();
        Thread.sleep(1000);
        waitForVisibility(RedHybrid_CardExpiryDateYearField);
        RedHybrid_CardExpiryDateYearField.sendKeys(year);
        IOSDoneCTAKeyBoard.click();
    }

    @Override
    public void BarclaysDrawerIsDisplayed() {
        waitForVisibility(RedHybrid_CardNameField);
    }

    public void validateCardFields() {
        validateBarclaysLabels();
        validateBarclaysTextFields();
    }

    @Override
    public void validateBarclaysLabels() {
        AssertResult(RedHybrid_CardNameLabel.getText(), "Cardholder Name");
        AssertResult(RedHybrid_CardNumberLabel.getText(), "Card number");
        AssertResult(RedHybrid_CardExpiryDateLabel.getText(), "Expiry date");
        AssertResult(RedHybrid_CardSecurityCodeLabel.getText(), "Card Security Code");
    }

    @Override
    public void validateBarclaysTextFields() {
        AssertDisplayed(RedHybrid_CardNameField.isDisplayed());
        AssertDisplayed(RedHybrid_CardNumberField.isDisplayed());
        AssertDisplayed(RedHybrid_CardExpiryDateMonthField.isDisplayed());
        AssertDisplayed(RedHybrid_CardExpiryDateYearField.isDisplayed());
        AssertDisplayed(RedHybrid_CardSecurityCodeField.isDisplayed());
    }

    @Override
    public void EnterValidVisaDetails() throws InterruptedException {
        RedHybrid_CardNameField.clear();
        RedHybrid_CardNameField.sendKeys(VisaCardDetails.GetCardName());
        RedHybrid_CardNumberField.clear();
        RedHybrid_CardNumberField.sendKeys(VisaCardDetails.GetCardNumber());
        selectExpiryDate(GetCardMonthExpDate(), GetCardYearExpDate());
        RedHybrid_CardSecurityCodeField.clear();
        RedHybrid_CardSecurityCodeField.sendKeys(VisaCardDetails.GetCVV());
    }

    @Override
    public void validateCardNameField() {
        RedHybrid_CardNameField.click();
        AssertKeyboardIsDisplayed();
    }

    //@Override
    public void AssertKeyboardIsDisplayed() {
        boolean isKeyboardShown = false;

        IOSDriver dri = new IOSDriver((Capabilities) driver);
        isKeyboardShown = dri.isKeyboardShown();

        AssertDisplayed(isKeyboardShown);
    }

    @Override
    public void validateCardNumberField() {
        RedHybrid_CardNumberField.click();
        AssertKeyboardIsDisplayed();
    }

    @Override
    public void validateExpirationDateField() {
        RedHybrid_CardSecurityCodeField.click();
        AssertKeyboardIsDisplayed();
    }

    @Override
    public void validateWhenEnteringInvalidCVV() throws InterruptedException {
        EnterValidVisaDetails();
        EnterInvalidField(RedHybrid_CardSecurityCodeField, "111");
        //Assert error displayed
    }

    @Override
    public void validateWhenEnteringInvalidCardName() throws InterruptedException {
        EnterValidVisaDetails();
        EnterInvalidField(RedHybrid_CardNameField, "aaa");
        //Assert error displayed
    }

    @Override
    public void validateWhenEnteringInvalidCardNumber() throws InterruptedException {
        EnterValidVisaDetails();
        EnterInvalidField(RedHybrid_CardNumberField, "123456789012");
        //Assert error displayed
    }

    @Override
    public void validateWhenEnteringInvalidCardExpiryDate() throws InterruptedException {
        EnterValidVisaDetails();
        //EnterInvalidField(RedHybrid_CardExpiryDateField, "");
        //Assert error displayed
    }

    @Override
    public void validateWhenEnteringValidCardDetailsAuthTrue() throws InterruptedException {
        EnterValidVisaDetails();
        RedHybrid_CardPayNowCTA.click();
        //Assert two factor auth ??
    }

    @Override
    public void validateWhenEnteringValidCardDetailsAuthFalse() throws InterruptedException {
        EnterValidVisaDetails();
        RedHybrid_CardPayNowCTA.click();
        waitForInVisibility(RedHybrid_CardPayNowCTA);
        AssertDisplayed(!RedHybrid_CardPayNowCTA.isDisplayed());
    }

    @Override
    public void EnterInvalidField(WebElement redHybrid_cardField, String input) {
        redHybrid_cardField.click();
        redHybrid_cardField.clear();
        redHybrid_cardField.sendKeys(input);// invalid card name
        RedHybrid_CardPayNowCTA.click();
    }


}

