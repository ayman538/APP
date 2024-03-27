package pages.RedHybrid.CardDetailsBarclays;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import testdata.VisaCardDetails;

import static core.Config.getPlatformType;
import static testdata.VisaCardDetails.GetCardMonthExpDate;
import static testdata.VisaCardDetails.GetCardYearExpDate;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForInVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class RedHybrid_CardDetailsLogic extends RedHybrid_CardDetailsPO {

    public RedHybrid_CardDetailsLogic() {
        super();
    }

    public void selectExpiryDate(String month, String year) throws InterruptedException {
        waitForVisibility(RedHybrid_CardExpiryDateMonthField);
        RedHybrid_CardExpiryDateMonthField.click();
        scrollDownTo(driver.findElement(By.xpath("//*[@text='" + month + "']")));
        driver.findElement(By.xpath("//*[@text='" + month + "']")).click();
        waitForVisibility(RedHybrid_CardExpiryDateYearField);
        RedHybrid_CardExpiryDateYearField.click();
        Thread.sleep(1000);
        waitForVisibility(driver.findElement(By.xpath("//*[@text='" + year + "']")));
        scrollDownTo(driver.findElement(By.xpath("//*[@text='" + year + "']")));
        driver.findElement(By.xpath("//*[@text='" + year + "']")).click();
    }

    public void BarclaysDrawerIsDisplayed() {
        waitForVisibility(RedHybrid_CardNameField);
    }

    public void validateCardFields() {
        validateBarclaysLabels();
        validateBarclaysTextFields();
    }

    public void validateBarclaysLabels() {
        AssertResult(RedHybrid_CardNameLabel.getText(), "Cardholder Name");
        AssertResult(RedHybrid_CardNumberLabel.getText(), "Card number");
        AssertResult(RedHybrid_CardExpiryDateLabel.getText(), "Expiry date");
        AssertResult(RedHybrid_CardSecurityCodeLabel.getText(), "Card Security Code");
    }

    public void validateBarclaysTextFields() {
        AssertDisplayed(RedHybrid_CardNameField.isDisplayed());
        AssertDisplayed(RedHybrid_CardNumberField.isDisplayed());
        AssertDisplayed(RedHybrid_CardExpiryDateMonthField.isDisplayed());
        AssertDisplayed(RedHybrid_CardExpiryDateYearField.isDisplayed());
        AssertDisplayed(RedHybrid_CardSecurityCodeField.isDisplayed());
    }

    public void EnterValidVisaDetails() throws InterruptedException {
        RedHybrid_CardNameField.clear();
        RedHybrid_CardNameField.sendKeys(VisaCardDetails.GetCardName());
        RedHybrid_CardNumberField.clear();
        RedHybrid_CardNumberField.sendKeys(VisaCardDetails.GetCardNumber());
        selectExpiryDate(GetCardMonthExpDate(), GetCardYearExpDate());
        RedHybrid_CardSecurityCodeField.clear();
        RedHybrid_CardSecurityCodeField.sendKeys(VisaCardDetails.GetCVV());
    }

    public void validateCardNameField() {
        RedHybrid_CardNameField.click();
        AssertKeyboardIsDisplayed();
    }

    private void AssertKeyboardIsDisplayed() {
        boolean isKeyboardShown = false;
        if (getPlatformType().equalsIgnoreCase("Android")) {
            AndroidDriver dri = new AndroidDriver((Capabilities) driver);
            isKeyboardShown = dri.isKeyboardShown();
        } else {
            IOSDriver dri = new IOSDriver((Capabilities) driver);
            isKeyboardShown = dri.isKeyboardShown();
        }
        AssertDisplayed(isKeyboardShown);
    }

    public void validateCardNumberField() {
        RedHybrid_CardNumberField.click();
        AssertKeyboardIsDisplayed();
    }

    public void validateExpirationDateField() {
        RedHybrid_CardSecurityCodeField.click();
        AssertKeyboardIsDisplayed();
    }

    public void validateWhenEnteringInvalidCVV() throws InterruptedException {
        EnterValidVisaDetails();
        EnterInvalidField(RedHybrid_CardSecurityCodeField, "111");
        //Assert error displayed
    }

    public void validateWhenEnteringInvalidCardName() throws InterruptedException {
        EnterValidVisaDetails();
        EnterInvalidField(RedHybrid_CardNameField, "aaa");
        //Assert error displayed
    }

    public void validateWhenEnteringInvalidCardNumber() throws InterruptedException {
        EnterValidVisaDetails();
        EnterInvalidField(RedHybrid_CardNumberField, "123456789012");
        //Assert error displayed
    }

    public void validateWhenEnteringInvalidCardExpiryDate() throws InterruptedException {
        EnterValidVisaDetails();
        //EnterInvalidField(RedHybrid_CardExpiryDateField, "");
        //Assert error displayed
    }

    public void validateWhenEnteringValidCardDetailsAuthTrue() throws InterruptedException {
        EnterValidVisaDetails();
        RedHybrid_CardPayNowCTA.click();
        //Assert two factor auth ??
    }

    public void validateWhenEnteringValidCardDetailsAuthFalse() throws InterruptedException {
        EnterValidVisaDetails();
        RedHybrid_CardPayNowCTA.click();
        waitForInVisibility(RedHybrid_CardPayNowCTA);
        AssertDisplayed(!RedHybrid_CardPayNowCTA.isDisplayed());
    }


    public void EnterInvalidField(WebElement redHybrid_cardField, String input) {
        redHybrid_cardField.click();
        redHybrid_cardField.clear();
        redHybrid_cardField.sendKeys(input);// invalid card name
        RedHybrid_CardPayNowCTA.click();
    }


}
