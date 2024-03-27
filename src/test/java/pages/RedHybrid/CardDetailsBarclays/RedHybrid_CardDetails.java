package pages.RedHybrid.CardDetailsBarclays;


import org.openqa.selenium.WebElement;

public abstract class RedHybrid_CardDetails extends RedHybrid_CardDetailsPO {

    public RedHybrid_CardDetails() {
        super();
    }

    public abstract void selectExpiryDate(String month, String year) throws InterruptedException;

    public abstract void BarclaysDrawerIsDisplayed();


    public abstract void validateCardFields();

    public abstract void validateBarclaysLabels();

    public abstract void validateBarclaysTextFields();


    public abstract void EnterValidVisaDetails() throws InterruptedException;

    public abstract void validateCardNameField();

    public abstract void AssertKeyboardIsDisplayed();

    public abstract void validateCardNumberField();

    public abstract void validateExpirationDateField();

    public abstract void validateWhenEnteringInvalidCVV() throws InterruptedException;

    public abstract void validateWhenEnteringInvalidCardName() throws InterruptedException;

    public abstract void validateWhenEnteringInvalidCardNumber() throws InterruptedException;

    public abstract void validateWhenEnteringInvalidCardExpiryDate() throws InterruptedException;

    public abstract void validateWhenEnteringValidCardDetailsAuthTrue() throws InterruptedException;

    public abstract void validateWhenEnteringValidCardDetailsAuthFalse() throws InterruptedException;


    public abstract void EnterInvalidField(WebElement redHybrid_cardField, String input);

}

